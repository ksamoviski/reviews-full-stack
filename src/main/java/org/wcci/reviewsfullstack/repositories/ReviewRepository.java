package org.wcci.reviewsfullstack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.reviewsfullstack.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
