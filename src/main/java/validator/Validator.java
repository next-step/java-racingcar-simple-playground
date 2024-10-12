package validator;

import java.util.List;
import java.util.Set;

public class Validator {

  public void validRound(int round) {
    if (round <= 0 ) {
      throw new RuntimeException(ErrorStatus.INVAILD_ROUND_ERROR.getReason());
    }
  }

  public void validName(List<String> nameList) {
    for (String name : nameList) {
      vaildEmpty(name);
    }

    if ( nameList.isEmpty() ) {
      throw new RuntimeException(ErrorStatus.NOT_FOUND_NAME_ERROR.getReason());
    }

    Set<String> set = Set.copyOf(nameList);
    if ( set.size() != nameList.size() ) {
      throw new RuntimeException(ErrorStatus.DUPLICATE_NAME_ERROR.getReason());
    }


  }

  private void vaildEmpty(String str) {
    if ( str.isBlank() )
      throw new RuntimeException(ErrorStatus.EMPTY_NAME_ERROR.getReason());
  }

}
