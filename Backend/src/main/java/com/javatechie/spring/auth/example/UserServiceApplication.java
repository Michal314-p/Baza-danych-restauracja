package com.javatechie.spring.auth.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class UserServiceApplication {


	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}

	@GetMapping("/dane_restauracja")
	public List<Dane_restauracja> getUsers()
	{
		String nazwa = null;
		String wlasciciel = null;
		String miasto = null;
		String lokalizacja = null;
		String godziny_otwarcia = null;
		String wifi = null;
		String ilosc_stolikow = null;
		String rodzaj_kuchni = null;

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from dane_restauracja");
			while(rs.next())
			{
				nazwa=rs.getString(3);
				wlasciciel=rs.getString(4);
				miasto=rs.getString(5);
				lokalizacja=rs.getString(6);
				godziny_otwarcia=rs.getString(7);
				wifi=rs.getString(8);
				ilosc_stolikow=rs.getString(9);
				rodzaj_kuchni=rs.getString(10);
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return Stream.of(new Dane_restauracja(nazwa,wlasciciel,miasto,lokalizacja,godziny_otwarcia,wifi,ilosc_stolikow,rodzaj_kuchni)).
				collect(Collectors.toList());
	}

	@GetMapping("/dane_pracownicy")
	public List<Dane_pracownicy> dane_pracownicy()
	{
		int id = 0;
		String imie = null;
		String nazwisko = null;
		String stanowisko = null;
		int telefon = 0;
		double godziny = 0;
		double stawka = 0;
		double wyplata = 0;
		List <Dane_pracownicy> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from pracownicy");
			while(rs.next())
			{
				id=rs.getInt(1);
				imie=rs.getString(3);
				nazwisko=rs.getString(4);
				stanowisko=rs.getString(5);
				telefon=rs.getInt(6);
				godziny=rs.getDouble(7);
				stawka=rs.getDouble(8);
				wyplata=stawka*godziny;
				stream.add(new Dane_pracownicy(id,imie,nazwisko,stanowisko,telefon,godziny,stawka,wyplata));
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return stream;
	}


	@PostMapping("/register_user")
	public boolean register_user(@RequestBody Dane_rejestracja dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			String sprawdzenie = null;

			Statement stmt1=db.conn.createStatement();
			ResultSet rs=stmt1.executeQuery("select login from uzytkownicy");
			while(rs.next())
			{
				sprawdzenie = rs.getString(1);
				if(sprawdzenie.equals(dane.log))
				{
					db.rozlacz();
					return false;
				}
			}

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into uzytkownicy (login, haslo) values (?,?)");
			stmt2.setString(1,dane.log);
			stmt2.setString(2,dane.pas);

			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return true;
	}

	@GetMapping("/magazyn_pobierz")
	public List<Dane_magazyn> dane_magazyn()
	{
		String nazwa = null;
		String jednostka = null;
		double cena = 0;
		double ilosc = 0;
		double wartosc = 0;
		List <Dane_magazyn> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from magazyn");
			while(rs.next())
			{
				nazwa=rs.getString(2);
				jednostka=rs.getString(3);
				cena=rs.getDouble(5);
				ilosc=rs.getDouble(4);
				wartosc=cena*ilosc;
				stream.add(new Dane_magazyn(nazwa,jednostka,ilosc,cena,wartosc));
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return stream;
	}


	@PostMapping("/dodaj_produkt")
	public void dodaj_produkt(@RequestBody Dane_magazyn dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into magazyn (login, nazwa, jednostka, ilosc, cena) values (?,?,?,?,?)");
			stmt2.setString(1,"michal");
			stmt2.setString(2,dane.nazwa);
			stmt2.setString(3,dane.jednostka);
			stmt2.setDouble(4,dane.ilosc);
			stmt2.setDouble(5,dane.cena);

			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/usun_produkt")
	public void usun_produkt(@RequestBody Dane_magazyn dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("delete from magazyn where nazwa = ?");
			stmt2.setString(1,dane.nazwa);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/zamow_produkt")
	public void zamow_produkt(@RequestBody Dane_magazyn dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select ilosc from magazyn where nazwa = ?");
			stmt.setString(1,dane.nazwa);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc+=dane.ilosc;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update magazyn set ilosc = ? where nazwa = ?");
			stmt2.setString(2,dane.nazwa);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/odejmij_produkt")
	public void odejmij_produkt(@RequestBody Dane_magazyn dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select ilosc from magazyn where nazwa = ?");
			stmt.setString(1,dane.nazwa);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc-=dane.ilosc;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update magazyn set ilosc = ? where nazwa = ?");
			stmt2.setString(2,dane.nazwa);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/edytuj_produkt")
	public void edytuj_produkt(@RequestBody Dane_magazyn dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update magazyn set jednostka = ?, ilosc = ?, cena = ? where nazwa = ?");
			stmt2.setString(4,dane.nazwa);
			stmt2.setString(1,dane.jednostka);
			stmt2.setDouble(2,dane.ilosc);
			stmt2.setDouble(3,dane.cena);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/dodaj_pracownik")
	public void dodaj_pracownik(@RequestBody Dane_pracownicy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into pracownicy (login, imie, nazwisko, stanowisko, telefon, godziny, stawka) values (?,?,?,?,?,?,?)");
			stmt2.setString(1,"michal");
			stmt2.setString(2,dane.imie);
			stmt2.setString(3,dane.nazwisko);
			stmt2.setString(4,dane.stanowisko);
			stmt2.setDouble(5,dane.telefon);
			stmt2.setDouble(6,0);
			stmt2.setDouble(7,dane.stawka);

			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/edytuj_pracownik")
	public void edytuj_produkt(@RequestBody Dane_pracownicy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set imie = ?, nazwisko = ?, stanowisko = ?, telefon = ?, godziny = ?, stawka = ? where id = ?");
			stmt2.setInt(7,dane.id);
			stmt2.setString(1,dane.imie);
			stmt2.setString(2,dane.nazwisko);
			stmt2.setString(3,dane.stanowisko);
			stmt2.setInt(4,dane.telefon);
			stmt2.setDouble(5,dane.stawka);
			stmt2.setDouble(6,dane.godziny);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/usun_pracownik")
	public void usun_pracownik(@RequestBody Dane_pracownicy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("delete from pracownicy where id = ?");
			stmt2.setInt(1,dane.id);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/dodaj_godziny")
	public void dodaj_godziny(@RequestBody Dane_pracownicy dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select godziny from pracownicy where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc+=dane.godziny;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set godziny = ? where id = ?");
			stmt2.setInt(2,dane.id);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/odejmij_godziny")
	public void odejmij_godziny(@RequestBody Dane_pracownicy dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select godziny from pracownicy where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc-=dane.godziny;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set godziny = ? where id = ?");
			stmt2.setInt(2,dane.id);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/resetuj_godziny")
	public void resetuj_godziny()
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set godziny = 0 where login = michal");
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
