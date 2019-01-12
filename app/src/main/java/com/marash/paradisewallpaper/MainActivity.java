package com.marash.paradisewallpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.marash.paradisewallpaper.flickr.FlickrSearchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoSearchPage(View view) {
        Intent intent = new Intent(this, FlickrSearchActivity.class);
        startActivity(intent);
    }
}
