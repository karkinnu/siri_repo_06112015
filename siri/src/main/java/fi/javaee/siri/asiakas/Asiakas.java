package fi.javaee.siri.asiakas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "asiakas")
public class Asiakas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long asiakasId;

	@Size(min = 2, max = 20)
	private String nimi;
	@Size(min = 2, max = 20)
	private String puhelin;
	@NotNull
	@Email
	private String sahkoposti;
	@Lob
	private byte[] valokuva;
	@Size(min = 2, max = 20)
	private String maa;
	@Size(min = 2, max = 20)
	private String osoite;

	public Asiakas() {

	}

	public Asiakas(Long asiakasId, String nimi, String puhelin, String sahkoposti, Image valokuva, String maa,
			String osoite) {
		super();
		this.asiakasId = asiakasId;
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.sahkoposti = sahkoposti;
		
		this.maa = maa;
		this.osoite = osoite;
	}

	public Asiakas(String nimi, String puhelin, String sahkoposti, Image valokuva, String maa, String osoite) {
		super();
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.sahkoposti = sahkoposti;
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

	public byte[] getValokuva() {
		return valokuva;
	}

	public void setValokuva(byte[] kuva) {
		this.valokuva = kuva;
	}

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
		return "Asiakas [asiakasId=" + asiakasId + ", nimi=" + nimi + ", puhelin=" + puhelin + ", sahkoposti="
				+ sahkoposti + ",  maa=" + maa + ", osoite=" + osoite + "]";
	}

}
