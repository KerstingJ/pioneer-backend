package com.joshkersting.pioneer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="projects")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
public class Project extends AbstractEntity
{
    private Contractor contractor;
    private List<String> images, tags;
    private String location, client, details;
    private Review review;

    public Project()
    {
    }

    public Project(Contractor contractor, String client, String location, List<String> tags)
    {
        this.contractor = contractor;
        this.client = client;
        this.location = location;
        this.tags = tags;
    }

    @ManyToOne
    @JoinColumn(name="contractor_uid")
    public Contractor getContractor()
    {
        return contractor;
    }
    public void setContractor(Contractor contractor)
    {
        this.contractor = contractor;
    }

    @ElementCollection
    @CollectionTable(name = "project_images", joinColumns = @JoinColumn(name = "project_uid"))
    @Column(name = "image")
    public List<String> getImages()
    {
        return images;
    }
    public void setImages(List<String> images)
    {
        this.images = images;
    }

    @ElementCollection
    @CollectionTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_uid"))
    @Column(name = "tag")
    public List<String> getTags()
    {
        return tags;
    }
    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    @Column(name="location")
    public String getLocation()
    {
        return location;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    @Column(name="client")
    public String getClient()
    {
        return client;
    }
    public void setClient(String client)
    {
        this.client = client;
    }

    @Column(name="details")
    public String getDetails()
    {
        return details;
    }
    public void setDetails(String details)
    {
        this.details = details;
    }

    @OneToOne(mappedBy="project")
    @JsonIdentityReference
    public Review getReview()
    {
        return review;
    }
    public void setReview(Review review)
    {
        this.review = review;
    }

    @Override
    public String toString()
    {
        return "Project{" + "contractor=" + contractor + ", images=" + images + ", tags=" + tags + ", location='" + location + '\'' + ", client='" + client + '\'' + ", details='" + details + '\'' + ", review=" + review + '}';
    }
}
