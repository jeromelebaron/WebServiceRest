package fr.afcepf.atod26.ws.rest.web.api;

import java.util.List;

import fr.afcepf.atod26.ws.rest.web.entity.Devise;

public interface IDeviseDao {

	Devise getDeviseByCode(String paramCode);

	List<Devise> getAllDevise();

	void addDevise(Devise paramDevise);

	void deleteDevise(String paramCode);

}
