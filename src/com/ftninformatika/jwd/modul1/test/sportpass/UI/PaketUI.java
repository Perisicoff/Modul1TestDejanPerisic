package com.ftninformatika.jwd.modul1.test.sportpass.UI;

import com.ftninformatika.jwd.modul1.test.sportpass.DAO.PaketDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Paket;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Konzola;

public class PaketUI {

	private static PaketDAO paketDAO;

	public static void setPaketDAO(PaketDAO paketDAO) {
		PaketUI.paketDAO = paketDAO;
	}

	
	public static Paket pretragaPaketa(long id) {
		Paket paket = null;
		try {
			paket = paketDAO.get(id);
			if (paket == null) {
				System.out.println("Paket ne postoji pod brojem " + id + "!");
			}
		} catch (Exception e) {
			System.out.println("Dogodila se greska!");
			e.printStackTrace();
		}
		return paket;
	}
	
	public static void prikazPaketa() {
		long id = Konzola.ocitajLong("unesite ID paketa: ");
		Paket paket = pretragaPaketa(id);
		if (paket == null) {
			return;
		}
		System.out.println(paket);
		
		
		
	}
	
	
}
