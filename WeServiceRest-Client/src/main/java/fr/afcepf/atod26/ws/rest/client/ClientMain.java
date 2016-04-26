package fr.afcepf.atod26.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		final Double resultat = Double.parseDouble(convertTarget.request(MediaType.TEXT_PLAIN).get()
				.readEntity(String.class));
		logger.info("Résultat de la conversion : " + resultat);
	}
}
