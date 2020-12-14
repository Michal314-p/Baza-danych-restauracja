-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Gru 2020, 17:14
-- Wersja serwera: 10.4.14-MariaDB
-- Wersja PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `test`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dzienne_rozliczenie`
--

CREATE TABLE `dzienne_rozliczenie` (
  `koszt_pracownikow` double NOT NULL,
  `kosz_pojazdow` double NOT NULL,
  `koszt_produktow` double NOT NULL,
  `dzienny_zysk` double NOT NULL,
  `inne_koszta` double NOT NULL,
  `login` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `dzienne_rozliczenie`
--

INSERT INTO `dzienne_rozliczenie` (`koszt_pracownikow`, `kosz_pojazdow`, `koszt_produktow`, `dzienny_zysk`, `inne_koszta`, `login`) VALUES
(206.39999999999998, 63, 100, 0, 123, 'michal');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
