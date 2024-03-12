package org.sadmansakib.expensemanagement.budget.application;

import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.budget.domain.*;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Port
@Service
@Slf4j
@Component
public class BudgetManagement {
    private final BudgetRepository budgets;
    private final BudgetCreator creator;

    private final BudgetUpdater updater;

    public BudgetManagement(BudgetRepository budgets) {
        this.budgets = budgets;
        creator = new BudgetCreator(budgets);
        updater = new BudgetUpdater(budgets);
    }

    public Budget create(BudgetCreator.BudgetToCreate budgetToCreate) {
        log.info("BudgetManagement|create:: budgetToCreate: {}", budgetToCreate);
        var createdBudget = creator.create(budgetToCreate);
        log.info("BudgetManagement|create:: createdBudget: {}", createdBudget);
        return createdBudget;
    }

    public Budgets history() {
        return new Budgets(budgets.findAll());
    }

    @ApplicationModuleListener
    @Async
    public void on(BudgetSpent event){
        log.info("BudgetManagement|on:: received event: {}", event);
        updater.updateBudgetSpent(event.budgetId(), event.spentAmount());
    }
}
