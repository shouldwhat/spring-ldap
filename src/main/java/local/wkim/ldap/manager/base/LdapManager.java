package local.wkim.ldap.manager.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.exception.LdapManagerException;

public abstract class LdapManager<T>{

	private static final Logger LOG = LoggerFactory.getLogger(LdapManager.class);
	
	private LdapTemplate ldapTemplate;
	
	public LdapManager<T> connect(LdapConnectionProvider provider) {
		this.ldapTemplate = provider.createConnection();
		return this;
	}
	
	public T create(T entity) {
		
		ldapTemplate.create(entity);
		return entity;
	}
	
	public T update(T entity) {
		
		ldapTemplate.update(entity);
		return entity;
	}
	
	public void delete(T entity) {

		if(entity != null) {
			ldapTemplate.delete(entity);
		}
	}
	
	public T find(LdapQuery query) throws LdapManagerException {

		try {
			return ldapTemplate.findOne(query, this.genericClassType());
		} catch(EmptyResultDataAccessException e) {
			/* not exist entity */
			return null;
		} catch(IncorrectResultSizeDataAccessException e) {
			/* exception */
			throw new LdapManagerException(e.getMessage(), e);
		}
	}
	
	public List<T> findAll(LdapQuery query) throws LdapManagerException {
		
		List<T> entities = ldapTemplate.find(query, this.genericClassType());
		return entities;
	}
	
	/***
	 * LdapManager 클래스의 제네릭 타입(<T>)을 조회한다.
	 */
	public Class<T> genericClassType() {
		
		Type superClass = this.getClass().getGenericSuperclass();
		Type typeClass = (((ParameterizedType) superClass).getActualTypeArguments())[0];
		
		return (Class<T>) typeClass;
	}
}
