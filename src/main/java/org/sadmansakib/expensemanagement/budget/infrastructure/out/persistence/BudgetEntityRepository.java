package org.sadmansakib.expensemanagement.budget.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetEntityRepository extends JpaRepository<BudgetEntity, Long>, JpaSpecificationExecutor<BudgetEntity> {
}