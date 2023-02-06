package com.example.route.controller;

import com.example.route.response.RouteResponse;
import com.example.route.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    private RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping("/api/direct")
    public ResponseEntity<RouteResponse> getDirectRoute(@RequestParam("from") int from,
                                                        @RequestParam("to") int to) {
        boolean direct = service.hasDirectRoute(from, to);
        RouteResponse response = new RouteResponse(from, to, direct);
        return ResponseEntity.ok(response);
    }
}

