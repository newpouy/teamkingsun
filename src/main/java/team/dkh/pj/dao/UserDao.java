package team.dkh.pj.dao;

import java.util.List;
import java.util.Map;

import team.dkh.pj.domain.BoardVo;
import team.dkh.pj.domain.User;

public interface UserDao {
	public List<Map<String, Object>> selectUserList();
	public User selectUser(String username);
	public int insertUser(User user);
	public int updateUser(User user);
	public User deleteUser(int userid);
}
