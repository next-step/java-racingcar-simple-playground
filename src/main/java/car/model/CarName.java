package car.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CarName {
    private List<String> carNameList;
    private static final int NAME_LENGTH = 5;

    public void setCarName(String carNames){
        validateNull(carNames);
        List<String> carNameList = Arrays.asList(carNames.split(","));
        valid(carNameList);
        this.carNameList = carNameList;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    private void valid(List<String> carNameList) {
        validateLength(carNameList);
        validateType(carNameList);
        validateDuplicate(carNameList);
    }

    private void validateDuplicate(List<String> carNameList) {
        List<String> tmp = new ArrayList<>(carNameList);
        if(tmp.stream().distinct().count() != carNameList.size()){
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private void validateType(List<String> carNameList) {
        for (String carName : carNameList) {
            if(!Pattern.matches("^[a-zA-Z]*$", carName)){
                throw new IllegalArgumentException("알파벳만 입력하세요.");
            }
        }
    }

    private void validateLength(List<String> carNameList) {
        for (String carName : carNameList) {
            if(carName.length() > NAME_LENGTH){
                throw new IllegalArgumentException("5글자 이하로 입력하세요.");
            }
        }
    }

    private void validateNull(String carNames) {
        if(carNames.equals("")){
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
