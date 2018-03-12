package local.wkim.ldap.entity;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = {"organizationalUnit", "top"})
public final class LdapOu {

	@Id
	private Name dn;

	@Attribute(name="ou")
	private String name;
	
	@Attribute(name="description")
	private String ouDesc;
	
	@Attribute(name="gPLink")
	private String gplink;

	@Override
	public String toString() {
		return "LdapOu [name=" + name + ", ouDesc=" + ouDesc + ", gplink=" + gplink + ", dn=" + dn + "]";
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

	public String getOuDesc() {
		return ouDesc;
	}

	public void setOuDesc(String ouDesc) {
		this.ouDesc = ouDesc;
	}

	public String getGplink() {
		return gplink;
	}

	public void setGplink(String gplink) {
		this.gplink = gplink;
	}
}
