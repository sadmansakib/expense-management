package org.sadmansakib.expensemanagement.grocery.infrastructure.in;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sadmansakib.expensemanagement.grocery.application.GroceryItemUnitManagement;
import org.sadmansakib.expensemanagement.shared.response.domain.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/grocery/units")
@Slf4j
@RequiredArgsConstructor
public class GroceryItemUnitResource {
    private final GroceryItemUnitManagement units;

    @PostMapping
    public ResponseEntity<RestResponse<RestGroceryItemUnit>> create(RestGroceryItemUnitToCreate create) {
        log.info("GroceryItemUnitResource|create:: create: {}", create);
        var domain = units.create(create.toDomain());
        log.info("GroceryItemUnitResource|create:: created domain: {}", domain);
        return ResponseEntity.created(URI.create(STR."/api/grocery/units/\{domain.getId().get()}"))
                .body(RestResponse.created(RestGroceryItemUnit.fromDomain(domain),
                        "Grocery item unit created successfully"));
    }

    @GetMapping
    public ResponseEntity<RestResponse<RestGroceryItemUnits>> all() {
        log.info("GroceryItemUnitResource|all:: fetching all grocery item units");
        var items = units.all();
        return ResponseEntity.ok(RestResponse.ok(RestGroceryItemUnits.fromDomain(items)));
    }
}
