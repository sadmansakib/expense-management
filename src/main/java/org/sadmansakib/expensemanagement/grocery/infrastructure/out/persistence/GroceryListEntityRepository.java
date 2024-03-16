package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface GroceryListEntityRepository extends JpaRepository<GroceryListEntity, Long>, JpaSpecificationExecutor<GroceryListEntity> {
}