package local.wkim.ldap.exception;

public class LdapManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LdapManagerException() {
		super();
	}
	
	public LdapManagerException(String message) {
		super(message);
	}
	
	public LdapManagerException(String message, Exception e) {
		super(message, e);
	}
}
