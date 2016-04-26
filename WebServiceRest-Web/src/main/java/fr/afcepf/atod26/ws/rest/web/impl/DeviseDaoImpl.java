package fr.afcepf.atod26.ws.rest.web.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import fr.afcepf.atod26.ws.rest.web.api.IDeviseDao;
import fr.afcepf.atod26.ws.rest.web.entity.Devise;

@Named(value = "deviseDaoImpl")
public class DeviseDaoImpl implements IDeviseDao {

	private static DeviseDaoImpl uniqueInstance;

	private Map<String, Devise> mapDevise = new HashMap<>();

	private DeviseDaoImpl() {
		mapDevise.put("EUR", new Devise("EUR", "Euro", 0.9));
		mapDevise.put("USD", new Devise("USD", "Dollar", 1.1));
		mapDevise.put("LIV", new Devise("LIV", "Livre", 1.5));
		mapDevise.put("JPY", new Devise("JPY", "Yen", 120));
	}

	public static DeviseDaoImpl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new DeviseDaoImpl();
		}
		return uniqueInstance;
	}

	@Override
	public Devise getDeviseByCode(String paramCode) {
		return mapDevise.get(paramCode);
	}

	@Override
	public List<Devise> getAllDevise() {
		return new ArrayList<>(mapDevise.values());
	}

	@Override
	public void addDevise(Devise paramDevise) {
		mapDevise.put(paramDevise.getCode(), paramDevise);
	}

	@Override
	public void deleteDevise(String paramCode) {
		mapDevise.remove(paramCode);
	}

}
