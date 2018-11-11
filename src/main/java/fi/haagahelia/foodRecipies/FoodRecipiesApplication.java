package fi.haagahelia.foodRecipies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.foodRecipies.domain.Category;
import fi.haagahelia.foodRecipies.domain.CategoryRepository;
import fi.haagahelia.foodRecipies.domain.Recipe;
import fi.haagahelia.foodRecipies.domain.RecipeRepository;


@SpringBootApplication
public class FoodRecipiesApplication {
	private static final Logger log = LoggerFactory.getLogger(FoodRecipiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FoodRecipiesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository repository, CategoryRepository categoryrepository) {
		return (args) -> {
			log.info("save a couple of recipes");
			categoryrepository.save(new Category("Salaatit"));
			categoryrepository.save(new Category("Keitot"));
			categoryrepository.save(new Category("Uuniruuat"));
			
			repository.save(new Recipe("Perunasalaatti", "Leikkaa kasvikset ja perunat, sekoita joukkoon majoneesi, laita jääkaappiin marinoitumaan.", categoryrepository.findByName("Salaatit").get(0)));
			repository.save(new Recipe("Uunijuurekset", "Leikkaa juurekset, lisää joukkoon mausteet ja öljy, paista 200 asteessa 30 minuuttia.", categoryrepository.findByName("Uuniruuat").get(0)));	
			
			log.info("fetch all recipies");
			for (Recipe recipe : repository.findAll()) {
				log.info(recipe.toString());
				
			}

		};
	}
}
