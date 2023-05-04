package com.ftninformatika.jwd.modul1.test.sportpass.UI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
			Collection<Paket> paketi = paketDAO.getAll();
			for (Paket paket : paketi) {
				naziviPaketa.add(paket.getNaziv());
			}

			List<StavkaIzvestaja> stavke = new ArrayList<>();
			for (String nazivPaketa : naziviPaketa) {
				List<String> korisnici = new ArrayList<>();
				String korisinikSaNajviseClanarina = "";
				for (Paket paket : paketi) {
					if (nazivPaketa.equals(paket.getNaziv())) {
						for (Clanarina clanarina : paket.getClanarine()) {
							if (clanarina.isDatumUOpsegu(pocetniDatum, krajnjiDatum)) {
								korisnici.add(clanarina.getImeKorisnika());
							}
						}
					}
				}
				StavkaIzvestaja stavka = new StavkaIzvestaja(nazivPaketa, korisnici, korisinikSaNajviseClanarina);
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
