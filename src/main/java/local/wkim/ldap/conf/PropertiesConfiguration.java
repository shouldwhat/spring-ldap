package local.wkim.ldap.conf;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(PropertiesConfiguration.class);
	
	private static final String DEFAULT_CONNECTION_PROP = "/properties/connection.properties";
	
	public Properties connectionProp() {
		
		boolean isLoadOk = false;
		
		Properties prop = new Properties();
		
		try (InputStream is = new ClassPathResource(DEFAULT_CONNECTION_PROP).getInputStream()) {
			prop.load(is);
			isLoadOk = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			isLoadOk = false;
		}
		
		LOG.debug("property load result = {}", isLoadOk);
		return prop;
	}
}
