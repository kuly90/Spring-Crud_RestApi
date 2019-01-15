package com.letsstartcoding.springbootrestapiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.letsstartcoding.springbootrestapiexample.model.ProjectTask;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long>{

}
