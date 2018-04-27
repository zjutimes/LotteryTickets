package com.betterzw.lotterytickets.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.betterzw.lotterytickets.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhengwu on 4/10/18.
 */
public class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected LayoutInflater mInflater;
    protected Resources resources;

    @BindView(R.id.main_toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.main_toolbar_title)
    protected TextView toolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        resources = mContext.getResources();
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.bind(this);

        setupToolbar();
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
