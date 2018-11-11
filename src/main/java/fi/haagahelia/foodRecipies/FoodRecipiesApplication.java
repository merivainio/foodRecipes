package fi.haagahelia.foodRecipies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.foodRecipies.domain.Recipe;
import fi.haagahelia.foodRecipies.domain.RecipeRepository;


@SpringBootApplication
public class FoodRecipiesApplication {
	private static final Logger log = LoggerFactory.getLogger(FoodRecipiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FoodRecipiesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository repository) {
		return (args) -> {
			log.info("save a couple of recipes");
			repository.save(new Recipe("Perunasalaatti", "Leikkaa kasvikset ja perunat, sekoita joukkoon majoneesi, laita jääkaappiin marinoitumaan."));
			repository.save(new Recipe("Uunijuurekset", "Leikkaa juurekset, lisää joukkoon mausteet ja öljy, paista 200 asteessa 30 minuuttia."));	
			
			log.info("fetch all recipies");
			for (Recipe recipe : repository.findAll()) {
				log.info(recipe.toString());
				
			}

		};
	}
}
