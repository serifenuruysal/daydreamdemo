package com.turkcell.daydreamdemo.service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.service.dreams.DreamService;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.turkcell.daydreamdemo.R;

/**
 * Created by serifenuruysal on 11/05/16.
 */
public class Screensaver extends DreamService {
    private class LinkLauncher extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
    }
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setContentView(R.layout.layout_web);
        setFullscreen(true);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        final String url = prefs.getString("url", "file:///android_asset/default.html");
        String url="https://vimeo.com/moogaloop.swf?clip_id=148385707&amp;autoplay=1";
        final boolean interactive = prefs.getBoolean("interactive", false);
        Log.v("WebViewDream", String.format("loading %s in %s mode",
                url, interactive ? "interactive" : "noninteractive"));
        setInteractive(interactive);
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new LinkLauncher());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.loadUrl(url);
    }
}