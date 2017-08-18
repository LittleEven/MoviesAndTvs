package com.LittleEven.xunyingwang.commune;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.LittleEven.xunyingwang.R;
import com.LittleEven.xunyingwang.base.BaseActivity;

public class DialogueActivity extends BaseActivity {
    private WebView mWebView;
    private String mId = "";
    private String URL_DIALOGUE = "http://www.xunyingwang.com%s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dialogue);
        initData();
        initID();
        initView();
    }

    private void initView() {
        //WebView设置
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        String REAL_URL = String.format(URL_DIALOGUE, mId);
        //将内容显示到网页上面
        mWebView.loadUrl(REAL_URL);
    }

    private void initID() {
        mWebView = (WebView) findViewById(R.id.dialogue_webview);
    }

    private void initData() {
        mId = getIntent().getStringExtra("id");
    }
}
