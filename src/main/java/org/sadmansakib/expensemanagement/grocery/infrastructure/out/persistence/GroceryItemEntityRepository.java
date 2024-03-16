package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemEntityRepository extends JpaRepository<GroceryItemEntity, Long>, JpaSpecificationExecutor<GroceryItemEntity> {
}