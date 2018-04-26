package cn.lidongspace.www.mymusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton SearchAction;
    private EditText SearchSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchAction=(ImageButton)findViewById(R.id.serachaction);
        SearchSong=(EditText)findViewById(R.id.serachsong);


    }
    public void setting(View v){
        Intent i= new Intent(this,SettingActivity.class);
        startActivity(i);
    }
    public void searchsong(View v){
        Intent i= new Intent(this,SearchActivity.class);
        startActivity(i);
    }
    public void localsong(View v){
        Intent i=new Intent(this,localsongActivity.class);
        startActivity(i);
    }
    public void Onplayhistory(View v){
        Intent i=new Intent(this,playhistotyActivity.class);
        startActivity(i);
    }
}
