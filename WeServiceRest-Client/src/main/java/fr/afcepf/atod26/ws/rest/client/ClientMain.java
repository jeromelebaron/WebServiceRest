package fr.afcepf.atod26.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

public class ClientMain {

	private static Logger logger = Logger.getLogger(ClientMain.class);

	private ClientMain() {
	}

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		final String urlDevise = "http://localhost:8080/WebServiceRest-Web/services/rest/deviseService";
		final Double paramMontant = 50.0;
		final String paramSource = "EUR";
		final String paramDestination = "USD";
		WebTarget convertTarget = client.target(urlDevise).path("convert").queryParam("amount", paramMontant)
				.queryParam("src", paramSource).queryParam("target", paramDestination);
		final String resultatReponse = convertTarget.request(MediaType.TEXT_PLAIN).get().readEntity(String.class);
		logger.info("Résultat réponse : " + resultatReponse);
		final Double resultat = Double.parseDouble(resultatReponse);
		logger.info("Résultat de la conversion : " + resultat);

		WebTarget updateTarget = client.target(urlDevise).path("devise");
		final Response resultatReponseUpdate = updateTarget.request(MediaType.APPLICATION_JSON_TYPE).put(
				Entity.entity((new Devise("EUR", "Euro", 1.5)), MediaType.APPLICATION_JSON_TYPE));
		if (resultatReponseUpdate.getStatus() == 200) {
			logger.info("Update réussi");
			final Devise deviseMAJ = resultatReponseUpdate.readEntity(Devise.class);
			logger.info(deviseMAJ.getChange());
		}
	}
}
