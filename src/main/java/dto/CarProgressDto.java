package dto;

public record CarProgressDto(String name, int position) {

    public String toDisplayString() {
        return name + " : " + "-".repeat(position);
    }
}
