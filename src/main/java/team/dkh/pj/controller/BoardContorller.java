package team.dkh.pj.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.dkh.pj.domain.BoardVo;
import team.dkh.pj.service.BoardService;

@Controller
public class BoardContorller {
		
		private Logger logger = LoggerFactory.getLogger(BoardContorller.class);
		@Autowired
		BoardService boardService;
		
		@RequestMapping(value="/", method=RequestMethod.GET)
		public String main(Model model) {
			logger.debug("boardList: "+boardService.getBoardList().toString());
			model.addAttribute("boardList", boardService.getBoardList());
			return "boardList";
		}
		@RequestMapping(value="/boardList", method=RequestMethod.GET)
		public String getBoardList(Model model) {
			logger.debug("boardList: "+boardService.getBoardList().toString());
			model.addAttribute("boardList", boardService.getBoardList());
			return "boardList";
		}
		
		@RequestMapping(value="/board/{boardId}", method=RequestMethod.GET)
		public String getBoard(Model model, @PathVariable int boardId) {
			logger.debug("getBpard: "+boardService.getBoardOne(boardId));
			model.addAttribute("boardOne", boardService.getBoardOne(boardId));
			return "boardOne";
		}
		
		@RequestMapping(value="/boardWriteView", method=RequestMethod.GET)
		public String writeBoardView(Model model) {
			//logger.debug("writeBoard: "+boardService.writeBoard(boardVo));
			//model.addAttribute("resultBoardVo", boardService.writeBoard(boardVo));	
			return "boardWriteView";
		}
		
		@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
		public String writeBoard(Model model, BoardVo boardVo) {
			logger.debug("writeBoard");
			if(boardService.writeBoard(boardVo)>0){ //insert성공여부
				model.addAttribute("boardOne", boardVo);	
			}else{
				logger.debug("insert failure");
			}
			return "boardOne";
		}
		@RequestMapping(value="/boardModifyView/{boardId}", method=RequestMethod.GET)
		public String boardModifyView(Model model, @PathVariable int boardId) {
			logger.debug("controller.boardModifyView: "+boardId);
			model.addAttribute("board", boardService.getBoardOne(boardId));
			return "boardModifyView";
		}
		@RequestMapping(value="/boardModify/{boardId}", method=RequestMethod.POST)
		public String boardModify(Model model, BoardVo boardVo, @PathVariable int boardId) {
			logger.debug("controller.boardModify: "+boardVo.getContent());
			boardVo.setBoardId(boardId);
			if(boardService.modifyBoard(boardVo)>0){
				model.addAttribute("boardOne", boardVo);
			} else {
				logger.debug("update failure");
			}
			return "boardOne";
		}
}
