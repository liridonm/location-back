package com.test.location.controller;

import com.test.location.service.CityService;
import com.test.location.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    private final CityService cityService;

    /**
     * Default constructor.
     * @param cityService CityService.
     */
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Read all cities.
     * @return list of cities.
     */
    @GetMapping("/read")
    public ResponseEntity<Response> readAll() {
        Response response = Response.builder()
                .code(200)
                .message("Successfully retrieve cities!")
                .data(cityService.readAll())
                .success(true).build();
        return ResponseEntity.ok(response);
    }
}
