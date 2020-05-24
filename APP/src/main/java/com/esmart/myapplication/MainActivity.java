package com.esmart.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    WebView wv;
    String url ="http://192.168.43.168" ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {





        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    wv.loadUrl("https://192.168.43.168/lightson.php");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_homeof);
                    wv.loadUrl("https://192.168.43.168/lightsoff.php");
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    wv.loadUrl("https://192.168.43.168/fanon.php");
                    return true;
                case R.id.off:
                    mTextMessage.setText(R.string.title_dashboardof);
                    wv.loadUrl("https://192.168.43.168/fanff.php");
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




        wv = (WebView)   findViewById(R.id.webview)   ;
        WebSettings settings = wv.getSettings();
        wv. setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);

        wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv.getSettings().setAppCacheEnabled(true);
        wv.getSettings().setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setSaveFormData(true);

        wv.setWebChromeClient(new WebChromeClient());



        wv.loadUrl(url);





    }

}
