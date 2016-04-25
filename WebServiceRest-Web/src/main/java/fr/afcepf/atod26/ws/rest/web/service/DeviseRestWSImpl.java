package fr.afcepf.atod26.ws.rest.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
	public List<Devise> rechercherDevise(@QueryParam("changeMinimum") final Double paramChangeMinimum) {
		log.info("Méthode rechercherDevise");
		final List<Devise> toutesLesDevise = deviseDao.getAllDevise();
		final List<Devise> lesDeviseFiltrees = new ArrayList<>();
		if (paramChangeMinimum != null && !Double.isNaN(paramChangeMinimum)) {
			for (Devise localDevise : toutesLesDevise) {
				if (localDevise.getChange() > paramChangeMinimum) {
					lesDeviseFiltrees.add(localDevise);
				}
			}
			return lesDeviseFiltrees;
		} else {
			return toutesLesDevise;
		}
	}

	@GET
	@Path("/convert")
	@Produces("text/plain")
	public double convertir(@QueryParam("amount") final Double paramMontant,
			@QueryParam("src") final String paramSource, @QueryParam("target") final String paramDestination) {
		Double resultat = 0.0;
		if (paramMontant != null && !paramMontant.isNaN() && paramSource != null && !paramSource.isEmpty()
				&& paramDestination != null && !paramDestination.isEmpty()) {
			final Devise deviseSource = deviseDao.getDeviseByCode(paramSource);
			final Devise deviseDestination = deviseDao.getDeviseByCode(paramDestination);
			resultat = paramMontant * deviseSource.getChange() / deviseDestination.getChange();
		}
		return resultat;
	}

	@PUT
	@Path("/devise")
	@Consumes("application/json")
	public Devise mettreAJourDevise(final Devise paramDevise) {
		log.info("Méthode mettreAJourDevise");
		final Devise deviseAMettreAJour = new Devise(paramDevise.getCode(), paramDevise.getMonnaie(),
				paramDevise.getChange());
		deviseDao.addDevise(deviseAMettreAJour);
		return deviseAMettreAJour;
	}
}
