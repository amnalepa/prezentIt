package com.example.anna_maria.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;




public class video extends AppCompatActivity {
    public Button playback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        Integer minutes = intent.getIntExtra(MainActivity.EXTRA_MINUTES, 1);
        Integer seconds = intent.getIntExtra(MainActivity.EXTRA_SECONDS, 1);
        Log.d("test", "video " + minutes + " " + seconds);
        Integer timeInSeconds = (minutes*60)+seconds;
        Log.d("test", "test " + timeInSeconds);
        // mCountdownTxt.setText(timeInSeconds);


        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2VideoFragment.newInstance(timeInSeconds))
                    .commit();
        }

//        playback = (Button)findViewById(R.id.button);
//        playback.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // TODO Auto-generated method stub
//                        Intent userCreationIntent = new Intent(v.getContext(), PlaybackActivity.class);
//                        startActivityForResult(userCreationIntent, 0);
//                            Intent newIntent = new Intent(video.this, PlaybackActivity.class);
//                            startActivity(newIntent);
//                    }
//                }
//        );


    }





}
