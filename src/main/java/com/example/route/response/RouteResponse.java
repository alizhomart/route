package com.example.route.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {
    private int from;
    private int to;
    private boolean direct;
}

