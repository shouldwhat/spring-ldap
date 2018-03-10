package local.wkim.ldap.connection.entity;

public class LdapConnectionInfo {

	private String url;
	private String base;
	private String userDn;
	private String password;
	
	@Override
	public String toString() {
		return "LdapConnectionInfo [url=" + url + ", base=" + base + ", userDn=" + userDn + ", password=" + password
				+ "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getUserDn() {
		return userDn;
	}

	public void setUserDn(String userDn) {
		this.userDn = userDn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
