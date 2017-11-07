package fr.utt.if26.michel_tp05;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by if26-grp1 on 07/11/2017.
 */

public class ModulePersistance extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Modules.db"; //nom du fichier pour la base
    private static final String TABLE_MODULES = "module"; //nom de la table
    private static final String ATTRIBUT_SIGLE = "sigle";
    private static final String ATTRIBUT_CATEGORIE = "categorie";
    private static final String ATTRIBUT_CREDIT = "credit";
    private static final String ATTRIBUT_RESULTAT = "resultat";

    public ModulePersistance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String table_module_create = "CREATE TABLE " + TABLE_MODULES +
                "(" + ATTRIBUT_SIGLE + " TEXT primary_key, " +
                ATTRIBUT_CATEGORIE + " TEXT, " +
                ATTRIBUT_CREDIT + " INTEGER, " +
                ATTRIBUT_RESULTAT + " TEXT)";
        db.execSQL(table_module_create);
        Log.i("Persistance onCreate", "capsule C01");
        Module m = new Module("ISI_C01", "TM", 3, Resultat.R);
        addModule(m);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODULES);
        onCreate(db);
    }

    public void addModule(Module m) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ATTRIBUT_SIGLE, m.getSigle());
        values.put(ATTRIBUT_CATEGORIE, m.getCategorie());
        values.put(ATTRIBUT_CREDIT, m.getCredit());
        values.put(ATTRIBUT_RESULTAT, m.getResultat().toString());
        db.insert(TABLE_MODULES, null, values);
    }

    Module getModule(String sigle) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MODULES, new String[] { ATTRIBUT_SIGLE, ATTRIBUT_CATEGORIE, ATTRIBUT_CREDIT, ATTRIBUT_RESULTAT}, ATTRIBUT_SIGLE + "=?",
                new String[] { String.valueOf(ATTRIBUT_SIGLE) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Module m = new Module(cursor.getString(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Resultat.R);
        return m;
    }

    public ArrayList<Module> getAllModules() {
        ArrayList<Module> modulesList = new ArrayList<Module>();
        String selectQuery = "SELECT  * FROM " + TABLE_MODULES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Module m = new Module(cursor.getString(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Resultat.R);
                modulesList.add(m);
            } while (cursor.moveToNext());
        }
        return modulesList;
    }

    public void deleteModule(Module m) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MODULES, ATTRIBUT_SIGLE + " = ?",
                new String[] { String.valueOf(m.getSigle()) });
        db.close();
    }

    public int getModulesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MODULES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}
