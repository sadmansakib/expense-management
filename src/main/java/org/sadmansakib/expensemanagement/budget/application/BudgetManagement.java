package org.sadmansakib.expensemanagement.budget.application;

import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Port;
import org.sadmansakib.expensemanagement.budget.domain.Budget;
import org.sadmansakib.expensemanagement.budget.domain.BudgetCreator;
import org.sadmansakib.expensemanagement.budget.domain.BudgetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Port
@Service
@Slf4j
@Component
public class BudgetManagement {
    private final BudgetRepository budgets;
    private final BudgetCreator creator;

    public BudgetManagement(BudgetRepository budgets) {
        this.budgets = budgets;
        creator = new BudgetCreator(budgets);
    }

    public Budget create(BudgetCreator.BudgetToCreate budgetToCreate) {
        log.info("BudgetManagement|create:: budgetToCreate: {}", budgetToCreate);
        var createdBudget = creator.create(budgetToCreate);
        log.info("BudgetManagement|create:: createdBudget: {}", createdBudget);
        return createdBudget;
    }
}
