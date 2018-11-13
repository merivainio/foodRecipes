package fi.haagahelia.foodRecipies;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.foodRecipies.domain.Category;
import fi.haagahelia.foodRecipies.domain.Recipe;
import fi.haagahelia.foodRecipies.domain.RecipeRepository;

public class RecipeRepositoryTest {
	
	@RunWith(SpringRunner.class)
	@DataJpaTest

	public class BookRepositoryTest {
		
		@Autowired
	    private RecipeRepository repository;

	    @Test
	    public void findByTitleShouldReturnBook() {
	        List<Recipe> recipes = repository.findByName("Perunasalaatti");
	        
	        assertThat(recipes).hasSize(1);
	        assertThat(recipes.get(0).getInstructions()).isEqualTo("Leikkaa kasvikset ja perunat, sekoita joukkoon majoneesi, laita jääkaappiin marinoitumaan.");
	    }
	    
	    @Test
	    public void createNewRecipe() {
	    	Recipe recipe = new Recipe("Uunijuurekset", "Leikkaa juurekset, lisää joukkoon mausteet ja öljy, paista 200 asteessa 30 minuuttia.", new Category ("Uuniruuat"));
	    	repository.save(recipe);
	    	assertThat(recipe.getId()).isNotNull();
	    }
	    

	}

}
