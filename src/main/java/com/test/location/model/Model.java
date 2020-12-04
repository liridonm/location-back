package com.test.location.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Audit abstract model with all necessary fields.
 * In this class we can add all general property that are repeated in every single table.
 * @param <T>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Model<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

}
