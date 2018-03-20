package com.example.androiddevelopment.informativnaagencijaapp.activities;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androiddevelopment.informativnaagencijaapp.R;
import com.example.androiddevelopment.informativnaagencijaapp.db.DatabaseHelper;
import com.example.androiddevelopment.informativnaagencijaapp.db.Komentari;
import com.example.androiddevelopment.informativnaagencijaapp.db.Vesti;
import com.j256.ormlite.dao.Dao;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class DetailActivity extends AppCompatActivity {

    public static final String VESTI_ID = "vestiId";
    public static final String VESTI_NAZIV = "vestiNaziv";
    public static final String VESTI_OPIS = "vestiOpis";
    public static final String VESTI_SLIKA = "vestiSlika";
    public static final String VESTI_AUTOR = "vestiAutor";
    public static final String VESTI_DATUM = "vestiDatum";
    public static final String VESTI_ZADOVOLJNI = "vestiZadovoljni";
    public static final String VESTI_NEZADOVOLJNI = "vestiNezadovoljni";

    public static final String EXTRA_NO = "vestiNo";
    private Vesti vesti = null;
    private List<Komentari> komentar = null;

    private ListView listView = null;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

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
    protected void onResume() {
        super.onResume();



        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
        editor.putString(VESTI_NAZIV, "VEST 1");
        editor.putString(VESTI_OPIS, "opis 1");
        editor.putString(VESTI_SLIKA, "/home/androiddevelopment/Downloads/index.jpeg");
        editor.putString(VESTI_AUTOR, "Tijana");
        editor.putString(VESTI_DATUM, "danasnji");
        editor.putString(VESTI_ZADOVOLJNI, "1");
        editor.putString(VESTI_NEZADOVOLJNI, "1");
        editor.commit();




        int vestiNo = (Integer) getIntent().getExtras().get(EXTRA_NO);

        DatabaseHelper helper = new DatabaseHelper(this);
        Dao<Vesti, Integer> vestiDao = null;
        try {
            vestiDao = helper.getVestiDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            vesti = vestiDao.queryForId(vestiNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ImageView vestiSlika = (ImageView) findViewById(R.id.detail_image);
        if (vesti.getmSlika() != null) {
            File imgFile = new File(vesti.getmSlika());
            if (imgFile.exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                vestiSlika.setImageBitmap(myBitmap);
            }
        }

        TextView vestiId = (TextView) findViewById(R.id.detail_identifikator);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String idStr = sharedPref.getString(VESTI_ID, null);
        vestiId.setText(idStr);

        TextView vestiNaziv = (TextView) findViewById(R.id.detail_naziv);

        String nazivStr = sharedPref.getString(VESTI_NAZIV, null);
        vestiNaziv.setText(nazivStr);

        TextView vestiOpis = (TextView) findViewById(R.id.detail_opis);

        String opisStr = sharedPref.getString(VESTI_OPIS, null);
        vestiOpis.setText(opisStr);


        TextView vestiAutor = (TextView) findViewById(R.id.detail_autor);
        String AutorStr = sharedPref.getString(VESTI_AUTOR, null);
        vestiAutor.setText(AutorStr);

        TextView vestiDatum = (TextView) findViewById(R.id.detail_datum);

        String datumStr = sharedPref.getString(VESTI_DATUM, null);
        vestiDatum.setText(datumStr);

        TextView vestiZadovoljni = (TextView) findViewById(R.id.detail_zadovoljni_korisnici);

        String zadStr = sharedPref.getString(VESTI_ZADOVOLJNI, null);
        vestiZadovoljni.setText(zadStr);

        TextView vestiNezadovoljni = (TextView) findViewById(R.id.detail_nezadovolnji_korisnici);

        String nezadovoljniStr = sharedPref.getString(VESTI_NEZADOVOLJNI, null);
        vestiNezadovoljni.setText(nezadovoljniStr);

        listView = (ListView) findViewById(R.id.list_of_comments);

        ArrayList<String> listaKomentara = new ArrayList<>();
        for (Komentari k : komentar) {
            listaKomentara.add(k.getmId() + " " + k.getmNaziv());
        }

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                this,
                simple_list_item_1,
                listaKomentara) {
        };
        listView.setAdapter(listAdapter);
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
