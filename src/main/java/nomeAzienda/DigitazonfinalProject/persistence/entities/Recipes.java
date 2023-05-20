package nomeAzienda.DigitazonfinalProject.persistence.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="recipes")
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "ingredients", nullable = false)
    private String ingredients;


    @Column(name = "difficulty", nullable = false)
    private String difficulty;


    @Column(name = "price", nullable = false)
    private double price;


    @Column(name = "timePreparation", nullable = false)
    private int timePreparation;


    @Column(name = "cookingTime", nullable = false)
    private int cookingTime;


    @Column(name = "cover", columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte[] cover;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}