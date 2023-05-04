package com.ftninformatika.jwd.modul1.test.sportpass.model;

import java.util.ArrayList;
import java.util.List;

public class StavkaIzvestaja {

	private String nazivPaketa = "";
	private List<String> korisnici = new ArrayList<>();
	private String imeKorisnikaSaNajviseC = "";

	public StavkaIzvestaja(String nazivPaketa, List<String> korisnici, String imeKorisnikaSaNajviseC) {
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

	public List<String> getKorisnici() {
		return korisnici;
	}

	public String getImeKorisnikaSaNajviseC() {
		return imeKorisnikaSaNajviseC;
	}

}
