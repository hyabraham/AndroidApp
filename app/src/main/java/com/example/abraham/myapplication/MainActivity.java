package com.example.abraham.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyLoading.IAsyncTask{

    MyLoading ml;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar)findViewById(R.id.progressb);
    }

    @Override
    public void loadProgress(int progress) {
        pb.setProgress(progress);
    }

    @Override
    public void start() {
        ml=new MyLoading(this,100);
        ml.execute();

    }

    @Override
    public void printStart() {
        Toast.makeText(MainActivity.this, "Loadingstart...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void printEnd() {
        Toast.makeText(MainActivity.this, "Loading end...", Toast.LENGTH_SHORT).show();

    }
    public void startProgress(View v){
        start();
    }
}
