package isp.lab8.airways;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Route implements Serializable {

    private Long id;
    private String name;
    private ArrayList<Waypoint> waypoints;
    public static Long currentId = 0L;

    public Route() {
        this.id = currentId++;
        this.name = "";
        this. waypoints = new ArrayList<>();
    }

    public Route(String name) {
        this.id = currentId++;
        this.name = name;
        this.waypoints = new ArrayList<>();
    }

    public Route(String name, ArrayList<Waypoint> waypoints) {
        this.id = currentId++;
        this.name = name;
        this.waypoints = waypoints;
    }

    public Route(Long id, String name, ArrayList<Waypoint> waypoints) {
        this.id = id;
        this.name = name;
        this.waypoints = waypoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(ArrayList<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public double getTotalDistance() {
        double total = 0d;
        for (int i=0; i< waypoints.size()-1; i++) {
            total += Haversine.haversine(waypoints.get(i).getLatitude(), waypoints.get(i).getLongitude(),
                    waypoints.get(i+1).getLatitude(), waypoints.get(i+1).getLongitude());
        }
        return total;
    }

    public void orderWaypoints() {
        for (int i = 0; i < waypoints.size()-1; i++) {
            for (int j = i; j < waypoints.size(); j++) {
                if(waypoints.get(i).getIndex() > waypoints.get(j).getIndex()) {
                    Collections.swap(waypoints, i, j);
                }
            }
        }
    }
}
