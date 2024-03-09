package org.sadmansakib.expensemanagement.category.infrastructure.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.sadmansakib.expensemanagement.category.domain.Category;
import org.sadmansakib.expensemanagement.category.domain.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@SecondaryAdapter
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {
    private final CategoryEntityRepository categories;
    @Override
    public Category save(Category category) {
        log.info("CategoryRepositoryAdapter|save:: category: {}", category);
        var entity = CategoryEntity.fromDomain(category);
        log.info("CategoryRepositoryAdapter|save:: converted to entity: {}", entity);
        entity = categories.save(entity);
        log.info("CategoryRepositoryAdapter|save:: saved entity: {}", entity);
        return entity.toDomain();
    }

    @Override
    public Collection<Category> findAll() {
        return categories.findAll()
                .stream()
                .map(CategoryEntity::toDomain)
                .toList();
    }
}
