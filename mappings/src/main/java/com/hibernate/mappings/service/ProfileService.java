package com.hibernate.mappings.service;

import com.hibernate.mappings.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Optional<Profile> getProfileById(Long id);
    Profile createProfile(Profile profile);
    Profile updateProfile(Long id, Profile profileDetails);
    void deleteProfile(Long id);
}
