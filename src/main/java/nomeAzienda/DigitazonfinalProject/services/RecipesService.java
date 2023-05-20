package nomeAzienda.DigitazonfinalProject.services;


import nomeAzienda.DigitazonfinalProject.persistence.entities.Recipes;
import nomeAzienda.DigitazonfinalProject.persistence.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipesService {

    @Autowired
    private RecipesRepository recipesRepository;


    public List<Recipes> getAll() {
        return recipesRepository.findAll();
    }

    public Recipes getById (long id) {
        Optional<Recipes> recipesOptional = recipesRepository.findById(id);
        if(recipesOptional.isEmpty()) {
            throw  new IllegalStateException("Entity not found");
        }
        return recipesOptional.get();
    }



    public Recipes create (Recipes newRecipes) {
        if ( newRecipes.getCategory()==null) {
            throw  new IllegalStateException("Recipes Category not be null");
        }
       newRecipes= recipesRepository.save(newRecipes);
        return newRecipes;
        }

        public Recipes update ( long id, Recipes updateRecipes) {
            if ( updateRecipes.getCategory()==null) {
                throw  new IllegalStateException("Recipes Category not be null");
            }
            Optional <Recipes> optionalRecipes= recipesRepository.findById(id);
            if (optionalRecipes.isEmpty()) {
                throw new IllegalStateException("Entity not found");
            }
            Recipes entityToUpdate = optionalRecipes.get();
            updateRecipes.setId(entityToUpdate.getId());
            updateRecipes = recipesRepository.save(updateRecipes);
            return updateRecipes;
        }


        public Recipes delete ( long id ) {
            Optional <Recipes>recipes= recipesRepository.findById(id);
            if (recipes.isEmpty()) {
                throw new IllegalStateException("Entity not found");
            }
            Recipes entityToDelete = recipes.get();
            recipesRepository.delete(entityToDelete);
            return  entityToDelete;
        }




    }

