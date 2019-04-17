package shw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tujietg.gradpro.service.OrderQuestReplyService;
import com.tujietg.gradpro.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class TestSql {

	@Autowired
	UserService userService;

	@Autowired
	OrderQuestReplyService orderQuestReplyService;

	@Test
	public void getPasswordTest() {
		userService.getUserEntity("asad");
	}

}
