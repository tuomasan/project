package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository repository;
	
	@RequestMapping("/students")
    public Iterable<Student> student(@RequestParam(value="name", defaultValue="World") String name) {
        return repository.findAll();
    }
	
	@RequestMapping(value = "/student" , method = RequestMethod.POST)
    public @ResponseBody Student addStudent(@RequestBody Student jsonStudent) {
    	repository.save(jsonStudent);
        return jsonStudent;
    }  	
    
    @RequestMapping(value = "/student" , method = RequestMethod.DELETE)
    public void deleteStudent(@RequestBody Student jsonStudent) {
    	repository.delete(jsonStudent);
    }      
    
    @RequestMapping(value = "/student" , method = RequestMethod.PUT)
    public @ResponseBody Student updateStudent(@RequestBody Student jsonStudent) {
    	repository.save(jsonStudent);
    	return jsonStudent;
    } 
    
    
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Student get(@RequestParam(value="id", defaultValue="1") int id){
    	return repository.findOne(id);
} 

}
