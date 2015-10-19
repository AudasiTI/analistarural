package br.com.analistarural.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.analistarural.domain.details.ApiUserDetails;

@Service
public class SingleUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		return new ApiUserDetails(userService.findByLogin(login));
	}
}
