package com.ftninformatika.jwd.modul1.test.sportpass.DAO;

import java.util.Collection;

import com.ftninformatika.jwd.modul1.test.sportpass.model.Paket;

public interface PaketDAO {

	public Paket get(long id) throws Exception;
	public Collection<Paket> getAll() throws Exception;
}
