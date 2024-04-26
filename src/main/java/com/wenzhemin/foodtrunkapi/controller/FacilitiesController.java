package com.wenzhemin.foodtrunkapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FacilitiesController {

    @GetMapping("/facilities")
    public String getAllFacilities() {
        return "all facilities";
    }

    @GetMapping("/facilities/{id}")
    public String getFacilityById(@PathVariable(value = "id") Long fid) {
        return "facility by id: " + fid;
    }
}
