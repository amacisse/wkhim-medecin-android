/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wkhim.gsb_android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 * @author wkhim
 */
public class AfficherActivity extends Activity {

    /**
     *
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.affichermed);
        TextView text_nom = (TextView) findViewById(R.id.nom);
        TextView text_prenom = (TextView) findViewById(R.id.prenom);
        TextView text_spe = (TextView) findViewById(R.id.specialite);
        TextView text_adresse = (TextView) findViewById(R.id.adresse);
        TextView text_tel = (TextView) findViewById(R.id.tel);
        Intent inter = getIntent();
        String nom = inter.getStringExtra("leNom");
        String prenom = inter.getStringExtra("lePrenom");
        String specialite = inter.getStringExtra("laSpe");
        String adresse = inter.getStringExtra("lAdresse");
        final String tel = inter.getStringExtra("leTel");
        text_nom.setText(nom);
        text_prenom.setText(prenom);
        text_spe.setText(specialite);
        text_adresse.setText(adresse);
        text_tel.setText(tel);
        Button button = (Button) findViewById(R.id.call_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + tel));
                startActivity(callIntent);
            }
        });
    }

}
