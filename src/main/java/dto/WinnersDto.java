package dto;

import java.util.List;

public record WinnersDto(List<String> names) {

    public String toDisplayString() {
        return String.join(", ", names) + "가 최종 우승했습니다.";
    }
}
