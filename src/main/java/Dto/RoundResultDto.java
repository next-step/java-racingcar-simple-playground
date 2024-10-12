package Dto;

import java.util.List;

public class RoundResultDto {

  private String name;
  private int pos;

  public RoundResultDto() {
  }

  public RoundResultDto(Builder builder) {
    this.name = builder.name;
    this.pos = builder.pos;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String name;
    private int pos;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder pos(int pos) {
      this.pos = pos;
      return this;
    }

    public RoundResultDto build() {
      return new RoundResultDto(this);
    }

  }

  public String getName() {
    return this.name;
  }

  public int getPos() {
    return this.pos;
  }
}
