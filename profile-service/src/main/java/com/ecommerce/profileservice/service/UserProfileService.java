package com.ecommerce.profileservice.service;

import com.ecommerce.profileservice.dto.request.ProfileCreationRequest;
import com.ecommerce.profileservice.dto.response.UserProfileResponse;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public abstract class UserProfileService {
    public abstract UserProfileResponse createProfile(ProfileCreationRequest request);

    public abstract UserProfileResponse getProfile(String id);

    @PreAuthorize("hasRole('ADMIN')")
    public abstract List<UserProfileResponse> getAllProfiles();
}
