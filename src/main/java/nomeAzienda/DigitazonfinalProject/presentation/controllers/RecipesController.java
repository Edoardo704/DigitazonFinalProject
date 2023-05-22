package nomeAzienda.DigitazonfinalProject.presentation.controllers;


import nomeAzienda.DigitazonfinalProject.persistence.entities.Recipes;
import nomeAzienda.DigitazonfinalProject.persistence.entities.Category;
import nomeAzienda.DigitazonfinalProject.presentation.dto.CategoryDTO;
import nomeAzienda.DigitazonfinalProject.presentation.dto.RecipesDTO;
import nomeAzienda.DigitazonfinalProject.services.CategoryService;
import nomeAzienda.DigitazonfinalProject.services.RecipesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins="http://localhost:3000")
public class RecipesController {


    @Autowired
    private ModelMapper modelmapper;

    @Autowired
    private RecipesService recipesService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<RecipesDTO> getRecipes() {
        return recipesService.getAll()
                .stream().map(this::convertToDTO).toList();
    }

    @GetMapping ("/{id}")
    private RecipesDTO getById (@PathVariable long id) {
        return  convertToDTO(recipesService.getById(id));
    }

    @PostMapping
    private RecipesDTO create (@RequestBody RecipesDTO newRecipes) {
        Recipes recipes = convertToEntity(newRecipes);
        recipes = recipesService.create(recipes);
        return convertToDTO(recipes);
    }

        @PutMapping ("/{id}")
        private RecipesDTO update (@PathVariable long id ,@RequestBody RecipesDTO updateRecipes) {
        Recipes recipes = convertToEntity(updateRecipes);
        recipes = recipesService.update(id,recipes);
        return  convertToDTO(recipes);

    }

    @DeleteMapping ("/{id}")
    private RecipesDTO delete ( @PathVariable long id) {
        return convertToDTO(recipesService.delete(id));
    }

    private RecipesDTO convertToDTO ( Recipes recipes) {
        return modelmapper.map(recipes,RecipesDTO.class);
    }

    private Recipes convertToEntity( RecipesDTO dto) {
        return modelmapper.map(dto, Recipes.class);
    }

    private CategoryDTO convertToRecipesCategoryToDTO (Category recipesCategory) {
        return modelmapper.map (recipesCategory, CategoryDTO.class);
    }



    @GetMapping("/{id}/categories")
    public CategoryDTO getCategory (@PathVariable long id) {
        Recipes recipes = recipesService.getById(id);
        return  convertToRecipesCategoryToDTO(recipes.getCategory());


    }
}
