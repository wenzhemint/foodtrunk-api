package com.wenzhemin.foodtrunkapi.controller;

import com.wenzhemin.foodtrunkapi.exception.ResourceNotFoundException;
import com.wenzhemin.foodtrunkapi.model.Facility;
import com.wenzhemin.foodtrunkapi.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacilitiesController {

    @Autowired
    FacilityRepository facilityRepository;
    @GetMapping("/facilities")
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @GetMapping("/facilities/{id}")
    public Facility getFacilityById(@PathVariable(value = "id") Long fid) {
        return facilityRepository.findById(fid).orElseThrow(() -> new ResourceNotFoundException("Facility","id",fid));
    }
}