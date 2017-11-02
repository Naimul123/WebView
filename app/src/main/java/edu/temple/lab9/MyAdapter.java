package edu.temple.lab9;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends FragmentStatePagerAdapter {
    List<WebViewFragment> array = new ArrayList();

    public MyAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public WebViewFragment getItem(int position) {
        WebViewFragment fragment= array.get(position);
        if(fragment == null){
            fragment = WebViewFragment.getWebViewFragment();
            array.add(fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }

    public int count(){


        return array.size()-1;
    }
}
