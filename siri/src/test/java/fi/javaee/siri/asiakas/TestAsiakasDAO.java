package fi.javaee.siri.asiakas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fi.javaee.siri.config.SiriTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SiriTestConfiguration.class}, loader = SpringApplicationContextLoader.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TestAsiakasDAO {

	@Autowired
    private AsiakasDAO asiakasDAO;
  
	// TODO asiakasDAO.edit -> asiakasDAO.findById
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddAsiakas() {
    	Asiakas asiakas = new Asiakas("Testi Asiakas", "+35811223345", "testi.asiakas@testi.com", null, "Finland", "testiosoite");    	
        asiakasDAO.save(asiakas);       
        
        List<Asiakas> searchedAsiakkaat = new ArrayList<Asiakas>();
        searchedAsiakkaat = asiakasDAO.findByName(asiakas.getNimi());
        for ( Asiakas a: searchedAsiakkaat){
        	Assert.assertEquals(asiakas.getNimi(), a.getNimi());
        	Assert.assertEquals(asiakas.getPuhelin(), a.getPuhelin());
        	Assert.assertEquals(asiakas.getSahkoposti(), a.getSahkoposti());
        	Assert.assertEquals(asiakas.getMaa(), a.getMaa());
        	Assert.assertEquals(asiakas.getOsoite(), a.getOsoite());

        }
       
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testRemoveAsiakas() {
    	Asiakas asiakas = new Asiakas("Testi Asiakas", "+35811223345", "testi.asiakas@testi.com", null, "Finland", "testiosoite");    	
    	 asiakasDAO.save(asiakas);  
    	asiakasDAO.delete(asiakas.getAsiakasId());       
        
        List<Asiakas> searchedAsiakkaat = new ArrayList<Asiakas>();
        searchedAsiakkaat = asiakasDAO.findByName(asiakas.getNimi());
        Assert.assertEquals(searchedAsiakkaat.size(), 0);
     
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateAsiakas() {
    	Asiakas asiakas = new Asiakas("Testi Asiakas", "+35811223345", "testi.asiakas@testi.com", null, "Finland", "testiosoite");    	
    	asiakasDAO.save(asiakas);  
    	
    	asiakas.setNimi("Testi Asiakas2");
    	asiakasDAO.update(asiakas);      	    
        Asiakas changedAsiakas = asiakasDAO.edit(asiakas.getAsiakasId());
    	Assert.assertEquals(asiakas.getNimi(), changedAsiakas.getNimi());
    	
    	asiakas.setPuhelin("0405124362");
    	asiakasDAO.update(asiakas); 
    	changedAsiakas = asiakasDAO.edit(asiakas.getAsiakasId());
    	Assert.assertEquals(asiakas.getPuhelin(),  changedAsiakas.getPuhelin());
    	
    	asiakas.setSahkoposti("testi2.asiakas@testi.com");
    	asiakasDAO.update(asiakas); 
    	changedAsiakas = asiakasDAO.edit(asiakas.getAsiakasId());
    	Assert.assertEquals(asiakas.getSahkoposti(),  changedAsiakas.getSahkoposti());
    	    	
    	asiakas.setMaa("Sweden");
    	asiakasDAO.update(asiakas); 
    	changedAsiakas = asiakasDAO.edit(asiakas.getAsiakasId());
    	Assert.assertEquals(asiakas.getMaa(),  changedAsiakas.getMaa());
    	
    	asiakas.setOsoite("Testiosoite 2");
    	asiakasDAO.update(asiakas); 
    	changedAsiakas = asiakasDAO.edit(asiakas.getAsiakasId());
    	Assert.assertEquals(asiakas.getOsoite(), changedAsiakas.getOsoite());

     }
 // AsiakasDAO pitää palauttaa null jos poistaminen ei onnistu
// 
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testRemoveNonexistentAsiakas() {
// 
//    	Asiakas deletedAsiakas = asiakasDAO.delete(1);       
//      Assert.assertEquals(null, deletedAsiakas);
//     
//	}
	
 
	@Test
	@Transactional
	@Rollback(true)
	public void testEditNonexistentAsiakas() {
 
		Asiakas asiakas = new Asiakas("Testi Asiakas", "+35811223345", "testi.asiakas@testi.com", null, "Finland", "testiosoite");    	

		Asiakas changedAsiakas= asiakasDAO.update(asiakas);      	    
		changedAsiakas = asiakasDAO.edit(asiakas.getAsiakasId());
		Assert.assertEquals(null, changedAsiakas);
     
	}
 }
