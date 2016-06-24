package com.example.abraham.myapplication;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by Abraham on 23-06-16.
 */
public class MyLoading extends AsyncTask<Integer,Integer,Integer>{

    IAsyncTask callback;
    int max;
    public interface IAsyncTask{
        public void loadProgress(int progress);
        public void start();
        public void printStart();
        public void printEnd();
    }

    public MyLoading(IAsyncTask callback, int max){
        this.callback=callback;
        this.max=max;
    }
    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        callback.printStart();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        //super.onPostExecute(integer);
        callback.printEnd();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        for(int i=0;i<=100;i++){
            SystemClock.sleep(100);
            callback.loadProgress(i);
        }
        return null;
    }
}
