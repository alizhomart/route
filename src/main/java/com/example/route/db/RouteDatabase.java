package com.example.route.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDatabase {
    private String fileName;
    private Map<Integer, List<Integer>> routeMap;

    public RouteDatabase(String fileName) {
        this.fileName = fileName;
        routeMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                List<Integer> stops = new ArrayList<>();
                for (int i = 1; i < str.length; i++) {
                    stops.add(Integer.parseInt(str[i]));
                }
                routeMap.put(Integer.parseInt(str[0]), stops);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
