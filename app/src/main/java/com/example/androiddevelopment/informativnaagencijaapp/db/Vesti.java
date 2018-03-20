package com.example.androiddevelopment.informativnaagencijaapp.db;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.3.18..
 */
@DatabaseTable (tableName = Vesti.TABLE_NAME_VESTI)
public class Vesti {

    public static final String TABLE_NAME_VESTI = "vesti";

    public static final String FIELD_NAME_ID     = "_id";
    public static final String FIELD_NAME_NAZIV   = "naziv";
    public static final String FIELD_NAME_OPIS   = "opis";
    public static final String FIELD_NAME_AUTOR   = "autor";
    public static final String FIELD_NAME_DATUM = "datum";
    public static final String FIELD_NAME_ZADOVOLJNI_KORISNICI = "zadovoljni korisnici";
    public static final String FIELD_NAME_NEZADOVOLJNI_KORISNICI = "nezadovoljni korisnici";
    public static final String FIELD_NAME_SLIKA = "slika";
    public static final String FIELD_NAME_KOMENTARI = "komentari";

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

    @DatabaseField(columnName = FIELD_NAME_ZADOVOLJNI_KORISNICI)
    private String mZadovoljni;

    @DatabaseField(columnName = FIELD_NAME_NEZADOVOLJNI_KORISNICI)
    private String mNezadovoljni;

    @DatabaseField(columnName = FIELD_NAME_SLIKA)
    private String mSlika;

    @ForeignCollectionField(columnName = FIELD_NAME_KOMENTARI, eager = true)
    private ForeignCollection<Komentari> mKomentari;

    public Vesti() {
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

    public String getmZadovoljni() {
        return mZadovoljni;
    }

    public void setmZadovoljni(String mZadovoljni) {
        this.mZadovoljni = mZadovoljni;
    }

    public String getmNezadovoljni() {
        return mNezadovoljni;
    }

    public void setmNezadovoljni(String mNezadovoljni) {
        this.mNezadovoljni = mNezadovoljni;
    }

    public String getmSlika() {
        return mSlika;
    }

    public void setmSlika(String mSlika) {
        this.mSlika = mSlika;
    }

    public ForeignCollection<Komentari> getmKomentari() {
        return mKomentari;
    }

    public void setmKomentari(ForeignCollection<Komentari> mKomentari) {
        this.mKomentari = mKomentari;
    }


    @Override
    public String toString() {
        return  mNaziv;
    }
}

