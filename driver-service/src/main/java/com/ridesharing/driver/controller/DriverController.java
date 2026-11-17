package com.ridesharing.driver.controller;

import com.ridesharing.driver.model.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private static final Logger log = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private Environment environment;

    private static final List<Driver> SAMPLE_DRIVERS = Arrays.asList(
            new Driver("D101", "John Doe", "AP-09-AB-1234", "AVAILABLE", 4.8),
            new Driver("D102", "Jane Smith", "TS-07-CD-5678", "ON_TRIP", 4.9),
            new Driver("D103", "Alex Johnson", "KA-03-EF-9012", "AVAILABLE", 4.7)
    );

    @GetMapping
    public ResponseEntity<Map<String, Object>> getDrivers() {
        String port = environment.getProperty("local.server.port");
        if (port == null || port.isEmpty()) {
            port = environment.getProperty("server.port", "8081");
        }
        String instanceId = "DRIVER-SERVICE:" + port;

        // Print request handling clearly in the console
        System.out.println("=======================================================");
        System.out.println(">>> [DRIVER-SERVICE] Request received at " + LocalDateTime.now());
        System.out.println(">>> [DRIVER-SERVICE] Handled by Instance on PORT: " + port);
        System.out.println(">>> [DRIVER-SERVICE] Instance ID: " + instanceId);
        System.out.println("=======================================================");

        log.info("Request handled by DRIVER-SERVICE instance running on port: {}", port);

        Map<String, Object> response = new HashMap<>();
        response.put("service", "DRIVER-SERVICE");
        response.put("port", port);
        response.put("instanceId", instanceId);
        response.put("message", "Request handled by Driver Service on port: " + port);
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("drivers", SAMPLE_DRIVERS);

        return ResponseEntity.ok(response);
    }
}
