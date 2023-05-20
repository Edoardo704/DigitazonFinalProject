package nomeAzienda.DigitazonfinalProject.persistence.repositories;
import nomeAzienda.DigitazonfinalProject.persistence.entities.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipes,Long> {
}
