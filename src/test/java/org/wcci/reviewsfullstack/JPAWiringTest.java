package org.wcci.reviewsfullstack;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void categoryShouldHaveAListOfReviews(){
        Category testCategory = new Category("Test Category");
        Category testCategory2 = new Category("Test Category2");
        Review testReview = new Review("Title", "Description", testCategory);
        Review testReview2 = new Review("Title", "Description", testCategory2);

        categoryRepository.save(testCategory);
        categoryRepository.save(testCategory2);
        reviewRepository.save(testReview);
        reviewRepository.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepository.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        assertThat(retrievedCategory.getReviews()).contains(testReview);
    }
}

