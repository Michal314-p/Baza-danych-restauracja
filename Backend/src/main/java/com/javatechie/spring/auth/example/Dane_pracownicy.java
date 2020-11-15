package com.javatechie.spring.auth.example;

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
    int telefon;
    double godziny;
    double stawka;
    double wyplata;
}
