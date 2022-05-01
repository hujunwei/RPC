package com.msb.controller;

import com.msb.pojo.Person;
import com.msb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IBM on 2020/9/14.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/show")
    @ResponseBody
    public List<Person> show()
    {
        return personService.show();
    }
}
