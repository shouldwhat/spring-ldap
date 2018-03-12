package local.wkim.ldap.manager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import local.wkim.ldap.connection.LdapConnectionProviderFactory;
import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.entity.LdapComputer;
import local.wkim.ldap.exception.LdapManagerException;
import local.wkim.ldap.manager.base.LdapManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputerManagerTest {

	private static final Logger LOG = LoggerFactory.getLogger(ComputerManagerTest.class);
	
	@Autowired
	private LdapConnectionProviderFactory ldapConnectionProviderFactory;
	
	@Autowired
	private LdapManagerFactory ldapManagerFactory;
	
	private LdapManager<LdapComputer> manager = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		manager = (LdapManager<LdapComputer>) ldapManagerFactory.createLdapManager("computer");
	}
	
	@Test
	public void find() {
		
		LdapConnectionProvider provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
		
		String findComputer = "WON12";
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("computer")
				.and("cn").is(findComputer);
		
		try {
			LdapComputer find = manager.connect(provider).find(query);
			LOG.debug("`e`found = {}", find);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}
	}
}
