package fi.javaee.siri.asiakas;

import java.awt.Image;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="asiakas")
public class Asiakas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long asiakasId;
	private String nimi;
	private	String puhelin;
	private String sahkoposti;
//	private	Image valokuva;
	private	String maa;
	private String osoite;
	
	public Asiakas (){
		
	}

	public Asiakas( Long asiakasId, String nimi, String puhelin, String sahkoposti, Image valokuva, String maa,
			String osoite) {
		super();
		this.asiakasId = asiakasId;
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.sahkoposti = sahkoposti;
//		this.valokuva = valokuva;
		this.maa = maa;
		this.osoite = osoite;
	}

	public Long getAsiakasId() {
		return asiakasId;
	}

	public void setAsiakasId(Long id) {
		this.asiakasId = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}
//
//	public Image getValokuva() {
//		return valokuva;
//	}
//
//	public void setValokuva(Image valokuva) {
//		this.valokuva = valokuva;
//	}
//
	public String getMaa() {
		return maa;
	}

	public void setMaa(String maa) {
		this.maa = maa;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	@Override
	public String toString() {
		return "Asiakas [henkiloId=" + asiakasId + ", nimi=" + nimi + ", puhelin=" + puhelin + ", sahkoposti="
				+ sahkoposti + ",  maa=" + maa + ", osoite=" + osoite + "]";
	}

//	

}
