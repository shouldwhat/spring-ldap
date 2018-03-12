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
import local.wkim.ldap.exception.LdapManagerException;
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
	
	private LdapConnectionProvider provider = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		
		manager = (LdapManager<LdapOu>) ldapManagerFactory.createLdapManager("ou");
		provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
	}
	
	@Test
	public void test() {
	
		String ouName = "wkkim";
		
		LdapOu ou = this.find(ouName);
		this.delete(ou);
	}
	
	private LdapOu find(String ouName) {
		
		LdapConnectionProvider provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
		
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("organizationalUnit")
				.and("ou").is(ouName);
		
		LdapOu ou = null;
		try {
			ou = manager.connect(provider).find(query);
			LOG.debug("`e`found = {}", ou);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}
		
		return ou;
	}
	
	private void delete(LdapOu ou) {
		manager.connect(provider).delete(ou);
	}
}
