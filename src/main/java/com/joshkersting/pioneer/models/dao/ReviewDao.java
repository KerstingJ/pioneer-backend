package com.joshkersting.pioneer.models.dao;

import com.joshkersting.pioneer.models.Project;
import com.joshkersting.pioneer.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ReviewDao extends CrudRepository<Review, Integer>
{
    List<Review> findAll();
    Review findByProject(Project p);
    Review findByUid(int uid);
}
