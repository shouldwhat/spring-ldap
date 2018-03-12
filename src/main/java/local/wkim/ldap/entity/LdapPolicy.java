package local.wkim.ldap.entity;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = {"groupPolicyContainer", "top"}, base="CN=Policies, CN=System")
public final class LdapPolicy {

	@Id
	private Name dn;
	
	@Attribute(name = "cn")
	private String policyId;

	@Attribute(name = "displayName")
	private String policyName;

	@Override
	public String toString() {
		return "LdapPolicy [dn=" + dn + ", policyId=" + policyId + ", policyName=" + policyName + "]";
	}

	public Name getDn() {
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
}
