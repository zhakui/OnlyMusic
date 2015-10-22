package com.zhakui.OnlyMusic.service;


import java.util.List;

import com.zhakui.OnlyMusic.MusicPlayer.OMPlayMode;
import com.zhakui.OnlyMusic.data.Song;
import com.zhakui.OnlyMusic.data.SourceType;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

public class ServiceManager {
	
	private final static String SERVICE_NAME = "com.zhakui.onlymusic.service.musicservice";
	
	private ServiceConnection mServiceConnection;

	private IMusicManagerAIDL mMusicConnect;
	
	private Boolean mConnectComplete;
	
	private Context mContext;
	
	private IOnServiceConnectComplete mIOnServiceConnectComplete;
	
	public ServiceManager(Context context)
	{
		mContext = context;
		defaultParam();
	}
	
	private void defaultParam()
	{
		mMusicConnect = null;
		mConnectComplete = false;
		mServiceConnection = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				mMusicConnect = null;
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {

				mMusicConnect = IMusicManagerAIDL.Stub.asInterface(service);
				if (mMusicConnect != null)
				{
					if (mIOnServiceConnectComplete != null)
					{
						mIOnServiceConnectComplete.OnServiceConnectComplete();
					}
				}
			}
		};		
	}
	
	public void setOnServiceConnectComplete(IOnServiceConnectComplete IServiceConnect)
	{
		mIOnServiceConnectComplete = IServiceConnect;
	}
	
	public boolean connectService()
	{
		if (mConnectComplete == true)
		{
			return true;
		}
		
		Intent intent = new Intent(SERVICE_NAME);
		if (mContext != null)
		{
			mContext.startService(intent);
			mContext.bindService(intent, mServiceConnection,  Context.BIND_AUTO_CREATE);
			mConnectComplete = true;
			return  true;
		}
		
		return false;
	}
	
	public boolean disconnectService()
	{
		if (mConnectComplete == false)
		{
			return true;
		}
		
		if (mContext != null)
		{
			mContext.unbindService(mServiceConnection);	
			mMusicConnect = null;
			mConnectComplete = false;
			return true;
		}
		return false;
	}
	
	public void exit()
	{
		if (mConnectComplete)
		{
			try {
				mMusicConnect.exit();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			Intent intent = new Intent(SERVICE_NAME);
			mContext.unbindService(mServiceConnection);	
			mContext.stopService(intent);
			mMusicConnect = null;
			mConnectComplete = false;

		}
	}
	
	public void reset()
	{
		if (mConnectComplete)
		{
			try {
				mMusicConnect.reset();
			} catch (RemoteException e) {
			}
		}
	}
	
	public void play()
	{
		try {
			mMusicConnect.play();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void stop()
	{
		try {
			mMusicConnect.stop();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void pause()
	{
		try {
			mMusicConnect.pause();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void Prev()
	{
		try {
			mMusicConnect.Prev();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void next()
	{
		try {
			mMusicConnect.next();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isPlaying()
	{
		try {
			return mMusicConnect.isPlaying();
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isPause()
	{
		try {
			return mMusicConnect.isPause();
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void forward(int time)
	{
		try {
			mMusicConnect.forward(time);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void rewind(int time)
	{
		try {
			mMusicConnect.rewind(time);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public Song getPlayingSong()
	{
		try {
			return mMusicConnect.getPlayingSong();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getPlayingSongIndex()
	{
		try {
			return mMusicConnect.getPlayingSongIndex();
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void setPlayingSong(Song path)
	{
		try {
			mMusicConnect.setPlayingSong(path);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void setMediaPathList(List<Song> pathList)
	{
		try {
			mMusicConnect.setMediaPathList(pathList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String getCurrentTime()
	{
		try {
			return mMusicConnect.getCurrentTime();
		} catch (RemoteException e) {
			e.printStackTrace();
			return "0:0";
		}
	}

	public int getCurrentPosition()
	{
		try {
			return mMusicConnect.getCurrentPosition();
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void setPlayMode(OMPlayMode playMode)
	{
		try {
			mMusicConnect.setPlayMode(playMode.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public OMPlayMode getPlayMode()
	{
		try {
			return OMPlayMode.values()[mMusicConnect.getPlayMode()];
		} catch (RemoteException e) {
			e.printStackTrace();
			return OMPlayMode.MPM_LIST_LOOP_PLAY;
		}
	}
	
	public void addMediaPathList(List<Song> pathList)
	{
		try {
			mMusicConnect.addMediaPathList(pathList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void removeMediaPath(int index)
	{
		try {
			mMusicConnect.removeMediaPath(index);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void addMediaPath(Song path)
	{
		try {
			mMusicConnect.addMediaPath(path);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String getDurationTime()
	{
		try {
			return mMusicConnect.getDurationTime();
		} catch (RemoteException e) {
			e.printStackTrace();
			return "0:0";
		}
	}

	public int getDuration()
	{
		try {
			return mMusicConnect.getDuration();
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void setSourceType(SourceType sourcetype) {
		try {
			mMusicConnect.setSourceType(sourcetype.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public SourceType getSourceType(){
		try {
			return SourceType.values()[mMusicConnect.getSourceType()];
		} catch (RemoteException e) {
			e.printStackTrace();
			return SourceType.LOCAL;
		}
	}

}
