package com.qandroid.common;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by chengxiang.peng on 2017/1/3.
 */

public class QBaseApplication extends Application {
    //保留全局refWatcher引用
    private RefWatcher refWatcher;

    /**
     * 获取全局RefWatcher引用对象
     */
    public static RefWatcher getRefWatcher(Context context) {
        QBaseApplication qBaseApplication = (QBaseApplication) context.getApplicationContext();
        return qBaseApplication.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);
    }
}
