package com.ftninformatika.jwd.modul1.test.sportpass.UI;


import java.sql.Connection;
import java.sql.DriverManager;

import com.ftninformatika.jwd.modul1.test.sportpass.DAO.ClanarinaDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.DAO.PaketDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.database.DAO.DatabaseClanarinaDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.database.DAO.DatabasePaketDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Meni;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Meni.FunkcionalnaStavkaMenija;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Meni.IzlaznaStavkaMenija;
import com.ftninformatika.jwd.modul1.test.sportpass.util.Meni.StavkaMenija;



public class Application {

	private static void initDatabase() throws Exception {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sportpass?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade",
				"root", "root");

		ClanarinaDAO clanarinaDAO = new DatabaseClanarinaDAO(conn);
		PaketDAO paketDAO = new DatabasePaketDAO(conn);

		ClanarinaUI.setClanarinaDAO(clanarinaDAO);
		ClanarinaUI.setPaketDAO(paketDAO);
		PaketUI.setPaketDAO(paketDAO);
		IzvestajUI.setPaketDAO(paketDAO);

	}

	static {
		try {
			initDatabase();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Greška pri povezivanju sa izvorom podataka!");

			System.exit(1);
		}
	}

		public static void main(String[] args) throws Exception {
			Meni.pokreni("Sportpass", new StavkaMenija[] {
				new IzlaznaStavkaMenija("Izlaz"),
				new FunkcionalnaStavkaMenija("Prikaz odabranog paketa") {

					@Override
					public void izvrsi() { PaketUI.prikazPaketa(); }
					
				}, 
				new FunkcionalnaStavkaMenija("Prikaz svih clanarina") {

					@Override
					public void izvrsi() { ClanarinaUI.prikazSvihClanarina(); }
					
				}, 
				new FunkcionalnaStavkaMenija("Dodavanje clanarine") {

					@Override
					public void izvrsi() { ClanarinaUI.novaClanarina(); }
					
				},
				new FunkcionalnaStavkaMenija("Izvestaj") {

					@Override
					public void izvrsi() { IzvestajUI.izvestaj(); }
					
				}
			});
		}


}
