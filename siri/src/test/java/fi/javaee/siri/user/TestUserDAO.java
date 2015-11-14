package fi.javaee.siri.user;

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
public class TestUserDAO {

	@Autowired
	    private UserDAO userDAO;
	  
    @Test
    @Transactional
    @Rollback(true)
    public void testAddUser()
    {
    	User u = new User("TestUser", "TestPassword", true);    	
        userDAO.saveUser(u);       
        User searchedUser = userDAO.findByUserName(u.getUsername());
        Assert.assertEquals(u.getUsername(), searchedUser.getUsername());
    }

    
    @Test
    @Transactional
    @Rollback(true)
    public void testRemoveUser()
    {
    	User u = new User("TestUser", "TestPassword", true);    	
        userDAO.saveUser(u);       
        User searchedUser = userDAO.findByUserName(u.getUsername());
        Assert.assertEquals(u.getUsername(), searchedUser.getUsername());
        
        userDAO.deleteUser(u.getUsername());
        searchedUser = userDAO.findByUserName(u.getUsername());
        Assert.assertEquals(searchedUser, null);
    }

}
