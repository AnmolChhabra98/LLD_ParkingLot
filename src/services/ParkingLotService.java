package services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import models.ParkingLot;

public class ParkingLotService {

  public static Map<String, ParkingLot> parkingLots = new ConcurrentHashMap<>();

  public void createParkingLot(String parkingLotId, int noOfFloors, int slotsPerFloor) {
    ParkingLot parkingLot = new ParkingLot(parkingLotId, noOfFloors, slotsPerFloor);
    parkingLots.put(parkingLotId, parkingLot);

    System.out.println("Created parking lot with " + noOfFloors + " floors and " + slotsPerFloor + " slots per floor");
  }
}
