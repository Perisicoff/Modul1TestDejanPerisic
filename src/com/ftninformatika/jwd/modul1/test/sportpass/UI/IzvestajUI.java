package com.ftninformatika.jwd.modul1.test.sportpass.UI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.ftninformatika.jwd.modul1.test.sportpass.DAO.PaketDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Clanarina;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Paket;
import com.ftninformatika.jwd.modul1.test.sportpass.model.StavkaIzvestaja;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Konzola;

public class IzvestajUI {

	private static PaketDAO paketDAO;

	public static void setPaketDAO(PaketDAO paketDAO) {
		IzvestajUI.paketDAO = paketDAO;
	}

	public static void izvestaj() {

		LocalDateTime pocetniDatum = Konzola.ocitajDateTime("Unesite pocetni datum pretrage: ");
		LocalDateTime krajnjiDatum = Konzola.ocitajDateTime("Unesite krajnji datum pretrage: ");

		try {
			List<String> naziviPaketa = new ArrayList<>();
			Set<String> sviKorisnici = new LinkedHashSet<>();

			Collection<Paket> paketi = paketDAO.getAll();
			for (Paket paket : paketi) {
				naziviPaketa.add(paket.getNaziv());
				for (Clanarina clanarina : paket.getClanarine()) {
					sviKorisnici.add(clanarina.getImeKorisnika());
				}
			}

			List<StavkaIzvestaja> stavke = new ArrayList<>();
			for (String nazivPaketa : naziviPaketa) {
				Set<String> korisniciPaketa = new LinkedHashSet<>();
				String korisinikSaNajviseClanarina = "";
				int brojClanarina = Integer.MIN_VALUE;
				for (Paket paket : paketi) {
					if (nazivPaketa.equals(paket.getNaziv())) {
						for (String korisnik : sviKorisnici) {
							int brojac = 0;
							for (Clanarina clanarina : paket.getClanarine()) {
								if (clanarina.isDatumUOpseguAktivneClanarine(pocetniDatum, krajnjiDatum)) {
									korisniciPaketa.add(clanarina.getImeKorisnika());
									if (korisnik.equals(clanarina.getImeKorisnika())) {
										brojac++;
									}
									if (brojac > brojClanarina) {
										brojClanarina = brojac;
										korisinikSaNajviseClanarina = clanarina.getImeKorisnika();
									}
								}
							}
						}
					}
				}
				StavkaIzvestaja stavka = new StavkaIzvestaja(nazivPaketa, korisniciPaketa, korisinikSaNajviseClanarina);
				stavke.add(stavka);
			}
			stavke.sort(StavkaIzvestaja::compareBrojPrijava);
			for (StavkaIzvestaja stavkaIzvestaja : stavke) {
				System.out.println(stavkaIzvestaja);
			}

		} catch (Exception e) {
			System.out.println("Dogodila se greska!");
			e.printStackTrace();
		}

	}

}
