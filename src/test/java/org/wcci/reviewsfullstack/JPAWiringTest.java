package org.wcci.reviewsfullstack;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryShouldHaveAListOfReviews(){
        Category testCategory = new Category("Test Category");
        Review testReview1 = new Review("Title", "Description", testCategory);

    }
}

