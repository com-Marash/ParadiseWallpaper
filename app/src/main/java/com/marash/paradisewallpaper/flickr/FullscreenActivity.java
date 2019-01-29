package com.marash.paradisewallpaper.flickr;

import android.app.WallpaperManager;
import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.samples.flickr.GlideApp;
import com.bumptech.glide.samples.flickr.GlideRequest;
import com.marash.paradisewallpaper.flickr.api.Photo;
import com.marash.paradisewallpaper.R;

import java.io.IOException;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;
import static com.bumptech.glide.request.RequestOptions.centerInsideTransform;
import static com.bumptech.glide.request.RequestOptions.circleCropTransform;
import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;
import static com.bumptech.glide.request.RequestOptions.noTransformation;

/**
 * A simple activity for viewing a single photo.
 */
public class FullscreenActivity extends FragmentActivity {
    private static final String ARG_PHOTO = "photo";

    public static Intent getIntent(Context context, Photo photo) {
        Intent intent = new Intent(context, FullscreenActivity.class);
        intent.putExtra(ARG_PHOTO, photo);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreen_activity);
        ImageView fullscreenView = (ImageView) findViewById(R.id.fullscreen_view);
        Photo photo = getIntent().getParcelableExtra(ARG_PHOTO);
        GlideApp.with(this).load(photo).apply(noTransformation()).into(fullscreenView);
    }

    public void setAsWallpaper(View view) {
        ImageView fullscreenView = (ImageView) findViewById(R.id.fullscreen_view);
        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        BitmapDrawable bitmapDrawable = ((BitmapDrawable) fullscreenView.getDrawable());

        Bitmap wallpaperBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), myWallpaperManager.getDesiredMinimumWidth(), myWallpaperManager.getDesiredMinimumHeight(), true);
        myWallpaperManager.suggestDesiredDimensions(myWallpaperManager.getDesiredMinimumWidth(), myWallpaperManager.getDesiredMinimumHeight());

        try {
            myWallpaperManager.setBitmap(wallpaperBitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveThisWallpaper(View view) {
    }
}