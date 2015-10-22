package com.zhakui.OnlyMusic.service;

import com.zhakui.OnlyMusic.data.Song;

interface IMusicManagerAIDL {

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

	void setPlayingSong(in Song path);
	
	void setMediaPathList(in List<Song> pathList);
	
	String getCurrentTime();

	int getCurrentPosition();
	
	void setPlayMode(int playMode);

	int getPlayMode();
	
	void addMediaPathList(in List<Song> pathList);
	
	void removeMediaPath(int index);
	
	void addMediaPath(in Song path);
	
	String getDurationTime();

	int getDuration();
   
   void sendPlayStateBrocast();
   
   	void setSourceType(int playMode);

	int getSourceType();
   
   void exit();
}