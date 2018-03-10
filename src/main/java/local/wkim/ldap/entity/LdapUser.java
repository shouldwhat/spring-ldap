package local.wkim.ldap.entity;

import org.springframework.ldap.odm.annotations.Entry;

@Entry(objectClasses = { "top", "user" })
public class LdapUser extends LdapEntity {

}
