package com.joshkersting.pioneer.controllers;

import com.joshkersting.pioneer.exceptions.ResourceNotFoundException;
import com.joshkersting.pioneer.models.Contractor;
import com.joshkersting.pioneer.models.Project;
import com.joshkersting.pioneer.models.Review;
import com.joshkersting.pioneer.models.dao.ContractorDao;
import com.joshkersting.pioneer.models.dao.ProjectDao;
import com.joshkersting.pioneer.models.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProjectsController
{
    @Autowired
    ProjectDao projectDao;
    @Autowired
    ContractorDao contractorDao;
    @Autowired
    ReviewDao reviewDao;

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects()
    {
        // create list to hold projects
        List<Project> projects = projectDao.findAll(); /*new ArrayList<>();*/

        // iterate through projects and remove contractor reference to projects
        for (Project p: projects) {
            p.getContractor().setProjects(null);
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable int projectId) throws ResourceNotFoundException
    {
        Project p = projectDao.findByUid(projectId);

        if (p == null) {
            throw new ResourceNotFoundException("Could not find project with id: " + projectId);
        }

        p.getContractor().setProjects(null);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/contractor/{contractorId}")
    public ResponseEntity<?> getContractorById(@PathVariable int contractorId) throws ResourceNotFoundException
    {
        // Get Contractor by ID
        Contractor c = contractorDao.findByUid(contractorId);

        // If we couldn't get a contractor throw exception
        if (c == null) {
            throw new ResourceNotFoundException("Could not find contractor with id: " + contractorId);
        }

        List<Project> projects = projectDao.findAllByContractorOrderByCreatedDesc(c);

        for (Project p: projects) {
            p.setContractor(null);
        }

        c.setProjects(projects);

        // put that completed contractor back
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
