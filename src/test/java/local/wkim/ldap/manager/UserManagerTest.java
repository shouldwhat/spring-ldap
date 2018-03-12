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
import local.wkim.ldap.entity.LdapUser;
import local.wkim.ldap.manager.base.LdapManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerTest {
private static final Logger LOG = LoggerFactory.getLogger(OuManagerTest.class);
	
	@Autowired
	private LdapConnectionProviderFactory ldapConnectionProviderFactory;
	
	@Autowired
	private LdapManagerFactory ldapManagerFactory;
	
	private LdapManager<LdapUser> manager = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		manager = (LdapManager<LdapUser>) ldapManagerFactory.createLdapManager("user");
	}
	
//	@Test
	public void create() {
		
		LdapConnectionProvider provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
		LOG.debug("`e`provider = {}", provider.createConnection());
		
		LOG.debug("create... !");
	}
	
//	@Test
	public void update() {
		
		LOG.debug("update... !");
	}
	
	@Test
	public void find() {
		
		LdapConnectionProvider provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
		
		String findUser = "kim wonkyus";
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("user")
				.and("cn").is(findUser);
		LOG.debug("`e`query = {}", query.toString());
		
		LdapUser find = manager.connect(provider).find(query);
		LOG.debug("`e`found = {}", find);
	}
}
