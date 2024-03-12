package org.sadmansakib.expensemanagement.budget.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadmansakib.expensemanagement.shared.entity.domain.Amount;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@Slf4j
@RequiredArgsConstructor
public class BudgetUpdater {
    private final BudgetRepository budgets;

    public void updateBudgetSpent(Id budgetId, Amount amount) {
        budgets.findById(budgetId)
                .ifPresentOrElse(budget -> {
                    log.info("BudgetUpdater|updateBudgetSpent:: found budget: {}", budget);
                    budget = budget.addSpent(amount);
                    log.info("BudgetUpdater|updateBudgetSpent:: updated budget: {}", budget);
                    budgets.save(budget);
                    log.info("BudgetUpdater|updateBudgetSpent:: saved budget: {}", budget);
                }, () -> {
                    log.error("BudgetUpdater|updateBudgetSpent:: budget not found for id: {}", budgetId);
                    throw new BudgetNotFoundException(budgetId);
                });
    }
}
