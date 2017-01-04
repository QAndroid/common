package com.qandroid.common;

import android.app.Fragment;

import com.squareup.leakcanary.RefWatcher;

/**
 * 在onDestroy使用leakCanary检测Fragment是否泄漏
 * Created by chengxiang.peng on 2017/1/3.
 */

public class QBaseFragment extends Fragment{
    @Override
    public void onDestroy() {
        super.onDestroy();

        //检测Fragment是否泄漏
        RefWatcher refWatcher = QBaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
