package com.ibd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_restauracja
{
    String nazwa;
    String wlasciciel;
    String miasto;
    String lokalizacja;
    String godziny_otwarcia;
    String wifi;
    String ilosc_stolikow;
    String rodzaj_kuchni;
}
