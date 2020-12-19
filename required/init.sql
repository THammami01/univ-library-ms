CREATE TABLE Utilisateurs (
	nomUtilisateur VARCHAR(30) NOT NULL,
	motDePasse VARCHAR(30) NOT NULL,
	PRIMARY KEY(nomUtilisateur)
);

INSERT INTO Utilisateurs
VALUES("admin", "1234");

CREATE TABLE Abonnes (
	idAbonne INT NOT NULL UNIQUE AUTO_INCREMENT,
	prenom VARCHAR(80) NOT NULL,
	nom VARCHAR(80) NOT NULL,
	etu_ou_ens INT(1) NOT NULL,
	num_tel INT(8) NOT NULL,
	date_abonnement DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(idAbonne)
);

CREATE TABLE Livres (
	idLivre INT NOT NULL UNIQUE AUTO_INCREMENT,
	titre VARCHAR(100) NOT NULL,
	isbn VARCHAR(13) NOT NULL,
	date_ajout DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(idLivre)	
);

CREATE TABLE Emprunts (
	idEmprunt INT NOT NULL UNIQUE AUTO_INCREMENT,
	idLivre INT NOT NULL,
	idAbonne INT NOT NULL,
	date_pret DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_rendu DATETIME,
	PRIMARY KEY(idEmprunt), 
	FOREIGN KEY(idLivre) REFERENCES Livres(idLivre),
	FOREIGN KEY(idAbonne) REFERENCES Abonnes(idAbonne)	
);
