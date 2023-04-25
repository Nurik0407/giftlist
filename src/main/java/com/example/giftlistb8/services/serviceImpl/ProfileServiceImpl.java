package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.dto.profile.request.ProfileRequest;
import com.example.giftlistb8.dto.profile.request.UpdateProfileRequest;
import com.example.giftlistb8.dto.profile.response.FriendsProfileResponse;
import com.example.giftlistb8.dto.profile.response.MyProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.entities.Holiday;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.UserInfo;
import com.example.giftlistb8.enums.Status;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.ProfileRepository;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.ProfileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Override
    public ProfileResponse saveProfile(ProfileRequest profileRequest) {
        User user = jwtService.getUserInToken();
        UserInfo userInfo = setUserInfoFromRequest(profileRequest);
        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        profileRepository.save(userInfo);
        log.info("Profile information saved successfully!");
        return getProfileResponse(user, userInfo);
    }

    @Override
    public MyProfileResponse getMyProfile() {
        User user = jwtService.getUserInToken();
        return MyProfileResponse
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    @Override
    public ProfileResponse getMyFullProfile() {
        User user = jwtService.getUserInToken();
        return getProfileResponse(user, user.getUserInfo());
    }

    @Override
    public FriendsProfileResponse getFriendsProfile(Long id) {
        User user = jwtService.getUserInToken();
        User friend = getUserById(id);
        Status friendStatus;
        boolean sendRequest = false;
        if (user.getFriends().contains(friend) || friend.getFriends().contains(user)) {
            friendStatus = Status.FRIEND;
        } else if (user.getRequestsForFriends().contains(friend) || friend.getRequestsForFriends().contains(user)) {
            friendStatus = Status.REQUEST_TO_FRIEND;
            sendRequest = true;
        } else {
            friendStatus = Status.NOT_FRIEND;
        }
        List<HolidayResponse> holidayResponses = new ArrayList<>();
        for (Holiday holiday : friend.getHolidays()) {
            HolidayResponse holidayResponse = new HolidayResponse(
                    holiday.getName(),
                    holiday.getImage(),
                    holiday.getDate());
            holidayResponses.add(holidayResponse);
        }
        return FriendsProfileResponse
                .builder()
                .id(friend.getId())
                .image(friend.getUserInfo().getImage())
                .status(friendStatus)
                .sendRequest(sendRequest)
                .firstName(friend.getFirstName())
                .lastName(friend.getLastName())
                .country(friend.getUserInfo().getCountry())
                .dateOfBirth(friend.getUserInfo().getDateOfBirth())
                .email(friend.getEmail())
                .phoneNumber(friend.getUserInfo().getPhoneNumber())
                .clothSize(friend.getUserInfo().getClothingSize())
                .shoeSize(friend.getUserInfo().getShoeSize())
                .hobby(friend.getUserInfo().getHobby())
                .important(friend.getUserInfo().getImportant())
                .facebookLink(friend.getUserInfo().getFacebook())
                .instagramLink(friend.getUserInfo().getInstagram())
                .vkLink(friend.getUserInfo().getWhatsApp())
                .telegramLink(friend.getUserInfo().getTelegram())
                .friendsHolidays(holidayResponses)
                .build();
    }

    public UserInfo updateProfile(UserInfo userInfo, UpdateProfileRequest profileRequest) {
        User user = jwtService.getUserInToken();
        userInfo.setImage(profileRequest.image());
        user.setFirstName(profileRequest.firstName());
        user.setLastName(profileRequest.lastName());
        userInfo.setCountry(profileRequest.country());
        userInfo.setDateOfBirth(profileRequest.dateOfBirth());
        userInfo.setPhoneNumber(profileRequest.phoneNumber());
        userInfo.setHobby(profileRequest.hobby());
        userInfo.setImportant(profileRequest.important());
        userInfo.setClothingSize(profileRequest.clothSize());
        userInfo.setShoeSize(profileRequest.shoeSize());
        userInfo.setInstagram(profileRequest.instagramLink());
        userInfo.setTelegram(profileRequest.telegramLink());
        userInfo.setFacebook(profileRequest.facebookLink());
        userInfo.setWhatsApp(profileRequest.vkLink());
        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        return userInfo;
    }

    @Override
    public SimpleResponse saveUpdatedProfile(Long id, UpdateProfileRequest profileRequest) {
        User userToUpdate = getUserById(id);
        UserInfo updatedUserInfo = updateProfile(userToUpdate.getUserInfo(), profileRequest);
        profileRepository.save(updatedUserInfo);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Profile updated successfully!")
                .build();
    }

    private ProfileResponse getProfileResponse(User user, UserInfo userInfo) {
        return new ProfileResponse(
                user.getId(),
                userInfo.getImage(),
                user.getFirstName(),
                user.getLastName(),
                userInfo.getCountry(),
                userInfo.getDateOfBirth(),
                user.getEmail(),
                userInfo.getPhoneNumber(),
                userInfo.getHobby(),
                userInfo.getImportant(),
                userInfo.getClothingSize(),
                userInfo.getShoeSize(),
                userInfo.getFacebook(),
                userInfo.getInstagram(),
                userInfo.getTelegram(),
                userInfo.getWhatsApp()
        );
    }

    private UserInfo setUserInfoFromRequest(ProfileRequest profileRequest) {
        return UserInfo
                .builder()
                .phoneNumber(profileRequest.phoneNumber())
                .image(profileRequest.image())
                .dateOfBirth(profileRequest.dateOfBirth())
                .country(profileRequest.country())
                .hobby(profileRequest.hobby())
                .important(profileRequest.important())
                .clothingSize(profileRequest.clothSize())
                .shoeSize(profileRequest.shoeSize())
                .instagram(profileRequest.instagramLink())
                .telegram(profileRequest.telegramLink())
                .facebook(profileRequest.facebookLink())
                .whatsApp(profileRequest.vkLink())
                .build();
    }

    private User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User with id: " + id + " not found!")
        );
    }
}
