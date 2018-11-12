package fi.haagahelia.foodRecipies.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	List<Recipe> findByName(@Param("name")String name);


}
