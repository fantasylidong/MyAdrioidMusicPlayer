package cn.lidongspace.www.mymusicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;

import java.io.IOException;

public class MusicService extends Service {
    private static final String TAG="MusicService";
    public MediaPlayer mediaPlayer;
    public MusicService() {
    }
class MyBinder extends Binder {
        public void play(String path){
            try{
                if(mediaPlayer==null){
                    mediaPlayer=new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    mediaPlayer.setDataSource(path);

                    mediaPlayer.prepare();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });

                }
                else{
                    int position=getCurrentProgress();
                    mediaPlayer.seekTo(position);
                    try{
                        mediaPlayer.prepare();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
           catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void pause(){
            if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
                mediaPlayer.pause();

            }else if(mediaPlayer!=null&&(!mediaPlayer.isPlaying())){
                mediaPlayer.start();
            }
        }
}
public void onCreate(){
        super.onCreate();
}
public int getCurrentProgress(){
    if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
        return mediaPlayer.getCurrentPosition();

    }else if(mediaPlayer!=null&&(!mediaPlayer.isPlaying())){
       return  mediaPlayer.getCurrentPosition();
    }
    return 0;
}
public void onDestory(){
    if(mediaPlayer!=null){
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
    }
}
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }
}
