package org.sadmansakib.expensemanagement.budget.application;

import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.budget.domain.BudgetRepository;
import org.sadmansakib.expensemanagement.budget.domain.BudgetService;
import org.springframework.stereotype.Component;

@Component
@Service
public class BudgetApplicationService extends BudgetService {
    public BudgetApplicationService(BudgetRepository budgets) {
        super(budgets);
    }
}
