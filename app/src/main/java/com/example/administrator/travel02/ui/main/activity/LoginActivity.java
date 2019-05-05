package com.example.administrator.travel02.ui.main.activity;

import android.support.v4.app.FragmentManager;

import com.example.administrator.travel02.R;
import com.example.administrator.travel02.base.BaseActivity;
import com.example.administrator.travel02.presenter.LoginPresenter;
import com.example.administrator.travel02.ui.main.fragment.LoginOrBindFragment;
import com.example.administrator.travel02.view.main.LoginView;

public class LoginActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView {
    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl_container,new LoginOrBindFragment()).commit();
    }
}
