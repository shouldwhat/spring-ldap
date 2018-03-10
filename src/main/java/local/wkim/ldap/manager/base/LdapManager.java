package local.wkim.ldap.manager.base;

import java.util.List;

import org.springframework.ldap.query.LdapQuery;

import local.wkim.ldap.connection.base.LdapConnectionProvider;

public abstract class LdapManager<T>{

	private LdapConnectionProvider provider;
	
	public LdapManager<T> connectionProvider(LdapConnectionProvider provider) {
		this.provider = provider;
		return this;
	}
	
	public T create(T entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}
	
	public T find(LdapQuery query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<T> findAll(LdapQuery query) {
		// TODO Auto-generated method stub
		return null;
	}
}
