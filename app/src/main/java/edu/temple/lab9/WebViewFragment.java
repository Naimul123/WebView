package edu.temple.lab9;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebViewFragment extends Fragment {

    WebView webview;

    static WebViewFragment getWebViewFragment(){
       WebViewFragment f = new WebViewFragment();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment, container, false);

        webview  = (WebView) v.findViewById(R.id.wv);

        return v;
    }

}


