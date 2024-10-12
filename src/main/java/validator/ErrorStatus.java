package validator;

public enum ErrorStatus {
  INVAILD_ROUND_ERROR("시도할 횟수가 유효하지 않습니다."),
  EMPTY_NAME_ERROR("이름에 빈값이 포함되어 있습니다."),
  DUPLICATE_NAME_ERROR("중복된 이름이 존재합니다."),
  NOT_FOUND_NAME_ERROR ("참가자가 존재하지 않습니다.");
  private final String reason;

  private ErrorStatus(String reason) {
    this.reason = reason;
  }

  public String getReason() {
    return reason;
  }
}
