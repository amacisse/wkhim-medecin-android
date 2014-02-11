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
import android.widget.TextView;
import java.util.List;
import wkhim.gsb_android.modele.Medecin;

/**
 *
 * @author wkhim
 */
public class MedAdapter extends BaseAdapter{
    private List<Medecin> lesMeds;
    private Context c;
    MedAdapter(List data, Context c)   {
        lesMeds = data;
        this.c = c;
    }

    public int getCount() {
        return lesMeds.size();
    }

    public Object getItem(int i) {
        return lesMeds.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View v, ViewGroup vg) {
        LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.lignemed, null);
        TextView nom = (TextView) v.findViewById(R.id.nom);
        TextView prenom = (TextView) v.findViewById(R.id.prenom);
        TextView adresse = (TextView) v.findViewById(R.id.adresse);
        TextView specialite = (TextView) v.findViewById(R.id.specialite);
        TextView tel = (TextView) v.findViewById(R.id.tel);
        Medecin leChev = lesMeds.get(i);
        nom.setText(leChev.getNom());
        prenom.setText(leChev.getPrenom());
        adresse.setText(leChev.getAdresse());
        specialite.setText(leChev.getSpecialite());
        tel.setText(leChev.getTel());
        return v;
    }
    
    
}
