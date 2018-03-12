package local.wkim.ldap.entity;

import org.springframework.ldap.odm.annotations.Entry;

@Entry(objectClasses = {"container", "groupPolicyContainer", "top"}, base="CN=Policies,CN=System")
public class LdapPolicy {

}
