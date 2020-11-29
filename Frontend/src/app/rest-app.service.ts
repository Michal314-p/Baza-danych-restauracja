import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { stringToKeyValue } from '@angular/flex-layout/extended/typings/style/style-transforms';

@Injectable({
  providedIn: 'root'
})
export class RestAppService {

  constructor(private http: HttpClient) { }

  private log:string;
  private pas:string;
  private nazwa:string;
  private jednostka:string;
  private ilosc:number;
  private cena:number;

  public login(username:string,password:string)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/", {headers, responseType:'text' as 'json'});
  }

  public pobierz_dane()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dane_restauracja", {headers});
  }

  public dane_pracownicy()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dane_pracownicy", {headers});
  }

  public dane_magazyn()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/magazyn_pobierz", {headers});
  }

  public register_user(login:string,password:string)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {log:login, pas:password};
    return this.http.post("http://localhost:8080/register_user", body,{headers});
  }

  public dodaj_produkt(nazwa:string,jednostka:string,ilosc:number,cena:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {nazwa:nazwa, jednostka:jednostka,ilosc:ilosc,cena:cena};
    return this.http.post("http://localhost:8080/dodaj_produkt", body,{headers});
  }

  public usun_produkt(nazwa:string)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {nazwa:nazwa};
    return this.http.post("http://localhost:8080/usun_produkt", body,{headers});
  }

  public edytuj_produkt(nazwa:string,jednostka:string,ilosc:number,cena:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {nazwa:nazwa, jednostka:jednostka,ilosc:ilosc,cena:cena};
    return this.http.post("http://localhost:8080/edytuj_produkt", body,{headers});
  }

  public zamow_produkt(nazwa:string,ilosc:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {nazwa:nazwa, ilosc:ilosc};
    return this.http.post("http://localhost:8080/zamow_produkt", body,{headers});
  }

  public odejmij_produkt(nazwa:string,ilosc:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {nazwa:nazwa, ilosc:ilosc};
    return this.http.post("http://localhost:8080/odejmij_produkt", body,{headers});
  }

  public dodaj_pracownik(imie:string,nazwisko:string,stanowisko:string,telefon:number,stawka:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {imie:imie, nazwisko:nazwisko,stanowisko:stanowisko,telefon:telefon,stawka:stawka};
    return this.http.post("http://localhost:8080/dodaj_pracownik", body,{headers});
  }

  public usun_pracownik(id:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id};
    return this.http.post("http://localhost:8080/usun_pracownik", body,{headers});
  }

  public edytuj_pracownik(id:number,imie:string,nazwisko:string,stanowisko:string,telefon:number,godziny:number,stawka:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,imie:imie, nazwisko:nazwisko,stanowisko:stanowisko,telefon:telefon,godziny:godziny,stawka:stawka};
    return this.http.post("http://localhost:8080/edytuj_pracownik", body,{headers});
  }

  public dodaj_godziny(id:number,godziny:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,godziny:godziny};
    return this.http.post("http://localhost:8080/dodaj_godziny", body,{headers});
  }

  public odejmij_godziny(id:number,godziny:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,godziny:godziny};
    return this.http.post("http://localhost:8080/odejmij_godziny", body,{headers});
  }

  public resetuj_godziny(id:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id};
    return this.http.post("http://localhost:8080/resetuj_godziny",body, {headers});
  }

  public dane_pojazdy()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dane_pojazdy", {headers});
  }

  public dodaj_pojazd(pojazd:string,marka:string)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {pojazd:pojazd, marka:marka};
    return this.http.post("http://localhost:8080/dodaj_pojazd", body,{headers});
  }

  public usun_pojazd(id:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id};
    return this.http.post("http://localhost:8080/usun_pojazd", body,{headers});
  }

  public edytuj_pojazd(id:number,pojazd:string,marka:string,spalanie:number,koszt:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,pojazd:pojazd, marka:marka,spalanie:spalanie,koszt:koszt};
    return this.http.post("http://localhost:8080/edytuj_pojazd", body,{headers});
  }

  public rachunek_paliwo(id:number,spalanie:number,koszt:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,spalanie:spalanie,koszt:koszt};
    return this.http.post("http://localhost:8080/rachunek_paliwo", body,{headers});
  }

  public reset_paliwo(id:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id};
    return this.http.post("http://localhost:8080/reset_paliwo", body,{headers});
  }

  public dane_o_prace()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dane_o_prace", {headers});
  }

  public dodaj_o_prace(imie:string,nazwisko:string,stanowisko:string,telefon:number,etat:number,wyplata:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {imie:imie, nazwisko:nazwisko,stanowisko:stanowisko,telefon:telefon,etat:etat,wyplata:wyplata};
    return this.http.post("http://localhost:8080/dodaj_o_prace", body,{headers});
  }

  public usun_o_prace(id:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id};
    return this.http.post("http://localhost:8080/usun_o_prace", body,{headers});
  }

  public edytuj_o_prace(id:number,imie:string,nazwisko:string,stanowisko:string,telefon:number,etat:number,wyplata:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,imie:imie, nazwisko:nazwisko,stanowisko:stanowisko,telefon:telefon,etat:etat,wyplata:wyplata};
    return this.http.post("http://localhost:8080/edytuj_o_prace", body,{headers});
  }

  public dodaj_godziny_o_prace(id:number,godziny:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,godziny:godziny};
    return this.http.post("http://localhost:8080/dodaj_godziny_o_prace", body,{headers});
  }

  public odejmij_godziny_o_prace(id:number,godziny:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id,godziny:godziny};
    return this.http.post("http://localhost:8080/odejmij_godziny_o_prace", body,{headers});
  }

  public resetuj_godziny_o_prace(id:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {id:id};
    return this.http.post("http://localhost:8080/resetuj_godziny_o_prace",body, {headers});
  }

  public ustaw_etat(godziny:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {godziny:godziny};
    return this.http.post("http://localhost:8080/ustaw_etat", body,{headers});
  }

  public dane_dzienne_pobierz()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dane_dzienne_pobierz", {headers});
  }

  public dochod_pobierz()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dochod_pobierz", {headers});
  }

  public dane_inne_wydatki()
  {
    let username="michal";
    let password="anar";
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8080/dane_inne_wydatki", {headers});
  }

  public dzienny_dochod(dzienny_zysk:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {dzienny_zysk:dzienny_zysk};
    return this.http.post("http://localhost:8080/dzienny_dochod", body,{headers});
  }

  public dodatkowe_wydatki(data:any,opis:string,cena:number)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {data:data,opis:opis,cena:cena};
    return this.http.post("http://localhost:8080/dodatkowe_wydatki", body,{headers});
  }

  public zatwierdz_koszta(data:any)
  {
    const headers= new HttpHeaders({Authorization: 'Basic ' + btoa("michal"+":"+"anar")})
    let body = {data:data};
    return this.http.post("http://localhost:8080/zatwierdz_koszta", body,{headers});
  }

}
