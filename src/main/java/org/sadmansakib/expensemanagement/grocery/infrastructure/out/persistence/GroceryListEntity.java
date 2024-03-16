package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryList;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.persistence.domain.BaseEntity;

import java.time.LocalDate;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grocery_lists")
public class GroceryListEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "type", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String type;

    @Column(name = "purchase_date", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate purchaseDate;

    @Column(name = "total_paid")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double totalPaid;

    @Column(name = "estimated_cost")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double estimatedCost;

    static GroceryListEntity fromDomain(GroceryList groceryList) {
        var entity = new GroceryListEntity();
        if (Objects.nonNull(groceryList.id()) && Objects.nonNull(groceryList.id().get())) {
            entity.setId(groceryList.id().get());
        }
        entity.setName(groceryList.name().get());
        entity.setType(groceryList.type().name());
        entity.setPurchaseDate(groceryList.shoppingDate().get());
        entity.setTotalPaid(groceryList.paid().get());
        entity.setEstimatedCost(groceryList.estimated().get());
        return entity;
    }

    GroceryList toDomain() {
        return GroceryList.builder()
                .id(new Id(getId()))
                .name(new GroceryList.Name(getName()))
                .type(GroceryList.Type.valueOf(getType()))
                .paid(new Amount(getTotalPaid()))
                .estimated(new Amount(getEstimatedCost()))
                .shoppingDate(new GroceryList.Date(getPurchaseDate()))
                .build();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        GroceryListEntity that = (GroceryListEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return STR."\{getClass().getSimpleName()}(id = \{getId()}, name = \{getName()}, type = \{getType()}, purchaseDate = \{getPurchaseDate()}, totalPaid = \{getTotalPaid()}, estimatedCost = \{getEstimatedCost()})";
    }
}