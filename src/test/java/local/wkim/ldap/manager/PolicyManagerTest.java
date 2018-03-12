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
	
	private LdapConnectionProvider provider = null;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		
		manager = (LdapManager<LdapPolicy>) ldapManagerFactory.createLdapManager("policy");
		provider = ldapConnectionProviderFactory.createConnectionProvider("propertyBase");
	}
	
	@Test
	public void test() {
	
		String policyName = "user-policy1";
		
		LdapPolicy policy = this.find(policyName);
		this.delete(policy);
	}
	
	public LdapPolicy find(String policyName) {
		
		LdapQuery query = LdapQueryBuilder.query()
				.where("objectClass").is("groupPolicyContainer")
				.and("displayName").is(policyName);
		
		LdapPolicy policy = null;
		try {
			policy = manager.connect(provider).find(query);
			LOG.debug("`e`found = {}", policy);
		} catch (LdapManagerException e) {
			e.printStackTrace();
		}
		
		return policy;
	}
	
	private void delete(LdapPolicy policy) {
		manager.connect(provider).delete(policy.getDn());
	}
}
