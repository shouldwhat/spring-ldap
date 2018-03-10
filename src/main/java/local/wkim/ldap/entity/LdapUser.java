package local.wkim.ldap.entity;

import org.springframework.ldap.odm.annotations.Entry;

import local.wkim.ldap.entity.base.LdapEntity;

@Entry(objectClasses = { "top", "user" })
public class LdapUser extends LdapEntity {

}
