package org.sadmansakib.expensemanagement.category.domain;

import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface CategoryRepository {
    Category save(Category category);
}
