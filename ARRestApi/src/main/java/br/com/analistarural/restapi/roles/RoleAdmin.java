package br.com.analistarural.restapi.roles;

import org.springframework.security.access.annotation.Secured;

@Secured("ROLE_ADMIN")
public @interface RoleAdmin {

}
