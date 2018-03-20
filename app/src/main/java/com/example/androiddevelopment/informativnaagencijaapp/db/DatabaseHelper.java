package com.example.androiddevelopment.informativnaagencijaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public static String DATABASE_NAME = "mojaAgencija.db";
    public static int DATABASE_VERSION = 1;

    private Dao<Vesti, Integer> mVestiDao = null;
    private Dao<Komentari, Integer> mKomentariDao = null;

    //Potrebno je dodati konstruktor zbog pravilne inicijalizacije biblioteke
    public DatabaseHelper(Context context) {
        super(context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION);
    }

    //Prilikom kreiranja baze potrebno je da pozovemo odgovarajuce metode biblioteke
    //prilikom kreiranja moramo pozvati TableUtils.createTable za svaku tabelu koju imamo
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Vesti.class);
            TableUtils.createTable(connectionSource, Komentari.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //kada zelimo da izmenomo tabele, moramo pozvati TableUtils.dropTable za sve tabele koje imamo
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Vesti.class, true);
            TableUtils.dropTable(connectionSource, Komentari.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //jedan Dao objekat sa kojim komuniciramo. Ukoliko imamo vise tabela
    //potrebno je napraviti Dao objekat za svaku tabelu
    public Dao<Vesti, Integer> getVestiDao() throws SQLException {
        if (mVestiDao == null) {
            mVestiDao = getDao(Vesti.class);
        }

        return mVestiDao;
    }

    public Dao<Komentari, Integer> getKomentariDao() throws SQLException {
        if (mKomentariDao == null) {
            mKomentariDao = getDao(Komentari.class);
        }

        return mKomentariDao;
    }

    //obavezno prilikom zatvarnaj rada sa bazom osloboditi resurse
    @Override
    public void close() {
        mVestiDao = null;
        mKomentariDao = null;

        super.close();
    }
}
