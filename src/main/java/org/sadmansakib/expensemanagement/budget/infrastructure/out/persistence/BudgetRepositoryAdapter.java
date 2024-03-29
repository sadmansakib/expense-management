package org.sadmansakib.expensemanagement.budget.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.sadmansakib.expensemanagement.budget.domain.Budget;
import org.sadmansakib.expensemanagement.budget.domain.BudgetRepository;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BudgetRepositoryAdapter implements BudgetRepository {
    private final BudgetEntityRepository budgets;

    @Override
    public Budget save(Budget budget) {
        var entity = BudgetEntity.fromDomain(budget)
                .then(budgets::save);
        log.info("BudgetRepositoryAdapter|save:: entity: {}", entity);
        return entity.toDomain();
    }

    @Override
    public Optional<Budget> findByMonthAndYear(Budget.Month month, Budget.Year year) {
        return Optional.empty();
    }

    @Override
    public Optional<Budget> findById(Id id) {
        return budgets.findById(id.get())
                .map(BudgetEntity::toDomain);
    }

    @Override
    public Collection<Budget> findAll() {
        return budgets.findAll()
                .stream()
                .map(BudgetEntity::toDomain)
                .toList();
    }
}
