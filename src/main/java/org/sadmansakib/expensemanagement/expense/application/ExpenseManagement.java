package org.sadmansakib.expensemanagement.expense.application;

import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.category.domain.CategoryService;
import org.sadmansakib.expensemanagement.expense.domain.Expense;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseCreator;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseEventPublisher;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
@Slf4j
@Port
@Transactional
public class ExpenseManagement {
    private final ExpenseCreator creator;
    private final ExpenseRepository expenses;

    public ExpenseManagement(ExpenseRepository expenses, CategoryService categories, ExpenseEventPublisher publisher) {
        this.expenses = expenses;
        creator = new ExpenseCreator(expenses, categories, publisher);
    }

    public Expense create(ExpenseCreator.ExpenseToCreate expenseToCreate) {
        log.info("ExpenseManagement|create:: expenseToCreate: {}", expenseToCreate);
        return creator.create(expenseToCreate);
    }
}
