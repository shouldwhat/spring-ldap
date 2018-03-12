package local.wkim.ldap.manager;

public enum LdapManagerType {

	USER("user"), OU("ou"), POLICY("policy"), COMPUTER("computer"),
	;
	
	LdapManagerType(String value) { this.value = value; }
	
	public String value;
//	public String value() { return this.value; }
}
