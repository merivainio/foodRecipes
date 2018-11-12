package fi.haagahelia.foodRecipies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.foodRecipies.domain.CategoryRepository;
import fi.haagahelia.foodRecipies.domain.Recipe;
import fi.haagahelia.foodRecipies.domain.RecipeRepository;


@Controller
public class RecipeController {
	@Autowired
	private RecipeRepository repository;
	@Autowired
	private CategoryRepository categoryrepository;
	
    @RequestMapping(value="/recipelist")
    public String recipeList(Model model) {	
        model.addAttribute("recipes", repository.findAll());
        return "recipelist";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRecipe(@PathVariable("id") Long recipeId, Model model) {
    	model.addAttribute("recipe", repository.findById(recipeId));
    	model.addAttribute("categories", categoryrepository.findAll());
        return "editrecipe";
    }     
    
    @RequestMapping(value = "/add")
    public String addRecipe(Model model){
    	model.addAttribute("recipe", new Recipe());
    	model.addAttribute("categories", categoryrepository.findAll());
        return "addrecipe";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Recipe recipe){
        repository.save(recipe);
        return "redirect:recipelist";
	}
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
    	repository.deleteById(recipeId);
        return "redirect:../recipelist";
    }     

}
