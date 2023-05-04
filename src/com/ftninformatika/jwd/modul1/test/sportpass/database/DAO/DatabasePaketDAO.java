package com.ftninformatika.jwd.modul1.test.sportpass.database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import com.ftninformatika.jwd.modul1.test.sportpass.DAO.PaketDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Clanarina;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Paket;

public class DatabasePaketDAO implements PaketDAO {

	private final Connection conn;

	public DatabasePaketDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Paket get(long id) throws Exception {
		Paket paket = null;

		String sql = "SELECT p.naziv, p.brTreninga, p.duzinaTrajanja, p.cena, c.id, c.imeKorisnika, c.datumIPocetka FROM sportpass.paketi p LEFT JOIN sportpass.clanarine c ON p.id = c.paketId WHERE p.id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			int param = 0;
			stmt.setLong(++param, id);
			try (ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					String pNaziv = rset.getString(++kolona);
					int pBrtrening = rset.getInt(++kolona);
					int pduzinaTrajanja = rset.getInt(++kolona);
					double pCena = rset.getDouble(++kolona);

					paket = new Paket(id, pNaziv, pBrtrening, pduzinaTrajanja, pCena);

					long cId = rset.getLong(++kolona);
					if (cId != 0) {
						String imeKorisnika = rset.getString(++kolona);
						LocalDateTime datum = rset.getTimestamp(++kolona).toLocalDateTime();
						Clanarina clanarina = new Clanarina(cId, paket, imeKorisnika, datum);
						paket.addClanarinu(clanarina);
					}
				}

			}
		}
		return paket;
	}

	@Override
	public Collection<Paket> getAll() throws Exception {
		Map<Long, Paket> paketi = new HashMap<>();

		String sql = "SELECT p.id, p.naziv, p.brTreninga, p.duzinaTrajanja, p.cena, c.id, c.imeKorisnika, c.datumIPocetka FROM sportpass.paketi p LEFT JOIN sportpass.clanarine c ON p.id = c.paketId";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			try (ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					String pNaziv = rset.getString(++kolona);
					int pBrtrening = rset.getInt(++kolona);
					int pduzinaTrajanja = rset.getInt(++kolona);
					double pCena = rset.getDouble(++kolona);

					Paket paket = paketi.get(id);
					if (paket == null) {
						paket = new Paket(id, pNaziv, pBrtrening, pduzinaTrajanja, pCena);
						paketi.put(id, paket);
					}

					long cId = rset.getLong(++kolona);
					if (cId != 0) {
						String imeKorisnika = rset.getString(++kolona);
						LocalDateTime datum = rset.getTimestamp(++kolona).toLocalDateTime();
						Clanarina clanarina = new Clanarina(cId, paket, imeKorisnika, datum);
						paket.addClanarinu(clanarina);

					}
				}
			}
		}

		return paketi.values();
	}

}
