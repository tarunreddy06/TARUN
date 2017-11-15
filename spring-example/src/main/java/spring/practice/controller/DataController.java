package spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.practice.entity.Data;
import spring.practice.repository.DataRepository;

@RestController
@RequestMapping("/data")
public class DataController {
	@Autowired
	DataRepository repository;

	@RequestMapping("/save")
	public String process(){
		
		repository.save(new Data("Jack", "jack@email.com"));
		repository.save(new Data("Adam", "adam@gmail.com"));
		repository.save(new Data("Kim", "Smith@yahoo.com"));
		repository.save(new Data("David", "Dwilliams@apple.com"));
		repository.save(new Data("Peter", "peter@hotmail.com"));
		return "Done";
	
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Data cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbyEmail")
	public String fetchDataByEmail(@RequestParam("email") String email){
		String result = "<html>";
		
		for(Data cust: repository.findByEmail(email)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyName")
	public String fetchDataByName(@RequestParam("name") String name){
		String result = "<html>";
		
		for(Data cust: repository.findByName(name)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}

}
