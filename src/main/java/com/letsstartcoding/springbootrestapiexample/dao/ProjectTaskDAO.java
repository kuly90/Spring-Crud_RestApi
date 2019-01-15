package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.ProjectTask;
import com.letsstartcoding.springbootrestapiexample.repository.ProjectTaskRepository;

@Service
public class ProjectTaskDAO {

	@Autowired
	ProjectTaskRepository projectTaskRepository;
	
	//to save a Project task
	public ProjectTask save(ProjectTask proTask) {
		return projectTaskRepository.save(proTask);
	}
	
	//search all Project task
	public List<ProjectTask> findAll(){
		
		return projectTaskRepository.findAll();
	}
	
	//search projectTask by id
	public ProjectTask findOne(Long id) {
		
		return projectTaskRepository.findOne(id);
	}
	
	//delete project Task by id
	public void delete(ProjectTask protask) {
		
		projectTaskRepository.delete(protask);
	}
}
