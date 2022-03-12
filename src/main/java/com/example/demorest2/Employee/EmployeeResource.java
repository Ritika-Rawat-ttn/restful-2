package com.example.demorest2.Employee;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeResource {


    @Autowired
    private EmployeeService service;




    @GetMapping("/employee")
    @ApiOperation(
            value="get info of employee"
    )
    public List<Employee>retriveAllUsers(){

        return service.findAll();

    }



    @GetMapping("employee/{id}")
    public EntityModel<Employee> specificUser(@PathVariable int id){
        Employee one = service.findOne(id);
        if(one == null){
            throw new UserNotFoundException("id :"+id);
        }

        EntityModel<Employee> resource = EntityModel.of(one);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retriveAllUsers());

        resource.add(linkTo.withRel("all-employee"));

        return resource;

    }




    @DeleteMapping("/employee/{id}")
    @ApiOperation(
            value="delete by id"
    )
    public Employee deleteUser(@PathVariable int id) {
        Employee employee = service.deletebyId(id);
        if (employee == null) {
            throw new UserNotFoundException("id" + id);
        }
        return employee;
    }



//HATEOAS


    @PostMapping("/employee")
    @ApiOperation(value="employeedetails")
    public ResponseEntity<Object>CreateEmployee( @RequestBody Employee employee){
        Employee SavedEmployee = service.save(employee);


        //setting uri
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(SavedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();


    }


    @PutMapping("/updateid")
    public  String updateid(@RequestBody Employee employee){
        return service.updateid(employee);
    }


}
