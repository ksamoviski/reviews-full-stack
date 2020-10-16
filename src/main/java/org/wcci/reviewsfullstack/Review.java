package org.wcci.reviewsfullstack;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String description;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public Review(){
    }

    public Review(String title, String description, Category category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
