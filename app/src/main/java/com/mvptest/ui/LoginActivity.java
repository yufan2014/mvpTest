package com.mvptest.ui;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.frame.base.BaseMVPActivity;
import com.mvptest.R;
import com.mvptest.bean.IndexContents;
import com.mvptest.ui.mvp.presenter.LoginPresenter;
import com.mvptest.ui.mvp.view.LoginView;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/11/2.
 */

public class LoginActivity extends BaseMVPActivity<LoginView, LoginPresenter> implements LoginView {

    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.pwd)
    EditText pwd;
    @Bind(R.id.submit)
    Button submit;
    private ProgressDialog progressBar;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initGetData() {

    }

    @Override
    protected void initView() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData1();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onHttpSuccess(Object model) {
        if(model instanceof IndexContents){
            IndexContents info = (IndexContents) model;
        }
    }

    @Override
    public void onHttpStart() {
        showLoading("提交中...");
    }

    @Override
    public void onHttpFailure(int code, String msg) {

    }

    @Override
    public void onHttpCompleted() {
        closeLoading();
    }

}
