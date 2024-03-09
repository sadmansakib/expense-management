package org.sadmansakib.expensemanagement.category.domain;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryPort;
import org.jmolecules.ddd.annotation.Service;

@SecondaryPort
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categories;

    public Category findById(Long id) {
        return categories.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
