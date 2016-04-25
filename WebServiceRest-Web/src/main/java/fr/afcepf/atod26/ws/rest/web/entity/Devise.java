package fr.afcepf.atod26.ws.rest.web.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "devise")
public class Devise {

	private String code;

	private String monnaie;

	private double change;

	public Devise() {
		// EMPTY
	}

	public Devise(String code, String monnaie, double change) {
		this.code = code;
		this.monnaie = monnaie;
		this.change = change;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
