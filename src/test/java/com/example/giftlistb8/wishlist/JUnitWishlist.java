package com.example.giftlistb8.wishlist;

import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.entities.Wish;
import com.example.giftlistb8.repositories.WishRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class JUnitWishlist {

    @Autowired
    private WishRepository underTest;

    @Test
    public void testSave() {

        // Создание тестовых данных
        WishRequest request = WishRequest.builder()
                .name("Test wishlist")
                .linkGift("Test link gift")
                .dateOfHoliday(LocalDate.now())
                .image("test image")
                .descriptions("test description")
                .build();

        // Преобразование WishRequest в Wish
        Wish wish = Wish.builder()
                .name(request.name())
                .linkGift(request.linkGift())
                .image(request.image())
                .description(request.descriptions())
                .dateOfHoliday(request.dateOfHoliday())
                .status(false)
                .isBlocked(false)
                .build();

        // Проверка соответствия WishRequest и Wish
        assertAll("Wishes fields",
                () -> assertEquals(request.name(), wish.getName(),"Name mismatch"),
                () -> assertEquals(request.linkGift(), wish.getLinkGift(),"Gift mismatch"),
                () -> assertEquals(request.image(), wish.getImage(), "Image mismatch"),
                () -> assertEquals(request.descriptions(), wish.getDescription(), "Description mismatch"));

        // Созранение в базе данных
        Wish saveWish = underTest.save(wish);

        // Поле id должно быть установлено после сохранения
        assertNotNull(saveWish.getId(), "id mismatch");

        // Получение Wish из репозитория по id
        Optional<Wish> retrievedWish = underTest.findById(saveWish.getId());

        // Проверка наличия Wish
        assertTrue(retrievedWish.isPresent(), "Wish should be present in the repository");

        // Проверка соответствия сохраненного Wish и полученного из репозитория
        assertEquals(saveWish, retrievedWish.get());

        // Проверка соответствия сохраненного Wish и полученного из репозитория
        assertAll("Wishes fields",
                () -> assertEquals(wish.getName(), retrievedWish.get().getName(),"Name is mismatch"),
                () -> assertEquals(wish.getLinkGift(), retrievedWish.get().getLinkGift(),"Gift is mismatch"),
                () -> assertEquals(wish.getImage(), retrievedWish.get().getImage(),"Image is mismatch"),
                () -> assertEquals(wish.getDescription(), retrievedWish.get().getDescription(),"Description is mismatch"),
                () -> assertEquals(wish.getDateOfHoliday(), retrievedWish.get().getDateOfHoliday(),"Date is mismatch"),
                () -> assertEquals(wish.getStatus(), retrievedWish.get().getStatus(),"Status is mismatch"));
    }

    @Test
    public void testFindWishById() {

        // Создание тестового объекта Wish
        Wish wish = Wish.builder()
                .name("Test Wish")
                .linkGift("Test Link gift")
                .image("Test image")
                .description("Test description")
                .dateOfHoliday(LocalDate.now())
                .status(false)
                .isBlocked(false)
                .build();

        // Сохранение Wish в репозитории
        Wish savedWish = underTest.save(wish);

        // Вызов метода findById() с идентификатором сохраненного Wish
        Optional<Wish> retrievedWishOptional = underTest.findById(savedWish.getId());

        // Проверка наличия Wish
        assertTrue(retrievedWishOptional.isPresent(), "Wish should be present in the repository");

        // Получение полученного из репозитория Wish
        Wish retrievedWish = retrievedWishOptional.get();

        // Проверка соответствия полей
        assertAll("Wish fields",
                () -> assertEquals(wish.getName(), retrievedWish.getName(), "Name mismatch"),
                () -> assertEquals(wish.getLinkGift(), retrievedWish.getLinkGift(), "Link gift mismatch"),
                () -> assertEquals(wish.getImage(), retrievedWish.getImage(), "Image mismatch"),
                () -> assertEquals(wish.getDescription(), retrievedWish.getDescription(), "Description mismatch"),
                () -> assertEquals(wish.getDateOfHoliday(), retrievedWish.getDateOfHoliday(), "Date of holiday mismatch"),
                () -> assertEquals(wish.getStatus(), retrievedWish.getStatus(), "Status mismatch")
        );

        // Проверка соответствия сохраненного Wish и полученного из репозитория
        assertEquals(savedWish, retrievedWish);
    }
}