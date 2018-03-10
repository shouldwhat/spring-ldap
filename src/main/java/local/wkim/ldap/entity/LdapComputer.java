package local.wkim.ldap.entity;

import org.springframework.ldap.odm.annotations.Entry;

@Entry(objectClasses = {"computer", "top"})
public class LdapComputer extends LdapEntity {

}
