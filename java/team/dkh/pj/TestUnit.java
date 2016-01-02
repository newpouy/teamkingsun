package team.dkh.pj;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myCypher.MyAES256Cipher;
import team.dkh.pj.domain.BoardVo;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestUnit {

	@Autowired
	SqlSession sqlSession;
	@Ignore
	@Test
	public void test(){
		//sqlSession.selectList("boardMap.selectBoardList");
		//sqlSession.selectOne("boardMap.selectBoard", "1");

		assertEquals(((BoardVo)sqlSession.selectOne("boardMap.selectBoard", "1")).getBoardId(),1);

	}
	@Ignore
	@Test
	public void cipherTest() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String str="jdbc:mysql://tks-db.ckz7bigg7w4o.ap-northeast-1.rds.amazonaws.com:3306/test";
		
		MyAES256Cipher my = MyAES256Cipher.getInstance();
		String encStr = my.AES_Encode(str);
		String decStr = my.AES_Decode(encStr);
		System.out.println(encStr);
		System.out.println(decStr);
	}
}
