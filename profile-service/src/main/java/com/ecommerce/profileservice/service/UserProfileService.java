package com.ecommerce.profileservice.service;

import com.ecommerce.profileservice.dto.request.ProfileCreationRequest;
import com.ecommerce.profileservice.dto.response.UserProfileResponse;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface UserProfileService {
    UserProfileResponse createProfile(ProfileCreationRequest profileCreationRequest);

    UserProfileResponse getProfile(String id);

    @PreAuthorize("hasRole('ADMIN')")
    List<UserProfileResponse> getAllProfiles();

    UserProfileResponse updateProfile(String profileId, ProfileCreationRequest profileCreationRequest);

    void deleteProfile(String profileId);
}
