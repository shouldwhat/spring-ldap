package local.wkim.ldap.manager;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.support.LdapNameBuilder;
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
	
		String ouName = "wkkim3";
		
		LdapOu created = this.create(ouName);
		assertNotNull(created);
		
		LdapOu found = this.find(ouName);
		assertNotNull(found);
		
		this.delete(found);
	}
	
	private LdapOu create(String ouName) {
		
//		LdapName dn = LdapNameBuilder.newInstance().add("OU", ouName).build();
		
		LdapOu newOu = new LdapOu();
		newOu.setDn(LdapNameBuilder.newInstance().add("OU", ouName).build());
		newOu.setGplink(null);
		newOu.setName(ouName);
		newOu.setOuDesc("This is OU Description");
		
		LdapOu created = null;
		try {
			created = manager.connect(provider).create(newOu);
			LOG.debug("`e`created = {}", created);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}

		return created;
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
