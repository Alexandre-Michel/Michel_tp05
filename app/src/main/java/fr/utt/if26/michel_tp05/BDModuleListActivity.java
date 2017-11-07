package fr.utt.if26.michel_tp05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BDModuleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);
        ListView maListe = (ListView)findViewById(R.id.listeModule);
        ModulePersistance db = new ModulePersistance(this);
        ArrayList<Module> modules = db.getAllModules();
        CursusAdapter adapteur = new CursusAdapter(this, R.layout.test, modules);
        maListe.setAdapter(adapteur);
    }
}
