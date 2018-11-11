package fi.haagahelia.foodRecipies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String instructions;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Recipe(String name, String instructions, Category category) {
		super();
		this.name = name;
		this.instructions = instructions;
		this.category = category;
	}
	
	public Recipe() {
		super();
		this.name = null;
		this.instructions = null;
	}
	
	//setterit
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	// getterit
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getInstructions() {
		return instructions;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	// toString
	@Override
	public String toString() {
		if (this.category != null)
		return "Recipe [id=" + id + ", name=" + name + ", instructions=" + instructions + ", category=" + this.getCategory() + "]";
		else
		return "Recipe [id=" + id + ", name=" + name + ", instructions=" + instructions +"]";
	}
	
	

}
	
	


