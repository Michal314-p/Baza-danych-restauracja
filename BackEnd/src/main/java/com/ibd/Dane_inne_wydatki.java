package com.ibd;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_inne_wydatki
{
    Integer id;
    String data;
    String opis;
    Double cena;
}
