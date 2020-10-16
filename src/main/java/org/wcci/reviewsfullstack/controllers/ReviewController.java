package org.wcci.reviewsfullstack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.reviewsfullstack.models.Review;
import org.wcci.reviewsfullstack.repositories.ReviewRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepository;

    @RequestMapping("/reviews")
    public String displayReviews(Model model){
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviewsView";
    }

    @RequestMapping("/reviews/{id}")
    public String displaySingleReview(@PathVariable long id, Model model){
        Optional<Review> retrievedReview = reviewRepository.findById(id);
        Review foundReview = retrievedReview.get();
        model.addAttribute("review", foundReview);
        return "reviewView";
    }

}
