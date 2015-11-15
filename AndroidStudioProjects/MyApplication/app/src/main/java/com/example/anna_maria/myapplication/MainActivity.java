package com.example.anna_maria.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MINUTES = "com.example.anna_maria.myapplication.minutes";
    public final static String EXTRA_SECONDS = "com.example.anna_maria.myapplication.seconds";

    List<Integer> minutes = new ArrayList<>();
    List<Integer> seconds = new ArrayList<>();
    Button btn_Go;

    TextView txtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);


        for(int i=0;i<=60;i++){
            minutes.add(i);
        }


        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        for(int j=0;j<=60;j++){
            seconds.add(j);
        }

        // Create the ArrayAdapter
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this
                ,android.R.layout.simple_spinner_item, minutes);

        // Set the Adapter
        spinner.setAdapter(arrayAdapter);

        // Set the ClickListener for Spinner
        spinner.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,"You Selected : "
                        + minutes.get(i)+" Level ",Toast.LENGTH_SHORT).show();

            }
            // If no option selected
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        // Create the ArrayAdapter
        ArrayAdapter<Integer> arrayAdapter2 = new ArrayAdapter<Integer>(this
                ,android.R.layout.simple_spinner_item, seconds);

        // Set the Adapter
        spinner2.setAdapter(arrayAdapter2);

        // Set the ClickListener for Spinner
        spinner2.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,"You Selected : "
                        + seconds.get(i)+" Level ",Toast.LENGTH_SHORT).show();

            }
            // If no option selected
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });




        btn_Go = (Button) findViewById(R.id.goBut);
        btn_Go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Takes spinner input values and passes to video activity for video length
                final int minutesInput = Integer.valueOf(spinner.getSelectedItem().toString());
                final int secondsInput = Integer.valueOf(spinner2.getSelectedItem().toString());

                Intent intent = new Intent(MainActivity.this, video.class);
                intent.putExtra(EXTRA_MINUTES, minutesInput);
                intent.putExtra(EXTRA_SECONDS, secondsInput);

                Log.d("test", "main " + minutesInput + " " + secondsInput);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
