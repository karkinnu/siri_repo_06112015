package fi.javaee.siri.yritys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "yritys")
public class Yritys implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long yritysId;

	@Size(min = 2, max = 20)
	private String nimi;
	@Size(min = 2, max = 20)
	private String puhelin;
	@Size(min = 2, max = 20)
	private String osoite;
	@Size(min = 2, max = 30)
	private String nettisivu;
	@Size(min = 2, max = 20)
	private String ytunnus;

	public Yritys() {
		super();
	}

	public Yritys(Long yritysId, String nimi, String puhelin, String osoite, String nettisivu, String ytunnus) {
		super();
		this.yritysId = yritysId;
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.osoite = osoite;
		this.nettisivu = nettisivu;
		this.ytunnus = ytunnus;
	}

	public Yritys(String nimi, String puhelin, String osoite, String nettisivu, String ytunnus) {
		super();
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.osoite = osoite;
		this.nettisivu = nettisivu;
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
		return nettisivu;
	}

	public void setNettisivu(String nettisivu) {
		this.nettisivu = nettisivu;
	}

	public String getYtunnus() {
		return ytunnus;
	}

	public void setYtunnus(String ytunnus) {
		this.ytunnus = ytunnus;
	}


}
