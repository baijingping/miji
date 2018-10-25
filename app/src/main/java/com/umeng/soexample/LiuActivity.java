package com.umeng.soexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umeng.soexample.weighit.FlowLayout;

public class LiuActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtSearch;
    private EditText etSearch;
    private FlowLayout flSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liu);
        initView();
        txtSearch.setOnClickListener(this);
    }

    private void initView() {
        txtSearch = findViewById(R.id.txt_search);
        etSearch = findViewById(R.id.et_search);
        flSearch = findViewById(R.id.fl_search);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_search:
                String trim = etSearch.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)){
                    TextView txt=new TextView(this);
                    txt.setText(trim);
                    txt.setPadding(10,10,10,10);
                    ViewGroup.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    txt.setLayoutParams(layoutParams);
                    flSearch.addView(txt);
                    etSearch.setText("");
                }
                break;
        }
    }
}
