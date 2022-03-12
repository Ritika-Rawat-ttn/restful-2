package com.example.demorest2.Employee;


import org.springframework.stereotype.Component;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

//Service to perform diffferent operation related to employee
//Q-2
@Component
public class EmployeeService {
    private static List<Employee> employees=new ArrayList<>();
    private static int employeesCount=3;
    static {
        employees.add((new Employee(1,"Ritika",22)));
        employees.add((new Employee(2,"Som",23)));
        employees.add((new Employee(3,"Ayushi",24)));
        employees.add((new Employee(4,"Vritika",25)));

    }
    public List<Employee> findAll(){
        return employees;
    }
    public Employee save(Employee employee){
        if(employee.getId()==null){
            employee.setId(++employeesCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee findOne(int id) {
        for (Employee employee:employees){
            if(employee.getId()==id){
                return employee;
            }
        }
        return null;
    }

    //Deleting element Q-7
    public Employee deletebyId(int id) {
        Iterator<Employee> iterator=employees.iterator();
        while(iterator.hasNext()){
            Employee employee= iterator.next();
            if(employee.getId()==id){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }

    //For put request Q-8
    public String updateid(Employee employee) {
        //exist in the employye -yes else nob


        boolean resourceFound=false;
        for (Employee employees:employees){
            if(employee.getId()==employee.getId()){
                employee.setId(employee.getId());
                employee.setName(employee.getName());
                employee.setAge(employee.getAge());
            }
        }
        if (!resourceFound){
            employees.add(new Employee());
            return "yo";
        }
        return "item updated sucessfully";
    }
}