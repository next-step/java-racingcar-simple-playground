package Dto;

import java.util.List;

public class GameResultDto {

  private List<String> nameList;

  public GameResultDto() {
  }

  public GameResultDto(Builder builder) {
    this.nameList = builder.nameList;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private List<String> nameList;

    public Builder name(List<String> nameList) {
      this.nameList = nameList;
      return this;
    }

    public GameResultDto build() {
      return new GameResultDto(this);
    }

  }

  public List<String> getNameList() {
    return this.nameList;
  }
}
