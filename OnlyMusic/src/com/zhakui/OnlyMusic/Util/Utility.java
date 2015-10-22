package com.zhakui.OnlyMusic.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

public class Utility {
	
	private Handler handler;
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	private String Url;
	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
	private Bitmap bitmap = null; 
	
	public Utility()
	{}
	
	public void RequestBitMap() { 
		
		new Thread()
		{
			@Override
			public void run()
			{
				URL myFileUrl = null; 
				try { 
					myFileUrl = new URL(Url); 
					} catch (MalformedURLException e) { 
						e.printStackTrace(); 
					} 
				try { 
					HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection(); 
					conn.setDoInput(true); 
					conn.connect(); 
					InputStream is = conn.getInputStream(); 
					bitmap = BitmapFactory.decodeStream(is); 
					is.close(); 
					handler.sendEmptyMessage(2);
					} catch (IOException e) { 
						e.printStackTrace(); 
					} 
			} 
		}.start();
	}
	
	public Bitmap getBitMap()
	{
		return bitmap;
	}
}
