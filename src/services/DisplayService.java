package services;

import enums.DisplayType;
import enums.VehicleType;
import java.util.List;
import models.Floor;
import models.ParkingLot;
import models.Slot;

public class DisplayService {
  public void display(DisplayType displayType, VehicleType vehicleType) {

    ParkingLot parkingLot = ParkingLotService.parkingLots.get("PR1234");
    List<Floor> floors = parkingLot.getFloors();

    switch (displayType) {
      case FREE_COUNT -> {
        for(int floorIndex = 0; floorIndex < floors.size(); floorIndex++) {
          List<Slot> slots = floors.get(floorIndex).getSlots();
          long availableSlotsCount = slots.stream().filter(slot -> slot.isFree() && slot.getVehicleType() == vehicleType).count();
          System.out.println("No. of free slots for "+ vehicleType + " on Floor " + (floorIndex + 1) + ": " + availableSlotsCount);
        }
      }
      case FREE_SLOTS -> {
        for(int floorIndex = 0; floorIndex < floors.size(); floorIndex++) {
          List<Slot> slots = floors.get(floorIndex).getSlots();
          List<Integer> availableSlots = slots.stream().filter(slot -> slot.isFree() && slot.getVehicleType() == vehicleType).map(Slot::getNumber).toList();
          System.out.println("Free slots for "+ vehicleType + " on Floor " + (floorIndex + 1) + ": " + availableSlots);
        }
      }
      case OCCUPIED_SLOTS -> {
        for(int floorIndex = 0; floorIndex < floors.size(); floorIndex++) {
          List<Slot> slots = floors.get(floorIndex).getSlots();
          List<Integer> occupiedSlots = slots.stream().filter(slot -> !slot.isFree() && slot.getVehicleType() == vehicleType).map(Slot::getNumber).toList();
          System.out.println("Occupied slots for "+ vehicleType + " on Floor " + (floorIndex + 1) + ": " + occupiedSlots);
        }
      }
    }
  }
}
