package com.hibernate.mappings.service.impl;

import com.hibernate.mappings.model.Profile;
import com.hibernate.mappings.repository.ProfileRepository;
import com.hibernate.mappings.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile profileDetails) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
            Profile profile = profileOptional.get();
            profile.setAddress(profileDetails.getAddress());
            profile.setPhoneNumber(profileDetails.getPhoneNumber());
            return profileRepository.save(profile);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
