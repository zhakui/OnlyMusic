package com.zhakui.OnlyMusic.service;

import java.util.ArrayList;
import java.util.List;

import com.zhakui.OnlyMusic.Activity.MainActivity;
import com.zhakui.OnlyMusic.Activity.R;
import com.zhakui.OnlyMusic.MusicPlayer.OMMusicPlayer;
import com.zhakui.OnlyMusic.MusicPlayer.OMPlayMode;
import com.zhakui.OnlyMusic.data.Song;
import com.zhakui.OnlyMusic.data.SourceType;
import com.zhakui.OnlyMusic.service.IMusicManagerAIDL.Stub;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.os.RemoteException;

public class MusicService extends Service implements OnCompletionListener{

	private final String BROCAST_NAME = "com.zhakui.OnlyMusic.brocast";
	private static final int PLAYING_NOTIFY_ID = 667667;
	
	NotificationManager nNotificationManager;
	private MusicManagerBinder MMBinder = new MusicManagerBinder(); 
	private OMMusicPlayer musicPlayer;
	
	@Override
	public IBinder onBind(Intent intent) {
		return MMBinder;
	}

	@Override
	public void onCreate() {
		musicPlayer = new OMMusicPlayer();
		musicPlayer.setOnCompletionListener(this);
		musicPlayer.setmContext(this);
		String notification = Context.NOTIFICATION_SERVICE;
		nNotificationManager = (NotificationManager) getSystemService(notification);
		super.onCreate();	
	}

	@Override
	public void onDestroy() {	
		musicPlayer.reset();
		musicPlayer.release();
		super.onDestroy();	
	}
	
	/**
	 * 发送歌曲信息到标题栏
	 */
	public void sendNotification() {
		Notification notification = new Notification(R.drawable.ic_launcher, "音乐播放器", System.currentTimeMillis());
		Context context = getApplicationContext();
		CharSequence contentTitle =musicPlayer.getPlayingSong().getTitle();
		CharSequence contentText = musicPlayer.getPlayingSong().getArtist();
		Intent noti = new Intent(Intent.ACTION_MAIN);
		noti.addCategory(Intent.CATEGORY_LAUNCHER);
		noti.setClass(this, MainActivity.class);
		noti.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, noti, 0);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		notification.flags |= Notification.FLAG_NO_CLEAR;
		//Finals修改
		startForeground(PLAYING_NOTIFY_ID, notification);
		//nNotificationManager.notify(1, notification);
	}
	
	public void sendPlayStateBrocast(int index, int type)
	{
			Intent intent = new Intent(BROCAST_NAME);
			intent.putExtra("TYPE",type);
			intent.putExtra("INDEX", index);

			this.sendBroadcast(intent);
	}
	
	
	public class MusicManagerBinder extends Stub
	{

		@Override
		public void play() throws RemoteException {
			musicPlayer.play();
			sendNotification();
		}

		@Override
		public void reset() throws RemoteException {
			musicPlayer.reset();
			musicPlayer.setMediaPathList(new ArrayList<Song>());
			musicPlayer.setPlayingSong(null);
			musicPlayer.setPlayOrder(new ArrayList<Integer>());
		}

		@Override
		public void stop() throws RemoteException {
			musicPlayer.stop();
		}

		@Override
		public void pause() throws RemoteException {
			musicPlayer.pause();
		}

		@Override
		public void Prev() throws RemoteException {
			musicPlayer.Prev();
		}

		@Override
		public void next() throws RemoteException {
			musicPlayer.next();
		}

		@Override
		public boolean isPlaying() throws RemoteException {
			return musicPlayer.isPlaying();
		}

		@Override
		public boolean isPause() throws RemoteException {
			return musicPlayer.isPause();
		}

		@Override
		public void forward(int time) throws RemoteException {
			musicPlayer.forward(time);
		}

		@Override
		public void rewind(int time) throws RemoteException {
			musicPlayer.rewind(time);
		}

		@Override
		public Song getPlayingSong() throws RemoteException {
			return musicPlayer.getPlayingSong();
		}

		@Override
		public int getPlayingSongIndex() throws RemoteException {
			return musicPlayer.getPlayingSongIndex();
		}

		@Override
		public void setPlayingSong(Song path) throws RemoteException {
			musicPlayer.setPlayingSong(path);
		}

		@Override
		public void setMediaPathList(List<Song> pathList)
				throws RemoteException {
			musicPlayer.setMediaPathList(pathList);
		}

		@Override
		public String getCurrentTime() throws RemoteException {
			return musicPlayer.getCurrentTime();
		}

		@Override
		public int getCurrentPosition() throws RemoteException {
			return musicPlayer.getCurrentPosition();
		}

		@Override
		public void setPlayMode(int playMode) throws RemoteException {
			musicPlayer.setPlayMode(OMPlayMode.values()[playMode]);
		}

		@Override
		public int getPlayMode() throws RemoteException {
			return musicPlayer.getPlayMode().ordinal();
		}

		@Override
		public void addMediaPathList(List<Song> pathList)
				throws RemoteException {
			musicPlayer.addMediaPathList(pathList);
		}

		@Override
		public void removeMediaPath(int index) throws RemoteException {
			musicPlayer.removeMediaPath(index);
		}

		@Override
		public void addMediaPath(Song path) throws RemoteException {
			musicPlayer.addMediaPath(path);
		}

		@Override
		public String getDurationTime() throws RemoteException {
			return musicPlayer.getDurationTime();
		}

		@Override
		public int getDuration() throws RemoteException {
			return musicPlayer.getDuration();
		}

		@Override
		public void sendPlayStateBrocast() throws RemoteException {

		}

		@Override
		public void exit() throws RemoteException {
			musicPlayer.reset();
			musicPlayer.release();
		}

		@Override
		public void setSourceType(int sourcetype) throws RemoteException {
			musicPlayer.setSourcetype(SourceType.values()[sourcetype]);
		}

		@Override
		public int getSourceType() throws RemoteException {
			return musicPlayer.getSourcetype().ordinal();
		}}


	@Override
	public void onCompletion(MediaPlayer mp) {
		musicPlayer.next();
		sendPlayStateBrocast(musicPlayer.getPlayingSongIndex(),musicPlayer.getSourcetype().ordinal());
	}

}
