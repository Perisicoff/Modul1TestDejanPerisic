package com.ftninformatika.jwd.modul1.test.sportpass.database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import com.ftninformatika.jwd.modul1.test.sportpass.DAO.ClanarinaDAO;
import com.ftninformatika.jwd.modul1.test.sportpass.model.Clanarina;

public class DatabaseClanarinaDAO implements ClanarinaDAO {

	private final Connection conn;

	public DatabaseClanarinaDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void add(Clanarina clanarina) throws Exception {
		String sql = "INSERT INTO clanarine (paketId, imeKorisnika, datumIPocetka) VALUES (?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			int kolona = 0;
			stmt.setLong(++kolona, clanarina.getPaket().getId());
			stmt.setString(++kolona, clanarina.getImeKorisnika());
			stmt.setTimestamp(++kolona, Timestamp.valueOf(clanarina.getDatumPocetka()));
			stmt.executeUpdate();
		}
	}

}
