package org.sadmansakib.expensemanagement.expense.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExpenseEntityRepository extends JpaRepository<ExpenseEntity, Long>, JpaSpecificationExecutor<ExpenseEntity> {
}