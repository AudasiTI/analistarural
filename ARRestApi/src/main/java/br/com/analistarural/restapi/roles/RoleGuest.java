package br.com.analistarural.restapi.roles;

import org.springframework.security.access.annotation.Secured;

@Secured("ROLE_GUEST")
public @interface RoleGuest  {

}
