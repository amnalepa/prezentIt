package com.example.anna_maria.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class PlaybackActivity extends AppCompatActivity {

    ListView listView;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lvPlaylist);

//        ArrayList<File> myVideos = findVideos(Environment.getExternalStorageDirectory());
        File file = new File("/sdcard/Videos");
        final ArrayList<File> myVideos = findVideos(file);
        items = new String[myVideos.size()];

        for(int i = 0; i<myVideos.size(); i++){
            //toast(myVideos.get(i).getName().toString());
            toast(myVideos.get(i).getPath());
            items[i] = myVideos.get(i).getName().toString();
//            myVideos.get(i).getPath();
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(),R.layout.video_list_layout,R.id.textView,items);
        listView.setAdapter(adp);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myVideos.get(position).getPath()));
                intent.setDataAndType(Uri.parse(myVideos.get(position).getPath()), "video/mp4");
                startActivity(intent);
            }
        });
    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    public ArrayList<File> findVideos(File root){
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();
        for(File singleFile : files){
//            Recursion used for finding videos in child folders
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(findVideos(singleFile));
            } else {
                if(singleFile.getName().endsWith(".mp4")){
                    al.add(singleFile);
                }
            }
        }
        return al;
    }
}
