package models;

import enums.VehicleType;

public class Slot {
  private String parkingLotId;
  private int floorNumber;
  private int number;
  private VehicleType vehicleType;
  private boolean isFree;
  // can add support of startTime and endTime

  public Slot(String parkingLotId, int floorNumber, int number, VehicleType vehicleType) {
    this.parkingLotId = parkingLotId;
    this.floorNumber = floorNumber;
    this.number = number;
    this.vehicleType = vehicleType;
    this.isFree = true;
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

  public void setParkingLotId(String parkingLotId) {
    this.parkingLotId = parkingLotId;
  }

  public int getFloorNumber() {
    return floorNumber;
  }

  public void setFloorNumber(int floorNumber) {
    this.floorNumber = floorNumber;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public boolean isFree() {
    return isFree;
  }

  public void setFree(boolean free) {
    isFree = free;
  }
}
