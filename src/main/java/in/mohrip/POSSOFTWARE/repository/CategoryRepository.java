package in.mohrip.POSSOFTWARE.repository;

import in.mohrip.POSSOFTWARE.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
