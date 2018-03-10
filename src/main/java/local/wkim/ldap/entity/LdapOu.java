package local.wkim.ldap.entity;

import org.springframework.ldap.odm.annotations.Entry;

import local.wkim.ldap.entity.base.LdapEntity;

@Entry(objectClasses = {"organizationalUnit", "top"})
public class LdapOu extends LdapEntity{

}
