package local.wkim.ldap.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import local.wkim.ldap.connection.LdapConnectionProviderFactory;
import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.manager.base.LdapManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerTest {

	private static final Logger LOG = LoggerFactory.getLogger(ManagerTest.class);
	
	@Autowired
	private LdapConnectionProviderFactory ldapConnectionProviderFactory;
	
	@Autowired
	private LdapManagerFactory ldapManagerFactory;
	
	@Test
	public void create() {
		
		LdapManager<?> manager = ldapManagerFactory.createLdapManager("user");
		LOG.debug("type = {}", manager.genericClassType().getName());
		
		LdapConnectionProvider provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
		LOG.debug("provider = {}", provider.createConnection());
		
		LOG.debug("create... !");
	}
	
	@Test
	public void update() {
		
		LdapManager<?> manager = ldapManagerFactory.createLdapManager("ou");
		LOG.debug("type = {}", manager.genericClassType().getName());
		
		LOG.debug("update... !");
	}
}
