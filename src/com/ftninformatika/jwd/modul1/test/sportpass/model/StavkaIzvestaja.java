package com.ftninformatika.jwd.modul1.test.sportpass.model;

import java.util.HashSet;
import java.util.Set;

public class StavkaIzvestaja {

	private String nazivPaketa = "";
	private Set<String> korisnici = new HashSet<String>();
	private String imeKorisnikaSaNajviseC = "";

	public StavkaIzvestaja(String nazivPaketa, Set<String> korisnici, String imeKorisnikaSaNajviseC) {
		super();
		this.nazivPaketa = nazivPaketa;
		this.korisnici = korisnici;
		this.imeKorisnikaSaNajviseC = imeKorisnikaSaNajviseC;
	}

	@Override
	public String toString() {
		return "   Naziv paketa: " + nazivPaketa + "   Korisnici: " + korisnici + "   Korisnik sa najvise Clanarina: "
				+ imeKorisnikaSaNajviseC;
	}

	public static int compareBrojPrijava(StavkaIzvestaja stavka1, StavkaIzvestaja stavka2) {
		return -Integer.compare(stavka1.korisnici.size(), stavka2.korisnici.size());

	}

	public String getNazivPaketa() {
		return nazivPaketa;
	}

	public Set<String> getKorisnici() {
		return korisnici;
	}

	public String getImeKorisnikaSaNajviseC() {
		return imeKorisnikaSaNajviseC;
	}

}
