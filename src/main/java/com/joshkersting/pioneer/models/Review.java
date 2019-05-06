package com.joshkersting.pioneer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review extends AbstractEntity
{
    private Project project;
    private int rating;
    private String review;

    public Review()
    {
    }

    public Review(Project project, int rating, String review)
    {
        this.project = project;
        this.rating = rating;
        this.review = review;
    }

    @OneToOne
    @JoinColumn(name = "project_uid")
    @JsonBackReference
    public Project getProject()
    {
        return project;
    }
    public void setProject(Project project)
    {
        this.project = project;
    }

    @Column(name="rating")
    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    @Column(name="review")
    public String getReview()
    {
        return review;
    }
    public void setReview(String review)
    {
        this.review = review;
    }

    @Override
    public String toString()
    {
        return "Review{" + "project=" + project + ", rating=" + rating + ", review='" + review + '\'' + '}';
    }
}
