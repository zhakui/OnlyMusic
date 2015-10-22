package com.zhakui.OnlyMusic.FMCore;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import com.zhakui.OnlyMusic.data.Song;

import android.os.Handler;

public class SongInfo {

	public List<Song> songlist;

	public List<Song> getSonglist() {
		return songlist;
	}

	private Handler handler;
	
	public SongInfo(Handler handler)
	{
		this.handler = handler;
	}
	
	public void requestSongInfo()
	{
		songlist = new ArrayList<Song>();
		
		new Thread()
		{
			@Override
			public void run()
			{
				try{
					String json;
					URL url = new URL("http://douban.fm/j/mine/playlist?type=s&sid=1775835&channel=4&pb=4&from=mainsite&r=4c80c79813"); 
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(5 * 1000);
					conn.setRequestMethod("GET");
					conn.setRequestProperty("accept", "*/*");
					conn.setRequestProperty("connection", "Keep-Alive");
					conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
					conn.connect();
					if(conn.getResponseCode() == 200){
						InputStream is = conn.getInputStream();
						byte[] date  = readStream(is);
						json = new String(date);
						JSONObject jsonObject=new JSONObject(json); 
						JSONArray jsonArray = jsonObject.getJSONArray("song");
						for(int i=0;i<jsonArray.length();i++)
						{
							JSONObject item = jsonArray.getJSONObject(i); // 得到每个对象  
							Song song = new Song();
							song.setAlbum(item.getString("album"));
							song.setPicture(item.getString("picture"));
							song.setSsid(item.getString("ssid"));
							song.setArtist(item.getString("artist"));
							song.setUrl(item.getString("url"));
							song.setCompany(item.getString("company"));
							song.setTitle(item.getString("title"));
							song.setRating_avg(item.getString("rating_avg"));
							song.setLength(item.getString("length"));
							song.setSource_url("");
							song.setSubtype(item.getString("subtype"));
							song.setPublic_time(item.getString("public_time"));
							song.setSid(item.getString("sid"));
							song.setAid(item.getString("aid"));
							song.setAlbumtitle(item.getString("albumtitle"));
							song.setLike(item.getString("like"));
							songlist.add(song);
						}
						handler.sendEmptyMessage(1);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}	
		}.start();	
	}	
	
	public byte[] readStream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			bout.write(buffer, 0, len);
		}
		bout.close();
		inputStream.close();

		return bout.toByteArray();
	}
}
