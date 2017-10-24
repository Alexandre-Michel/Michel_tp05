package fr.utt.if26.michel_tp05;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ModuleSigleListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigle_list);
        Cursus cursus = new Cursus();
        cursus.triParCredit();
        ArrayList<String> arr = cursus.getResumes();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        setListAdapter(arrayAdapter);
    }
}
