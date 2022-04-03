package com.example.demo.controller;

import com.example.demo.interfaces.iOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/option")
public class OptionsController {

    @Autowired
    iOptionService optionsService;
}
