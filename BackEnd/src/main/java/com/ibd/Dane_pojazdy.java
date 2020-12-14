package com.ibd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dane_pojazdy
{
    int id;
    String pojazd;
    String marka;
    Double spalanie;
    Double koszt;
}
