public record Name(String value) {
    public Name {
        validateEmptyName(value);
    }

    private void validateEmptyName(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }
}
