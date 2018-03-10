package local.wkim.ldap.manager.conf;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import local.wkim.ldap.manager.LdapManagerFactory;

@Configuration
public class LdapManagerConfiguration {

	@Bean("ldapManagerServiceLocatorFactoryBean")
	public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
		
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(LdapManagerFactory.class);
        
        return serviceLocatorFactoryBean;
	}
}
