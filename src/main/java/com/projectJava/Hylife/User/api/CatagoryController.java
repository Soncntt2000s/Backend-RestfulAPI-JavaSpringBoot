package com.projectJava.Hylife.User.api;


import com.projectJava.Hylife.User.entity.Catagories;
import com.projectJava.Hylife.User.service.CatagoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/categories")
public class CatagoryController {

    @Autowired
    CatagoryServiceImpl catagoryService;

    @GetMapping("/")
    @PreAuthorize("hasRole('USER') or hasRole('USER')")
    public List<Catagories> getAll(){
        return catagoryService.getAllCategory();
    }
}
