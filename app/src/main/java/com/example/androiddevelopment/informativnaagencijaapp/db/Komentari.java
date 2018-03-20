package com.example.androiddevelopment.informativnaagencijaapp.db;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.3.18..
 */
@DatabaseTable(tableName = Komentari.TABLE_NAME_KOMENTARI)
public class Komentari {

    public static final String TABLE_NAME_KOMENTARI = "komentari";

    public static final String FIELD_NAME_ID     = "_id";
    public static final String FIELD_NAME_NAZIV   = "naziv";
    public static final String FIELD_NAME_OPIS   = "opis";
    public static final String FIELD_NAME_AUTOR   = "autor";
    public static final String FIELD_NAME_DATUM = "datum";
    public static final String FIELD_NAME_VESTI = "vesti";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIELD_NAME_NAZIV)
    private String mNaziv;

    @DatabaseField(columnName = FIELD_NAME_OPIS)
    private String mOpis;

    @DatabaseField(columnName = FIELD_NAME_AUTOR)
    private String mAutor;

    @DatabaseField(columnName = FIELD_NAME_DATUM)
    private String mDatum;

    @DatabaseField(columnName = FIELD_NAME_VESTI, foreign = true, foreignAutoRefresh =
            true)
    private Vesti mVesti;

    public Komentari() {
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNaziv() {
        return mNaziv;
    }

    public void setmNaziv(String mNaziv) {
        this.mNaziv = mNaziv;
    }

    public String getmOpis() {
        return mOpis;
    }

    public void setmOpis(String mOpis) {
        this.mOpis = mOpis;
    }

    public String getmAutor() {
        return mAutor;
    }

    public void setmAutor(String mAutor) {
        this.mAutor = mAutor;
    }

    public String getmDatum() {
        return mDatum;
    }

    public void setmDatum(String mDatum) {
        this.mDatum = mDatum;
    }

    public Vesti getmVesti() {
        return mVesti;
    }

    public void setmVesti(Vesti mVesti) {
        this.mVesti = mVesti;
    }
    @Override
    public String toString() {
        return mNaziv;
    }
}
