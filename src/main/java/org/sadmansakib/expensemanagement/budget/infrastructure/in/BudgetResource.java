package org.sadmansakib.expensemanagement.budget.infrastructure.in;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.sadmansakib.expensemanagement.budget.application.BudgetManagement;
import org.sadmansakib.expensemanagement.shared.response.domain.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@PrimaryAdapter
@RequestMapping("/api/v1/budgets")
@RequiredArgsConstructor
@Slf4j
public class BudgetResource {
    private final BudgetManagement budgetManagement;

    @PostMapping
    public ResponseEntity<RestResponse<RestBudget>> create(@RequestBody RestBudgetToCreate restBudgetToCreate) {
        log.info("BudgetResource|create:: restBudgetToCreate: {}", restBudgetToCreate);
        var createdBudget = budgetManagement.create(restBudgetToCreate.toDomain());
        log.info("BudgetResource|create:: createdBudget: {}", createdBudget);
        return ResponseEntity.created(
                URI.create("/api/v1/budgets/" + createdBudget.id().get())
        ).body(RestResponse.created(RestBudget.from(createdBudget), "Budget created successfully"));
    }
}
