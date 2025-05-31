package services;

import models.Floor;

public class FloorService {

  public Floor addFloor(String parkingLotId, int floorNo, int noOfSlots) {
    return new Floor(parkingLotId, floorNo, noOfSlots);
  }
}
