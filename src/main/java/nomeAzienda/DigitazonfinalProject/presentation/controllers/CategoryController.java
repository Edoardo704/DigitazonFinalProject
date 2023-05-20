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
@RequestMapping("/categories")
@CrossOrigin(origins="http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecipesService recipesService;


    @GetMapping
    public List<CategoryDTO> getCategory () {
        return categoryService.getAll()
                .stream()
                .map(this::convertoDTO)
                .toList();
    }


    @GetMapping("/{id}")
    public CategoryDTO getById (@PathVariable long id) {
        return convertoDTO(categoryService.getById(id));
    }

    @PostMapping
    public CategoryDTO createCategory (@RequestBody CategoryDTO newRecipes) {
            Category category = convertToEntity(newRecipes);
           category= categoryService.create(category);
            return  convertoDTO(category);

        }

        @PutMapping("/{id}")
    public CategoryDTO updateCategory (@PathVariable long id, @RequestBody CategoryDTO updateCategory ) {
        Category category = convertToEntity(updateCategory);
       category= categoryService.update(id,category);
        return convertoDTO(category);
    }

    @DeleteMapping ("/{id}")
    public CategoryDTO delete (@PathVariable long id) {
        return convertoDTO(categoryService.delete(id));
    }


    @GetMapping ("/{id}/recipes")  // recupera un elenco di ricette associate a una singola categoria di ricette.
    //http://localhost:3432/categories/2/recipes

    public List <RecipesDTO> getRecipes ( @PathVariable long id) {
        Category category = categoryService.getById(id);
        return category.getRecipes()
                .stream()
                .map(this::convertToRecipesDTO)
                .toList();
    }

    private CategoryDTO convertoDTO (Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    private Category convertToEntity (CategoryDTO dto) {
        return modelMapper.map (dto, Category.class);
    }

    private RecipesDTO convertToRecipesDTO ( Recipes recipes) {
        return modelMapper.map(recipes,RecipesDTO.class);
    }


}
