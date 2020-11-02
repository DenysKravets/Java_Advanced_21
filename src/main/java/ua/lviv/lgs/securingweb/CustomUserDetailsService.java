package ua.lviv.lgs.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.serviceImpl.UserServiceImpl;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserServiceImpl userService; 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return new CustomUserDetails(userService.readByEmail(email));
	}

}
