package test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" ,"classpath:spring-redis.xml","classpath:spring-mvc.xml"})
// ��Ȼ ���������һ��������� ÿ����Ԫ���Զ���������ع� ���۳ɹ����
@TransactionConfiguration(defaultRollback = true)
// �ǵ�Ҫ��XML�ļ�����������Ŷ~~~���ǲ���ע��ķ�ʽ
@Transactional
public class MyTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		// webAppContextSetup ע�������static import
		// webAppContextSetup �����WEB�����������fileter ���ǲ������listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// ����������������Ϸ��� ��ᱨ��ָ��
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testGetTrdSession() throws Exception {
		// resultAction������ģ��ͻ�������
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/itarget/user/getTrdSession")
				.accept(MediaType.APPLICATION_JSON).param("jsCode", "031EftpO11IN361cMDsO1cvbpO1EftpI"));
		// MvcResult�ǻ�÷�������Response���ݡ�
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("*******:" + result);
	}

	@Test // ��Щ��Ԫ�����㲻ϣ���ع�
	@Rollback(false)
	public void ownerId() throws Exception {
		mockMvc.perform((get("/spring/rest/4.do"))).andExpect(status().isOk()).andDo(print());
	}


	@Test
	public void testUser() throws Exception {
		mockMvc.perform((get("/test/aaa.do"))).andExpect(status().isOk()).andDo(print());
	}
}
