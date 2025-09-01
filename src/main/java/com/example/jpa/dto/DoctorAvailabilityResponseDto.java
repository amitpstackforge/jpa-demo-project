package com.example.jpa.dto;

public class DoctorAvailabilityResponseDto {
    private Long doctorId;
    private String doctorName;
    private String specialization;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private int slotDuration;

    // Optional Lunch break
    private String lunchStart;
    private String lunchEnd;

    public DoctorAvailabilityResponseDto(Long doctorId, String doctorName, String specialization,
                                         String dayOfWeek, String startTime, String endTime, int slotDuration,
                                         String lunchStart,  String lunchEnd) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotDuration = slotDuration;
        this.lunchStart = lunchStart;
        this.lunchEnd = lunchEnd;
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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