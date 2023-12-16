package com.example.corrpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView LV;
Spinner spQuart ;
TextView txtNom, txtAdr, txtTel;
Switch swPara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Pharmacie P1 = new Pharmacie("Al houda"," AV Med", "0654433","Hay Riad",true);
            Pharmacie P2 = new Pharmacie("Palestine"," AV Annasr", "065443563","Hay Nahda",false);
            Pharmacie.ajouter(P1);
            Pharmacie.ajouter(P2);
            Pharmacie.ajouter(new Pharmacie("Al fadila","Av tarik ibn Ziad","07565443","Youssoufia",true));
            LV= findViewById(R.id.LV);
            Log.i("liste",String.valueOf( Pharmacie.getListePharmacies().size()));
            ArrayAdapter<Pharmacie> AA = new ArrayAdapter<Pharmacie>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,Pharmacie.getListePharmacies());
LV.setAdapter(AA);
    spQuart=findViewById(R.id.spQuart);
    txtNom=findViewById(R.id.txtNom);
    txtAdr=findViewById(R.id.txtAdr);
            txtTel=findViewById(R.id.txtTel);
           swPara=findViewById(R.id.swPara);

           spQuart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                   String selectedQuartier=spQuart.getSelectedItem().toString();
                  Pharmacie P = Pharmacie.rechercherParQuartier(selectedQuartier);
                  if (P==null)
                  {
                      Toast.makeText(MainActivity.this, "Aucune pharmacie pour ce quartier", Toast.LENGTH_SHORT).show();
                      txtNom.setText("");
                      txtAdr.setText("");
                      txtTel.setText("");
                      swPara.setChecked(false);
                  }
                  else
                  {

                      //Affichage des informations
                      txtNom.setText(P.getNom());
                      txtAdr.setText(P.getAdresse());
                      txtTel.setText(P.getTel());
                      swPara.setChecked(P.isPara());

                  }
               }

               @Override
               public void onNothingSelected(AdapterView<?> adapterView) {

               }
           });
        }
        catch (Exception ex)
        {
           // Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
       Log.i("liste",ex.getMessage());
        }



    }
}