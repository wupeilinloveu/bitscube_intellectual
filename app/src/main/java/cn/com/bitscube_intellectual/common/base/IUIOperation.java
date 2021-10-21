package cn.com.bitscube_intellectual.common.base;

import android.view.View;

/**
 * 封装的UI接口
 * Created by Emily on 9/6/21
 */

public interface IUIOperation extends View.OnClickListener {
    /**
     * 布局
     */
    int getLayoutRes();

    /**
     * 初始化布局
     */
    void initView();

    /**
     * 设置监听
     */
    void initListener();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 点击事件
     */
    void onClick(View v, int id);
}

