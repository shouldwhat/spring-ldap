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
import local.wkim.ldap.entity.LdapPolicy;
import local.wkim.ldap.exception.LdapManagerException;
import local.wkim.ldap.manager.base.LdapManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyManagerTest {

	private static final Logger LOG = LoggerFactory.getLogger(PolicyManagerTest.class);
	
	@Autowired
	private LdapConnectionProviderFactory ldapConnectionProviderFactory;
	
	@Autowired
	private LdapManagerFactory ldapManagerFactory;
	
	private LdapManager<LdapPolicy> manager = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		manager = (LdapManager<LdapPolicy>) ldapManagerFactory.createLdapManager("policy");
	}
	
	@Test
	public void find() {
		
		LdapConnectionProvider provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
		
		String findPolicy = "08_실행명령 사용 차단";
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("groupPolicyContainer")
				.and("displayName").is(findPolicy);
		
		try {
			LdapPolicy find = manager.connect(provider).find(query);
			LOG.debug("`e`found = {}", find);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}
	}
}
