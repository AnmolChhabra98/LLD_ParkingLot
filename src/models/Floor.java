package models;

import enums.VehicleType;
import java.util.ArrayList;
import java.util.List;
import services.SlotService;

public class Floor {
  private String parkingLotId;
  private int number;
  private int noOfSlots;
  private List<Slot> slots;

  public Floor(String parkingLotId, int number, int noOfSlots) {
    this.parkingLotId = parkingLotId;
    this.number = number;
    this.noOfSlots = noOfSlots;
    this.slots = new ArrayList<>();

    SlotService slotService = new SlotService();

    for(int slot = 1; slot <= noOfSlots; slot++) {
      if(slot <= 1)
        slots.add(slotService.addSlot(parkingLotId, number, slot, VehicleType.TRUCK));

      if(slot > 1 && slot <= 3)
        slots.add(slotService.addSlot(parkingLotId, number, slot, VehicleType.BIKE));

      if(slot > 3)
        slots.add(slotService.addSlot(parkingLotId, number, slot, VehicleType.CAR));
    }
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

  public void setParkingLotId(String parkingLotId) {
    this.parkingLotId = parkingLotId;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getNoOfSlots() {
    return noOfSlots;
  }

  public void setNoOfSlots(int noOfSlots) {
    this.noOfSlots = noOfSlots;
  }

  public List<Slot> getSlots() {
    return slots;
  }

  public void setSlots(List<Slot> slots) {
    this.slots = slots;
  }
}
