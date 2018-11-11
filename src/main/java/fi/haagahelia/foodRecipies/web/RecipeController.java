package fi.haagahelia.foodRecipies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.foodRecipies.domain.RecipeRepository;


@Controller
public class RecipeController {
	@Autowired
	private RecipeRepository repository; 
	
    @RequestMapping(value="/recipelist")
    public String recipeList(Model model) {	
        model.addAttribute("recipes", repository.findAll());
        return "recipelist";
    }
    
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public String findRecipe(@PathVariable("id") Long recipeId, Model model) {
    	model.addAttribute("recipe", repository.findById(recipeId));
        return "recipe";
    }     

}
