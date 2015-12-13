package team.dkh.pj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import team.dkh.pj.dao.UserDao;
import team.dkh.pj.dao.UserDaoImpl;
import team.dkh.pj.domain.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("load");
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		User user = userDao.selectUser(username);
		
		logger.debug("loadUserByUsername: "+user.getEmail());
		return user;
	}	
}
