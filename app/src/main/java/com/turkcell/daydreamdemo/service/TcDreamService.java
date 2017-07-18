package com.turkcell.daydreamdemo.service;

import android.net.Uri;
import android.service.dreams.DreamService;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.turkcell.daydreamdemo.R;

/**
 * Created by serifenuruysal on 11/05/16.
 */
public class TcDreamService extends DreamService implements View.OnClickListener {
    public static final String TAG = TcDreamService.class.getSimpleName();

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        Log.d(TAG, "onDreamingStarted: ");
    }

    @Override
    public void onDreamingStopped() {
        super.onDreamingStopped();
        Log.d(TAG, "onDreamingStopped: ");
    }

    @Override
    public void onAttachedToWindow() {
        setInteractive(false);
        setFullscreen(true);

        RelativeLayout r1 = new RelativeLayout(this);
//
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(300, 250);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
//
//        TextView textView = new TextView(this);
//        textView.setText("This is a demo of the DayDream service");
//        textView.setTextSize(15);
//        textView.setLayoutParams(params);
//
//        r1.addView(textView, params);


        setContentView(R.layout.dream_layout);

        VideoView videoLayout;


        Uri videoUri = Uri.parse("https://vimeo.com/moogaloop.swf?clip_id=148385707&amp;autoplay=1");

        VideoView mVideoView  = new VideoView(this);
        MediaController videoMediaController = new MediaController(this);
        mVideoView.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");
        videoMediaController.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(videoMediaController);
        mVideoView.requestFocus();
        mVideoView.start();
        r1.addView(mVideoView, params);

//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=8LWZSGNjuF0"));
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(i);

    }

    @Override
    public void onDetachedFromWindow() {
//tidy up
    }

    @Override
    public void onClick(View v) {

    }
}
