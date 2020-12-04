package com.test.location.service;

import com.test.location.model.Location;
import com.test.location.repository.LocationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Create or update location.
     * Through out JPA, save method, can create or update record depends on id.
     * If ID is present to object JPA will update otherwise will create.
     *
     * @param location location to bre created or updated. {@link Location}
     * @return created or updated location {@link Location}
     */
    @Transactional
    public Location createOrUpdate(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> readAll() {
        return locationRepository.findAll();
    }
    /**
     * Find location by id.
     *
     * @param id id paramter {@link Integer}
     * @return founded location or null {@link Location}
     */
    public Location findById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    /**
     * Delete location by id.
     *
     * @param id id parameter {@link Integer}
     */
    @Transactional
    public void delete(Integer id) {
        locationRepository.removeLocation(id);
    }
}
