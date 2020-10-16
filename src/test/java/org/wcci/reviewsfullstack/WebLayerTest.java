package org.wcci.reviewsfullstack;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.reviewsfullstack.repositories.CategoryRepository;
import org.wcci.reviewsfullstack.repositories.ReviewRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ReviewRepository reviewRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void categoriesShouldBeOkAndReturnCategoriesViewWithCategoriesModelAttribute() throws Exception{
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect( view().name("categoriesView"))
                .andExpect((model().attributeExists("categories")));
    }

    @Test
    public void reviewsShouldBeOkAndReturnReviewsViewWithReviewsModelAttribute() throws Exception{
        mockMvc.perform(get("/reviews"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect( view().name("reviewsView"))
                .andExpect((model().attributeExists("reviews")));
    }
}
