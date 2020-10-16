package org.wcci.reviewsfullstack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.reviewsfullstack.models.Category;
import org.wcci.reviewsfullstack.models.Review;
import org.wcci.reviewsfullstack.repositories.CategoryRepository;
import org.wcci.reviewsfullstack.repositories.ReviewRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {

        Category art = new Category("Art");
        categoryRepository.save(art);

        Category music = new Category("Music");
        categoryRepository.save(music);

        Category culture = new Category("Culture");
        categoryRepository.save(culture);

        Review zineZenith = new Review("Zine Zinith"," Short description", culture);
        reviewRepository.save(zineZenith);

        Review gaunt = new Review("Gaunt: Bricks and Blackouts", "Short description", music);
        reviewRepository.save(gaunt);

        Review hiveMindHolyShroud = new Review("Hive Mind, Holy Shroud", "Short description", art);
        reviewRepository.save(hiveMindHolyShroud);
    }
}
