package nomeAzienda.DigitazonfinalProject.presentation.dto;

import jakarta.persistence.Column;

public class RecipesDTO {
    private long id;
    private String title;
    private String description;
    private String ingredients;
    private String recipeProcess;
    private String difficulty;
    private double price;
    private int timePreparation;
    private int cookingTime;
    private byte [] cover;
    private long idCategory;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeProcess() {
        return recipeProcess;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public void setRecipeProcess(String recipeProcess) {
        this.recipeProcess = recipeProcess;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTimePreparation() {
        return timePreparation;
    }

    public void setTimePreparation(int timePreparation) {
        this.timePreparation = timePreparation;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }
}
