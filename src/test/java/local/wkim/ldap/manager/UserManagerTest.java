package local.wkim.ldap.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import local.wkim.ldap.entity.LdapUser;
import local.wkim.ldap.exception.LdapManagerException;
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
	
	private LdapConnectionProvider provider = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		
		manager = (LdapManager<LdapUser>) ldapManagerFactory.createLdapManager("user");
		provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
	}
	
	@Test
	public void test() {
	
		String userId = "kim wonkyu";
		
		LdapUser created = this.create(userId);
		assertNotNull(created);
		
		LdapUser found = this.find(userId);
		assertNotNull(found);
		
		this.delete(found);
		found = this.find(userId);
		assertNull(found);
	}
	
	private LdapUser create(String userId) {
		
		LdapUser newUser = new LdapUser();
		newUser.setDn(LdapNameBuilder.newInstance().add("CN", userId).build());
		newUser.setUserId(userId);
		newUser.setUserName("This is User's Name");
		newUser.setSamAccountName(userId);
		
		LdapUser created = null;
		try {
			created = manager.connect(provider).create(newUser);
			LOG.debug("`d`created = {}", created);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}
		
		return created;
	}

	private LdapUser find(String userId) {
		
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("user")
				.and("cn").is(userId);
		
		LdapUser user = null;
		try {
			user = manager.connect(provider).find(query);
			LOG.debug("`e`found = {}", user);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	private void delete(LdapUser user) {
		manager.connect(provider).delete(user);
	}
}
