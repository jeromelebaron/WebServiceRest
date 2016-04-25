package fr.afcepf.atod26.ws.rest.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import fr.afcepf.atod26.ws.rest.web.api.IDeviseDao;
import fr.afcepf.atod26.ws.rest.web.entity.Devise;

@Path("/deviseService")
@Produces("application/json")
public class DeviseRestWSImpl {

	/**
	 * Pour faire du log.
	 */
	private Logger log = Logger.getLogger(DeviseRestWSImpl.class);

	@Inject
	private IDeviseDao deviseDao;

	/**
	 * Méthode pour récupérer une devise via son {@link Devise@code}. Joignable via l'url :
	 * http://localhost:8080/WebServiceRest-Web/services/rest/deviseService/devise/{code}
	 * @param paramCode le code de la devise à récupérer.
	 * @return une {@link Devise}.
	 */
	@GET
	@Path("/devise/{code}")
	public Devise findDeviseByCode(@PathParam(value = "code") final String paramCode) {
		log.info("Méthode findDeviseByCode");
		return deviseDao.getDeviseByCode(paramCode);
	}

	/**
	 * Pour récupérer toutes les devises http://localhost:8080/WebServiceRest-Web/services/rest/deviseService/devises
	 * @return une liste de {@link Devise}.
	 */
	@GET
	@Path("/devises")
	@Produces("application/xml")
	public List<Devise> getAllDevise() {
		return deviseDao.getAllDevise();
	}

}
