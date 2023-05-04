package com.ftninformatika.jwd.modul1.test.sportpass.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Paket {

	private long id;
	private String naziv = "";
	private int mesecniBrTreninga;
	private int duzinaTrajanja;
	private double cena;

	final Set<Clanarina> clanarine = new HashSet<>();

	public Paket() {
		super();
	}

	public Paket(String naziv, int mesecniBrTreninga, int duzinaTrajanja, double cena) {
		super();
		this.naziv = naziv;
		this.mesecniBrTreninga = mesecniBrTreninga;
		this.duzinaTrajanja = duzinaTrajanja;
		this.cena = cena;
	}

	public Paket(long id, String naziv, int mesecniBrTreninga, int duzinaTrajanja, double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesecniBrTreninga = mesecniBrTreninga;
		this.duzinaTrajanja = duzinaTrajanja;
		this.cena = cena;
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
		Paket other = (Paket) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Id paketa: " + id + "   Naziv: " + naziv + "   Mesecni br. treninga: " + mesecniBrTreninga + "   Duzina trajanja: "
				+ duzinaTrajanja + "   Cena: " + cena;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getMesecniBrTreninga() {
		return mesecniBrTreninga;
	}

	public void setMesecniBrTreninga(int mesecniBrTreninga) {
		this.mesecniBrTreninga = mesecniBrTreninga;
	}

	public int getDuzinaTrajanja() {
		return duzinaTrajanja;
	}

	public void setDuzinaTrajanja(int duzinaTrajanja) {
		this.duzinaTrajanja = duzinaTrajanja;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Collection<Clanarina> getClanarine() {
		return Collections.unmodifiableCollection(clanarine);
	}

	public void addClanarinu(Clanarina clanarina) {
		clanarine.add(clanarina);
		clanarina.paket = this;
	}

	public void addSveClanarine(Collection<Clanarina> clanarine) {
		clanarine.addAll(clanarine);
		for (Clanarina clanarina : clanarine) {
			clanarina.paket = this;
		}
	}

}
