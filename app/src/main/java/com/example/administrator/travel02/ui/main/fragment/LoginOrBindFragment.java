package com.example.administrator.travel02.ui.main.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.travel02.R;
import com.example.administrator.travel02.base.BaseFragment;
import com.example.administrator.travel02.presenter.LoginOrBindPresenter;
import com.example.administrator.travel02.ui.main.activity.WebActivity;
import com.example.administrator.travel02.view.main.LoginOrBindView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginOrBindFragment extends BaseFragment<LoginOrBindView, LoginOrBindPresenter> implements LoginOrBindView {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_hello)
    TextView tvHello;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_coutry_code)
    TextView tvCoutryCode;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_send_verify)
    Button btnSendVerify;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.ll_or)
    LinearLayout llOr;
    @BindView(R.id.iv_wechat)
    ImageView ivWechat;
    @BindView(R.id.iv_qq)
    ImageView ivQq;
    @BindView(R.id.iv_sina)
    ImageView ivSina;
    @BindView(R.id.tv_protocol)
    TextView tvProtocol;

    @Override
    protected LoginOrBindPresenter initPresenter() {
        return new LoginOrBindPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_bind;
    }

    @Override
    protected void initListener() {
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                swicchBtnState(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void swicchBtnState(CharSequence s) {
        if (TextUtils.isEmpty(s)){
            btnSendVerify.setBackgroundResource(R.drawable.bg_btn_ea_r15);
        }else {
            btnSendVerify.setBackgroundResource(R.drawable.bg_btn_fa6a13_r15);
        }
    }

    @OnClick({R.id.iv_back,R.id.btn_send_verify,R.id.iv_wechat,R.id.iv_qq,R.id.iv_sina})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.iv_back:
                break;
            case R.id.btn_send_verify:
                addVerietyFragment();
                break;
            case R.id.iv_wechat:
                break;
            case R.id.iv_qq:
                break;
            case R.id.iv_sina:
                break;
        }
    }

    private void addVerietyFragment() {
        if (TextUtils.isEmpty(getPhone())){
            return;
        }
        FragmentManager manager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.fl_container,new VerifyFragment()).commit();
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString().trim();
    }

    @Override
    protected void initView() {
        SpannableStringBuilder builder=new SpannableStringBuilder(getResources().getString(R.string.agree_protocol));
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                WebActivity.startAct(getActivity());
            }
        };
        builder.setSpan(clickableSpan,11,15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        builder.setSpan(underlineSpan,11,15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan what = new ForegroundColorSpan(getResources().getColor(R.color.c_fa6a13));
        builder.setSpan(what,11,15,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        tvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        tvProtocol.setText(builder);
    }
}
