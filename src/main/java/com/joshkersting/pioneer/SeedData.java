package com.joshkersting.pioneer;

import com.joshkersting.pioneer.models.Contractor;
import com.joshkersting.pioneer.models.Project;
import com.joshkersting.pioneer.models.Review;
import com.joshkersting.pioneer.models.dao.ContractorDao;
import com.joshkersting.pioneer.models.dao.ProjectDao;
import com.joshkersting.pioneer.models.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SeedData
{
    @Autowired
    ProjectDao projectDao;
    @Autowired
    ContractorDao contractorDao;
    @Autowired
    ReviewDao reviewDao;

    @EventListener
    public void seed(ContextRefreshedEvent event){

        Contractor c1 = new Contractor("Roofing Guys", "Roofing@Guys.com");
        c1.setAddress("Cityville, US");
        c1.setPhone(123_456_7890L);
        c1.setWebsiteUrl("awesomeWebsite.com");

        Contractor c2 = new Contractor("Flooring Guys", "Flooring@Guys.com");
        c2.setAddress("Cityville, US");
        c2.setPhone(231_654_7990L);
        c2.setWebsiteUrl("adifferent.com");

        contractorDao.save(c1);
        contractorDao.save(c2);

        Project p1 = new Project(c1, "Jane Doe", "Townville, US",  Arrays.asList("Roofing", "Remodel", "Tin Shingle"));
        p1.setImages(Arrays.asList("imgs/333.jpeg", "imgs/333_2.jpeg", "imgs/simpleColorScheme.jpeg"));
        p1.setDetails("This is just a long blob of text that details all the stuff i want to say about the project. where it was, what all we did, maybe materials we use, etc");

        Project p2 = new Project(c1, "Jimmy John", "Townville, US",  Arrays.asList("Roofing", "Remodel", "add on"));
        p2.setImages(Arrays.asList("imgs/333.jpeg", "imgs/333_2.jpeg", "imgs/simpleColorScheme.jpeg"));
        p2.setDetails("This is just a long blob of text that details all the stuff i want to say about the project. where it was, what all we did, maybe materials we use, etc");

        Project p3 = new Project(c1, "Yvette Johnson", "Townville, US",  Arrays.asList("Roofing", "Remodel", "reshingle"));
        p3.setImages(Arrays.asList("imgs/333.jpeg", "imgs/333_2.jpeg", "imgs/simpleColorScheme.jpeg"));
        p3.setDetails("This is just a long blob of text that details all the stuff i want to say about the project. where it was, what all we did, maybe materials we use, etc");

        projectDao.saveAll(Arrays.asList(p1, p2, p3));

        Review r4p1 = new Review(p1, 4, "Was really professional and amazing to work with. Answered all of my questions in a way that made me feel completely comfortable spending so much money. Completely worth it.");
        Review r4p2 = new Review(p2, 5, "Was really professional and amazing to work with. Answered all of my questions in a way that made me feel completely comfortable spending so much money. Completely worth it.");
        Review r4p3 = new Review(p3, 3, "Was really professional and amazing to work with. Answered all of my questions in a way that made me feel completely comfortable spending so much money. Completely worth it.");

        reviewDao.saveAll(Arrays.asList(r4p1, r4p2, r4p3));

        Project p4 = new Project(c2, "Mark Yarkel", "Townville, US",  Arrays.asList("Flooring", "Kitchen", "Tile"));
        p4.setImages(Arrays.asList("imgs/333.jpeg", "imgs/333_2.jpeg", "imgs/simpleColorScheme.jpeg"));
        p4.setDetails("This is just a long blob of text that details all the stuff i want to say about the project. where it was, what all we did, maybe materials we use, etc");

        Project p5 = new Project(c2, "Amir Abdimatellib", "Townville, US",  Arrays.asList("Flooring", "Bathroom", "Tile"));
        p5.setImages(Arrays.asList("imgs/333.jpeg", "imgs/333_2.jpeg", "imgs/simpleColorScheme.jpeg"));
        p5.setDetails("This is just a long blob of text that details all the stuff i want to say about the project. where it was, what all we did, maybe materials we use, etc");

        Project p6 = new Project(c2, "Jon Jon", "Townville, US",  Arrays.asList("Flooring", "Carpet", "Remodel"));
        p6.setImages(Arrays.asList("imgs/333.jpeg", "imgs/333_2.jpeg", "imgs/simpleColorScheme.jpeg"));
        p6.setDetails("This is just a long blob of text that details all the stuff i want to say about the project. where it was, what all we did, maybe materials we use, etc");

        projectDao.saveAll(Arrays.asList(p4, p5, p6));

        Review r4p4 = new Review(p4, 4, "Was really professional and amazing to work with. Answered all of my questions in a way that made me feel completely comfortable spending so much money. Completely worth it.");
        Review r4p5 = new Review(p5, 5, "Was really professional and amazing to work with. Answered all of my questions in a way that made me feel completely comfortable spending so much money. Completely worth it.");
        Review r4p6 = new Review(p6, 2, "Was really professional and amazing to work with. Answered all of my questions in a way that made me feel completely comfortable spending so much money. Completely worth it.");

        reviewDao.saveAll(Arrays.asList(r4p4, r4p5, r4p6));

    }
}

