package local.wkim.ldap.entity;

import org.springframework.ldap.odm.annotations.Entry;

import local.wkim.ldap.entity.base.LdapEntity;

@Entry(objectClasses = {"container", "groupPolicyContainer", "top"}, base="CN=Policies,CN=System")
public class LdapPolicy extends LdapEntity {

}
