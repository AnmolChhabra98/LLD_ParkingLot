//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import enums.Color;
import enums.DisplayType;
import enums.VehicleType;
import services.DisplayService;
import services.ParkingLotService;
import services.VehicleService;

public class ParkingLotApp {

  public static void main(String[] args) {
    ParkingLotService parkingLotService = new ParkingLotService();
    DisplayService displayService = new DisplayService();
    VehicleService vehicleService = new VehicleService();

    parkingLotService.createParkingLot("PR1234", 2, 6);

    displayService.display(DisplayType.FREE_COUNT, VehicleType.CAR);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK);

    displayService.display(DisplayType.FREE_SLOTS, VehicleType.CAR);
    displayService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_SLOTS, VehicleType.TRUCK);

    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.CAR);
    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.BIKE);
    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.TRUCK);

    vehicleService.park(VehicleType.CAR, "KA-01-DB-1234", Color.BLACK);
    vehicleService.park(VehicleType.CAR, "KA-02-CB-1334", Color.RED);
    vehicleService.park(VehicleType.CAR, "KA-01-DB-1133", Color.BLACK);
    vehicleService.park(VehicleType.CAR, "KA-05-HJ-8432", Color.WHITE);
    vehicleService.park(VehicleType.CAR, "WB-45-HO-9032", Color.WHITE);
    vehicleService.park(VehicleType.CAR, "KA-01-DF-8230", Color.BLACK);
    vehicleService.park(VehicleType.CAR, "KA-21-HS-2347", Color.RED);

    displayService.display(DisplayType.FREE_COUNT, VehicleType.CAR);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK);

    vehicleService.unpark("PR1234_2_5");
    vehicleService.unpark("PR1234_2_5");
    vehicleService.unpark("PR1234_2_7");

    displayService.display(DisplayType.FREE_COUNT, VehicleType.CAR);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK);

    displayService.display(DisplayType.FREE_SLOTS, VehicleType.CAR);
    displayService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_SLOTS, VehicleType.TRUCK);

    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.CAR);
    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.BIKE);
    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.TRUCK);

    vehicleService.park(VehicleType.BIKE, "KA-01-DB-1541", Color.BLACK);
    vehicleService.park(VehicleType.TRUCK, "KA-32-SJ-5389", Color.ORANGE);
    vehicleService.park(VehicleType.TRUCK, "KL-54-DN-4582", Color.GREEN);
    vehicleService.park(VehicleType.TRUCK, "KL-12-HF-4542", Color.GREEN);

    displayService.display(DisplayType.FREE_COUNT, VehicleType.CAR);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK);

    displayService.display(DisplayType.FREE_SLOTS, VehicleType.CAR);
    displayService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE);
    displayService.display(DisplayType.FREE_SLOTS, VehicleType.TRUCK);

    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.CAR);
    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.BIKE);
    displayService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.TRUCK);
  }
}