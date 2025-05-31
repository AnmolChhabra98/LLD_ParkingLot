package services;

import enums.Color;
import enums.VehicleType;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import models.Floor;
import models.ParkingLot;
import models.Slot;
import models.Ticket;
import models.Vehicle;

public class VehicleService {

  private final SlotService slotService;
  private final TicketService ticketService;
  public static Map<String, Vehicle> ticketIdToVehicle = new ConcurrentHashMap<>();

  public VehicleService() {
    this.slotService = new SlotService();
    this.ticketService = new TicketService();
  }

  public void park(VehicleType vehicleType, String regNumber, Color color) {
    Vehicle vehicle = new Vehicle(vehicleType, regNumber, color);
    Slot slot = slotService.findFirstAvailableSlot(vehicle);
    if(Objects.isNull(slot)) {
      System.out.println("Parking Lot Full");
      return;
    }

    slot.setFree(false);
    Ticket ticket = ticketService.createTicket(slot);
    String ticketId = ticket.getId();
    ticketIdToVehicle.put(ticketId, vehicle);

    System.out.println("Parked vehicle. Ticket ID: " + ticketId);
  }
  public void unpark(String ticketId) {
    //    PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
    if(!ticketIdToVehicle.containsKey(ticketId)) {
      System.out.println("Invalid Ticket");
      return;
    }

    String [] splitted = ticketId.split("_");
    String parkingLotId = splitted[0];
    int floorNumber = Integer.parseInt(splitted[1]);
    int slotNumber = Integer.parseInt(splitted[2]);

    ParkingLot parkingLot = ParkingLotService.parkingLots.get(parkingLotId);

    if(Objects.isNull(parkingLot) ||
        floorNumber > parkingLot.getNoOfFloors() ||
        slotNumber > parkingLot.getFloors().get(floorNumber - 1).getNoOfSlots()) {
      System.out.println("Invalid Ticket");
      return;
    }

    Floor floor = parkingLot.getFloors().get(floorNumber - 1);
    Slot slot = floor.getSlots().get(slotNumber - 1);
    slot.setFree(true);

    Vehicle vehicle = ticketIdToVehicle.get(ticketId);
    ticketIdToVehicle.remove(ticketId);

    System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegNumber() + " and Color: " + vehicle.getColor());
  }
}
