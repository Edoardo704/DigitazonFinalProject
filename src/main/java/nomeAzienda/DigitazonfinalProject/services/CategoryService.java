package nomeAzienda.DigitazonfinalProject.services;

import nomeAzienda.DigitazonfinalProject.persistence.entities.Category;
import nomeAzienda.DigitazonfinalProject.persistence.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


    public Category getById(long id){
        Optional<Category> category =categoryRepository.findById(id);
        if(category.isEmpty()) {
            throw  new IllegalStateException("Entity not found");
        }
        return  category.get();

    }


    public Category create (Category newCategory){
        newCategory= categoryRepository.save(newCategory);
        return newCategory;
    }

    public Category update (long id, Category updateCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isEmpty()) {
            throw  new IllegalStateException("Entity not found");
        }
        Category entityToUpdate = optionalCategory.get();
        updateCategory.setId(entityToUpdate.getId());
        updateCategory=categoryRepository.save(updateCategory);
        return updateCategory;

    }

    public Category delete (long id) {
        Optional <Category> optionalCategory =categoryRepository.findById(id);
        if(optionalCategory.isEmpty()) {
            throw  new IllegalStateException("Entity not found");
        }
        Category entityToDelete = optionalCategory.get();
        categoryRepository.delete(entityToDelete);
        return entityToDelete;
    }



}
