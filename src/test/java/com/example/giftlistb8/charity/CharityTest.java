package com.example.giftlistb8.charity;

import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.repositories.CharityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CharityTest {
    @Autowired
    private CharityRepository underTest;

    @Test
    public void testCharitySave() {

        // Создание тестовых данных
        CharityRequest request = CharityRequest.builder()
                .name("Test Charity")
                .state("Test State")
                .category("Test Category")
                .subCategory("Test Subcategory")
                .description("Test Description")
                .image("test_image.jpg")
                .build();

        // Преобразование CharityRequest в Charity
        Charity charity = Charity.builder()
                .name(request.name())
                .state(request.state())
                .category(request.category())
                .subCategory(request.subCategory())
                .description(request.description())
                .image(request.image())
                .dateOfIssue(LocalDate.now())
                .isBlocked(false)
                .build();

        // Проверка соответствия CharityRequest и Charity
        assertAll("Charity fields",
                () -> assertEquals(request.name(), charity.getName(), "Name mismatch"),
                () -> assertEquals(request.state(), charity.getState(), "State mismatch"),
                () -> assertEquals(request.category(), charity.getCategory(), "Category mismatch"),
                () -> assertEquals(request.subCategory(), charity.getSubCategory(), "Subcategory mismatch"),
                () -> assertEquals(request.description(), charity.getDescription(), "Description mismatch"),
                () -> assertEquals(LocalDate.now(), charity.getDateOfIssue(), "Date of Issue mismatch"),
                () -> assertEquals(request.image(), charity.getImage(), "Image mismatch"),
                () -> assertFalse(charity.isBlocked(), "Blocked mismatch")
        );

        // Созранение в базе данных
        Charity savedCharity = underTest.save(charity);

        // Поле id должно быть установлено после сохранения
        assertNotNull(savedCharity.getId(), "Id mismatch");

        // Получение Charity из репозитория по id
        Optional<Charity> retrievedCharity = underTest.findById(savedCharity.getId());

        // Проверка наличия Charity
        assertTrue(retrievedCharity.isPresent(), "Charity should be present in the repository");

        // Проверка соответствия сохраненного Charity и полученного из репозитория
        assertEquals(savedCharity, retrievedCharity.get());

        // Проверка соответствия сохраненного Charity и полученного из репозитория
        assertAll("Charity fields",
                () -> assertEquals(charity.getName(), retrievedCharity.get().getName(), "Name mismatch"),
                () -> assertEquals(charity.getState(), retrievedCharity.get().getState(), "State mismatch"),
                () -> assertEquals(charity.getCategory(), retrievedCharity.get().getCategory(), "Category mismatch"),
                () -> assertEquals(charity.getSubCategory(), retrievedCharity.get().getSubCategory(), "Subcategory mismatch"),
                () -> assertEquals(charity.getDescription(), retrievedCharity.get().getDescription(), "Description mismatch"),
                () -> assertEquals(charity.getDateOfIssue(), retrievedCharity.get().getDateOfIssue(), "Date of Issue mismatch"),
                () -> assertEquals(charity.getImage(), retrievedCharity.get().getImage(), "Image mismatch"),
                () -> assertEquals(charity.isBlocked(), retrievedCharity.get().isBlocked(), "Blocked mismatch")
        );
    }


    @Test
    public void testFindCharityById() {

        // Создание тестового объекта Charity
        Charity charity = Charity.builder()
                .name("Test Charity")
                .state("Test State")
                .category("Test Category")
                .subCategory("Test Subcategory")
                .description("Test Description")
                .dateOfIssue(LocalDate.now())
                .image("test_image.jpg")
                .isBlocked(false)
                .build();

        // Сохранение Charity в репозитории
        Charity savedCharity = underTest.save(charity);

        // Вызов метода findById() с идентификатором сохраненного Charity
        Optional<Charity> retrievedCharityOptional = underTest.findById(savedCharity.getId());

        // Проверка наличия Charity
        assertTrue(retrievedCharityOptional.isPresent(), "Charity should be present in the repository");

        // Получение полученного из репозитория Charity
        Charity retrievedCharity = retrievedCharityOptional.get();

        // Проверка соответствия полей
        assertAll("Charity fields",
                () -> assertEquals(charity.getName(), retrievedCharity.getName(), "Name mismatch"),
                () -> assertEquals(charity.getState(), retrievedCharity.getState(), "State mismatch"),
                () -> assertEquals(charity.getCategory(), retrievedCharity.getCategory(), "Category mismatch"),
                () -> assertEquals(charity.getSubCategory(), retrievedCharity.getSubCategory(), "Subcategory mismatch"),
                () -> assertEquals(charity.getDescription(), retrievedCharity.getDescription(), "Description mismatch"),
                () -> assertEquals(charity.getDateOfIssue(), retrievedCharity.getDateOfIssue(), "Date of Issue mismatch"),
                () -> assertEquals(charity.getImage(), retrievedCharity.getImage(), "Image mismatch"),
                () -> assertEquals(charity.isBlocked(), retrievedCharity.isBlocked(), "Blocked mismatch")
        );

        // Проверка соответствия сохраненного Charity и полученного из репозитория
        assertEquals(savedCharity, retrievedCharity);
    }
}
