package local.wkim.ldap.connection.base;

import java.util.Map;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import local.wkim.ldap.connection.entity.LdapConnectionInfo;

public abstract class LdapConnectionProvider {

	private Map<String, Object> connectionInfo = null;
	
	public Map<String, Object> getConnectionInfo() {
		return connectionInfo;
	}
	public void setConnectionInfo(Map<String, Object> connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	
	protected abstract LdapConnectionInfo connectionInfo();
	public LdapTemplate createConnection() {
		
		LdapConnectionInfo connectionInfo = this.connectionInfo();
		return this.create(connectionInfo);
	}
	
	protected LdapTemplate create(LdapConnectionInfo connectionInfo) {
		
		LdapTemplate ldapTemplate = new LdapTemplate(this.createContext(connectionInfo));
//		ldapTemplate.setIgnorePartialResultException(true);
		return ldapTemplate;
	}
	
	private LdapContextSource createContext(LdapConnectionInfo connectionInfo) {
		
		LdapContextSource context = new LdapContextSource();
		
		context.setUrl(connectionInfo.getUrl());
		context.setBase(connectionInfo.getBase());
		context.setUserDn(connectionInfo.getUserDn());
		context.setPassword(connectionInfo.getPassword());
		/*
		 * afterPropertiesSet() 메소드를 호출해야, 동적 커넥션 refresh가 가능함.
		 */
		context.afterPropertiesSet();
		
		return context;
	}
}
