-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 24 Décembre 2017 à 19:38
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_des_ventes`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `CltId` int(11) NOT NULL,
  `CltNom` varchar(50) NOT NULL,
  `CltPrenom` varchar(50) NOT NULL,
  `CltEmail` varchar(50) NOT NULL,
  `CltTel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`CltId`, `CltNom`, `CltPrenom`, `CltEmail`, `CltTel`) VALUES
(1, 'el-boubakri', 'fatima', 'fatimaboubakri2013@gmail.com', '0688581080'),
(2, 'Biqcha', 'Bahia', 'b.biqcha@upm.ac.ma', '0688000000'),
(3, 'JAMILA', 'ATTABI', 'J.ATTABI@UPM.AC.MA', '0603000000');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `ProdId` int(11) NOT NULL,
  `ProdLibelle` varchar(50) NOT NULL,
  `ProdCategory` varchar(50) NOT NULL,
  `ProdQte` int(11) NOT NULL,
  `ProdPrix` double NOT NULL,
  `ProdFile` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`ProdId`, `ProdLibelle`, `ProdCategory`, `ProdQte`, `ProdPrix`, `ProdFile`) VALUES
(1, 'Asus', 'Ordinateur Portable', 10, 5000, 'img_20171224140207.jpeg'),
(3, 'DEL', 'Ordinateur Portable', 7, 4000, 'img_20171224140224.jpeg'),
(11, 'hp', 'Ordinateur Portable', 10, 7000, 'img_20171224143825.jpeg'),
(12, 'TOSHIBA', 'Ordinateur Portable', 10, 6000, 'img_20171224140335.jpeg'),
(13, 'MAC BOOK', 'Ordinateur Portable', 10, 10000, 'img_20171224140356.png');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `UserId` int(11) NOT NULL,
  `UserLogin` varchar(50) NOT NULL,
  `UserPass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`UserId`, `UserLogin`, `UserPass`) VALUES
(1, 'fatima', 'fatima'),
(2, 'bahia', 'bahia');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `VenteId` int(11) NOT NULL,
  `VenteClient` int(11) NOT NULL,
  `VenteProduit` int(11) NOT NULL,
  `VenteQte` int(11) NOT NULL,
  `VenteDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vente`
--

INSERT INTO `vente` (`VenteId`, `VenteClient`, `VenteProduit`, `VenteQte`, `VenteDate`) VALUES
(6, 1, 1, 1, '2017-12-26'),
(7, 1, 3, 2, '2017-12-09'),
(8, 3, 3, 3, '2017-12-24');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`CltId`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`ProdId`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`UserId`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`VenteId`),
  ADD KEY `c1` (`VenteClient`),
  ADD KEY `c2` (`VenteProduit`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `CltId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `ProdId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `VenteId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `c1` FOREIGN KEY (`VenteClient`) REFERENCES `client` (`CltId`),
  ADD CONSTRAINT `c2` FOREIGN KEY (`VenteProduit`) REFERENCES `produit` (`ProdId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
