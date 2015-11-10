package fi.javaee.siri.asiakas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AsiakasMain {
	

	public static void main(String[] args) {
		
	//EntityManager em = tehdas.createEntityManager();
	
	Asiakas ask = new Asiakas();
	ask.setNimi("SeijaKarttunen");	
	Asiakas a = new Asiakas();
	a.setNimi("SeijaKarttunen");
	/*a.setPuhelin("+358405124362");
	a.setSahkoposti("seija.karttunen@hotmail.com");
	a.setMaa("Suomi");
	a.setOsoite("Sahamäenkuja 18 41340 Laukaa");
	ask.setPuhelin("+358405124362");
	ask.setSahkoposti("seija.karttunen@hotmail.com");
	ask.setMaa("Suomi");
	ask.setOsoite("Sahamäenkuja 18 41340 Laukaa");*/

	//em.persist(ask);
	
	
	/*
	
	 TypedQuery<MonivalintaKysymys> query =
		      manageri.createNamedQuery("monivalintaKysymys.haeKaikki", MonivalintaKysymys.class);
	 List<MonivalintaKysymys> results = query.getResultList();
	 for (MonivalintaKysymys t:results){
		 System.out.println(t.toString());
	 }
	 
	 TypedQuery<Kysymys> query2 =
		      manageri.createNamedQuery("kysymys.haeKaikki", Kysymys.class);
	 List<Kysymys> results2 = query2.getResultList();
	 for (Kysymys t:results2){
		 System.out.println(t.toString());
	 }
	*/

	}
}
