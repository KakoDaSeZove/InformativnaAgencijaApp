package com.example.androiddevelopment.informativnaagencijaapp.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiddevelopment.informativnaagencijaapp.R;
import com.example.androiddevelopment.informativnaagencijaapp.db.DatabaseHelper;
import com.example.androiddevelopment.informativnaagencijaapp.db.Komentari;
import com.example.androiddevelopment.informativnaagencijaapp.db.Vesti;
import com.j256.ormlite.dao.Dao;

import java.io.File;
import java.sql.SQLException;

public class DodajKomantarActivity extends AppCompatActivity {

    public static final String EXTRA_KOMENTAR = "komentarNo";

    private Vesti vesti = null;

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_komantar);
    }

    public void onClickOK(View v) {
        // dohvati sve UI komponente
        EditText naziv = (EditText) findViewById(R.id.add_naziv);
        EditText autor = (EditText) findViewById(R.id.add_autor);
        EditText opis = (EditText) findViewById(R.id.add_opis);

        DatabaseHelper helper = new DatabaseHelper(this);

        Dao<Komentari, Integer> komentariDao = null;
        try {
            komentariDao = helper.getKomentariDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int komentarNo = (Integer) getIntent().getExtras().get(EXTRA_KOMENTAR);

        Dao<Vesti, Integer> vestiDao = null;
        try {
            vestiDao = helper.getVestiDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            vesti = vestiDao.queryForId(komentarNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Komentari numberDB = new Komentari();


            numberDB.setmNaziv(naziv.getText().toString());

            numberDB.setmAutor(autor.getText().toString());

            numberDB.setmOpis(opis.getText().toString());

        numberDB.setmVesti(vesti);

        try {
            helper.getKomentariDao().create(numberDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finish();
    }

    public void onClickCancel(View v) {
        finish();
    }


