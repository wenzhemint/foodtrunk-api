package com.wenzhemin.foodtrunkapi.repository;

import com.wenzhemin.foodtrunkapi.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
//    Page<Facility> findByAddressLike(String address, Pageable pageable);
    Page<Facility> findByAddressLikeOrZipCodesLike(String address, String zipCodes, Pageable pageable);
}
