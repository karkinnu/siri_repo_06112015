package fi.javaee.siri.yritys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yritys")
public class Yritys implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long yritysId;
	private String nimi;
	private	String puhelin;
	private String osoite;
	private String nettiSivu;
	private String ytunnus;
	
	public Yritys () {
		
	}

	public Yritys(Long yritysId, String nimi, String puhelin, String osoite, String nettisivu, String ytunnus) {
		super();
		this.yritysId = yritysId;
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.osoite = osoite;
		this.nettiSivu = nettisivu;
		this.ytunnus = ytunnus;
	}
	
	public Yritys(String nimi, String puhelin, String osoite, String nettisivu, String ytunnus) {
		super();
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.osoite = osoite;
		this.nettiSivu = nettisivu;
		this.ytunnus = ytunnus;
	}

	public Long getYritysId() {
		return yritysId;
	}

	public void setYritysId(Long yritysId) {
		this.yritysId = yritysId;
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

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getNettisivu() {
		return nettiSivu;
	}

	public void setNettisivu(String nettisivu) {
		this.nettiSivu = nettisivu;
	}

	public String getYtunnus() {
		return ytunnus;
	}

	public void setYtunnus(String ytunnus) {
		this.ytunnus = ytunnus;
	}

	@Override
	public String toString() {
		return "Yritys [yritysId=" + yritysId + ", nimi=" + nimi + ", puhelin=" + puhelin + ", osoite=" + osoite
				+ ", nettisivu=" + nettiSivu + ", ytunnus=" + ytunnus + "]";
	}

}
