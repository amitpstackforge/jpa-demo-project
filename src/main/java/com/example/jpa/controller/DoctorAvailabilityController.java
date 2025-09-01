package com.example.jpa.controller;

import com.example.jpa.dto.DoctorAvailabilityRequestDto;
import com.example.jpa.dto.DoctorAvailabilityResponseDto;
import com.example.jpa.entity.DoctorAvailability;
import com.example.jpa.service.DoctorAvailabilityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorAvailabilityController {
    @Autowired
    private DoctorAvailabilityService availabilityService;

    @PostMapping("/{id}/availability")
    public DoctorAvailabilityResponseDto setDoctorAvailability(
            @PathVariable Long id,
            @Valid @RequestBody DoctorAvailabilityRequestDto dto) {
        return availabilityService.setAvailability(id, dto);

    }

}
