package com.lwp.lintproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

/**
 * lint 静态代码检查
 * http://www.paincker.com/android-lint-2-implements#i
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show();

        Log.d("tag", "msg");

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).run();
    }



}
