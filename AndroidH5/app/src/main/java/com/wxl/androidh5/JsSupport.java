package com.wxl.androidh5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * 描述：添加类的描述
 *
 * @author Created by wxl
 * @e-mail mmwxl666@163.com
 * @time Created on 2018/6/7
 */
public class JsSupport {
    private String Json;
    private Context context;

    public JsSupport(Context context) {
        this.context = context;
    }
    @JavascriptInterface
    public String getJson() {
        return Json;
    }

    public void setJson(String json) {
        Json = json;
    }
    @JavascriptInterface
    public void ShowToast(String string){
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
