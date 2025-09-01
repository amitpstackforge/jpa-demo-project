package com.example.jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DoctorAvailabilityRequestDto {


    @NotBlank(message = "Day of Week is required")
    private String  dayOfWeek;

    @NotBlank(message = "Start Time is required")
    private String  startTime;

    @NotBlank(message = "EndTime is required")
    private String  endTime;

    @NotNull(message = "Slot Duration is required")
    @Min(value = 1, message = "Slot Duration must be greater than 0")
    private Integer slotDuration; // int → Integer করলাম যাতে @NotNull কাজ করে

    // Optional Lunch break
    private String lunchStart;
    private String lunchEnd;

    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
    }

    public String getLunchStart() {
        return lunchStart;
    }

    public void setLunchStart(String lunchStart) {
        this.lunchStart = lunchStart;
    }

    public String getLunchEnd() {
        return lunchEnd;
    }

    public void setLunchEnd(String lunchEnd) {
        this.lunchEnd = lunchEnd;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }
}