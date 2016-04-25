package fr.afcepf.atod26.ws.rest.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import fr.afcepf.atod26.ws.rest.web.entity.Devise;

@Path("/deviseService")
@Produces("application/json")
public class DeviseRestWSImpl {

	private Logger log = Logger.getLogger(DeviseRestWSImpl.class);

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
		if ("EUR".equals(paramCode)) {
			return new Devise("EUR", "Euro", 1.1);
		} else if ("WSD".equals(paramCode)) {
			return new Devise("WSD", "Dollar", 0.9);
		} else {
			return null;
		}
	}

}
