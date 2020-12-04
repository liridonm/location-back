package com.test.location.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Location model/table with all property we need.
 */
@Entity
@Table(name = "locations")
@Getter
@Setter
public class Location extends Model<Integer>{

    private String name;

    private String address;

    private Integer latitude;

    private Integer longitude;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
