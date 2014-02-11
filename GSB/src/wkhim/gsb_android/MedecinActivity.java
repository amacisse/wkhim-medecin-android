/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wkhim.gsb_android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.List;
import wkhim.gsb_android.modele.DAO;
import wkhim.gsb_android.modele.Medecin;

/**
 *
 * @author wkhim
 */
public class MedecinActivity extends ListActivity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listemed);
        Intent inter = getIntent();
        String dep = inter.getStringExtra("leDep");
        List<Medecin> lesMeds = DAO.getLesMedsParDep(dep);
        MedAdapter adapter = new MedAdapter(lesMeds, this);
        setListAdapter(adapter);
    }
}
