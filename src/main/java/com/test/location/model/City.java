package com.test.location.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * City model/table with all property we need.
 */
@Entity
@Table(name = "cities")
@Getter
@Setter
public class City extends Model<Integer>{

    private String name;
}
