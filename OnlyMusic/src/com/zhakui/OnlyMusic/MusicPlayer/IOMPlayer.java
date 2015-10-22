package com.zhakui.OnlyMusic.MusicPlayer;

import java.util.List;

import android.media.MediaPlayer.OnCompletionListener;

import com.zhakui.OnlyMusic.data.Song;

public interface IOMPlayer {

	void play();

	void reset();

	void stop();

	void pause();

	void Prev();

	void next();
	
	boolean isPlaying();

	boolean isPause();
	
	void forward(int time);

	void rewind(int time);
	
	Song getPlayingSong();
	
	int getPlayingSongIndex();

	void setPlayingSong(Song path);
	
	void setMediaPathList(List<Song> pathList);
	
	String getCurrentTime();

	int getCurrentPosition();
	
	void setPlayMode(OMPlayMode playMode);

	OMPlayMode getPlayMode();
	
	void setOnCompletionListener(OnCompletionListener onCompletionListener);
	
	void addMediaPathList(List<Song> pathList);
	
	void removeMediaPath(int index);
	
	void addMediaPath(Song path);
	
	String getDurationTime();

	int getDuration();
	
	void release();
}
