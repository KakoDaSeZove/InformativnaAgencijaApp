package com.example.androiddevelopment.informativnaagencijaapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView listView = null;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

//
//        AdapterView.OnItemClickListener itemClickListener =
//                new AdapterView.OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> listView,
//                                            View v,
//                                            int position,
//                                            long id)
//
//                    {
//                        Intent intent = new Intent(MainActivity.this,
//                                DetailActivity.class);
//                        intent.putExtra(DetailActivity.EXTRA_NO, contact.get(position).getmId());
//                        startActivity(intent);
//                    }

//
//                };
        listView = (ListView) findViewById(R.id.list_of_contact);
//        listView.setOnItemClickListener(itemClickListener);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.nav_all_news:
//                                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//                                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//                                }
                                return true;

                            case R.id.nav_tools:
//
                                return true;

                            case R.id.nav_about:
//
                                return true;
                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
