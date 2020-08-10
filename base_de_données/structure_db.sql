-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 10, 2020 at 08:18 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `tva` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `descriptions`
--

CREATE TABLE `descriptions` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `prixUnitaire` int(11) DEFAULT NULL,
  `factureId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `factures`
--

CREATE TABLE `factures` (
  `id` int(11) NOT NULL,
  `montantTVA` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `clientId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `descriptions`
--
ALTER TABLE `descriptions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `factureId` (`factureId`);

--
-- Indexes for table `factures`
--
ALTER TABLE `factures`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clientId` (`clientId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `descriptions`
--
ALTER TABLE `descriptions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `factures`
--
ALTER TABLE `factures`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `descriptions`
--
ALTER TABLE `descriptions`
  ADD CONSTRAINT `descriptions_ibfk_1` FOREIGN KEY (`factureId`) REFERENCES `factures` (`id`);

--
-- Constraints for table `factures`
--
ALTER TABLE `factures`
  ADD CONSTRAINT `factures_ibfk_1` FOREIGN KEY (`clientId`) REFERENCES `clients` (`id`);
