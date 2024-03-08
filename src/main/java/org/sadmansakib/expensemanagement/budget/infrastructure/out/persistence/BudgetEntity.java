package org.sadmansakib.expensemanagement.budget.infrastructure.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;
import org.sadmansakib.expensemanagement.budget.domain.Budget;

import java.util.Objects;
import java.util.function.UnaryOperator;

@Getter
@Setter
@Table(name = "budgets", indexes = {
        @Index(name = "idx_budgets_month_year", columnList = "month, year")
})
@Entity
@jakarta.persistence.Entity
public class BudgetEntity{

    @Id
    @Identity
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budgets_gen")
    @SequenceGenerator(name = "budgets_gen", sequenceName = "budgets_seq")
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "allocated_amount", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double allocated;

    @Column(name = "total_spent_amount")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double spent;

    @Column(name = "month", nullable = false, length = 10)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String month;

    @Column(name = "year")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer year;

    public static BudgetEntity fromDomain(Budget budget) {
        BudgetEntity budgetEntity = new BudgetEntity();
        if (Objects.nonNull(budget.id()) && Objects.nonNull(budget.id().get())) {
            budgetEntity.setId(budget.id().get());
        }
        budgetEntity.setAllocated(budget.allocated().get());
        budgetEntity.setSpent(budget.spent().get());
        budgetEntity.setMonth(budget.month().get());
        budgetEntity.setYear(budget.year().get());
        return budgetEntity;
    }

    public Budget toDomain() {
        return Budget.toBudget(getId(), getAllocated(), getSpent(), getMonth(), getYear());
    }

    public BudgetEntity then(UnaryOperator<BudgetEntity> operator) {
        return operator.apply(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        BudgetEntity that = (BudgetEntity) o;
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
                "allocatedAmount = " + getAllocated() + ", " +
                "totalSpentAmount = " + getSpent() + ", " +
                "month = " + getMonth() + ", " +
                "year = " + getYear() + ")";
    }
}