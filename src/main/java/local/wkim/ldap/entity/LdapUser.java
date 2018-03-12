package local.wkim.ldap.entity;

import java.util.Set;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = { "user", "top" })
public final class LdapUser {
	
	@Id
	private Name dn;
	
	@Attribute(name = "cn")
	private String	userId;
	
	@Attribute(name = "displayName")
	private String	userName;
	
	@Attribute(name = "sAMAccountName")
	private String	samAccountName;
	
	@Attribute(name = "memberOf")
	private Set<Name> groups;

	@Override
	public String toString() {
		return "LdapUser [dn=" + dn + ", userId=" + userId + ", userName=" + userName + ", samAccountName="
				+ samAccountName + ", groups=" + groups + "]";
	}

	public Name getDn() {
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSamAccountName() {
		return samAccountName;
	}

	public void setSamAccountName(String samAccountName) {
		this.samAccountName = samAccountName;
	}

	public Set<Name> getGroups() {
		return groups;
	}

	public void setGroups(Set<Name> groups) {
		this.groups = groups;
	}
}
