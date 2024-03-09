package org.sadmansakib.expensemanagement.category.domain;

import org.jmolecules.ddd.annotation.Repository;

import java.util.Collection;

@Repository
public interface CategoryRepository {
    Category save(Category category);
    Collection<Category> findAll();
    Collection<Category> findAllByBudgetId(Long budgetId);
}
