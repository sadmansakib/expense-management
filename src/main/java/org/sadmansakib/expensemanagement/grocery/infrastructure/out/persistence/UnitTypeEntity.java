package org.sadmansakib.expensemanagement.grocery.infrastructure.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.sadmansakib.expensemanagement.grocery.domain.GroceryItemUnit;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.sadmansakib.expensemanagement.shared.entity.domain.Name;
import org.sadmansakib.expensemanagement.shared.persistence.domain.BaseEntity;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "unit_types")
public class UnitTypeEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true, length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    static UnitTypeEntity fromDomain(GroceryItemUnit domain) {
        var entity = new UnitTypeEntity();
        entity.setName(domain.name().get());
        return entity;
    }

    GroceryItemUnit toDomain() {
        return GroceryItemUnit.builder()
                .id(new Id(getId()))
                .name(new Name(getName()))
                .build();
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UnitTypeEntity that = (UnitTypeEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return STR."\{getClass().getSimpleName()}(id = \{getId()}, name = \{getName()})";
    }
}