package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItem;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;
import org.sadmansakib.expensemanagement.shared.persistence.domain.BaseEntity;

import java.util.Objects;
import java.util.Optional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grocery_items")
public class GroceryItemEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "quantity", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double quantity;

    @Column(name = "estimated_cost")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double estimatedCost;

    @Column(name = "system_estimated_cost")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double systemEstimatedCost;

    static GroceryItemEntity fromDomain(GroceryItem groceryItem) {
        var entity = new GroceryItemEntity();
        if (Objects.nonNull(groceryItem.id()) && Objects.nonNull(groceryItem.id().get())) {
            entity.setId(groceryItem.id().get());
        }
        entity.setName(groceryItem.name().get());
        entity.setQuantity(groceryItem.quantity().get());
        groceryItem.estimatedCost()
                .ifPresentOrElse(est -> entity.setEstimatedCost(est.get()),
                        () -> entity.setEstimatedCost(0.0));
        groceryItem.systemEstimatedCost()
                .ifPresentOrElse(est -> entity.setSystemEstimatedCost(est.get()),
                        () -> entity.setSystemEstimatedCost(0.0));
        return entity;
    }

    GroceryItem toDomain() {
        return GroceryItem.builder()
                .id(new Id(getId()))
                .name(new Name(getName()))
                .quantity(new GroceryItem.Quantity(getQuantity()))
                .estimatedCost(Optional.of(new Amount(getEstimatedCost())))
                .systemEstimatedCost(Optional.of(new Amount(getSystemEstimatedCost())))
                .build();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        GroceryItemEntity that = (GroceryItemEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return STR."\{getClass().getSimpleName()}(id = \{getId()}, name = \{getName()}, quantity = \{getQuantity()}, estimatedCost = \{getEstimatedCost()}, systemEstimatedCost = \{getSystemEstimatedCost()})";
    }
}