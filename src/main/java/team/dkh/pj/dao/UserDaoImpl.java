package team.dkh.pj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import team.dkh.pj.domain.User;
import team.dkh.pj.service.UserDetailsServiceImpl;

@Repository
public class UserDaoImpl implements UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Inject
	SqlSession sqlsession;
	
	@Override
	public List<Map<String, Object>> selectUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUser(String username) {
		// TODO Auto-generated method stub
		User user = sqlsession.selectOne("selectUser", username);
		logger.debug("selectUser",user.getEmail());
		return user;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User deleteUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
