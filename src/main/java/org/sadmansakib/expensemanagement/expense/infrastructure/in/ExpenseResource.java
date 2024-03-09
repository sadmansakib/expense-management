package org.sadmansakib.expensemanagement.expense.infrastructure.in;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.sadmansakib.expensemanagement.expense.application.ExpenseManagement;
import org.sadmansakib.expensemanagement.shared.response.domain.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
@Slf4j
@PrimaryPort
public class ExpenseResource {
    private final ExpenseManagement expenses;

    @PostMapping
    ResponseEntity<RestResponse<RestExpense>> create(@RequestBody @Valid RestExpenseToCreate expenseToCreate) {
        log.info("ExpenseResource|create:: expenseToCreate: {}", expenseToCreate);
        var expense = expenses.create(expenseToCreate.toDomain());
        log.info("ExpenseResource|create:: created expense: {}", expense);
        return ResponseEntity.created(URI.create("/api/v1/expenses/" + expense.getId().get()))
                .body(RestResponse.created(RestExpense.from(expense), "Expense created successfully"));
    }
}
