-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Gru 2020, 17:15
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
-- Struktura tabeli dla tabeli `o_prace`
--

CREATE TABLE `o_prace` (
  `id` int(11) NOT NULL,
  `imie` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `stanowisko` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `telefon` int(11) NOT NULL,
  `etat` double NOT NULL,
  `godziny` double NOT NULL,
  `wyplata` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `o_prace`
--

INSERT INTO `o_prace` (`id`, `imie`, `nazwisko`, `stanowisko`, `telefon`, `etat`, `godziny`, `wyplata`) VALUES
(1, 'Asar', 'Ed', 'Właściciel', 123404503, 1, 120, 3500),
(4, 'Nork', 'Sett', 'Manager', 123444, 1, 120, 1400),
(9, 'Jan', 'Kowalski', 'Kelner', 2123313, 0.25, 30, 1000);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `o_prace`
--
ALTER TABLE `o_prace`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `o_prace`
--
ALTER TABLE `o_prace`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
