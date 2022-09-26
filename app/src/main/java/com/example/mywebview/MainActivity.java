package com.example.mywebview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editUrl;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl=findViewById(R.id.editUrl);
        webView=findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnGoNaver).setOnClickListener(this);
        findViewById(R.id.btnGoGoogle).setOnClickListener(this);
        findViewById(R.id.btnBack).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        InputMethodManager in=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(editUrl.getWindowToken(),0);
        switch (v.getId()){
            case R.id.btnClear:
                editUrl.setText("");
                break;
            case R.id.btnGoNaver:
                webView.loadUrl("https://search.naver.com/search.naver?query="+editUrl.getText().toString());
                break;
            case R.id.btnGoGoogle:
                webView.loadUrl("https://www.google.com/search?q="+editUrl.getText().toString());
                break;
            case R.id.btnBack:
                webView.goBack();
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }
}