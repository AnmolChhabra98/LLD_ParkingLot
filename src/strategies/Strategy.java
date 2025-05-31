package strategies;

import java.util.Comparator;
import models.Slot;

public class Strategy {
  public static final Comparator<Slot> defaultComparator = Comparator.comparing(Slot::getFloorNumber)
      .thenComparing(Slot::getNumber);
}
