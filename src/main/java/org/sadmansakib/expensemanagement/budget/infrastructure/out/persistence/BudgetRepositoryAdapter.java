package org.sadmansakib.expensemanagement.budget.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.sadmansakib.expensemanagement.budget.domain.Budget;
import org.sadmansakib.expensemanagement.budget.domain.BudgetRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
}
