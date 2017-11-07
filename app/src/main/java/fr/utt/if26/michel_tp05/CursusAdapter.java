package fr.utt.if26.michel_tp05;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by if26-grp1 on 24/10/2017.
 */

public class CursusAdapter extends ArrayAdapter<Module> {
    private Context context;
    private int ressource;
    private ArrayList<Module> data;

    public CursusAdapter(Context context, int textViewResourceId, ArrayList<Module> modules) {
        super(context, textViewResourceId, modules);
        this.ressource = textViewResourceId;
        this.context = context;
        this.data = modules;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            Log.i("Cursus Adapter", "convertView == null");
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.test,parent, false);
        }
        ModuleViewHolder viewHolder = (ModuleViewHolder) convertView.getTag();
        if(viewHolder != null) {
            Log.i("Cursus Adapter", "holder == null");
            viewHolder = new ModuleViewHolder();
            viewHolder.sigle = (TextView)convertView.findViewById(R.id.module_liste_sigle);
            viewHolder.credit = (TextView)convertView.findViewById(R.id.module_liste_credit);
            convertView.setTag(viewHolder);
        }

        Log.i("CursusAdapter - getView", "avant de remplir la vue");
        Module module = data.get(position);
        Log.i("data.get", module.toString());
        viewHolder.sigle.setText(module.getSigle());
        viewHolder.credit.setText(String.valueOf(module.getCredit()));
        return convertView;
    }

    private static class ModuleViewHolder {
        public TextView sigle;
        public TextView credit;
    }
}
