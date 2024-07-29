package com.ecommerce.profileservice.mapper;

import com.ecommerce.profileservice.dto.request.ProfileCreationRequest;
import com.ecommerce.profileservice.dto.response.UserProfileResponse;
import com.ecommerce.profileservice.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
