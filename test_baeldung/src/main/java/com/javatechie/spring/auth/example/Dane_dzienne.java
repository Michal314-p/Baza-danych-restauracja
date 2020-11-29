package com.javatechie.spring.auth.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_dzienne
{
    Double koszt_pracownikow;
    Double kosz_pojazdow;
    Double koszt_produktow;
    Double dzienny_zysk;
    Double inne_koszta;
    String login;
}
