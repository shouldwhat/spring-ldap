package local.wkim.ldap.entity;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = { "computer", "top" })
public final class LdapComputer {

	@Id
	private Name dn;
	
	@Attribute(name="cn")
    private String name;

	@Override
	public String toString() {
		return "LdapComputer [dn=" + dn + ", name=" + name + "]";
	}

	public Name getDn() {
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
