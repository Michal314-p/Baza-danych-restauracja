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

	@GetMapping("/dane_o_prace")
	public List<Dane_o_prace> dane_o_prace()
	{
		int id = 0;
		String imie = null;
		String nazwisko = null;
		String stanowisko = null;
		int telefon = 0;
		double etat = 0;
		double godziny = 0;
		double wyplata = 0;
		List <Dane_o_prace> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from o_prace");
			while(rs.next())
			{
				id=rs.getInt(1);
				imie=rs.getString(2);
				nazwisko=rs.getString(3);
				stanowisko=rs.getString(4);
				telefon=rs.getInt(5);
				etat=rs.getDouble(6);
				godziny=rs.getDouble(7);
				wyplata=rs.getDouble(8);
				stream.add(new Dane_o_prace(id,imie,nazwisko,stanowisko,telefon,etat,godziny,wyplata));
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return stream;
	}

	@GetMapping("/dane_pojazdy")
	public List<Dane_pojazdy> dane_pojazdy()
	{
		int id = 0;
		String pojazd = null;
		String marka = null;
		double spalanie = 0;
		double koszt = 0;

		List <Dane_pojazdy> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from pojazdy");
			while(rs.next())
			{
				id=rs.getInt(1);
				pojazd=rs.getString(2);
				marka=rs.getString(3);
				spalanie=rs.getDouble(4);
				koszt=rs.getDouble(5);
				stream.add(new Dane_pojazdy(id,pojazd,marka,spalanie,koszt));
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
		Double cena = null;
		Double baza_cena = null;
		Double koszt = null;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select ilosc,cena from magazyn where nazwa = ?");
			stmt.setString(1,dane.nazwa);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
				cena=resultSet.getDouble(2);
			}

			koncowa_wartosc+=dane.ilosc;
			koszt=cena*dane.ilosc;

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update magazyn set ilosc = ? where nazwa = ?");
			stmt2.setString(2,dane.nazwa);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();


			stmt = db.conn.prepareStatement("select koszt_produktow from dzienne_rozliczenie where login = ?");
			stmt.setString(1,"michal");
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				baza_cena= resultSet.getDouble(1);
			}

			koszt+=baza_cena;

			stmt2 = db.conn.prepareStatement("update dzienne_rozliczenie set koszt_produktow =? where login = ?");
			stmt2.setString(2,"michal");
			stmt2.setDouble(1,koszt);
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
		String jednostka = null;
		Double ilosc = null;
		Double cena = null;

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt=null;
			stmt = db.conn.prepareStatement("select * from magazyn where nazwa = ?");
			stmt.setString(1,dane.nazwa);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				jednostka=resultSet.getString(3);
				ilosc=resultSet.getDouble(4);
				cena=resultSet.getDouble(5);
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update magazyn set jednostka = ?,ilosc = ?, cena = ? where nazwa = ?");
			stmt2.setString(4,dane.nazwa);
			if(dane.jednostka==null) { stmt2.setString(1,jednostka); }
			else { stmt2.setString(1,dane.jednostka); }
			if(dane.ilosc==null) { stmt2.setDouble(2,ilosc); }
			else { stmt2.setDouble(2,dane.ilosc); }
			if(dane.cena==null) { stmt2.setDouble(3,cena);}
			else { stmt2.setDouble(3,dane.cena); }
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
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
		String imie = null;
		String nazwisko = null;
		String stanowisko = null;
		Integer telefon = null;
		Double godziny = null;
		Double stawka = null;


		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt=null;
			stmt = db.conn.prepareStatement("select * from pracownicy where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				imie=resultSet.getString(3);
				nazwisko=resultSet.getString(4);
				stanowisko=resultSet.getString(5);
				telefon=resultSet.getInt(6);
				godziny=resultSet.getDouble(7);
				stawka=resultSet.getDouble(8);

			}
			db.rozlacz();
		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set imie = ?, nazwisko = ?, stanowisko = ?, telefon = ?, godziny = ?,  stawka = ? where id = ?");
			stmt2.setInt(7,dane.id);

			if(dane.imie==null) { stmt2.setString(1,imie); }
			else { stmt2.setString(1,dane.imie); }

			if(dane.nazwisko==null) { stmt2.setString(2,nazwisko); }
			else { stmt2.setString(2,dane.nazwisko); }

			if(dane.stanowisko==null) { stmt2.setString(3,stanowisko); }
			else { stmt2.setString(3,dane.stanowisko); }

			if(dane.telefon==null) { stmt2.setInt(4,telefon);}
			else { stmt2.setInt(4,dane.telefon); }

			if(dane.godziny==null) { stmt2.setDouble(5,godziny); }
			else { stmt2.setDouble(5,dane.godziny); }

			if(dane.stawka==null) { stmt2.setDouble(6,stawka); }
			else { stmt2.setDouble(6,dane.stawka); }

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
		Double godziny = null;
		Double stawka = null;
		Double koszt = null;

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select godziny, stawka from pracownicy where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				godziny = resultSet.getDouble(1);
				stawka = resultSet.getDouble(2);
			}
			koszt=stawka*dane.godziny;
			System.out.println(koszt);
			godziny+=dane.godziny;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set godziny = ? where id = ?");
			stmt2.setInt(2,dane.id);
			stmt2.setDouble(1,godziny);
			stmt2.executeUpdate();

			stmt = db.conn.prepareStatement("select koszt_pracownikow from dzienne_rozliczenie where login = ?");
			stmt.setString(1,"michal");
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koszt += resultSet.getDouble(1);
			}

			stmt2 = db.conn.prepareStatement("update dzienne_rozliczenie set koszt_pracownikow =? where login = ?");
			stmt2.setString(2,"michal");
			stmt2.setDouble(1,koszt);
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
	public void resetuj_godziny(@RequestBody Dane_pracownicy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pracownicy set godziny = 0 ");
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/rachunek_paliwo")
	public void rachunek_paliwo(@RequestBody Dane_pojazdy dane)
	{
		Double spalanie = 0.0;
		Double koszt = 0.0;
		Double do_bazy=null;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select spalanie,koszt from pojazdy where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				spalanie = resultSet.getDouble(1);
				koszt = resultSet.getDouble(2);
			}

			koszt+=dane.spalanie*dane.koszt;
			spalanie+=dane.spalanie;

			stmt = db.conn.prepareStatement("select kosz_pojazdow from dzienne_rozliczenie where login = ?");
			stmt.setString(1,"michal");
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				do_bazy = resultSet.getDouble(1);
			}

			do_bazy+=dane.spalanie*dane.koszt;
			stmt = db.conn.prepareStatement("update dzienne_rozliczenie set kosz_pojazdow =? where login = ?");
			stmt.setString(2,"michal");
			stmt.setDouble(1,do_bazy);
			stmt.executeUpdate();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pojazdy set spalanie = ?, koszt = ? where id = ?");
			stmt2.setInt(3,dane.id);
			stmt2.setDouble(2,koszt);
			stmt2.setDouble(1,spalanie);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}


	@PostMapping("/reset_paliwo")
	public void reset_paliwo(@RequestBody Dane_pojazdy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pojazdy set spalanie = 0, koszt = 0 ");
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/dodaj_pojazd")
	public void dodaj_pojazd(@RequestBody Dane_pojazdy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into pojazdy (pojazd,marka,spalanie,koszt) values (?,?,?,?)");
			stmt2.setString(1,dane.pojazd);
			stmt2.setString(2,dane.marka);
			stmt2.setDouble(3,0);
			stmt2.setDouble(4,0);

			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/edytuj_pojazd")
	public void edytuj_pojazd(@RequestBody Dane_pojazdy dane)
	{
		String pojazd = null;
		String marka = null;
		Double spalanie = null;
		Double koszt = null;

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt=null;
			stmt = db.conn.prepareStatement("select * from pojazdy where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				pojazd=resultSet.getString(2);
				marka=resultSet.getString(3);
				spalanie=resultSet.getDouble(4);
				koszt=resultSet.getDouble(5);
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update pojazdy set pojazd = ?, marka = ?, spalanie = ?, koszt = ? where id = ?");
			stmt2.setInt(5,dane.id);
			if(dane.pojazd==null) { stmt2.setString(1,pojazd); }
			else { stmt2.setString(1,dane.pojazd); }
			if(dane.marka==null) { stmt2.setString(2,marka); }
			else { stmt2.setString(2,dane.marka); }
			if(dane.spalanie==null) { stmt2.setDouble(3,spalanie);}
			else { stmt2.setDouble(3,dane.spalanie); }
			if(dane.koszt==null) { stmt2.setDouble(4,koszt); }
			else { stmt2.setDouble(4,dane.koszt); }
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/usun_pojazd")
	public void usun_pojazd(@RequestBody Dane_pojazdy dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("delete from pojazdy where id = ?");
			stmt2.setInt(1,dane.id);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/dodaj_o_prace")
	public void dodaj_o_prace(@RequestBody Dane_o_prace dane)
	{
		Double etat = null;


		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt=null;
			stmt = db.conn.prepareStatement("select * from etat where id = 1");
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				etat=resultSet.getDouble(2);
			}
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into o_prace (imie, nazwisko, stanowisko, telefon, etat, godziny, wyplata) values (?,?,?,?,?,?,?)");
			stmt2.setString(1,dane.imie);
			stmt2.setString(2,dane.nazwisko);
			stmt2.setString(3,dane.stanowisko);
			stmt2.setDouble(4,dane.telefon);
			stmt2.setDouble(5,dane.etat);
			stmt2.setDouble(6,dane.etat*etat);
			stmt2.setDouble(7,dane.wyplata);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/edytuj_o_prace")
	public void edytuj_o_prace(@RequestBody Dane_o_prace dane)
	{
		String imie = null;
		String nazwisko = null;
		String stanowisko = null;
		Integer telefon = null;
		Double etat = null;
		Double wyplata = null;


		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt=null;
			stmt = db.conn.prepareStatement("select * from o_prace where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				imie=resultSet.getString(2);
				nazwisko=resultSet.getString(3);
				stanowisko=resultSet.getString(4);
				telefon=resultSet.getInt(5);
				etat=resultSet.getDouble(6);
				wyplata=resultSet.getDouble(8);
			}
			db.rozlacz();
		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update o_prace set imie = ?, nazwisko = ?, stanowisko = ?, telefon = ?, etat = ?,  wyplata = ? where id = ?");
			stmt2.setInt(7,dane.id);

			if(dane.imie==null) { stmt2.setString(1,imie); }
			else { stmt2.setString(1,dane.imie); }

			if(dane.nazwisko==null) { stmt2.setString(2,nazwisko); }
			else { stmt2.setString(2,dane.nazwisko); }

			if(dane.stanowisko==null) { stmt2.setString(3,stanowisko); }
			else { stmt2.setString(3,dane.stanowisko); }

			if(dane.telefon==null) { stmt2.setInt(4,telefon);}
			else { stmt2.setInt(4,dane.telefon); }

			if(dane.etat==null) { stmt2.setDouble(5,etat); }
			else { stmt2.setDouble(5,dane.etat); }

			if(dane.wyplata==null) { stmt2.setDouble(6,wyplata); }
			else { stmt2.setDouble(6,dane.wyplata); }

			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/usun_o_prace")
	public void usun_o_prace(@RequestBody Dane_o_prace dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("delete from o_prace where id = ?");
			stmt2.setInt(1,dane.id);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/dodaj_godziny_o_prace")
	public void dodaj_godziny_o_prace(@RequestBody Dane_o_prace dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select godziny from o_prace where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc-=dane.godziny;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update o_prace set godziny = ? where id = ?");
			stmt2.setInt(2,dane.id);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/odejmij_godziny_o_prace")
	public void odejmij_godziny_o_prace(@RequestBody Dane_o_prace dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select godziny from o_prace where id = ?");
			stmt.setInt(1,dane.id);
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc+=dane.godziny;
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update o_prace set godziny = ? where id = ?");
			stmt2.setInt(2,dane.id);
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/resetuj_godziny_o_prace")
	public void resetuj_godziny_o_prace(@RequestBody Dane_o_prace dane)
	{
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update o_prace set godziny = 0 ");
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	@PostMapping("/ustaw_etat")
	public void ustaw_etat(@RequestBody Dane_o_prace dane)
	{
		int id = 0;
		double etat = 0;

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from o_prace");
			while(rs.next())
			{
				id=rs.getInt(1);
				etat=rs.getDouble(6);
				PreparedStatement stmt2= null;
				stmt2 = db.conn.prepareStatement("update o_prace set godziny = ? where id = ?");
				stmt2.setInt(2,id);
				stmt2.setDouble(1,etat*dane.godziny);
				stmt2.executeUpdate();
			}
			db.rozlacz();
		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update etat set etat = ? where id = 1");
			stmt2.setDouble(1,dane.godziny);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@GetMapping("/dane_dzienne_pobierz")
	public List<Dane_dzienne> dane_dzienne_pobierz()
	{
		Double koszt_pracownikow =null;
		Double kosz_pojazdow=null;
		Double koszt_produktow=null;
		Double dzienny_zysk=null;
		Double inne_koszta=null;
		String login =null;
		List <Dane_dzienne> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from dzienne_rozliczenie");
			while(rs.next())
			{
				koszt_pracownikow=rs.getDouble(1);
				kosz_pojazdow=rs.getDouble(2);
				koszt_produktow=rs.getDouble(3);
				dzienny_zysk=rs.getDouble(4);
				inne_koszta=rs.getDouble(5);
				login=rs.getString(6);

			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return Stream.of(new Dane_dzienne(koszt_pracownikow,kosz_pojazdow,koszt_produktow,dzienny_zysk,inne_koszta,login)).
				collect(Collectors.toList());
	}

	@GetMapping("/dochod_pobierz")
	public List<Dane_dochod> dochod_pobierz()
	{
		String login =null;
		Double suma =null;

		List <Dane_dochod> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from calkowity_dochod");
			while(rs.next())
			{
				login=rs.getString(1);
				suma=rs.getDouble(2);
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return Stream.of(new Dane_dochod(login,suma)).
				collect(Collectors.toList());
	}

	@GetMapping("/dane_inne_wydatki")
	public List<Dane_inne_wydatki> dane_inne_wydatki()
	{
		Integer id = null;
		String data= null;
		String opis= null;
		Double cena= null;

		List <Dane_inne_wydatki> stream = new ArrayList<>();

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();
			Statement stmt=db.conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from dodatkowe_koszty");
			while(rs.next())
			{
				id=rs.getInt(1);
				data=rs.getString(2);
				opis=rs.getString(3);
				cena=rs.getDouble(4);
				stream.add(new Dane_inne_wydatki(id,data,opis,cena));
			}

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
		return stream;
	}

	@PostMapping("/dzienny_dochod")
	public void dzienny_dochod(@RequestBody Dane_dzienne dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select dzienny_zysk from dzienne_rozliczenie where login = ?");
			stmt.setString(1,"michal");
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc+=dane.dzienny_zysk;

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update dzienne_rozliczenie set dzienny_zysk = ? where login = ?");
			stmt2.setString(2,"michal");
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/dodatkowe_wydatki")
	public void dodatkowe_wydatki(@RequestBody Dane_inne_wydatki dane)
	{
		Double koncowa_wartosc = 0.0;
		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select inne_koszta from dzienne_rozliczenie where login = ?");
			stmt.setString(1,"michal");
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koncowa_wartosc = resultSet.getDouble(1);
			}

			koncowa_wartosc+=dane.cena;

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("update dzienne_rozliczenie set inne_koszta = ? where login = ?");
			stmt2.setString(2,"michal");
			stmt2.setDouble(1,koncowa_wartosc);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into dodatkowe_koszty (data,opis,cena) values (?,?,?)");
			stmt2.setString(1,dane.data);
			stmt2.setString(2,dane.opis);
			stmt2.setDouble(3,dane.cena);
			stmt2.executeUpdate();
			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}

	}

	@PostMapping("/zatwierdz_koszta")
	public void zatwierdz_koszta(@RequestBody Dane_inne_wydatki dane)
	{
		Double koszt_pracownikow = null;
		Double koszt_pojazdow = null;
		Double koszt_produktow = null;
		Double dzienny_zysk = null;
		Double inne_koszta = null;
		Double dochod_calkowity = null;
		String login = null;
		Double dochod_z_bazy = null;

		try{
			Baza_uzytkowe db = new Baza_uzytkowe();
			db.polacz_z_baza();

			PreparedStatement stmt= null;
			stmt = db.conn.prepareStatement("select * from dzienne_rozliczenie where login = ?");
			stmt.setString(1,"michal");
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				koszt_pracownikow=resultSet.getDouble(1);
				koszt_pojazdow=resultSet.getDouble(2);
				koszt_produktow=resultSet.getDouble(3);
				dzienny_zysk=resultSet.getDouble(4);
				inne_koszta=resultSet.getDouble(5);
			}
			dochod_calkowity=dzienny_zysk-koszt_pojazdow-koszt_pracownikow-koszt_produktow-inne_koszta;



			PreparedStatement stmt4= null;
			stmt4 = db.conn.prepareStatement("select suma from calkowity_dochod where login = ?");
			stmt4.setString(1,"michal");
			ResultSet rSet = null;
			rSet = stmt4.executeQuery();
			while(rSet.next())
			{
				dochod_z_bazy = rSet.getDouble(1);
			}

			dochod_z_bazy+=dochod_calkowity;


			PreparedStatement stmt2= null;
			stmt2 = db.conn.prepareStatement("insert into archiwum_kosztow (data,koszt_produktow,koszt_pracownikow,koszt_pojazdow,koszt_inne,dochod_restauracja,dochod_calkowity) values (?,?,?,?,?,?,?)");
			stmt2.setString(1,dane.data);
			stmt2.setDouble(2,koszt_produktow);
			stmt2.setDouble(3,koszt_pracownikow);
			stmt2.setDouble(4,koszt_pojazdow);
			stmt2.setDouble(5,inne_koszta);
			stmt2.setDouble(6,dzienny_zysk);
			stmt2.setDouble(7,dochod_calkowity);
			stmt2.executeUpdate();

			PreparedStatement stmt3= null;
			stmt3 = db.conn.prepareStatement("update dzienne_rozliczenie set inne_koszta = 0,dzienny_zysk=0,koszt_produktow=0,kosz_pojazdow=0,koszt_pracownikow=0 where login = ?");
			stmt3.setString(1,"michal");
			stmt3.executeUpdate();

			PreparedStatement stmt5= null;
			stmt5 = db.conn.prepareStatement("update calkowity_dochod set suma = ? where login = ?");
			stmt5.setString(2,"michal");
			stmt5.setDouble(1,dochod_z_bazy);
			stmt5.executeUpdate();

			db.rozlacz();

		}catch(Exception e){ System.out.println(e);}
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
