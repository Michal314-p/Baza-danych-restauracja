package com.javatechie.spring.auth.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_o_prace
{
    int id;
    String imie;
    String nazwisko;
    String stanowisko;
    Integer telefon;
    Double etat;
    Double godziny;
    Double wyplata;
}
