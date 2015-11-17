package fi.javaee.siri.user;

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
public class TestUserDAO {

	@Autowired
	    private UserDAO userDAO;
	  
    @Test
    @Transactional
    @Rollback(true)
    public void testAddUser()
    {
    	/*
		UserRole userRole = new UserRole();
		userRole.setUserName("TestUser");
		userRole.setRole("role_admin");
		
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		userRoleList.add(userRole);
	*/	
		User u = new User();
		u.setUsername("TestUser");
		u.setPassword("TestPassword");
		u.setEnabled(true);
		//u.setUserRoleList(userRoleList);
		u.setRole_admin(true);
		u.setRole_user(true);
		u.setRole_dbadmin(true);
    	
    	//User u = new User("TestUser", "TestPassword", true);    	
        userDAO.saveUser(u);       
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();	
        
        User searchedUser = userDAO.findByUserName(u.getUsername());
        Assert.assertEquals(u.getUsername(), searchedUser.getUsername());
        Assert.assertTrue(encoder.matches("TestPassword", searchedUser.getPassword()));
        Assert.assertTrue(searchedUser.isEnabled());
        Assert.assertTrue(searchedUser.isRole_dbadmin());
        Assert.assertTrue(searchedUser.isRole_user());
        Assert.assertTrue(searchedUser.isRole_admin());
    }

    
    @Test
    @Transactional
    @Rollback(true)
    public void testRemoveUser()
    {
/*		UserRole userRole = new UserRole();
		userRole.setUserName("TestUser");
		userRole.setRole("role_admin");
		
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		userRoleList.add(userRole);
	*/	
		User u = new User();
		u.setUsername("TestUser");
		u.setPassword("TestPassword");
		//u.setUserRoleList(userRoleList);
    	
    	//User u = new User("TestUser", "TestPassword", true);    	
        userDAO.saveUser(u);   
    	
    	//User u = new User("TestUser", "TestPassword", true);   	
        userDAO.saveUser(u);       
        User searchedUser = userDAO.findByUserName(u.getUsername());
        Assert.assertEquals(u.getUsername(), searchedUser.getUsername());
        
        userDAO.deleteUser(u.getUsername());
        searchedUser = userDAO.findByUserName(u.getUsername());
        Assert.assertEquals(searchedUser, null);
    }

}
