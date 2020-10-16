package org.wcci.reviewsfullstack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.reviewsfullstack.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByCategoryType(String category);
}
