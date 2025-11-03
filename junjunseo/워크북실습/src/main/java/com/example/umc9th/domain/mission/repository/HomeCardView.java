package com.example.umc9th.domain.mission.repository;

public interface HomeCardView {
    Long getMissionId();
    String getStoreName();
    String getConditionalText();
    Integer getPoint();
    java.time.LocalDate getDeadline();
}
