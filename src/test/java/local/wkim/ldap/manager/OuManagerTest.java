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
import local.wkim.ldap.entity.LdapOu;
import local.wkim.ldap.manager.base.LdapManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OuManagerTest {

	private static final Logger LOG = LoggerFactory.getLogger(OuManagerTest.class);
	
	@Autowired
	private LdapConnectionProviderFactory ldapConnectionProviderFactory;
	
	@Autowired
	private LdapManagerFactory ldapManagerFactory;
	
	private LdapManager<LdapOu> manager = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		manager = (LdapManager<LdapOu>) ldapManagerFactory.createLdapManager("ou");
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
		
		String findOu = "wkkim";
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("organizationalUnit")
				.and("ou").is(findOu);
		LOG.debug("`e`query = {}", query.toString());
		
		LdapOu find = manager.connect(provider).find(query);
		LOG.debug("`e`found = {}", find);
	}
}
