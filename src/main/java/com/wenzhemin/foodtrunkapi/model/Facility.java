package com.wenzhemin.foodtrunkapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food_facility")
@Getter
@Setter
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationid;
    private String address;
    private String location;
}
