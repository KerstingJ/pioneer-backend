package com.joshkersting.pioneer.models.dao;

import com.joshkersting.pioneer.models.Contractor;
import com.joshkersting.pioneer.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProjectDao extends CrudRepository<Project, Integer>
{
    List<Project> findAll();
    List<Project> findAllByContractorOrderByCreatedDesc(Contractor c);

    Project findByUid(int uid);

}
