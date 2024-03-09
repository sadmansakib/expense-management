package org.sadmansakib.expensemanagement.expense.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.expense.domain.Expense;
import org.sadmansakib.expensemanagement.expense.domain.ExpenseRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SecondaryAdapter
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
@Component
public class ExpenseEntityAdapter implements ExpenseRepository {
    private final ExpenseEntityRepository expenses;

    @Override
    public Expense save(Expense expense) {
        log.info("ExpenseEntityAdapter|save:: expense: {}", expense);
        var entity = ExpenseEntity.fromDomain(expense);
        log.info("ExpenseEntityAdapter|save:: converted to entity: {}", entity);
        entity = expenses.save(entity);
        log.info("ExpenseEntityAdapter|save:: saved entity: {}", entity);
        return entity.toDomain();
    }
}
