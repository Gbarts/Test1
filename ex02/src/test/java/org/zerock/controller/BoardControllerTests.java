package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext ctx;
	
	//컨트롤러를 테스트하기위해서는 MockMvc 객체를 이용한다.
	private MockMvc mockMvc;
	
	//테스전에 mockMvc 객체 생성하기
	@Before
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	
	@Test
	public void testRegister() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "1111").param("content", "냉무")
				.param("writer", "나다")).andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "12"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRemove() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "100"))
		.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testModify() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "11").param("title","수정111").param("content", "수정내용111").
				param("writer","해커"))
		.andReturn().getModelAndView().getViewName());
	}
	
	// /board/count(get) -> /board/count.jsp (총 글개수를 보내준다)
	@Test
	public void testCount() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/count"))
		.andReturn().getModelAndView().getModelMap());
	}
}





