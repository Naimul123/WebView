package edu.temple.lab9;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button go;
    MyAdapter adapter;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        url = (EditText) findViewById(R.id.url);
        go = (Button) findViewById(R.id.go);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        adapter = new MyAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String protocol = "http://";
                String website = protocol + url.getText().toString();
                WebViewFragment webViewFragment = adapter.getItem(viewPager.getCurrentItem());

                WebView webView = webViewFragment.webview;

                webView.loadUrl(website);

                Bundle bundle = new Bundle();
                bundle.putString("url",website);
                webViewFragment.setArguments(bundle);


            }
        });



        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.add:
                int num = adapter.getCount();
                viewPager.setCurrentItem(num);
                break;

            case R.id.next:
                int current = viewPager.getCurrentItem();
                viewPager.setCurrentItem(current + 1);

                if(current == 10){
                    Toast.makeText(this, "You cannot create display anymore urls", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.back:
                int currentI = viewPager.getCurrentItem();
                viewPager.setCurrentItem(currentI - 1);

                if(currentI == 0){
                    Toast.makeText(this, "Cannot go back", Toast.LENGTH_SHORT).show();
                }
                break;
        }




        return super.onOptionsItemSelected(item);
    }
}
