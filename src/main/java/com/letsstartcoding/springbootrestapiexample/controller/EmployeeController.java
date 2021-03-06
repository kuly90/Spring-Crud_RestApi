package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.dao.ProjectTaskDAO;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.model.ProjectTask;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	ProjectTaskDAO projectTaskDAO;
	
	//to save an employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		
		return employeeDAO.save(emp);
	}
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	//get employee by empid
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid){
		
		Employee employee = employeeDAO.findOne(empid);
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(employee);
	}
	
	// update an employee by id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid, @Valid @RequestBody Employee empDetail){
		
		Employee emp = employeeDAO.findOne(empid);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetail.getName());
		emp.setDesignation(empDetail.getDesignation());
		emp.setExpertise(empDetail.getExpertise());
		
		employeeDAO.save(emp);
		
		return ResponseEntity.ok().body(emp);
	}
	
	// Delete an employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> delete(@PathVariable(value="id") Long empid){
		
		Employee emp = employeeDAO.findOne(empid);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().body(emp);
	}
	
	// Project Task
	
	//to save an project task
		@PostMapping("/board")
		public ProjectTask createProjectTask(@Valid @RequestBody ProjectTask pro) {
			
			return projectTaskDAO.save(pro);
		}
		
		//get all Project Task
		@GetMapping("/board")
		public List<ProjectTask> getAllProjectTask(){
			
			return projectTaskDAO.findAll();
		}
		
		//get a project Task by id
		@GetMapping("/board/{id}")
		public ResponseEntity<ProjectTask> getProjectTaskById(@PathVariable(value="id") Long proId){
			
			ProjectTask projectTask = projectTaskDAO.findOne(proId);
			if(projectTask == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(projectTask);
				
		}
		
		//update a projectTask
		@PutMapping("/board/{id}")
		public ResponseEntity<ProjectTask> updateProjectTask(@PathVariable(value="id") Long proId, @Valid @RequestBody ProjectTask protaskDetail){
			
			ProjectTask projectTask = projectTaskDAO.findOne(proId);
			if(projectTask == null) {
				return ResponseEntity.notFound().build();
			}
			projectTask.setSummary(protaskDetail.getSummary());
			projectTask.setAcceptanceCriteria(protaskDetail.getAcceptanceCriteria());
			projectTask.setStatus(protaskDetail.getStatus());
			projectTaskDAO.save(protaskDetail);
			
			return ResponseEntity.ok().body(projectTask);
		}
		
		//delete a projectTask
		@DeleteMapping("/board/{id}")
		public ResponseEntity<ProjectTask> deleteProjectTask(@PathVariable(value="id") Long proId){
			
			ProjectTask projectTask = projectTaskDAO.findOne(proId);
			if(projectTask == null) {
				return ResponseEntity.notFound().build();
			}
			projectTaskDAO.delete(projectTask);
			
			return ResponseEntity.ok().body(projectTask);
		}
	
}
