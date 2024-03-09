package org.sadmansakib.expensemanagement.expense.infrastructure.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.sadmansakib.expensemanagement.expense.domain.Expense;
import org.sadmansakib.expensemanagement.shared.persistence.domain.BaseEntity;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "expenses")
public class ExpenseEntity extends BaseEntity {
    @Column(name = "description", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @Column(name = "spent_amount", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double spentAmount;

    @Column(name = "expense_date", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate date;

    private Long categoryId;

    public static ExpenseEntity fromDomain(Expense expense) {
        var entity = new ExpenseEntity();
        if (Objects.nonNull(expense.getId()) && Objects.nonNull(expense.getId().get())) {
            entity.setId(expense.getId().get());
        }
        if (Objects.nonNull(expense.getDescription()) && Objects.nonNull(expense.getDescription().get())) {
            entity.setDescription(expense.getDescription().get());
        }
        entity.setSpentAmount(expense.getAmount().get());
        entity.setDate(expense.getDate().get());
        entity.setCategoryId(expense.getCategoryId().get());
        return entity;
    }

    public Expense toDomain() {
        return Expense.toExpense(getId(), getDescription(), getSpentAmount(), getDate(), getCategoryId());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ExpenseEntity that = (ExpenseEntity) o;
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
                "description = " + getDescription() + ", " +
                "spentAmount = " + getSpentAmount() + ", " +
                "date = " + getDate() + ", " +
                "categoryId = " + getCategoryId() + ")";
    }
}