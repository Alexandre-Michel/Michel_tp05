package fr.utt.if26.michel_tp05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by if26-grp1 on 24/10/2017.
 */

public class CursusAdapter extends ArrayAdapter<Cursus> {
    private Context context;
    private int ressource;
    private ArrayList<Cursus> cursus;

    public CursusAdapter(Context context, int textViewResourceId, ArrayList<Cursus> cursus) {
        super(context, textViewResourceId, cursus);
        this.cursus = cursus;
        this.ressource = textViewResourceId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cursus.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_module_list,parent, false);
        }
        ModuleViewHolder viewHolder = (ModuleViewHolder) convertView.getTag();
        return convertView;
    }

    public static class ModuleViewHolder {
        public TextView textView;
    }
}
