-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 29 jan. 2022 à 10:55
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dragon2`
--

-- --------------------------------------------------------

--
-- Structure de la table `aime`
--

DROP TABLE IF EXISTS `aime`;
CREATE TABLE IF NOT EXISTS `aime` (
  `id_dragon` int(2) NOT NULL,
  `dragonAimant` varchar(50) NOT NULL,
  `dragonAime` varchar(50) DEFAULT NULL,
  `dragonForce` varchar(50) DEFAULT NULL,
  KEY `dragonAimant` (`dragonAimant`),
  KEY `dragonAime` (`dragonAime`),
  KEY `id_dragon` (`id_dragon`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `aime`
--

INSERT INTO `aime` (`id_dragon`, `dragonAimant`, `dragonAime`, `dragonForce`) VALUES
(1, 'Smaug', 'Negueth', 'passionnement'),
(2, 'Birdurh', 'Negueth', 'beaucoup'),
(3, 'Negueth', 'Miloch', 'a la folie'),
(6, 'Miloch', 'Negueth', 'a la folie'),
(8, 'Tarak', 'Bolong', 'un peu'),
(9, 'Solong', 'Tarak', 'beaucoup');

-- --------------------------------------------------------

--
-- Structure de la table `dragons`
--

DROP TABLE IF EXISTS `dragons`;
CREATE TABLE IF NOT EXISTS `dragons` (
  `id_dragon` int(2) NOT NULL AUTO_INCREMENT,
  `dragon` varchar(50) NOT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `longueur` int(11) DEFAULT NULL,
  `nombre_ecailles` int(11) DEFAULT NULL,
  `crache_feu` varchar(10) DEFAULT NULL,
  `comportement_amoureux` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_dragon`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dragons`
--

INSERT INTO `dragons` (`id_dragon`, `dragon`, `sexe`, `longueur`, `nombre_ecailles`, `crache_feu`, `comportement_amoureux`) VALUES
(1, 'Smaug', 'Male', 152, 1857, 'oui', 'macho'),
(2, 'Birdurh', 'Male', 258, 4787, 'non', 'timide'),
(3, 'Negueth', 'Female', 128, 1581, 'oui', 'sincere'),
(4, 'MissToc', 'Female', 183, 2781, 'non', 'superflu'),
(5, 'Bolong', 'Male', 213, 2751, 'oui', 'macho'),
(6, 'Miloch', 'Male', 83, 718, 'oui', 'timide'),
(7, 'Nessie', 'Male', 168, 1721, 'non', 'absent'),
(8, 'Tarak', 'Female', 123, 851, 'oui', 'timide'),
(10, 'solong', NULL, NULL, 2345, NULL, NULL),
(14, 'Kevin', NULL, NULL, NULL, NULL, 'gentil des fois');

-- --------------------------------------------------------

--
-- Structure de la table `nourritures`
--

DROP TABLE IF EXISTS `nourritures`;
CREATE TABLE IF NOT EXISTS `nourritures` (
  `produit` varchar(20) NOT NULL,
  `calories` int(11) DEFAULT NULL,
  PRIMARY KEY (`produit`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `nourritures`
--

INSERT INTO `nourritures` (`produit`, `calories`) VALUES
('pomme', 7),
('cacahuete', 10),
('orange', 25),
('oeuf', 15),
('ver', 3),
('poisson', 35);

-- --------------------------------------------------------

--
-- Structure de la table `repas`
--

DROP TABLE IF EXISTS `repas`;
CREATE TABLE IF NOT EXISTS `repas` (
  `id_dragon` int(2) NOT NULL,
  `dragon` varchar(50) NOT NULL,
  `produit` varchar(20) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  KEY `produit` (`produit`),
  KEY `dragon` (`dragon`),
  KEY `id_dragon` (`id_dragon`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `repas`
--

INSERT INTO `repas` (`id_dragon`, `dragon`, `produit`, `quantite`) VALUES
(1, 'Smaug', 'cacahuete', 1000),
(1, 'Smaug', 'pomme', 16),
(2, 'Birdurh', 'oeuf', 4),
(3, 'Negueth', 'orange', 6),
(3, 'Negueth', 'oeuf', 1),
(6, 'Miloch', 'ver', 53),
(6, 'Miloch', 'cacahuete', 100),
(7, 'Nessie', 'poisson', 20),
(8, 'Tarak', 'pomme', 10),
(8, 'Tarak', 'orange', 10),
(9, 'Solong', 'oeuf', 6),
(9, 'Solong', 'poisson', 1),
(9, 'Solong', 'orange', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
