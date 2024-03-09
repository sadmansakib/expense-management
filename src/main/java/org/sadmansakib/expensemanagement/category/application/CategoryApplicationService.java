package org.sadmansakib.expensemanagement.category.application;

import org.jmolecules.ddd.annotation.Service;
import org.sadmansakib.expensemanagement.category.domain.CategoryRepository;
import org.sadmansakib.expensemanagement.category.domain.CategoryService;
import org.springframework.stereotype.Component;

@Service
@Component
public class CategoryApplicationService extends CategoryService {
    public CategoryApplicationService(CategoryRepository categories) {
        super(categories);
    }
}
