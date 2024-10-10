package domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RacingCar {
  private final String name;
  private final List<Boolean> results = new ArrayList<>();
}
