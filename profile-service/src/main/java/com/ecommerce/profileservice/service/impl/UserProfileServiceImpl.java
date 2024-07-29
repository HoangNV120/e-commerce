package com.ecommerce.profileservice.service.impl;

import com.ecommerce.profileservice.dto.request.ProfileCreationRequest;
import com.ecommerce.profileservice.dto.response.UserProfileResponse;
import com.ecommerce.profileservice.entity.UserProfile;
import com.ecommerce.profileservice.mapper.UserProfileMapper;
import com.ecommerce.profileservice.repository.UserProfileRepository;
import com.ecommerce.profileservice.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    @Override
    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile.setCreateDateTime(LocalDateTime.now());
        userProfile.setUpdateDateTime(LocalDateTime.now());
        userProfile.setDeleteFlag(false);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileReponse(userProfile);
    }

    @Override
    public UserProfileResponse getProfile(String id) {
        UserProfile userProfile =
                userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return userProfileMapper.toUserProfileReponse(userProfile);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> getAllProfiles() {
        var profiles = userProfileRepository.findAll();

        return profiles.stream().map(userProfileMapper::toUserProfileReponse).toList();
    }

    @Override
    public UserProfileResponse updateProfile(String profileId, ProfileCreationRequest profileCreationRequest) {
        UserProfile userProfile = userProfileMapper.toUserProfile(profileCreationRequest);
        if(!userProfileRepository.existsById(profileId)) {
            throw new RuntimeException("Profile not found");
        }
        userProfile.setUpdateDateTime(LocalDateTime.now());
        userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileReponse(userProfile);
    }

    @Override
    public void deleteProfile(String profileId) {
        UserProfile userProfile = userProfileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        userProfile.setDeleteFlag(true);
        userProfile.setUpdateDateTime(LocalDateTime.now());
        userProfileRepository.save(userProfile);
    }
}
