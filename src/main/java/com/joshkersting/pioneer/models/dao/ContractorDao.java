package com.joshkersting.pioneer.models.dao;

import com.joshkersting.pioneer.models.Contractor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ContractorDao extends CrudRepository<Contractor, Integer>
{
    List<Contractor> findAll();

    Contractor findByUid(int uid);
}
