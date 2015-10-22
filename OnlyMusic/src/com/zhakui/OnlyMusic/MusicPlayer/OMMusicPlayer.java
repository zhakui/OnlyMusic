package com.zhakui.OnlyMusic.MusicPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import com.zhakui.OnlyMusic.data.Song;
import com.zhakui.OnlyMusic.data.SourceType;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.util.Log;

public class OMMusicPlayer implements IOMPlayer, OnErrorListener {
	
	private final String BROCAST_SONG = "com.zhakui.OnlyMusic.song";
	
	private MediaPlayer mMediaPlayer;
	private List<Song> mSongList = new ArrayList<Song>();
	private List<Integer> playOrder = new ArrayList<Integer>();
	private int selectedOrderIndex = 0;
	private SourceType sourcetype = SourceType.LOCAL;
	private Context mContext;
	
	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	public SourceType getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(SourceType sourcetype) {
		this.sourcetype = sourcetype;
	}

	public int getSelectedOrderIndex() {
		return selectedOrderIndex;
	}

	public void setSelectedOrderIndex(int selectedOrderIndex) {
		this.selectedOrderIndex = selectedOrderIndex;
	}

	private boolean isPause = false;
	private Song playPath;
	private OMPlayMode mPlayMode = OMPlayMode.MPM_LIST_LOOP_PLAY;
	
	public List<Integer> getPlayOrder() {
		return playOrder;
	}

	public void setPlayOrder(List<Integer> playOrder) {
		this.playOrder = playOrder;
	}

	public OMMusicPlayer()
	{
		mMediaPlayer = new MediaPlayer();
	}
	
	public List<Song> getmSongList() {
		return mSongList;
	}
	
	@Override
	public void play() {
		if(null == playPath && mSongList.size()>0)
		{
			playPath = mSongList.get(0);
		}
		try {
			reset();
			sendSongInfoBrocast(playPath);
			mMediaPlayer.setDataSource(playPath.getUrl());
			if (!isPause) {
				mMediaPlayer.prepare();
			}
			mMediaPlayer.start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reset() {
		isPause = false;
		mMediaPlayer.reset();
	}

	@Override
	public void stop() {
		isPause = false;
		mMediaPlayer.stop();	
	}

	@Override
	public void pause() {
		isPause = true;
		mMediaPlayer.pause();		
	}

	@Override
	public void Prev() {
		if (mSongList.size() > 0) {
			selectedOrderIndex = getSelectedOrderIndexByPath(playPath);
			selectedOrderIndex--;
			if (selectedOrderIndex < 0) {
				selectedOrderIndex = mSongList.size() - 1;
			}
			playPath = getPathByPlaybackOrderIndex(selectedOrderIndex);
			play();
		}
	}

	@Override
	public void next() {
		if (mSongList.size() > 0) {
			selectedOrderIndex = mSongList.indexOf(playPath);
			selectedOrderIndex++;
			selectedOrderIndex %= mSongList.size();
			playPath = getPathByPlaybackOrderIndex(selectedOrderIndex);
			play();
		}
	}

	@Override
	public boolean isPlaying() {
		return mMediaPlayer.isPlaying();
	}

	@Override
	public boolean isPause() {
		return isPause;
	}

	@Override
	public void forward(int time) {		
		mMediaPlayer.seekTo(time);
	}

	@Override
	public void rewind(int time) {		
		mMediaPlayer.seekTo(time);
	}

	@Override
	public Song getPlayingSong() {
		return this.playPath;
	}

	@Override
	public void setPlayingSong(Song path) {
		this.playPath = path;
	}

	@Override
	public void setMediaPathList(List<Song> pathList) {
		this.mSongList = pathList;
		calculateOrder(true);
	}

	@Override
	public String getCurrentTime() {
		return getTime(mMediaPlayer.getCurrentPosition());
	}

	@Override
	public int getCurrentPosition() {
		return mMediaPlayer.getCurrentPosition();
	}
	
	@Override
	public void setPlayMode(OMPlayMode playMode) {
		this.mPlayMode = playMode;
		calculateOrder(true);
	}

	@Override
	public OMPlayMode getPlayMode() {
		return this.mPlayMode;
	}
	
	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		Log.e("OMPlayer", "OMPlayer onError!\n");
		return false;
	}
	
	@Override
	public int getPlayingSongIndex()
	{
		return getSelectedOrderIndexByPath(playPath);
	}
	
	@Override
	public void addMediaPathList(List<Song> pathList)
	{
		this.mSongList.addAll(pathList);
	}
	
	@Override
	public void removeMediaPath(int index)
	{
		this.mSongList.remove(index);
	}
	
	@Override
	public void addMediaPath(Song path)
	{
		this.mSongList.add(path);
	}
	
	@Override
	public String getDurationTime()
	{
		return getTime(this.mMediaPlayer.getDuration());
	}

	@Override
	public int getDuration()
	{
		return this.mMediaPlayer.getDuration();
	}
	
	@Override
	public void release()
	{
		mMediaPlayer.release();
	}
	
	private String getTime(int timeMs) {
		int totalSeconds = timeMs / 1000;// 获取文件有多少秒
		StringBuilder mFormatBuilder = new StringBuilder();
		Formatter mFormatter = new Formatter(mFormatBuilder, Locale
				.getDefault());
		int seconds = totalSeconds % 60;
		int minutes = (totalSeconds / 60) % 60;
		int hours = totalSeconds / 3600;
		mFormatBuilder.setLength(0);

		if (hours > 0) {
			return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds)
					.toString();// 格式化字符串
		} else {
			return mFormatter.format("%02d:%02d", minutes, seconds).toString();
		}
	}
	
	private int getSelectedOrderIndexByPath(Song path) {
		int selectedIndex = mSongList.indexOf(path);
		return playOrder.indexOf(selectedIndex);
	}

	private Song getPathByPlaybackOrderIndex(int index) {
		return mSongList.get(playOrder.get(index));
	}
	
	private void calculateOrder(boolean force) {
		int beforeSelected = 0;
		if (!playOrder.isEmpty()) {
			beforeSelected = playOrder.get(selectedOrderIndex);
			playOrder.clear();
		}
		for (int i = 0; i < mSongList.size(); i++) {
			playOrder.add(i, i);
		}

		if (null == mPlayMode) {
			mPlayMode = OMPlayMode.MPM_LIST_LOOP_PLAY;
		}
		switch (mPlayMode) {
		case MPM_ORDER_PLAY: {
			break;
		}
		case MPM_RANDOM_PLAY: {
			Collections.shuffle(playOrder);
			break;
		}
		case MPM_SINGLE_LOOP_PLAY: {
			selectedOrderIndex = beforeSelected;
			break;
		}
		case MPM_LIST_LOOP_PLAY: {
			break;
		}
		default: {
			break;
		}
		}
	}
	
	public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
		mMediaPlayer.setOnCompletionListener(onCompletionListener);
	}
	
	public void sendSongInfoBrocast(Song song)
	{
			Intent intent = new Intent(BROCAST_SONG);
			Bundle bundle = new Bundle();
			bundle.putParcelable(Song.KEY_MUSIC_DATA, song);
			intent.putExtra(Song.KEY_MUSIC_DATA, bundle);
			mContext.sendBroadcast(intent);
	}
}
