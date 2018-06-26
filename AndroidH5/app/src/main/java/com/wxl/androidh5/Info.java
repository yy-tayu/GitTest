package com.wxl.androidh5;

/**
 * 描述：添加类的描述
 *
 * @author Created by wxl
 * @e-mail mmwxl666@163.com
 * @time Created on 2018/6/7
 */
public class Info {
    private String title;
    private String content;
    private String icon;

    public Info(String title, String content, String icon) {
        this.title = title;
        this.content = content;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
