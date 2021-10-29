-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 29. Okt 2021 um 18:53
-- Server-Version: 10.4.16-MariaDB
-- PHP-Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `hwr_projekt_recycling_app`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `main`
--

CREATE TABLE `main` (
  `Barcode` bigint(13) NOT NULL,
  `Hinweis` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `main`
--

INSERT INTO `main` (`Barcode`, `Hinweis`) VALUES
(4004980517004, 'Deckel und Folie von der Dose trennen und alles in die Gelbe Tonne schmeißen.');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `main`
--
ALTER TABLE `main`
  ADD PRIMARY KEY (`Barcode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
