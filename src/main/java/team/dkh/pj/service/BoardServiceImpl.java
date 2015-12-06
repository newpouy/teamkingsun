package team.dkh.pj.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.dkh.pj.dao.BoardDao;
import team.dkh.pj.domain.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	public BoardDao boardDao;
	@Override
	public  List<Map<String, Object>> getBoardList() {
		return boardDao.selectBoardList();
	}
	@Override
	public BoardVo getBoardOne(int boardId) {
		return boardDao.selectBoard(boardId);
	}
	@Override
	public int writeBoard(BoardVo boardVo) {
		logger.debug("BoardServiceImpl.writeBoard:", boardVo.toString() );
		return boardDao.insertBoard(boardVo);
	}
	@Override
	public int modifyBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

}
