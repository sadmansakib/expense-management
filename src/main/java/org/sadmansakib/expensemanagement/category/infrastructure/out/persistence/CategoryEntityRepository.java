package org.sadmansakib.expensemanagement.category.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@org.jmolecules.ddd.annotation.Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long>, JpaSpecificationExecutor<CategoryEntity> {
    @Query("SELECT c FROM CategoryEntity c WHERE c.budgetId = :budgetId")
    List<CategoryEntity> findAllByBudgetId(Long budgetId);
}