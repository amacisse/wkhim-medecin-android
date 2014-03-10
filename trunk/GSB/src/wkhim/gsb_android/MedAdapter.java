/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wkhim.gsb_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import wkhim.gsb_android.modele.Medecin;

/**
 *
 * @author wkhim
 */
public class MedAdapter extends BaseAdapter implements Filterable {

    private List<Medecin> lesMeds;
    private List<Medecin> FilteredData;
    private Context c;

    MedAdapter(List data, Context c) {
        lesMeds = data;
        FilteredData = data;
        this.c = c;
    }

    public int getCount() {
        return FilteredData.size();
    }

    public Object getItem(int i) {
        return FilteredData.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View v, ViewGroup vg) {
        LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.lignemed, null);
        TextView nom = (TextView) v.findViewById(R.id.nom);
        TextView prenom = (TextView) v.findViewById(R.id.prenom);
        TextView adresse = (TextView) v.findViewById(R.id.adresse);
        TextView specialite = (TextView) v.findViewById(R.id.specialite);
        TextView tel = (TextView) v.findViewById(R.id.tel);
        Medecin unMed = FilteredData.get(i);
        nom.setText(unMed.getNom());
        prenom.setText(unMed.getPrenom());
        adresse.setText(unMed.getAdresse());
        specialite.setText(unMed.getSpecialite());
        tel.setText(unMed.getTel());
        return v;
    }

    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                ArrayList<Medecin> tempList = new ArrayList<Medecin>();
                //constraint is the result from text you want to filter against. 
                //objects is your data set you will filter from
                for (Medecin unMed : lesMeds) {
                    if (unMed.getNom().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        tempList.add(unMed);
                    }
                }

                //following two lines is very important
                //as publish result can only take FilterResults objects
                filterResults.values = tempList;
                filterResults.count = tempList.size();
                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence contraint, FilterResults results) {
                FilteredData = (ArrayList<Medecin>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

}
