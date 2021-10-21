package cn.com.bitscube_intellectual.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.base.Global;
import cn.com.bitscube_intellectual.common.util.SharedPreUtil;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 启动页
 * Created by Emily on 9/9/21
 */
public class SplashActivity extends SupportActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Global.getMainHandler().postDelayed(() -> {
 //            if (isFirst()) {
//                startActivity(new Intent(this, GuideActivity.class));
//                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//                finish();
//            } else {
//                startActivity(new Intent(this, LoginActivity.class));
//                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//                finish();
//            }

            String login = SharedPreUtil.getString(this, Const.APP_IS_LOGIN, "");
            if(!login.isEmpty()){
                startActivity(new Intent(this, MainActivity.class));
            }else{
                startActivity(new Intent(this, LoginActivity.class));
            }
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            finish();
        }, 2000);
    }

    //判断程序是否是第一次运行
    private boolean isFirst() {
        boolean isFirst = SharedPreUtil.getBoolean(this,Const.APP_IS_FIRST,true);
        if (isFirst) {
            SharedPreUtil.saveBoolean(this,  Const.APP_IS_FIRST, false);
            //是第一次运行
            return true;
        } else {
            //不是第一次运行
            return false;
        }
    }
}
