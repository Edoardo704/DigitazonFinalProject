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



    @GetMapping("/{id}/categories") //  categoria di ricette associata alla ricetta con l'ID specificato.
    public CategoryDTO getCategory (@PathVariable long id) {
        Recipes recipes = recipesService.getById(id);
        return  convertToRecipesCategoryToDTO(recipes.getCategory());

        //il metodo getRecipesCategory() gestisce una richiesta GET per ottenere una categoria di ricette specifica,
        // utilizzando l'ID della ricetta come parametro nella richiesta URL. Viene quindi utilizzato il metodo
        // convertToRecipesCategoryToDTO()
        // per convertire l'oggetto RecipesCategory in un oggetto RecipesCategoryDTO prima di restituire la risposta.


        //Convertire un oggetto in un'entità o in un DTO serve a gestire in modo più efficace l'informazione all'interno di un'applicazione.
        //
        //Le entità rappresentano gli oggetti del dominio, ovvero i dati che devono essere memorizzati nel database e
        // gestiti dall'applicazione. Le entità sono utilizzate per rappresentare
        // i dati in modo strutturato e fornire metodi per l'accesso e la gestione dei dati.
        // Tuttavia, spesso le entità contengono informazioni non necessarie o che non devono essere trasmesse al client.
        //
        //I DTO, d'altra parte, sono utilizzati per rappresentare solo le informazioni necessarie per una specifica operazione.
        // In genere, i DTO contengono solo i dati essenziali, e vengono utilizzati per ridurre il traffico di rete e migliorare
        // le prestazioni dell'applicazione. I DTO possono essere considerati come una rappresentazione più leggera delle entità,
        // che vengono utilizzati solo per la comunicazione tra il client e il server.
        //
        //Nel codice fornito, i metodi convertToDTO() e convertToRecipesCategoryToDTO() vengono utilizzati per convertire gli oggetti
        // delle entità Recipes e RecipesCategory in oggetti DTO, rispettivamente RecipesDTO e RecipesCategoryDTO. Questi metodi eliminano
        // le informazioni non necessarie e forniscono solo i dati essenziali, rendendo più efficiente la comunicazione tra il client e il
        // server.
        //
        //D'altra parte, il metodo convertToEntity() viene utilizzato per convertire un oggetto DTO in un'entità.
        // Questo è utile quando l'applicazione deve salvare i dati nel database, in quanto è necessario utilizzare oggetti di
        // entità per l'interazione con il database.


        // i service fungono da intermediari tra i controller (che gestiscono le richieste del client) e i repository
        // (che si occupano della persistenza dei dati nel database).
    }
}
