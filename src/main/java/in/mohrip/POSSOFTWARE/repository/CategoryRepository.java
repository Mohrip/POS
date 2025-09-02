package in.mohrip.POSSOFTWARE.repository;

import in.mohrip.POSSOFTWARE.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
   // findByCategoryId(String categoryId);
    Optional<CategoryEntity>findByCategoryId(String categoryId);
}
