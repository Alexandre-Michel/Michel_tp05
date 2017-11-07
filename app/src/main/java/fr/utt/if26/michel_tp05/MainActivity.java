package fr.utt.if26.michel_tp05;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addmodule:
                addModule();
                return true;
            case R.id.delmodule:
                delModule();
                return true;
            case R.id.listsigle:
                listSigle();
                return true;
            case R.id.listmodule:
                listModule();
                return true;
        }
        return false;
    }

    private void addModule() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "Je veux ajouter un module";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void delModule() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "Je veux supprimer un module";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void listSigle() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "Je veux lister un sigle";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent i = new Intent(MainActivity.this, ModuleSigleListActivity.class);
        startActivity(i);
    }

    private void listModule() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "Je veux lister un module";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent i = new Intent(MainActivity.this, ModuleListActivity.class);
        startActivity(i);
    }

    private void BDListModule() {
        Intent i = new Intent(MainActivity.this, BDModuleListActivity.class);
        startActivity(i);
    }

    private void BDAddModule() {
        Intent i = new Intent(MainActivity.this, BDModuleAddActivity.class);
        startActivity(i);
    }
}
