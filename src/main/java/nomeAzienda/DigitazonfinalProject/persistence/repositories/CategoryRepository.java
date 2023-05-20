package nomeAzienda.DigitazonfinalProject.persistence.repositories;
import nomeAzienda.DigitazonfinalProject.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category,Long> {
}
