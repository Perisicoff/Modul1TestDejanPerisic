package com.ftninformatika.jwd.modul1.test.sportpass.UI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ftninformatika.jwd.modul1.test.sportpass.DAO.ClanarinaDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.DAO.PaketDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Clanarina;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Paket;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Konzola;

public class ClanarinaUI {

	private static ClanarinaDAO clanarinaDAO;
	private static PaketDAO paketDAO;

	public static void setClanarinaDAO(ClanarinaDAO clanarinaDAO) {
		ClanarinaUI.clanarinaDAO = clanarinaDAO;
	}

	public static void setPaketDAO(PaketDAO paketDAO) {
		ClanarinaUI.paketDAO = paketDAO;
	}

	public static void prikazSvihClanarina() {
		List<Clanarina> clanarine = new ArrayList<>();
		try {
			Collection<Paket> paketi = paketDAO.getAll();
			for (Paket paket : paketi) {
				for (Clanarina clanarina : paket.getClanarine()) {
					clanarine.add(clanarina);
				}
			}
			clanarine.sort(Clanarina::compareID);
			for (Clanarina clanarina : clanarine) {
				System.out.println(clanarina);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void novaClanarina() {
		long id = Konzola.ocitajLong("Unesite ID paketa: ");
		Paket paket = PaketUI.pretragaPaketa(id);
		if (paket == null) {
			return;
		}
		String ime = "";
		while (ime.equals("")) {
			ime = Konzola.ocitajString("Unesite ime korisnika:");
		}
		boolean uspeh = proveraImena(ime);
		if (uspeh == false) {
			System.out.println("Clanarina vec postoji za ime :" + ime);
			return;
		}

		LocalDateTime datum = LocalDateTime.now();
		Clanarina clanarina = new Clanarina(paket, ime, datum);
		paket.addClanarinu(clanarina);
		try {
			clanarinaDAO.add(clanarina);
			System.out.println("Uspesno ste dodali novu clanarinu!");
		} catch (Exception e) {
			System.out.println("Dogodila se greska!");
			e.printStackTrace();
		}

	}
	
	public static boolean proveraImena(String ime) {
		boolean uspesno = true;
		try {
			Collection<Paket> paketi = paketDAO.getAll();
			for (Paket paket : paketi) {
				for (Clanarina clanarina : paket.getClanarine()) {
					if (clanarina.getImeKorisnika().equals(ime)) {
						uspesno = false;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Dogodila se greska!");
			e.printStackTrace();
		}
		return uspesno;

	}
	
	
	
}
