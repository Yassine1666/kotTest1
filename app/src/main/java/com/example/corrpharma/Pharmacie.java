package com.example.corrpharma;

import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Pharmacie {
    private String nom;
    private String adresse;
    private String tel;
    private String quartier;
    private boolean para;
    private static ArrayList<Pharmacie> lstPharmacie= new ArrayList<>();


    public Pharmacie(String nom, String adresse, String tel, String quartier, boolean para) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.quartier = quartier;
        this.para = para;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public boolean isPara() {
        return para;
    }

    public void setPara(boolean para) {
        this.para = para;
    }


    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", quartier='" + quartier + '\'' +
                ", para=" + para +
                '}';
    }

    @Override
    public boolean equals( Object obj) {
        Pharmacie P = (Pharmacie) obj;
        return P.quartier.equals(this.quartier);
    }

    public static Pharmacie rechercherParQuartier(String quart){
        Log.i("liste","quar=" + quart);

        for (Pharmacie P : lstPharmacie)
        {
            Log.i("liste","quartier=" + P.quartier);
            if (P.quartier.equals(quart)){
                Log.i("liste","ok");

                return  P;
            }

        }
        return  null;

    }
    public static  Pharmacie rechercherParPharmacie(Pharmacie phar){
        for (Pharmacie P : lstPharmacie)
        {
            //utilisation de la méthode equals créée
            if (P.equals(phar)){
                return  P;
            }
        }
        return  null;

    }
    public static  void ajouter(Pharmacie P)
    throws  Exception{
        if (rechercherParPharmacie(P)==null) {

            lstPharmacie.add(P);
        }
        else
        {
            throw new Exception ("Une pharmacie est déjà affectée pour ce quartier");
        }

    }
    public  static  void supprimer( String quartier)
            throws  Exception
               {
                   Pharmacie P = rechercherParQuartier(quartier);
                   if (P!=null) {
                       lstPharmacie.remove(P);
                   }
                   else
                   {
                       throw new Exception ("Aucune pharmacie n'existe dans ce quartier");
                   }
    }
    public  static  ArrayList<Pharmacie> getListePharmacies()
    {
        return  lstPharmacie;
    }
    //getListeQuartiers
    /*
    Si on veut charger les quartiers
    à partir de la collection
     */
    /*
 public ArrayList<String> getLstQuartiers(){
        ArrayList<String> lst= new ArrayList<>();
        for (Pharmacie P : lstPharmacie)
        {
           // if (!lst.contains(P.quartier)){
                lst.add(quartier);
           // }
        }
 }

     */

}
