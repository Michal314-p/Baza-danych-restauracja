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
-- Struktura tabeli dla tabeli `dodatkowe_koszty`
--

CREATE TABLE `dodatkowe_koszty` (
  `id` int(11) NOT NULL,
  `data` text NOT NULL,
  `opis` text NOT NULL,
  `cena` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `dodatkowe_koszty`
--

INSERT INTO `dodatkowe_koszty` (`id`, `data`, `opis`, `cena`) VALUES
(1, '2020-11-18', 'Naprawa zmywarki', 350),
(2, '2020-11-24', 'Kupno drukarki', 120.5),
(3, '2020-11-25', 'Zamówienie plakatu', 100),
(4, '2020-11-30', 'Naprawa skutera', 100),
(5, '2020-12-12', 'Naprawa skutera', 123);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `dodatkowe_koszty`
--
ALTER TABLE `dodatkowe_koszty`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `dodatkowe_koszty`
--
ALTER TABLE `dodatkowe_koszty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
