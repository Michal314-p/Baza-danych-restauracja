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
-- Struktura tabeli dla tabeli `dane_restauracja`
--

CREATE TABLE `dane_restauracja` (
  `id` int(11) NOT NULL,
  `login` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwa` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `wlasciciel` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `miasto` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `lokalizacja` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `godziny_otwarcia` text NOT NULL,
  `wifi` text NOT NULL,
  `ilosc_stolikow` text NOT NULL,
  `rodzaj_kuchni` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `dane_restauracja`
--

INSERT INTO `dane_restauracja` (`id`, `login`, `nazwa`, `wlasciciel`, `miasto`, `lokalizacja`, `godziny_otwarcia`, `wifi`, `ilosc_stolikow`, `rodzaj_kuchni`) VALUES
(1, 'michal', 'Ramen House', 'Michał Pasierbiewicz', 'Wrocław', 'Stysia Wincentego 49/1', '9-22', 'Tak', '10', 'Azjatycka');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `dane_restauracja`
--
ALTER TABLE `dane_restauracja`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `dane_restauracja`
--
ALTER TABLE `dane_restauracja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
