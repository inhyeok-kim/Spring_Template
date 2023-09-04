package com.sea.weed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.sea.weed.test.TestController;
import com.sea.weed.test.TestService;

@SpringBootTest
@ActiveProfiles("dev")
class SeaWeedApplicationTests {

	@Autowired
	private TestController testController;

	@Test
	void test(){

	}

}
