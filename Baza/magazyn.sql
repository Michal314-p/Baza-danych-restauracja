-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 15 Lis 2020, 14:37
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
-- Struktura tabeli dla tabeli `magazyn`
--

CREATE TABLE `magazyn` (
  `login` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwa` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `jednostka` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `ilosc` double NOT NULL,
  `cena` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `magazyn`
--

INSERT INTO `magazyn` (`login`, `nazwa`, `jednostka`, `ilosc`, `cena`) VALUES
('michal', 'Mleko', 'l', 1, 100),
('michal', 'Cebula', 'kg', 12.5, 1.75),
('michal', 'Banany', 'kg', 11, 12),
('michal', 'Arbuzy', 'szt', 25, 5.99),
('michal', 'Coca Cola 0.33l', 'szt', 5, 2.1),
('michal', 'Cukier', 'kg', 12, 5),
('michal', 'Tabasco', 'ml', 100, 0.33),
('michal', 'Sos BBQ Fanex', 'szt', 8, 12.5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
