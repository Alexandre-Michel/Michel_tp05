package fr.utt.if26.michel_tp05;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import java.util.ArrayList;

import static fr.utt.if26.michel_tp05.R.layout.activity_module_list;

public class ModuleListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_module_list);
        ListView listView = findViewById(R.id.listeModule);
        Cursus cursus = new Cursus();
        ArrayList<Module> arrayList = cursus.getModules();
        //CursusAdapter cursusAdapter = new CursusAdapter();
    }
}
