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

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "asiakas")
public class Asiakas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long asiakasId;
	private String nimi;
	private String puhelin;
	private String sahkoposti;
	private String valokuvaurl;
	@Lob
	private byte[] valokuva;
	transient MultipartFile valokuvafile;
	private String maa;
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
		// this.valokuva = valokuva;
		this.maa = maa;
		this.osoite = osoite;
	}

	public Asiakas(String nimi, String puhelin, String sahkoposti, Image valokuva, String maa, String osoite) {
		super();
		this.nimi = nimi;
		this.puhelin = puhelin;
		this.sahkoposti = sahkoposti;
		// this.valokuva = valokuva;
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
		;
		// byte[] imageInByte=null;
		// try {
		// //URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
		// URL url = new URL(this.valokuvaurl);
		// BufferedImage image = ImageIO.read(url);
		// System.out.println("Valokuvan luku onnistui ");
		//
		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// ImageIO.write(image, "jpg", baos);
		// baos.flush();
		// imageInByte = baos.toByteArray();
		//
		// }catch ( Exception e ) {
		// System.out.println("Asiakas: Valokuvan talletus kantaan ei onnistunut
		// " + e.getMessage());
		// }
		this.valokuva = kuva;
	}

	public String getValokuvaurl() {
		return valokuvaurl;
	}

	public void setValokuvaurl(String valokuvaurl) {
		this.valokuvaurl = valokuvaurl;
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

	//

}
