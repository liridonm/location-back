package com.test.location.controller;

import com.test.location.model.Location;
import com.test.location.service.LocationService;
import com.test.location.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Location controller.
 */
@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;

    /**
     * Default constructor.
     *
     * @param locationService LocationService.
     */
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Read all locations.
     *
     * @return list of locations.
     */
    @GetMapping("/read")
    public ResponseEntity<Response> readAll() {
        Response response = Response.builder()
                .code(200)
                .message("Successfully retrieve locations!")
                .data(locationService.readAll())
                .success(true).build();
        return ResponseEntity.ok(response);
    }

    /**
     * Read location by id.
     *
     * @param id
     * @return founded location.
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<Response> readById(@PathVariable Integer id) {
        Location foundLocation = locationService.findById(id);
        return responseBuilder(foundLocation, 404, "Location not found");

    }

    /**
     * Create location
     *
     * @param location location to be created.
     * @return createdLocation.
     */
    @PostMapping("/create")
    public ResponseEntity<Response> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createOrUpdate(location);
        return responseBuilder(createdLocation, 500, "Something went wrong, please try again!");
    }

    /**
     * Update location.
     *
     * @param location location.
     * @return updatedLocation
     */
    @PutMapping("/update")
    public ResponseEntity<Response> updateLocation(@RequestBody Location location) {
        Location updatedLocation = locationService.createOrUpdate(location);
        return responseBuilder(updatedLocation, 500, "Something went wrong, please try again!");
    }

    /**
     * Delete location.
     *
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteLocation(@PathVariable Integer id) {

        locationService.delete(id);

        Response response = Response.builder()
                .code(200)
                .message("Successfully delete location!")
                .success(true).build();
        return ResponseEntity.ok(response);
    }

    /**
     * Response builder.
     *
     * @param location location selected.
     * @param code     code
     * @param message  message
     * @return response entity response.
     */
    private ResponseEntity<Response> responseBuilder(Location location, Integer code, String message) {
        if (location == null) {
            Response response = Response.builder().code(code).success(false).message(message).build();
            return ResponseEntity.ok(response);
        }
        Response response = Response.builder().code(200).success(true).message("Successfully retrieve location").data(location).build();
        return ResponseEntity.ok(response);
    }
}
