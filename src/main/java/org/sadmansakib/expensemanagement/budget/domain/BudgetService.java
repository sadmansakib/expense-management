package org.sadmansakib.expensemanagement.budget.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.shared.entity.domain.Id;

@SecondaryPort
@Service
@RequiredArgsConstructor
@Slf4j
public class BudgetService {
    private final BudgetRepository budgets;
    public void checkBudgetExists(Id budgetId) {
        budgets.findById(budgetId)
                .orElseThrow(() -> new BudgetNotFoundException(budgetId))
        ;
    }
}
