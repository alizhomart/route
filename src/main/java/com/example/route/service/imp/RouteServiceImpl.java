package com.example.route.service.imp;

import com.example.route.db.RouteDatabase;
import com.example.route.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteDatabase db;

    @Override
    public boolean hasDirectRoute(int from, int to) {
        String path = "C:/alizhan/project/routes.txt";
        db = new RouteDatabase(path);

        boolean direct = false;
        for (List<Integer> stops : db.getRouteMap().values()) {
            if (stops.indexOf(from) != -1 && stops.indexOf(to) != -1) {
                direct = true;
                break;
            }
        }

        return direct;
    }

}
