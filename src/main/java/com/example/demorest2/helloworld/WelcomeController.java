package com.example.demorest2.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.MessageSource;

import java.util.Locale;


//Controller
@RestController
public class WelcomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/welcome" )
    public String Welcome(){
        
        return "Welcome to Spring boot";
    }

    @GetMapping(path = "/helloworld-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Welcome to Spring boot");
    }

    ///hello-world/path-variable
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }






//    @GetMapping(path = "/hello-world-internationalized")
//    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
//       return messageSource.getMessage("good.morning.message",
//               null, LocaleContextHolder.getLocale());
//    }

    @GetMapping(path = "/welcome-internationalized")           //mapping Get request for the method to URI
    public String getWelcomeInternationalized(){
        return messageSource.getMessage("good.morning.message",null,
                LocaleContextHolder.getLocale());

    }

}
