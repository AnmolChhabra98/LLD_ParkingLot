package models;

import java.util.ArrayList;
import java.util.List;
import services.FloorService;

public class ParkingLot {
  private String id;
  private int noOfFloors;
  private int slotsPerFloor;
  private List<Floor> floors;

  public ParkingLot(String id, int noOfFloors, int slotsPerFloor) {
    this.id = id;
    this.noOfFloors = noOfFloors;
    this.slotsPerFloor = slotsPerFloor;
    this.floors = new ArrayList<>();

    FloorService floorService = new FloorService();

    for (int floor = 1; floor <= noOfFloors; floor++) {
      floors.add(floorService.addFloor(id, floor, slotsPerFloor));
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getNoOfFloors() {
    return noOfFloors;
  }

  public void setNoOfFloors(int noOfFloors) {
    this.noOfFloors = noOfFloors;
  }

  public int getSlotsPerFloor() {
    return slotsPerFloor;
  }

  public void setSlotsPerFloor(int slotsPerFloor) {
    this.slotsPerFloor = slotsPerFloor;
  }

  public List<Floor> getFloors() {
    return floors;
  }

  public void setFloors(List<Floor> floors) {
    this.floors = floors;
  }
}
