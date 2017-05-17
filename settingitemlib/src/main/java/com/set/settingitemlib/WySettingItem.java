package com.set.settingitemlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Description: 设置控件
 * Author     : xq
 * Date       : 2017/5/10
 */

public class WySettingItem extends LinearLayout {
    private ImageView mSettingIconIv;
    private TextView mSettingTitleTv;
    private TextView mSettingMessageTv;
    private ImageView mSettingNextStepIv;
    private Drawable mIcon;
    private Drawable mNextIcon;
    private String mText;

    public WySettingItem(Context context) {
        this(context,null);
    }

    public WySettingItem(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public WySettingItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypedArray(context,attrs);
        initView(context);
    }

    private void initTypedArray(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.WySettingItem );
        mIcon = array.getDrawable(R.styleable.WySettingItem_settingIcon);
        mNextIcon = array.getDrawable(R.styleable.WySettingItem_nextIcon);
        mText = array.getString(R.styleable.WySettingItem_android_text);
        array.recycle();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.m_community_settting_item_layout,this,true);
        mSettingIconIv = (ImageView) findViewById(R.id.m_community_setting_item_icon);
        mSettingTitleTv = (TextView) findViewById(R.id.m_community_setting_item_title);
        mSettingMessageTv = (TextView) findViewById(R.id.m_community_setting_item_message);
        mSettingNextStepIv = (ImageView) findViewById(R.id.m_community_setting_item_next_step);
        mSettingIconIv.setBackgroundDrawable(mIcon);
        if (mNextIcon != null) {
            //保持默认箭头
            mSettingNextStepIv.setBackgroundDrawable(mNextIcon);
        }
        mSettingTitleTv.setText(mText);
    }

    public void setLeftIcon(@DrawableRes int resId){
        mSettingIconIv.setBackgroundResource(resId);
    }

    public void setRightIcon(@DrawableRes int resId){
        mSettingNextStepIv.setBackgroundResource(resId);
    }

    public void setText(@StringRes int resId){
        mSettingTitleTv.setText(resId);
    }

    public void setMsgVisibility(int visibility){
        mSettingMessageTv.setVisibility(visibility);
    }

    public void setMsgNum(@NonNull String num){
        mSettingMessageTv.setText(num);
    }

    public boolean isMsgVisible(){
        return mSettingMessageTv.getVisibility() == View.VISIBLE;
    }
}
