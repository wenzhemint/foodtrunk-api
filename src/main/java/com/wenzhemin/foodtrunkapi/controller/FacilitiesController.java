package com.wenzhemin.foodtrunkapi.controller;

import com.wenzhemin.foodtrunkapi.exception.ResourceNotFoundException;
import com.wenzhemin.foodtrunkapi.model.Facility;
import com.wenzhemin.foodtrunkapi.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacilitiesController {

    @Autowired
    FacilityRepository facilityRepository;
    @GetMapping("/facilities")
    public List<Facility> getAllFacilities(String address) {
        System.out.println("return all Facilities.");

        Pageable page = PageRequest.of(0, 20, Sort.by("locationid").ascending());

        return facilityRepository.findByAddressLike("%"+address+"%", page);
    }

    @GetMapping("/facilities/{id}")
    public Facility getFacilityById(@PathVariable(value = "id") Long fid) {
        System.out.println("return Facility by id.");
        return facilityRepository.findById(fid).orElseThrow(() -> new ResourceNotFoundException("Facility","id",fid));
    }
}
