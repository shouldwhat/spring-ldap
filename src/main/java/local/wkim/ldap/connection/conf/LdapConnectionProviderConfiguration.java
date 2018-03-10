package local.wkim.ldap.connection.conf;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import local.wkim.ldap.connection.LdapConnectionProviderFactory;


@Configuration
public class LdapConnectionProviderConfiguration {

	@Bean("ldapConnectionProviderServiceLocatorFactoryBean")
	public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
		
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(LdapConnectionProviderFactory.class);
        
        return serviceLocatorFactoryBean;
	}
}
