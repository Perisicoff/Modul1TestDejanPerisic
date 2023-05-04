DROP SCHEMA IF EXISTS sportpass;
CREATE SCHEMA sportpass DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE sportpass;

CREATE TABLE paketi (
	id BIGINT AUTO_INCREMENT,
    naziv VARCHAR(75) NOT NULL,
	brTreninga INT NOT NULL,
    duzinaTrajanja INT NOT NULL,
    cena DOUBLE NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE clanarine (
	id BIGINT AUTO_INCREMENT,
    paketId BIGINT NOT NULL,
	imeKorisnika VARCHAR(75) NOT NULL,
    datumIPocetka DATETIME NOT NULL,
	PRIMARY KEY(id),
    FOREIGN KEY(paketId) REFERENCES paketi(id),
    FOREIGN KEY(paketId) REFERENCES paketi(id) ON DELETE CASCADE
);


# paketi: naziv, treninga mesečno, meseci, cena
INSERT INTO paketi (id, naziv, brTreninga, duzinaTrajanja, cena) VALUES (1, 'Basic S', 12, 1, 2800.00);
INSERT INTO paketi (id, naziv, brTreninga, duzinaTrajanja, cena) VALUES (2, 'Classic S', 16, 1, 3600.00);
INSERT INTO paketi (id, naziv, brTreninga, duzinaTrajanja, cena) VALUES (3, 'Elite S', 31, 1, 5200.00);
INSERT INTO paketi (id, naziv, brTreninga, duzinaTrajanja, cena) VALUES (4, 'Basic M', 12, 3, 6300.00);
INSERT INTO paketi (id, naziv, brTreninga, duzinaTrajanja, cena) VALUES (5, 'Classic M', 16, 3, 8100.00);
INSERT INTO paketi (id, naziv, brTreninga, duzinaTrajanja, cena) VALUES (6, 'Elite M', 31, 3, 11700.00);

# članarine: paket, korisnik, početak
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (1, 'korisnik1', '2023-01-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (1, 'korisnik1', '2023-02-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (1, 'korisnik2', '2023-02-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (2, 'korisnik1', '2023-03-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (3, 'korisnik2', '2023-03-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (4, 'korisnik1', '2023-04-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (4, 'korisnik2', '2023-04-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (4, 'korisnik3', '2023-01-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (5, 'korisnik4', '2023-01-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (5, 'korisnik4', '2023-04-01');
INSERT INTO clanarine (paketId, imeKorisnika,  datumIPocetka) VALUES (6, 'korisnik5', '2023-01-01');
