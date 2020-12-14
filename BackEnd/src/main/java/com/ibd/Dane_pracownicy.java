package com.ibd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_pracownicy
{
    int id;
    String imie;
    String nazwisko;
    String stanowisko;
    Integer telefon;
    Double godziny;
    Double stawka;
    Double wyplata;
}
