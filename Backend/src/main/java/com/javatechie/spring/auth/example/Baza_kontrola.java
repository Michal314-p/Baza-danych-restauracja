package com.javatechie.spring.auth.example;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Baza_kontrola {

    private List<String> id;
    private List<String> imie;
    private List<String> nazwisko;
    private List<String> telefon;

    public void wyszukaj_wszystko()
    {
        ArrayList<String> pracownik;
        try{
            Baza_uzytkowe db = new Baza_uzytkowe();
            db.polacz_z_baza();
            Statement stmt=db.conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from pracownicy");
            while(rs.next())
            {
                id.add(String.valueOf(rs.getInt(1)));
                imie.add(rs.getString(2));
                nazwisko.add(rs.getString(3));
                telefon.add(rs.getString(4));

            }
            db.rozlacz();
        }catch(Exception e){ System.out.println(e);}

    }
}
