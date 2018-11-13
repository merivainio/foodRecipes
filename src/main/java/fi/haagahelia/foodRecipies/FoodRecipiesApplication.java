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
import fi.haagahelia.foodRecipies.domain.User;
import fi.haagahelia.foodRecipies.domain.UserRepository;


@SpringBootApplication
public class FoodRecipiesApplication {
	private static final Logger log = LoggerFactory.getLogger(FoodRecipiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FoodRecipiesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository repository, CategoryRepository categoryrepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of recipes");
			categoryrepository.save(new Category("Salaatit"));
			categoryrepository.save(new Category("Keitot"));
			categoryrepository.save(new Category("Uuniruuat"));
			
			repository.save(new Recipe("Perunasalaatti", "Leikkaa kasvikset ja perunat, sekoita joukkoon majoneesi, laita jääkaappiin marinoitumaan.", categoryrepository.findByName("Salaatit").get(0)));
			repository.save(new Recipe("Uunijuurekset", "Leikkaa juurekset, lisää joukkoon mausteet ja öljy, paista 200 asteessa 30 minuuttia.", categoryrepository.findByName("Uuniruuat").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all recipies");
			for (Recipe recipe : repository.findAll()) {
				log.info(recipe.toString());
				
			}

		};
	}
}
