-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 16 Juin 2016 à 09:59
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

-- --------------------------------------------------------

--
-- Structure de la table `element`
--

CREATE TABLE `element` (
  `id` int NOT NULL,
  `type` varchar(255) NOT NULL,
  `x` int NOT NULL,
  `y` int NOT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `lvl_number` int NOT NULL,
  FOREIGN KEY (lvl_number) REFERENCES lvl(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `element`
--

INSERT INTO `element` (`id`, `type`, `x`, `y`, `direction`, `lvl_number`) VALUES
(2, 'cross-wall', 0, 0, NULL, 1),
(4, 'vertical-wall', 0, 1, NULL, 1),
(5, 'vertical-wall', 0, 2, NULL, 1),
(6, 'vertical-wall', 0, 3, NULL, 1),
(7, 'cross-wall', 0, 4, NULL, 1),
(8, 'vertical-wall', 0, 5, NULL, 1),
(9, 'cross-wall', 0, 6, NULL, 1),
(10, 'vertical-wall', 0, 7, NULL, 1),
(11, 'vertical-wall', 0, 8, NULL, 1),
(12, 'cross-wall', 0, 9, NULL, 1),
(13, 'vertical-wall', 0, 10, NULL, 1),
(14, 'cross-wall', 0, 11, NULL, 1),
(15, 'horizontal-wall', 1, 0, NULL, 1),
(16, 'horizontal-wall', 1, 4, NULL, 1),
(17, 'horizontal-wall', 1, 6, NULL, 1),
(18, 'horizontal-wall', 1, 9, NULL, 1),
(19, 'horizontal-wall', 1, 11, NULL, 1),
(20, 'horizontal-wall', 2, 0, NULL, 1),
(21, 'horizontal-wall', 2, 4, NULL, 1),
(22, 'horizontal-wall', 2, 6, NULL, 1),
(23, 'horizontal-wall', 2, 9, NULL, 1),
(24, 'horizontal-wall', 2, 11, NULL, 1),
(25, 'horizontal-wall', 3, 0, NULL, 1),
(26, 'horizontal-wall', 3, 4, NULL, 1),
(27, 'horizontal-wall', 3, 6, NULL, 1),
(28, 'horizontal-wall', 3, 9, NULL, 1),
(29, 'horizontal-wall', 3, 11, NULL, 1),
(30, 'horizontal-wall', 4, 0, NULL, 1),
(31, 'horizontal-wall', 4, 4, NULL, 1),
(32, 'horizontal-wall', 4, 6, NULL, 1),
(33, 'horizontal-wall', 4, 9, NULL, 1),
(34, 'horizontal-wall', 4, 11, NULL, 1),
(35, 'horizontal-wall', 5, 0, NULL, 1),
(36, 'horizontal-wall', 5, 4, NULL, 1),
(37, 'horizontal-wall', 5, 6, NULL, 1),
(38, 'horizontal-wall', 5, 9, NULL, 1),
(39, 'horizontal-wall', 5, 11, NULL, 1),
(40, 'horizontal-wall', 6, 0, NULL, 1),
(41, 'horizontal-wall', 6, 4, NULL, 1),
(42, 'horizontal-wall', 6, 6, NULL, 1),
(43, 'horizontal-wall', 6, 9, NULL, 1),
(44, 'horizontal-wall', 6, 11, NULL, 1),
(45, 'cross-wall', 7, 0, NULL, 1),
(46, 'vertical-wall', 7, 1, NULL, 1),
(47, 'vertical-wall', 7, 2, NULL, 1),
(48, 'vertical-wall', 7, 3, NULL, 1),
(49, 'cross-wall', 7, 4, NULL, 1),
(50, 'vertical-wall', 7, 6, NULL, 1),
(51, 'vertical-wall', 7, 7, NULL, 1),
(52, 'vertical-wall', 7, 8, NULL, 1),
(53, 'cross-wall', 7, 9, NULL, 1),
(54, 'horizontal-wall', 7, 11, NULL, 1),
(55, 'horizontal-wall', 8, 0, NULL, 1),
(56, 'horizontal-wall', 8, 9, NULL, 1),
(57, 'horizontal-wall', 8, 11, NULL, 1),
(58, 'horizontal-wall', 9, 0, NULL, 1),
(59, 'horizontal-wall', 9, 9, NULL, 1),
(60, 'horizontal-wall', 9, 11, NULL, 1),
(61, 'horizontal-wall', 10, 0, NULL, 1),
(62, 'hero', 10, 1, 'DOWN', 1),
(63, 'horizontal-wall', 10, 9, NULL, 1),
(64, 'monster', 10, 10, 'LEFT', 1),
(65, 'horizontal-wall', 10, 11, NULL, 1),
(66, 'horizontal-wall', 11, 0, NULL, 1),
(67, 'horizontal-wall', 11, 9, NULL, 1),
(68, 'horizontal-wall', 11, 11, NULL, 1),
(69, 'horizontal-wall', 12, 0, NULL, 1),
(70, 'horizontal-wall', 12, 9, NULL, 1),
(71, 'horizontal-wall', 12, 11, NULL, 1),
(72, 'cross-wall', 13, 0, NULL, 1),
(73, 'vertical-wall', 13, 1, NULL, 1),
(74, 'vertical-wall', 13, 2, NULL, 1),
(75, 'vertical-wall', 13, 3, NULL, 1),
(76, 'cross-wall', 13, 4, NULL, 1),
(77, 'cross-wall', 13, 6, NULL, 1),
(78, 'vertical-wall', 13, 7, NULL, 1),
(79, 'vertical-wall', 13, 8, NULL, 1),
(80, 'cross-wall', 13, 9, NULL, 1),
(81, 'horizontal-wall', 13, 11, NULL, 1),
(82, 'horizontal-wall', 14, 0, NULL, 1),
(83, 'horizontal-wall', 14, 4, NULL, 1),
(84, 'horizontal-wall', 14, 9, NULL, 1),
(85, 'horizontal-wall', 14, 11, NULL, 1),
(86, 'horizontal-wall', 15, 0, NULL, 1),
(87, 'horizontal-wall', 15, 4, NULL, 1),
(88, 'horizontal-wall', 15, 6, NULL, 1),
(89, 'horizontal-wall', 15, 9, NULL, 1),
(90, 'horizontal-wall', 15, 11, NULL, 1),
(91, 'horizontal-wall', 16, 0, NULL, 1),
(92, 'horizontal-wall', 16, 4, NULL, 1),
(93, 'horizontal-wall', 16, 6, NULL, 1),
(94, 'horizontal-wall', 16, 9, NULL, 1),
(95, 'horizontal-wall', 16, 11, NULL, 1),
(96, 'horizontal-wall', 17, 0, NULL, 1),
(97, 'horizontal-wall', 17, 4, NULL, 1),
(98, 'horizontal-wall', 17, 6, NULL, 1),
(99, 'horizontal-wall', 17, 9, NULL, 1),
(100, 'horizontal-wall', 17, 11, NULL, 1),
(102, 'horizontal-wall', 18, 0, NULL, 1),
(103, 'horizontal-wall', 18, 4, NULL, 1),
(104, 'horizontal-wall', 18, 6, NULL, 1),
(105, 'horizontal-wall', 18, 9, NULL, 1),
(106, 'horizontal-wall', 18, 11, NULL, 1),
(107, 'cross-wall', 19, 0, NULL, 1),
(108, 'vertical-wall', 19, 1, NULL, 1),
(109, 'vertical-wall', 19, 2, NULL, 1),
(110, 'vertical-wall', 19, 3, NULL, 1),
(111, 'cross-wall', 19, 4, NULL, 1),
(112, 'door', 19, 5, NULL, 1),
(113, 'cross-wall', 19, 6, NULL, 1),
(114, 'vertical-wall', 19, 7, NULL, 1),
(115, 'vertical-wall', 19, 8, NULL, 1),
(116, 'cross-wall', 19, 9, NULL, 1),
(117, 'vertical-wall', 19, 10, NULL, 1),
(118, 'cross-wall', 19, 11, NULL, 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `element`
--
ALTER TABLE `element`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `element`
--
ALTER TABLE `element`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
