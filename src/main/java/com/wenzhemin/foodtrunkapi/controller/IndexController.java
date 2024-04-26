package com.wenzhemin.foodtrunkapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        System.out.println("index consumed.");
        return "Hello and Welcome to the FoodTrunk application. You can get filtered FoodFacility info by making a GET request to /api/facilities endpoint.";
    }
}
