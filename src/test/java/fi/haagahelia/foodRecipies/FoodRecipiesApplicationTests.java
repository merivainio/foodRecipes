package fi.haagahelia.foodRecipies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import fi.haagahelia.foodRecipies.web.RecipeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodRecipiesApplicationTests {
	
	@Autowired
	private RecipeController controller;


	@Test
	public void contextLoads() {
		
		assertThat(controller).isNotNull();

	}
		
		

}
