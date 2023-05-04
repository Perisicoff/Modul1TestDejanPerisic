package com.ftninformatika.jwd.modul1.test.sportpass.model;


import java.time.LocalDateTime;
import java.util.Objects;

import com.ftninformatika.jwd.modul1.test.sportpass.util.Konzola;


public class Clanarina {

	private long id;
	Paket paket;
	private String imeKorisnika = "";
	private LocalDateTime datumPocetka = LocalDateTime.now();

	public Clanarina() {
		super();
	}

	public Clanarina(Paket paket, String imeKorisnika, LocalDateTime datumPocetka) {
		super();
		this.paket = paket;
		this.imeKorisnika = imeKorisnika;
		this.datumPocetka = datumPocetka;
	}

	public Clanarina(long id, Paket paket, String imeKorisnika, LocalDateTime datumPocetka) {
		super();
		this.id = id;
		this.paket = paket;
		this.imeKorisnika = imeKorisnika;
		this.datumPocetka = datumPocetka;
	}
	
	public boolean isDatumUOpsegu(LocalDateTime pocetni, LocalDateTime krajnji) {
		return datumPocetka.compareTo(pocetni) >= 0 && datumPocetka.compareTo(krajnji) <= 0;

	}
	
	public static int compareID(Clanarina id, Clanarina id2) {
		return Long.compare(id.getId(), id2.getId());
		
	}
	
	public LocalDateTime istekClanarine() {
		return this.datumPocetka.plusMonths(paket.getDuzinaTrajanja());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clanarina other = (Clanarina) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Id clanarine: " + id + "   Paket: " + paket.getNaziv() + "   Ime korisnika: " + imeKorisnika + "   Datum pocetka: "
				+ Konzola.formatiraj(datumPocetka) + "  Istek Clanarine: " + Konzola.formatiraj(istekClanarine());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Paket getPaket() {
		return paket;
	}

	public void setPaket(Paket paket) {
		this.paket = paket;
		paket.clanarine.add(this);
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public LocalDateTime getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDateTime datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

}
