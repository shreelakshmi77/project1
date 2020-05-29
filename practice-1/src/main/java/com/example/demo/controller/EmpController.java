package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.emprepo;
import com.example.demo.model.Employee;

import antlr.collections.List;

@RestController
public class EmpController {
	
	@Autowired
	emprepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@PostMapping("/addemp")
	public Employee add(@RequestBody Employee emp)
	{
		repo.save(emp);
		return emp;
	}
	@PutMapping("/upsert")
	public Employee update(@RequestBody Employee emp)
	{
		repo.save(emp);
		return emp;
	}
	@DeleteMapping("emp/{Id}")
	public String delete(@PathVariable("Id") int id) {
		
	Employee emp = repo.getOne(id);
	repo.delete(emp);
	return emp.toString()+" is deleted";
	}
	@RequestMapping("/emp/{Id}")
	public Optional<Employee> getemp(@PathVariable("Id") int id)
	{
		
		return repo.findById(id);
	}
	@GetMapping("/employees")
	public java.util.List<Employee> getemployees()
	{
		
		return repo.findAll();
	}
}
