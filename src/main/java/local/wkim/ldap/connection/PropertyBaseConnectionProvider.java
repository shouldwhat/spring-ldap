package local.wkim.ldap.connection;

import java.util.Properties;

import javax.naming.ldap.LdapName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Scope("prototype")
@Component("propertyBase")
public class PropertyBaseConnectionProvider  extends LdapConnectionProvider {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyBaseConnectionProvider.class);
	
	@Autowired
	private Properties connectionProp;

	@Override
	protected LdapConnectionInfo connectionInfo() {

		String url = null;
		{
			String urlTemplate = "${protocol}://${ip}:${port}"
					.replace("${protocol}", connectionProp.getProperty("ad.access.protocol"))
					.replace("${ip}", connectionProp.getProperty("ad.access.ip"))
					.replace("${port}", connectionProp.getProperty("ad.access.port"));
			
			url = urlTemplate;
		}
		
		LdapName base = null;
		{
			String domain = connectionProp.getProperty("ad.domain");
			String[] splitDomain = domain.split("\\.");
			
			base = LdapNameBuilder.newInstance()
					.add("DC", splitDomain[1])
					.add("DC", splitDomain[0])
					.build();
		}
		
		LdapName userDn = null;
		{
			userDn = LdapNameBuilder.newInstance(base)
					.add("CN", "Users")
					.add("CN", connectionProp.getProperty("ad.auth.id"))
					.build();
		}

		String password = connectionProp.getProperty("ad.auth.password");
		
		LdapConnectionInfo connectionInfo = null;
		{
			connectionInfo = new LdapConnectionInfo();
			connectionInfo.setUrl(url);
			connectionInfo.setBase(base.toString());
			connectionInfo.setUserDn(userDn.toString());
			connectionInfo.setPassword(password);
		}
		
		LOG.debug("`e`connectionInfo = {}", connectionInfo);
		
		return connectionInfo;
	}
}
