package com.ecommerce.profileservice.controller;

import com.ecommerce.profileservice.dto.request.ProfileCreationRequest;
import com.ecommerce.profileservice.dto.response.UserProfileResponse;
import com.ecommerce.profileservice.service.UserProfileService;
import com.ecommerce.profileservice.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users/{profileId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable String profileId) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getProfile(profileId))
                .build();
    }

    @GetMapping("/users")
    ApiResponse<List<UserProfileResponse>> getAllProfiles() {
        return ApiResponse.<List<UserProfileResponse>>builder()
                .result(userProfileService.getAllProfiles())
                .build();
    }
    @PostMapping("/users/create")
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreationRequest profileCreationRequest) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.createProfile(profileCreationRequest))
                .build();
    }

    @PutMapping("/users/{profileId}")
    ApiResponse<UserProfileResponse> updateProfile(@PathVariable String profileId, @RequestBody ProfileCreationRequest profileCreationRequest) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.updateProfile(profileId, profileCreationRequest))
                .build();
    }

    @DeleteMapping("/users/{profileId}")
    ApiResponse<?> deleteProfile(@PathVariable String profileId) {
        userProfileService.deleteProfile(profileId);
        return ApiResponse.builder()
                .result("Delete OK")
                .build();
    }
}
