package org.sadmansakib.expensemanagement.category.infrastructure.in;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.sadmansakib.expensemanagement.category.application.CategoryManagement;
import org.sadmansakib.expensemanagement.shared.response.domain.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/categories")
@Slf4j
@RequiredArgsConstructor
@PrimaryAdapter
public class CategoryResource {
    private final CategoryManagement categories;

    @PostMapping
    ResponseEntity<RestResponse<RestCategory>> create(@RequestBody @Valid RestCategoryToCreate categoryToCreate) {
        log.info("CategoryResource|create:: categoryToCreate: {}", categoryToCreate);
        var category = categories.create(categoryToCreate.toDomain());
        log.info("CategoryResource|create:: created category: {}", category);
        return ResponseEntity.created(URI.create("/api/v1/categories/" + category.id().get()))
                .body(RestResponse.created(RestCategory.from(category), "Category created successfully"));
    }
}
