package org.sadmansakib.expensemanagement.category.infrastructure.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.proxy.HibernateProxy;
import org.sadmansakib.expensemanagement.category.domain.Category;
import org.sadmansakib.expensemanagement.shared.persistence.domain.BaseEntity;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "categories", indexes = {
        @Index(name = "idx_categories_budget_id", columnList = "budget_id")
})
@Slf4j
@org.jmolecules.ddd.annotation.Entity
public class CategoryEntity extends BaseEntity {
    private String name;
    private String description;
    private Double totalAllocatedAmount;
    private Double totalSpentAmount;
    private Long budgetId;

    public static CategoryEntity fromDomain(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (Objects.nonNull(category.id()) && Objects.nonNull(category.id().get())) {
            categoryEntity.setId(category.id().get());
        }
        categoryEntity.setName(category.name().get());
        categoryEntity.setDescription(category.description().get());
        categoryEntity.setTotalAllocatedAmount(category.allocated().get());
        categoryEntity.setTotalSpentAmount(category.spent().get());
        if (Objects.nonNull(category.budgetId()) && Objects.nonNull(category.budgetId().get())) {
            categoryEntity.setBudgetId(category.budgetId().get());
        }
        log.info("CategoryEntity|fromDomain:: categoryEntity: {}", categoryEntity);
        return categoryEntity;
    }

    public Category toDomain() {
        return Category.toCategory(getId(), getName(), getDescription(), getTotalAllocatedAmount(),
                getTotalSpentAmount(), getBudgetId());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CategoryEntity that = (CategoryEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "name = " + getName() + ", " +
                "description = " + getDescription() + ", " +
                "totalAllocatedAmount = " + getTotalAllocatedAmount() + ", " +
                "totalSpentAmount = " + getTotalSpentAmount() + ", " +
                "budgetId = " + getBudgetId() + ")";
    }
}