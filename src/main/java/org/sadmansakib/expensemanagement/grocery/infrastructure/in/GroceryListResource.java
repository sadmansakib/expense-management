package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadmansakib.expensemanagement.grocery.application.GroceryListManagement;
import org.sadmansakib.expensemanagement.shared.response.domain.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/grocery-lists")
@RequiredArgsConstructor
@Slf4j
public class GroceryListResource {
    private final GroceryListManagement groceries;

    @PostMapping
    public ResponseEntity<RestResponse<RestGroceryList>> create(@RequestBody @Valid RestGroceryListToCreate toCreate) {
        log.info("GroceryListResource|create:: create request: {}", toCreate);
        var grocery = groceries.create(toCreate.toDomain());
        log.info("GroceryListResource|create:: created grocery: {}", grocery);
        return ResponseEntity.created(
                URI.create(STR."/api/v1/grocery-lists/\{grocery.getId().get()}")
        ).body(RestResponse.created(RestGroceryList.from(grocery), "Grocery created successfully"));
    }

    @GetMapping
    public ResponseEntity<RestResponse<RestGroceryLists>> history() {
        log.info("GroceryListResource|history:: fetching all grocery lists");
        var groceryLists = groceries.history();
        return ResponseEntity.ok(RestResponse.ok(RestGroceryLists.from(groceryLists)));
    }
}
