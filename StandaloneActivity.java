package com.example.rit.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    private String GOOGLE_API_KEY="47701985551-0gmp6uos5484qqtnt8h4gb5755jfkce9.apps.googleusercontent.com";
    private String YOUTUBE_VIDEO_ID="Yctd8sL9U6c";
    private String  YOUTUBE_PLAYLIST="PLx0sYbCqOb8TBPRdmBHs5Iftvv9TPboYG";
    private Button  btnVideo;
    private Button  btnPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//             setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        btnPlaylist=(Button)findViewById(R.id.btnPlayList);
        btnVideo=(Button)findViewById(R.id.btnPlayVideo);

        btnVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent= null;

        switch(v.getId()){
            case R.id.btnPlayVideo:
                intent= YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent=YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST);
                break;
            default:

        }
        if(intent!=null)
            startActivity(intent);

    }
}
