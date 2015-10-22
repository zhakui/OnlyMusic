package com.zhakui.OnlyMusic.Activity;

import java.util.List;

import com.zhakui.OnlyMusic.FMCore.*;
import com.zhakui.OnlyMusic.Util.Utility;
import com.zhakui.OnlyMusic.data.Song;
import com.zhakui.OnlyMusic.data.SourceType;
import com.zhakui.OnlyMusic.service.IOnServiceConnectComplete;
import com.zhakui.OnlyMusic.service.ServiceManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements IOnServiceConnectComplete
{
	private final String BROCAST_NAME = "com.zhakui.OnlyMusic.brocast";
	private final String BROCAST_SONG = "com.zhakui.OnlyMusic.song";
	
	private ServiceManager mServiceManager;
	private MusicStateBrocast mPlayStateBrocast;
	private MusicInfoBrocast mMusicInfoBrocast;
	private List<Song> songlist;
	private ImageView btnImage;
	private ImageView lryImage;
	private TextView  musicName;
	private TextView  singer;
	private TextView Title;
	private TextView current_time;
	private TextView total_time;
	private SeekBar seek_bar;
	private Utility utility = new Utility();
	
	private Handler hander = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what == 1)
			{
				try {
					songlist = songInfo.getSonglist();
					mServiceManager.setSourceType(SourceType.DOUBANFM);
					mServiceManager.setMediaPathList(songlist);
					if(!mServiceManager.isPlaying())
					{mServiceManager.play();}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(msg.what == 2)
			{
				lryImage.setImageBitmap(utility.getBitMap());
			}
		}
	};
	
	SongInfo songInfo = new SongInfo(hander);
	
	private Runnable refresh = new Runnable() {
		public void run() {
    		int rate = 0;
    		if (mServiceManager.getDuration() != 0)
    		{
    			rate = (int) ((float)mServiceManager.getCurrentPosition() 
    					/ mServiceManager.getDuration() * 100);       		       
    		}
			seek_bar.setProgress(rate);
			current_time.setText(mServiceManager.getCurrentTime());
					hander.postDelayed(refresh, 1000);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnImage = (ImageView)findViewById(R.id.next);
		btnImage.setOnClickListener(btnImageOnClickListener);
		lryImage = (ImageView)findViewById(R.id.drawable_head);
		musicName = (TextView)findViewById(R.id.music_name);
		singer = (TextView)findViewById(R.id.singer);
		Title = (TextView)findViewById(R.id.Title);
		current_time = (TextView)findViewById(R.id.current_time);
		total_time = (TextView)findViewById(R.id.total_time);
		seek_bar = (SeekBar)findViewById(R.id.playback_seeker);
		seek_bar.setOnSeekBarChangeListener(seekbarListener);
		init();
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
	}
	
	@Override
	protected void onDestroy()
	{
		hander.removeCallbacks(refresh);
		mServiceManager.disconnectService();
		super.onDestroy();
	}
	
	public void init()
    {	

		mServiceManager = new ServiceManager(this);
		mServiceManager.setOnServiceConnectComplete(this);
		mServiceManager.connectService();

		mPlayStateBrocast = new MusicStateBrocast();
		IntentFilter PlayStateFilter = new IntentFilter(BROCAST_NAME);
		registerReceiver(mPlayStateBrocast, PlayStateFilter);	
		
		mMusicInfoBrocast = new MusicInfoBrocast();
		IntentFilter SongInfoFilter = new IntentFilter(BROCAST_SONG);
		registerReceiver(mMusicInfoBrocast, SongInfoFilter);	
		songInfo.requestSongInfo();
    }
	
	private void setSongInfo(Song song)
	{
		hander.removeCallbacks(refresh);
		 hander.postDelayed(refresh, 1000);
		if (mServiceManager.getPlayingSong() != null
				&& "" != mServiceManager.getPlayingSong().getUrl()) {
			current_time.setText(mServiceManager.getCurrentTime());
			total_time.setText(mServiceManager.getDurationTime());
		}
		musicName.setText(song.getTitle());
		Title.setText(song.getTitle());
		singer.setText(song.getArtist());
		utility.setHandler(hander);
		utility.setUrl(song.getPicture());
		utility.RequestBitMap();
	}
	
	OnClickListener btnImageOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			mServiceManager.next();
		}
	};
	
	OnSeekBarChangeListener seekbarListener = new OnSeekBarChangeListener() {
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			if (fromUser) {
				if (mServiceManager.getPlayingSong() != null && "" != mServiceManager.getPlayingSong().getUrl()) {
					hander.removeCallbacks(refresh);
					current_time.setText(mServiceManager.getCurrentTime());
				}
			}

		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			if (mServiceManager.getPlayingSong() != null && "" != mServiceManager.getPlayingSong().getUrl()) {
				mServiceManager.forward(seekBar.getProgress());
				hander.postDelayed(refresh, 1000);
			} else {
				seek_bar.setProgress(0);
			}
		}
	};
	
	class  MusicStateBrocast extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			  String action = intent.getAction(); 
			  if (action.equals(BROCAST_NAME))
			  {
				 if(SourceType.values()[intent.getIntExtra("TYPE", 0)] == SourceType.DOUBANFM
						 && intent.getIntExtra("INDEX", 0) == songlist.size()-2)
				 {
					 songInfo.requestSongInfo();
				 }
			  }
		}
	}
	
	class  MusicInfoBrocast extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			  String action = intent.getAction(); 
			  if (action.equals(BROCAST_SONG))
			  {
				 Bundle bundle = intent.getBundleExtra(Song.KEY_MUSIC_DATA);
				 Song song = bundle.getParcelable(Song.KEY_MUSIC_DATA);
				 setSongInfo(song);
			  }
		}
	}

	@Override
	public void OnServiceConnectComplete() {
		if(mServiceManager.isPlaying())
		{
			setSongInfo(mServiceManager.getPlayingSong());
		}
	}
}
