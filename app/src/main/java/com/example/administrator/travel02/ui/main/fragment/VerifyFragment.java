package com.example.administrator.travel02.ui.main.fragment;

import com.example.administrator.travel02.R;
import com.example.administrator.travel02.base.BaseFragment;
import com.example.administrator.travel02.presenter.VerifyPresenter;
import com.example.administrator.travel02.view.main.VerifyView;

public class VerifyFragment extends BaseFragment<VerifyView,VerifyPresenter> implements VerifyView{
    @Override
    protected VerifyPresenter initPresenter() {
        return new VerifyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_verify;
    }
}
