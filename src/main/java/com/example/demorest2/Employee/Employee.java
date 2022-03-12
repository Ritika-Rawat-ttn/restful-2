package com.example.demorest2.Employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Perform  Employee Class")
public class Employee {
    @ApiModelProperty(notes = "This is id.")
    private Integer id;
    @NotNull
    @Size(min = 4, message = "minimum size")
    @ApiModelProperty(notes = "Employee Name")
    private  String name;
    @Min(value=20, message="equal or greater than 20")
    @Max(value=65, message="mequal or less than 65")
    @ApiModelProperty(notes = "Age must be between 20-65")
    private  Integer age;


    //For Post making Default Construtor
    protected  Employee(){
        //No-argument Constructor

    }

    public Employee(Integer id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
