package org.wcci.reviewsfullstack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.reviewsfullstack.repositories.ReviewRepository;

import javax.annotation.Resource;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepository;

    @RequestMapping("/reviews")
    public String displayReviews(Model model){
        model.addAttribute("reviews", reviewRepository.findAll());
        return "reviewsView";
    }
}
