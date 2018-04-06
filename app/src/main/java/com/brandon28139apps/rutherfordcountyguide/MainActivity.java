package com.brandon28139apps.rutherfordcountyguide;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WebView webView = (WebView) findViewById(R.id.whatsNewWebView);
        webView.loadUrl("http://162.198.222.215/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_News) {
            Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Videos) {
            Intent intent = new Intent(getApplicationContext(), activityVideos.class);
            startActivity(intent);
        } else if (id == R.id.nav_Photos) {
            Intent intent = new Intent(getApplicationContext(), activityPhotos.class);
            startActivity(intent);
        } else if (id == R.id.nav_Events) {
            Intent intent = new Intent(getApplicationContext(), activityEvents.class);
            startActivity(intent);
        } else if (id == R.id.nav_PlacestoSee) {
            Intent intent = new Intent(getApplicationContext(), activityPlacestoSee.class);
            startActivity(intent);
        } else if (id == R.id.nav_PlacestoStay) {
            Intent intent = new Intent(getApplicationContext(), activityPlacestoStay.class);
            startActivity(intent);
        } else if (id == R.id.nav_ThingtoDo) {
            Intent intent = new Intent(getApplicationContext(), activityThingtoDo.class);
            startActivity(intent);
        } else if (id == R.id.nav_History) {
            Intent intent = new Intent(getApplicationContext(), activityHistory.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}