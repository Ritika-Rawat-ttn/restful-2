package com.example.demorest2.Filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringControlleer {


    @GetMapping("/Filtering1")
    public SomeBean retriveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }


    @GetMapping("/filtering-list1")
       public List<SomeBean> retrieveListOfSomeBeans(){
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));
   }



}
