package com.javatechie.spring.auth.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_magazyn
{
    String nazwa;
    String jednostka;
    Double ilosc;
    Double cena;
    Double wartosc;
}
