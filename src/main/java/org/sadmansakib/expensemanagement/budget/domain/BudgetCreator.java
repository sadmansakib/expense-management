package org.sadmansakib.expensemanagement.budget.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;

@RequiredArgsConstructor
@Slf4j
@SecondaryPort
public class BudgetCreator {
    private final BudgetRepository budgets;

    public Budget create(BudgetToCreate budgetToCreate) {
        budgets.findByMonthAndYear(budgetToCreate.month(), budgetToCreate.year())
                .ifPresent(existingBudget -> {
                    log.error("BudgetCreator|create:: Budget already exists for month: {} & year: {}",
                            existingBudget.month().get(), existingBudget.year().get());
                    throw new BudgetAlreadyExistsException(existingBudget.month(), existingBudget.year());
                });

        Budget budget = budgetToCreate.create();
        log.info("BudgetCreator|create:: Creating budget: {}", budget);
        return budgets.save(budget);
    }

    public record BudgetToCreate(Amount totalAllocatedAmount, Budget.Month month, Budget.Year year) {
        public Budget create() {
            return Budget.builder()
                    .allocated(totalAllocatedAmount)
                    .spent(Amount.zero())
                    .month(month)
                    .year(year)
                    .build();
        }
    }
}
