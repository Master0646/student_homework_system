package shw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tujietg.gradpro.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class TestSql {

	@Autowired
	UserService userService;

	@Test
	public void getPasswordTest() {
		System.out.println(userService.getPasswd("000000000000"));
	}

}
