-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Gru 2020, 17:13
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
-- Struktura tabeli dla tabeli `archiwum_kosztow`
--

CREATE TABLE `archiwum_kosztow` (
  `id` int(11) NOT NULL,
  `data` text NOT NULL,
  `koszt_produktow` double NOT NULL,
  `koszt_pracownikow` double NOT NULL,
  `koszt_pojazdow` double NOT NULL,
  `koszt_inne` double NOT NULL,
  `dochod_restauracja` double NOT NULL,
  `dochod_calkowity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `archiwum_kosztow`
--

INSERT INTO `archiwum_kosztow` (`id`, `data`, `koszt_produktow`, `koszt_pracownikow`, `koszt_pojazdow`, `koszt_inne`, `dochod_restauracja`, `dochod_calkowity`) VALUES
(1, '2020-11-20', 300, 100, 200, 120.5, 123.45, -597.05),
(2, '2020-11-25', 0, 0, 0, 100, 10000, 9900),
(4, '2020-11-26', 0, 0, 0, 0, 12222, 12222),
(6, '2020-11-27', 100, 100, 48, 0, 0, -248),
(7, '2020-12-02', 200, 10, 40, 100, 0, -350);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `archiwum_kosztow`
--
ALTER TABLE `archiwum_kosztow`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `archiwum_kosztow`
--
ALTER TABLE `archiwum_kosztow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
