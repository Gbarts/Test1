package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;

	//전체목록 /list(get)  -> /board/list.jsp
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list 요청");
		model.addAttribute("list", service.getList(cri));
		//model.addAttribute("count", service.count());
		model.addAttribute("pageMaker",new PageDTO(cri, service.count()));
	}
	//등록하기위한 화면요청
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	//등록 /register(post) -> 요청 /board/list
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("글등록 요청");
		service.register(vo); //글등록
		rttr.addFlashAttribute("bno", vo.getBno()); //입력된 글번호 전송 
		//Flash로 전송하게 되면 내부적으로 세션으로 처리됨.
		return "redirect:/board/list"; //주의 /board/list.jsp 가 아님 새로운 url 요청이다.
	}
	
	//조회 /get?bno=13(get) -> /board/get.jsp , 수정화면 열기 /modify(get) -> /board/modify.jsp
	@GetMapping({"/get","/modify"})
	public void get(Long bno,Model model) {
		model.addAttribute("board", service.get(bno));
	}
	
	//삭제 /remove(post) ->   요청 /board/list
	@PostMapping("/remove")
	public String remove(Long bno,RedirectAttributes rttr) {
		if(service.remove(bno))
		rttr.addFlashAttribute("state","remove");
		return "redirect:/board/list";
	}

	
	//수정 /modify(post) -> 요청 /board/list
	@PostMapping("/modify")
	public String modify(BoardVO vo,RedirectAttributes rttr) {
		if(service.modify(vo))
			rttr.addFlashAttribute("state","modify");
		return "redirect:/board/list";
	}
	
	//퀴즈
	@GetMapping("count")
	public void count(Model model) {
		//총글개수 가져오는 서비스
		model.addAttribute("count", service.count());
	}
}






