package com.test.location.service;

import com.test.location.model.City;
import com.test.location.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> readAll() {
        return cityRepository.findAll();
    }
}
