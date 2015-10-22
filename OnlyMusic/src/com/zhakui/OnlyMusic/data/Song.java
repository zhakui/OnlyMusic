package com.zhakui.OnlyMusic.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable{

		public final static String KEY_MUSIC_DATA = "SongData";
	
		private final static String KEY_MUSIC_ALBUM = "album";
		private final static String KEY_MUSIC_PIVTURE = "picture";
		private final static String KEY_MUSIC_SSID = "ssid";
		private final static String KEY_MUSIC_ARTIST = "artist";
		private final static String KEY_MUSIC_URL = "url";
		private final static String KEY_MUSIC_COMPANY = "company";
		private final static String KEY_MUSIC_TITLE = "title";
		private final static String KEY_MUSIC_RATING_AVG = "rating_avg";
		private final static String KEY_MUSIC_LENGTH = "length";
		private final static String KEY_MUSIC_SOURE_URL = "source_url";
		private final static String KEY_MUSIC_SUBTYPE = "subtype";
		private final static String KEY_MUSIC_PUBLIC_TIME = "public_time";
		private final static String KEY_MUSIC_SID = "sid";
		private final static String KEY_MUSIC_AID = "aid";
		private final static String KEY_MUSIC_ALBUMTITLE = "albumtitle";
		private final static String KEY_MUSIC_LIKE = "like";
		
	
		private String album;
		private String picture;
		private String ssid;
		private String artist;
		private String url;
		private String company;
		private String title;
		private String rating_avg;
		private String length;
		private String source_url;
		private String subtype;
		private String public_time;
		private String sid;
		private String aid;
		private String albumtitle;
		private String like;
		
		public String getAlbum()
		{
			return album;
		}
		
		public void setAlbum(String album)
		{
			this.album = album; 
		}
		
		public String getPicture()
		{
			return picture;
		}
		
		public void setPicture(String picture)
		{
			this.picture = picture; 
		}
		
		public String getSsid()
		{
			return ssid;
		}
		
		public void setSsid(String ssid)
		{
			this.ssid = ssid; 
		}
		
		public String getArtist()
		{
			return artist;
		}
		
		public void setArtist(String artist)
		{
			this.artist = artist; 
		}
		
		public String getUrl()
		{
			return url;
		}
		
		public void setUrl(String url)
		{
			this.url = url; 
		}
		
		public String getCompany()
		{
			return company;
		}
		
		public void setCompany(String company)
		{
			this.company = company; 
		}
		
		public String getTitle()
		{
			return title;
		}
		
		public void setTitle(String title)
		{
			this.title = title; 
		}
		
		public String getRating_avg()
		{
			return rating_avg;
		}
		
		public void setRating_avg(String rating_avg)
		{
			this.rating_avg = rating_avg; 
		}
		
		public String getLength()
		{
			return length;
		}
		
		public void setLength(String length)
		{
			this.length = length; 
		}
		
		public String getSource_url()
		{
			return source_url;
		}
		
		public void setSource_url(String source_url)
		{
			this.source_url = source_url; 
		}
		
		public String getSubtype()
		{
			return subtype;
		}
		
		public void setSubtype(String subtype)
		{
			this.subtype = subtype; 
		}
		
		public String getPublic_time()
		{
			return public_time;
		}
		
		public void setPublic_time(String public_time)
		{
			this.public_time = public_time; 
		}
		
		public String getSid()
		{
			return sid;
		}
		
		public void setSid(String sid)
		{
			this.sid = sid; 
		}
		
		public String getAid()
		{
			return aid;
		}
		
		public void setAid(String aid)
		{
			this.aid = aid; 
		}
		
		public String getAlbumtitle()
		{
			return albumtitle;
		}
		
		public void setAlbumtitle(String albumtitle)
		{
			this.albumtitle = albumtitle; 
		}
		
		public String getLike()
		{
			return like;
		}
		
		public void setLike(String like)
		{
			this.like = like; 
		}

		@Override
		public int describeContents() {

			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			
			Bundle mBundle=new Bundle(); 
			
			mBundle.putString(KEY_MUSIC_ALBUM , album);
			mBundle.putString(KEY_MUSIC_PIVTURE , picture);
			mBundle.putString(KEY_MUSIC_SSID , ssid);
			mBundle.putString(KEY_MUSIC_ARTIST , artist);
			mBundle.putString(KEY_MUSIC_URL , url);
			mBundle.putString(KEY_MUSIC_COMPANY , company);
			mBundle.putString(KEY_MUSIC_TITLE , title);
			mBundle.putString(KEY_MUSIC_RATING_AVG , rating_avg);
			mBundle.putString(KEY_MUSIC_LENGTH , length);
			mBundle.putString(KEY_MUSIC_SOURE_URL , source_url);
			mBundle.putString(KEY_MUSIC_SUBTYPE , subtype);
			mBundle.putString(KEY_MUSIC_PUBLIC_TIME , public_time);
			mBundle.putString(KEY_MUSIC_SID , sid);
			mBundle.putString(KEY_MUSIC_AID , aid);
			mBundle.putString(KEY_MUSIC_ALBUMTITLE , albumtitle);
			mBundle.putString(KEY_MUSIC_LIKE , like);
			
			dest.writeBundle(mBundle);
		}
		
		 public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>()
				 {

					@Override
					public Song createFromParcel(Parcel source) {
						Song Data = new Song();

						Bundle mBundle=new Bundle(); 
						mBundle = source.readBundle();
						
				        Data.album = mBundle.getString(KEY_MUSIC_ALBUM);
				        Data.picture = mBundle.getString(KEY_MUSIC_PIVTURE);
				        Data.ssid = mBundle.getString(KEY_MUSIC_SSID);
				        Data.artist = mBundle.getString(KEY_MUSIC_ARTIST);
				        Data.url = mBundle.getString(KEY_MUSIC_URL);
				        Data.company = mBundle.getString(KEY_MUSIC_COMPANY);
				        Data.title = mBundle.getString(KEY_MUSIC_TITLE);
				        Data.rating_avg = mBundle.getString(KEY_MUSIC_RATING_AVG);
				        Data.length = mBundle.getString(KEY_MUSIC_LENGTH);
				        Data.source_url = mBundle.getString(KEY_MUSIC_SOURE_URL);
				        Data.subtype = mBundle.getString(KEY_MUSIC_SUBTYPE);
				        Data.public_time = mBundle.getString(KEY_MUSIC_PUBLIC_TIME);
				        Data.sid = mBundle.getString(KEY_MUSIC_SID);
				        Data.aid = mBundle.getString(KEY_MUSIC_AID);
				        Data.albumtitle = mBundle.getString(KEY_MUSIC_ALBUMTITLE);
				        Data.like = mBundle.getString(KEY_MUSIC_LIKE);
			
						return Data;
					}

					@Override
					public Song[] newArray(int size) {
						return new Song[size];
					}
					 
				 };
}
