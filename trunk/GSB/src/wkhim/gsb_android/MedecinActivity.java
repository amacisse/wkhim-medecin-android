/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wkhim.gsb_android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.List;
import wkhim.gsb_android.modele.DAO;
import wkhim.gsb_android.modele.Medecin;

/**
 *
 * @author wkhim
 */
public class MedecinActivity extends ListActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listemed);
        Intent inter = getIntent();
        String dep = inter.getStringExtra("leDep");
        final List<Medecin> lesMeds = DAO.getLesMedsParDep(dep);
        final MedAdapter adapter = new MedAdapter(lesMeds, this);
        setListAdapter(adapter);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.search_input);
                adapter.getFilter().filter(editText.getText());
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent inter = new Intent(this, AfficherActivity.class);
        inter.putExtra("leNom", ((Medecin) l.getItemAtPosition(position)).getNom());
        inter.putExtra("lePrenom", ((Medecin) l.getItemAtPosition(position)).getPrenom());
        inter.putExtra("laSpe", ((Medecin) l.getItemAtPosition(position)).getSpecialite());
        inter.putExtra("lAdresse", ((Medecin) l.getItemAtPosition(position)).getAdresse());
        inter.putExtra("leTel", ((Medecin) l.getItemAtPosition(position)).getTel());
        startActivity(inter);
    }
}
