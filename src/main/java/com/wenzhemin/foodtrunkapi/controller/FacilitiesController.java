package com.wenzhemin.foodtrunkapi.controller;

import com.wenzhemin.foodtrunkapi.exception.ResourceNotFoundException;
import com.wenzhemin.foodtrunkapi.model.Facility;
import com.wenzhemin.foodtrunkapi.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/facilities")
public class FacilitiesController {

    @Autowired
    FacilityRepository facilityRepository;

    @GetMapping
    public Page<Facility> getAllFacilities(
            @RequestParam(required = false, defaultValue = "1") String page,
            @RequestParam(required = false, defaultValue = "10") String limit
    ) {
        System.out.println("return all Facilities.");
        int pageIndex = Integer.parseInt(page) - 1;
        int pageLimit = Integer.parseInt(limit);
        Pageable pagination = PageRequest.of(pageIndex, pageLimit, Sort.by("locationid").ascending());
        return facilityRepository.findAll(pagination);
    }

    @GetMapping(params = "address")
    public Page<Facility> getFacilitiesByAddress(
            @RequestParam(required = false, defaultValue = "1") String page,
            @RequestParam(required = false, defaultValue = "10") String limit,
            @RequestParam String address
    ) {
        System.out.println("return all Facilities by address.");
        int pageIndex = Integer.parseInt(page) - 1;
        int pageLimit = Integer.parseInt(limit) ;
        Pageable pagination = PageRequest.of(pageIndex, pageLimit, Sort.by("locationid").ascending());
        return facilityRepository.findByAddressLike("%"+address+"%", pagination);
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable(value = "id") Long fid) {
        System.out.println("return Facility by id.");
        return facilityRepository.findById(fid).orElseThrow(() -> new ResourceNotFoundException("Facility","id",fid));
    }
}
