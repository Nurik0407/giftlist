//package com.example.giftlistb8.wishlist;
//
//import com.example.giftlistb8.config.JwtService;
//import com.example.giftlistb8.dto.SimpleResponse;
//import com.example.giftlistb8.dto.wish.requests.WishRequest;
//import com.example.giftlistb8.entities.Holiday;
//import com.example.giftlistb8.entities.User;
//import com.example.giftlistb8.entities.Wish;
//import com.example.giftlistb8.repositories.HolidayRepository;
//import com.example.giftlistb8.repositories.WishRepository;
//import com.example.giftlistb8.services.WishService;
//import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//public class JUnitWishlist {
//
//    @Mock
//    private JwtService jwtService;
//
//    @Mock
//    private HolidayRepository holidayRepository;
//
//    @Mock
//    private WishRepository wishRepository;
//
//    @InjectMocks
//    private WishService wishService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testSave() {
//        // Arrange
//        WishRequest request = new WishRequest();
//        // Set up the necessary properties in the request object
//
//        User user = new User(); // Create a mock User object
//        when(jwtService.getUserInToken()).thenReturn(user);
//
//        Holiday holiday = new Holiday(); // Create a mock Holiday object
//        when(holidayRepository.findById(any())).thenReturn(Optional.of(holiday));
//
//        // Act
//        SimpleResponse response = wishService.save(request);
//
//        // Assert
//        verify(jwtService).getUserInToken();
//        verify(holidayRepository).findById(any());
//        verify(wishRepository).save(any(Wish.class));
//
//        // Add more assertions based on your requirements
//    }
//
//        @Test
//        public void testUpdate() {
//            // Arrange
//            Long id = 123L; // Set the ID of the wish you want to update
//
//            WishRequest request = new WishRequest();
//            // Set up the necessary properties in the request object
//
//            Wish existingWish = new Wish(); // Create a mock existing Wish object
//            when(wishRepository.findById(id)).thenReturn(Optional.of(existingWish));
//
//            // Act
//            SimpleResponse response = wishService.update(id, request);
//
//            // Assert
//            verify(wishRepository).findById(id);
//            verify(wishRepository).save(existingWish);
//
//            // Add more assertions based on your requirements
//            }
//}
