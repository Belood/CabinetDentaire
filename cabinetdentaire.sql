-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 05 Mars 2018 à 22:41
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cabinetdentaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `cabinet`
--

CREATE TABLE `cabinet` (
  `CabinetID` int(10) NOT NULL,
  `Nom` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `Addresse` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `NumTel` int(10) DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `SiteWeb` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `ConsultationID` int(10) NOT NULL,
  `DossierID` int(10) NOT NULL,
  `ConsultationNum` int(10) DEFAULT NULL,
  `TypeConsultation` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `DateConsultation` date DEFAULT NULL,
  `Observations` text COLLATE utf8_roman_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dossier`
--

CREATE TABLE `dossier` (
  `DossierID` int(10) NOT NULL,
  `PatientID` int(10) NOT NULL,
  `DossierNum` int(10) DEFAULT NULL,
  `Remarque` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `DateCreation` date DEFAULT NULL,
  `DateDerniereModif` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `OperationID` int(10) NOT NULL,
  `ConsultationID` int(10) NOT NULL,
  `CodeOpe` int(10) DEFAULT NULL,
  `TypeOpe` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `NomOp` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `OrdonnanceID` int(10) NOT NULL,
  `ConsultationID` int(10) NOT NULL,
  `OrdonnanceNum` int(10) DEFAULT NULL,
  `Titre` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `DateOrd` date DEFAULT NULL,
  `Prescription` text COLLATE utf8_roman_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `PatientID` int(10) NOT NULL,
  `SalleAttenteID` int(10) DEFAULT NULL,
  `PersonnelID` int(10) NOT NULL,
  `Nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci DEFAULT NULL,
  `Prenom` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci DEFAULT NULL,
  `Addresse` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `NumTel` int(10) DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci DEFAULT NULL,
  `Profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci DEFAULT NULL,
  `Sexe` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci DEFAULT NULL,
  `Age` int(10) DEFAULT NULL,
  `NumSS` int(20) DEFAULT NULL,
  `NumAssurance` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `PersonnelID` int(10) NOT NULL,
  `CabinetID` int(10) NOT NULL,
  `Nom` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `Prenom` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `Addresse` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `NumTel` int(10) DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `Age` int(10) DEFAULT NULL,
  `Salaire` float DEFAULT NULL,
  `DateEmbauche` date DEFAULT NULL,
  `Login` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `Password` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `NiveauDroits` int(10) DEFAULT NULL,
  `Discriminator` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE `rdv` (
  `RdvID` int(10) NOT NULL,
  `PatientID` int(10) NOT NULL,
  `RdvNum` int(10) DEFAULT NULL,
  `RdvDate` date DEFAULT NULL,
  `Heure` time DEFAULT NULL,
  `Motif` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `SalleID` int(10) NOT NULL,
  `CabinetID` int(10) NOT NULL,
  `SalleNum` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `salleattente`
--

CREATE TABLE `salleattente` (
  `SalleAttenteID` int(10) NOT NULL,
  `SalleAttenteNum` int(10) DEFAULT NULL,
  `NbPatient` int(10) DEFAULT NULL,
  `TypeSalle` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE `specialite` (
  `SpecialiteID` int(10) NOT NULL,
  `PersonnelID` int(10) NOT NULL,
  `NomSpe` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `CodeSpe` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cabinet`
--
ALTER TABLE `cabinet`
  ADD PRIMARY KEY (`CabinetID`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`ConsultationID`),
  ADD KEY `DossierID` (`DossierID`);

--
-- Index pour la table `dossier`
--
ALTER TABLE `dossier`
  ADD PRIMARY KEY (`DossierID`),
  ADD KEY `PatientID` (`PatientID`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`OperationID`),
  ADD KEY `ConsultationID` (`ConsultationID`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`OrdonnanceID`),
  ADD KEY `ConsultationID` (`ConsultationID`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PatientID`),
  ADD KEY `SalleAttenteID` (`SalleAttenteID`),
  ADD KEY `PersonnelID` (`PersonnelID`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`PersonnelID`),
  ADD KEY `CabinetID` (`CabinetID`);

--
-- Index pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`RdvID`),
  ADD KEY `PatientID` (`PatientID`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`SalleID`),
  ADD KEY `CabinetID` (`CabinetID`);

--
-- Index pour la table `salleattente`
--
ALTER TABLE `salleattente`
  ADD PRIMARY KEY (`SalleAttenteID`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`SpecialiteID`),
  ADD KEY `PersonnelID` (`PersonnelID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cabinet`
--
ALTER TABLE `cabinet`
  MODIFY `CabinetID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `ConsultationID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `dossier`
--
ALTER TABLE `dossier`
  MODIFY `DossierID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `OperationID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  MODIFY `OrdonnanceID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `PatientID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `PersonnelID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `RdvID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `SalleID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `salleattente`
--
ALTER TABLE `salleattente`
  MODIFY `SalleAttenteID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `SpecialiteID` int(10) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `consultation_ibfk_1` FOREIGN KEY (`DossierID`) REFERENCES `dossier` (`DossierID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `dossier`
--
ALTER TABLE `dossier`
  ADD CONSTRAINT `dossier_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `operation_ibfk_1` FOREIGN KEY (`ConsultationID`) REFERENCES `consultation` (`ConsultationID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD CONSTRAINT `ordonnance_ibfk_1` FOREIGN KEY (`ConsultationID`) REFERENCES `consultation` (`ConsultationID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`SalleAttenteID`) REFERENCES `salleattente` (`SalleAttenteID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `patient_ibfk_2` FOREIGN KEY (`PersonnelID`) REFERENCES `personnel` (`PersonnelID`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`CabinetID`) REFERENCES `cabinet` (`CabinetID`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `rdv_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`CabinetID`) REFERENCES `cabinet` (`CabinetID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD CONSTRAINT `specialite_ibfk_1` FOREIGN KEY (`PersonnelID`) REFERENCES `personnel` (`PersonnelID`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
