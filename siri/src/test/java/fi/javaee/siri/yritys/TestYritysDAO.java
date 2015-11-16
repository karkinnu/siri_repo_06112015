package fi.javaee.siri.yritys;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
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
public class TestYritysDAO {

	@Autowired
    private YritysDAO yritysDAO;
  
	// TODO yritysDAO.edit -> yritysDAO.fingById
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddYritys() {
    	Yritys yritys = new Yritys("Testi Yritys", "+35811223345", "testiosoite","www.testi.com", "Y-123456");    	
        yritysDAO.save(yritys);       
        
        List<Yritys> searchedYritykset = new ArrayList<Yritys>();
        searchedYritykset = yritysDAO.findByName(yritys.getNimi());
        for ( Yritys a: searchedYritykset){
        	Assert.assertEquals(yritys.getNimi(), a.getNimi());
        	Assert.assertEquals(yritys.getPuhelin(), a.getPuhelin());
        	Assert.assertEquals(yritys.getOsoite(), a.getOsoite());
        	Assert.assertEquals(yritys.getNettisivu(), a.getNettisivu());
        	Assert.assertEquals(yritys.getYtunnus(), a.getYtunnus());
        	

        }
       
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testRemoveYritys() {
		Yritys yritys = new Yritys("Testi Yritys", "+35811223345", "testiosoite","www.testi.com", "Y-123456");    	
        yritysDAO.save(yritys); 
        
    	yritysDAO.delete(yritys.getYritysId());       
        
        List<Yritys> searchedYritykset = new ArrayList<Yritys>();
        searchedYritykset = yritysDAO.findByName(yritys.getNimi());
        Assert.assertEquals(searchedYritykset.size(), 0);
     
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateYritys() {
		Yritys yritys = new Yritys("Testi Yritys", "+35811223345", "testiosoite","www.testi.com", "Y-123456");    	
        yritysDAO.save(yritys);  
    	
    	yritys.setNimi("Testi Yritys2");
    	yritysDAO.update(yritys);      	    

        Yritys changedYritys = yritysDAO.findById(yritys.getYritysId());
    	Assert.assertEquals(yritys.getNimi(), changedYritys.getNimi());
    	
    	yritys.setPuhelin("0405124362");
    	yritysDAO.update(yritys); 
    	changedYritys = yritysDAO.findById(yritys.getYritysId());
    	Assert.assertEquals(yritys.getPuhelin(),  changedYritys.getPuhelin());
    	
    	yritys.setNettisivu("www.testi2.com");
    	yritysDAO.update(yritys); 
    	changedYritys = yritysDAO.findById(yritys.getYritysId());
    	Assert.assertEquals(yritys.getNettisivu(),  changedYritys.getNettisivu());
    	    	    	
    	yritys.setOsoite("Testiosoite 2");
    	yritysDAO.update(yritys); 
    	changedYritys = yritysDAO.findById(yritys.getYritysId());
    	Assert.assertEquals(yritys.getOsoite(), changedYritys.getOsoite());
    	
    	yritys.setYtunnus("Y-9876543");
    	yritysDAO.update(yritys); 
    	changedYritys = yritysDAO.findById(yritys.getYritysId()); 
    	Assert.assertEquals(yritys.getYtunnus(), changedYritys.getYtunnus());

     }
 // yritysDAOpitää palauttaa null jos poistaminen ei onnistu
// 
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testRemoveNonexistentYritys() {
// 
//    	Yritys deletedYritys = YritysDAO.delete(1);       
//      Assert.assertEquals(null, deletedYritys);
//     
//	}
	
 
	@Test
	@Transactional
	@Rollback(true)
	public void testEditNonexistentYritys() {
 
		Yritys yritys = new Yritys("Testi Yritys", "+35811223345", "testiosoite","www.testi.com", "Y-123456");    	
		Yritys changedYritys= yritysDAO.update(yritys);      	    
		changedYritys = yritysDAO.findById(yritys.getYritysId()); 

		Assert.assertEquals(null, changedYritys);
     
	}
 }
