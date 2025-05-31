package services;

import enums.VehicleType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import models.Floor;
import models.ParkingLot;
import models.Slot;
import models.Vehicle;
import strategies.Strategy;

public class SlotService {

  public static Map<Integer, List<Slot>> totalSlots = new ConcurrentHashMap<>();

  public Slot addSlot(String parkingLotId, int floorNumber, int slotNumber, VehicleType vehicleType) {
      Slot slot = new Slot(parkingLotId, floorNumber, slotNumber, vehicleType);
      totalSlots.computeIfAbsent(floorNumber, k -> new ArrayList<>()).add(slot);

      return slot;
  }

  public Slot findFirstAvailableSlot(Vehicle vehicle) {
    // The slot should be of the same type as the vehicle.
    // The slot should be on the lowest possible floor in the parking lot.
    // The slot should have the lowest possible slot number on the floor.

    ParkingLot parkingLot = ParkingLotService.parkingLots.get("PR1234");
    List<Floor> floors = parkingLot.getFloors();

    Optional<Slot> firstAvailableSlot = floors.stream()
        .flatMap(floor -> floor.getSlots().stream())
        .filter(slot -> slot.isFree() && slot.getVehicleType() == vehicle.getVehicleType())
        .min(Strategy.defaultComparator);

    return firstAvailableSlot.orElse(null);
  }
}
