package car.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CarName {
    private List<String> carNames;
    private static final int NAME_LENGTH = 5;

    public void setCarName(String inputCarNames){
        validateNull(inputCarNames);
        List<String> carNames = Arrays.asList(inputCarNames.split(","));
        valid(carNames);
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private void valid(List<String> carNames) {
        validateLength(carNames);
        validateType(carNames);
        validateDuplicate(carNames);
    }

    private void validateDuplicate(List<String> carNames) {
        List<String> tmp = new ArrayList<>(carNames);
        if(tmp.stream().distinct().count() != carNames.size()){
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private void validateType(List<String> carNames) {
        for (String carName : carNames) {
            if(!Pattern.matches("^[a-zA-Z]*$", carName)){
                throw new IllegalArgumentException("알파벳만 입력하세요.");
            }
        }
    }

    private void validateLength(List<String> carNames) {
        for (String carName : carNames) {
            if(carName.length() > NAME_LENGTH){
                throw new IllegalArgumentException("5글자 이하로 입력하세요.");
            }
        }
    }

    private void validateNull(String inputCarNames) {
        if(inputCarNames.equals("")){
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
