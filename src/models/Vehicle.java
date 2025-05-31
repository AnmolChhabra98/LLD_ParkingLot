package models;

import enums.Color;
import enums.VehicleType;

public class Vehicle {
  private String regNumber;
  private Color color;
  private VehicleType vehicleType;

  public Vehicle(VehicleType vehicleType, String regNumber, Color color) {
    this.regNumber = regNumber;
    this.color = color;
    this.vehicleType = vehicleType;
  }

  public String getRegNumber() {
    return regNumber;
  }

  public void setRegNumber(String regNumber) {
    this.regNumber = regNumber;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }
}
