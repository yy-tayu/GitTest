package com.wxl.androidh5;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private WebView main_web_view;
    private Button js_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        js_btn=findViewById(R.id.js_btn);
        main_web_view=findViewById(R.id.main_web_view);
        //js支持
        WebSettings webSettings=main_web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //运行访问assets目录
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        //设置WebView排版算法, 实现单列显示, 不允许横向移动
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        String path="file:///android_asset/index.html";
        //添加Json数据
        addJson();
        main_web_view.loadUrl(path);
        //设置后使用内部浏览器 从而不会跳转到外部浏览器
        main_web_view.setWebViewClient(new WebViewClient());



    }

    private void addJson() {
        JsSupport json=new JsSupport(this);
        List<Info> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Info("鹿鹿" + i,  "这里是Html测试数据, 这里是Html测试数据, 这里是Html测试数据" + i,"img/qq.png"));
        }
        Gson gson=new Gson();
        String jj=gson.toJson(list);
        Log.i(TAG, "addJson: json => " + jj);
        json.setJson(jj);

        main_web_view.addJavascriptInterface(json,"jsons");
    }

    @Override
    public void onBackPressed() {
        if (main_web_view.canGoBack()){
            main_web_view.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
