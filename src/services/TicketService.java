package services;

import models.Slot;
import models.Ticket;

public class TicketService {
  public Ticket createTicket(Slot slot) {
    String parkingLotId = "PR1234";
    return new Ticket(parkingLotId + "_" + slot.getFloorNumber() + "_" + slot.getNumber());
  }
}
