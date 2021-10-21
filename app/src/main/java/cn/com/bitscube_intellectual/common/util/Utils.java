package cn.com.bitscube_intellectual.common.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.RequiresApi;

import com.squareup.picasso.Picasso;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.ui.view.CircleCornerForm;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 封装方法工具类
 * Created by Emily on 9/6/21
 */
public class Utils {
    /**
     * 一键清除文本
     */
    public static TextWatcher textClearWatcher(ToggleButton toggleButton, EditText editText){
        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText.getEditableText().length()> 0) {
                    toggleButton.setVisibility(View.VISIBLE);
                } else {
                    toggleButton.setVisibility(View.GONE);
                }if (editText.getEditableText().length() > 0) {
                    toggleButton.setVisibility(View.VISIBLE);
                } else {
                    toggleButton.setVisibility(View.GONE);
                }
            }
        };
        return textWatcher;
    }

    /**
     * 密码的显示与隐藏
     */
    public static TextWatcher  togglePassword(Context  context ,ToggleButton toggleButton, EditText editText, Button button) {
        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("UseCompatLoadingForDrawables")
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void afterTextChanged(Editable s) {
                if (editText.getEditableText().length() > 0) {
                    toggleButton.setVisibility(View.VISIBLE);
                    editText.setSelection(editText.length());//将光标移至文字末尾
                    button.setBackground(context.getDrawable(R.drawable.bg_blue_radius_focused));
                    toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        if (isChecked) {
                            //如果选中，显示密码
                            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        } else {
                            //否则隐藏密码
                            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    });
                } else {
                    toggleButton.setVisibility(View.GONE);
                    button.setBackground(context.getDrawable(R.drawable.bg_blue_radius));
                }
            }
        };
        return textWatcher;
    }


    /**
     * toast提示框
     */
    public static void showToast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 图片加载
     */
    public static Picasso getPicasso( Context context,
                                       String avatar ,
                                       ImageView fialureView,
                                       String firstName,
                                       TextView textView){
        Picasso mPicasso = new Picasso.Builder(context.getApplicationContext())
                .listener((picasso, uri, exception) -> {
                    fialureView.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(firstName);
                }).build();
        mPicasso.load(avatar).transform(new CircleCornerForm())
                .into(fialureView);

        return mPicasso;
    }

    /**
     * 打电话
     */
    public static void goToPhone(Context context, String mobile) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + mobile);
        intent.setData(data);
        context.startActivity(intent);
    }

    /**
     * 动态布局
     */
    public static void  addNoBackgroundTalentsTagsTextView(
            Context context,
            FlowGroupView myFlowLayout,
            String str,
            String tag) {
        TextView  child = new TextView(context);

                new ViewGroup.MarginLayoutParams(
                        ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                        ViewGroup.MarginLayoutParams.WRAP_CONTENT
                );
        new ViewGroup.MarginLayoutParams(
                ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                ViewGroup.MarginLayoutParams.WRAP_CONTENT
        ).setMargins(10, 5, 10, 0);

        child.setLayoutParams(new ViewGroup.MarginLayoutParams(
                ViewGroup.MarginLayoutParams.WRAP_CONTENT,
                ViewGroup.MarginLayoutParams.WRAP_CONTENT
        ));
        child.setText(str);
        child.setTextSize(11.0F);
        child.setPadding(0, 5, 5, 5);
        myFlowLayout.addView(child);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    public static void findButtonAndSetOnClickListener(View rootView,
                                                       View.OnClickListener listener) {
        if (rootView instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) rootView;
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);

                if (child instanceof Button || child instanceof ImageButton) {

                    if (!child.hasOnClickListeners())
                        child.setOnClickListener(listener);
                }
                if (child instanceof ViewGroup) {
                    findButtonAndSetOnClickListener(child, listener);
                }
            }
        }
    }
}

