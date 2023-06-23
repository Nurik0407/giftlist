insert into user_infos (id, clothing_size, country, date_of_birth, facebook, hobby, image, important, instagram,
                        phone_number, reset_token, shoe_size, telegram, whats_app)
values (1, 'L', 'Kyrgyzstan', '2002-10-12', 'https://www.facebook.com/profile.php?id=100076926076401',
        'play need for speed',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRo6wCUSmJEK9kC5KVqmQczHMH3OMcc_9BTTQ&usqp=CAU',
        'where is my mind', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996999234595',
        null, 36, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (2, 'XXS', 'Kyrgyzstan', '2004-12-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play cs go',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIn-gE6j6sjvg0ekFgFBIzVP5VdN3aBu9dLg&usqp=CAU',
        'where is my mind', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996999234554',
        null, 43, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (3, 'L', 'Kyrgyzstan', '2004-10-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play tennis',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-we-PQ8adHvGI7Y9RxZfYl8We3BSNmHkDlg&usqp=CAU',
        'where is my mind', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996709899876',
        null, 44, 'http://t.me/nurkanowich', 'http://wa.me/996508206602'),
       (4, 'S', 'Kyrgyzstan', '2000-12-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play cs source',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxdm6KtsRZaI88FU5IJeL-7-FJ-VPwMaszJu6RAz6JWa-HpwL0_4uUMQGAP1od2tLnuHM&usqp=CAU',
        'where is my mind', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996709465733',
        null, 39, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (5, 'M', 'Kyrgyzstan', '2004-11-11', 'https://www.facebook.com/profile.php?id=100076926076401', 'play minecraft',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV-REr89iWROi6ScePs5agSIHpG9BPBDDZ_g&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996559234595',
        null, 41, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (6, 'L', 'Kyrgyzstan', '1998-10-09', 'https://www.facebook.com/profile.php?id=100076926076401', 'play pes 2013',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoZLkkxbsahAfa2-h2N0JxtXZBY-thKio_hQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996559234595',
        null, 40, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (7, 'XXL', 'Kyrgyzstan', '2000-10-05', 'https://www.facebook.com/profile.php?id=100076926076401', 'play cs 1.6',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc0fMjOVJf0_sIIIWfeEnaidbibryNOhOGVQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996559290595',
        null, 37, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (8, 'XXL', 'Kyrgyzstan', '1997-12-03', 'https://www.facebook.com/profile.php?id=100076926076401', 'play warface',
        'https://ca.slack-edge.com/T023L1WBFLH-U03MZAVNFL0-8750358d53b7-72',
        'where is my mind', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996959234845',
        null, 43, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (9, 'XL', 'Kyrgyzstan', '1998-12-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play aviator',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo7WfE6wFfdpeFph92LdEFJFnula0ecIObiQ&usqp=CAU',
        'only', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996999234595',
        null, 38, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (10, 'XS', 'Kyrgyzstan', '2002-9-12', 'https://www.facebook.com/profile.php?id=100076926076401',
        'play need for speed',
        'https://ca.slack-edge.com/T023L1WBFLH-U04439KFMNJ-665f46434425-512',
        'alrgiasy bar', 'https://instagran.com/nurkanowich?utm_medium=copy_link', '+996999234535',
        null, 35, 'http://t.me/adilet_324', 'http://wa.me/996408206602');


insert into users (id, email, first_name, is_blocked, last_name, password, role, subscribe_mailing, user_info_id)
values (1, 'a.asangazieva@gmail.com', 'Aijamal', false, 'Asangazieva',
        '$2a$12$a9cpi5sb2U7bhhgh3P4kiexwI.aIRczOeY6SUdtmAQCrfgH36jSm.', 'USER', true, 1),
       (2, 'nurislamnurkanov@gmail.com', 'Nurislam', false, 'Nurkanov',
        '$2a$12$cD/vVybmpIXV9vgW4mdsJ.GWOTQ9JPIuj1AscLPaQSgsl0RLT5NQ6', 'USER', true, 2),
       (3, 'nursultan@gmail.com', 'Syimyk', false, 'Odesov',
        '$2a$12$L.8HX7N70zwbxhgw3RE3outmnLGIgVlizD6bgkxsQuWLItdZjPsdG', 'USER', true, 3),
       (4, 'jumakadyrovadilet@gmail.com', 'Adilet', false, 'Jumakadyrov',
        '$2a$12$exhDiK8fE1KZtgsh1TPh7OblsSmwh7/JN/LlvYA3iF4LneNryzY3u', 'USER', true, 4),
       (5, 'eldiarro2004@gmail.com', 'Eldiar', false, 'Rasulov',
        '$2a$12$x.qXoudu3jdc8SkNg3KLMuuyUTH7Ly8Nlb/bNv/sjc9d.2cOcVX4K', 'USER', true, 5),
       (6, 'nurmatova161196@gmail.com', 'Nurmatova', false, 'Nuraim',
        '$2a$12$Cisx6qiDTPkmTQ1VT5nnnukPyoKZpAIBS/7XzeobdSBIaKWUwKXrq', 'USER', true, 6),
       (7, 'nurisa.abdykalykova03@gmail.com', 'Nurisa', false, 'Abdykalykova',
        '$2a$12$p2A8jzY9iGSu.GpG0BFLM.jMQH8r7bsczOf4JbIy0DmAzewp1OZSe', 'USER', true, 7),
       (8, 'programmist00707@gmail.com', 'Syimyk', false, 'Ravshanbekov',
        '$2a$12$hLlrlPOZ8zmSR82irl7xPeS3fmpoHykRkMz.UEjoJYTfpzM/D0wsO', 'USER', true, 8),
       (9, 'adinai.sharshekeeva.kk@gmail.com', 'Adinai', false, 'Sharshekeeva',
        '$2a$12$cpWhg3i4u2RUL0Sb70tC5OMUBF5PRUW1qEIJJiVM/ervhmuUagaVO', 'USER', true, 9),
       (10, 'admin@gmail.com', 'Admin', false, 'Admin',
        '$2a$12$TMQHpAfvViIwqb0aQPEJzueRqZvEUzzDkeT039fuP1xTD7i8lwota', 'ADMIN', true, 10);

INSERT INTO charities (id, category, date_of_issue, description, image, name, state, status, sub_category, is_blocked,
                       user_id)
VALUES (1, 'Книги', current_date, '«Отве́рженные» — роман-эпопея французского классика Виктора Гюго.',
        'https://avatars.mds.yandex.net/get-mpic/4399709/img_id4103982150204587909.jpeg/orig', 'Отверженные', 'Новое',
        true, 'Драма', false, 1),
       (2, 'Электроника', current_date, 'Беспроводные наушники Sony WI-C310 синие',
        'https://www.kivano.kg/images/product/87444/full/1609232285_79466800.jpg', 'Наушник', 'Б/У', true, 'Аксессуары',
        true,
        2),
       (3, 'Одежда', current_date,
        'Niyar style Представляю вашему вниманию бренд одежды, исключительно новые модели. Всё выполнено в индивидуальном стиле Шьём в быстрые сроки и в высоком качестве',
        'https://s.optlist.ru/i/54/78/16c4007793e3cf48-5478-1.jpg', 'Рубашка', 'Все', false, 'Рубашка', false, 3),
       (4, 'Одежда', current_date, 'Boys Chest Stripe Sun Farer Polo Shirt | Southern Tide',
        'https://cdn.shopify.com/s/files/1/2294/8559/products/youth-mesa-sun-farer-polo-shirt-9667_2048x2048.jpg?v=1676045990',
        'Polo', 'новое', false, 'Рубашка', false, 4),
       (5, 'Электроника', current_date, 'СЕТЕВОЕ ЗАРЯДНОЕ УСТРОЙСТВО HOCO C26 QUICK CHARGE QUALCOMM QC3.0',
        'https://softech.kg/image/cache/f4d29a07c9a0b69ba9cd6b03c4fb24b2.jpg', 'Зарядка', 'Все', false, 'Аксессуары',
        false,
        5),
       (6, 'Книги', current_date,
        'На высоком холме стоит очень странный дом. С его хозяйкой, мисс Корицей, явно что-то не так! Она терпеть не может людей, и поэтому в доме не бывает гостей. По хозяйству странной мисс помогают ',
        'https://moreknig.org/uploads/posts/covers/d7/90/medium/strannyy-dom-miss-koricy-hay-magdalena-359029.jpg',
        'Книга',
        'Б/У', false, 'Фантастика', false, 6),
       (7, 'Электроника', current_date,
        'Сверхъемкий внешний аккумулятор Oarmio 23 000 mAh предназначен для использования в длительных путешествиях и зарядки большого количества девайсов. Cправ  другой мобильной техники. ',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8_qNmGALnxvCp0YWpwN182ee3cAo1YPU4HA&usqp=CAU',
        'Повербанк', 'Новое', false, 'Аксессуары', false, 7),
       (8, 'Книги', current_date, 'В Лектории «Прямая речь» каждый день выступают выдающиеся ученые, писатели.',
        'https://cdn.ast.ru/v2/ASE000000000846056/COVER/cover1__w220.jpg', 'Русская литература: страсть и власть',
        'Все', false, 'Литература', false, 8),
       (9, 'Одежда', current_date, 'Джинсы широкие мужские',
        'https://img.joomcdn.net/13ac3e05cdae7a01fbff88ef7d8513972bf08961_original.jpeg', 'Джинсы', 'Новое',
        false, 'Брюки', false, 9);

INSERT INTO holidays (id, date, image, name, user_id)
VALUES (1, current_date, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9P0tiCHaPiIySluW5KwLWsFBExera7YrhKQ&usqp=CAU',
        'New Year', 1),
       (2, current_date,
        'https://www.hindustantimes.com/ht-img/img/2023/02/13/1600x900/valentines_day_2023_1676267034832_1676267046643_1676267046643.jpg',
        'Valentine''s Day', 2),
       (3, current_date,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmNKVQk0WqXUzH2SyHSqUIUhUi-Gk3trkQoQ&usqp=CAU',
        'International Women''s Day', 3),
       (4, current_date, 'https://assets.editorial.aetnd.com/uploads/2017/03/april-fools-day-2.jpg',
        'April Fool''s Day', 4),
       (5, current_date,
        'https://nationaldaycalendar.com/wp-content/uploads/2022/08/Labor-Day-First-Monday-in-September.jpg.webp',
        'Labor Day', 5),
       (6, current_date, 'https://img.freepik.com/free-vector/flat-design-russia-day-template_23-2148545705.jpg',
        'Russia Day', 6),
       (7, current_date, 'https://navi.com/blog/wp-content/uploads/2023/02/Independence-Day-Holiday.jpg',
        'Independence Day', 7),
       (8, current_date,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcqit2FwVJ-sR2sT7qq-0RHDwi94lm3zw4kw&usqp=CAU',
        'Knowledge Day', 8),
       (9, current_date, 'https://imgeng.jagran.com/images/2022/oct/halloween20221666809033978.jpg', 'Halloween', 9);


INSERT INTO wishes (id, date_of_holiday, description, image, link_gift, name, status, is_blocked, holiday_id, user_id)
VALUES (1, current_date, 'I wish for a new laptop',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT2sIjOTL42AO67qryBAfLqOa_N4mW3wrBeA&usqp=CAU',
        'https://example.com/laptop', 'Iphone 13 pro', false, false, 1, 1),
       (2, current_date, 'I wish for a vacation to Hawaii',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNVqATBGpIo5X5GdRqLq_Mg4U68jw6rgkvNQ&usqp=CAU',
        'https://example.com/hawaii', 'Великий Гетсби', false, false, 2, 2),
       (3, current_date, 'I wish for a new car',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQo7FlQK_2zj3oJWeN4oW0sfsk4FQxc_oAQXA&usqp=CAU',
        'https://example.com/car', 'Тёмный шоколад', false, false, 3, 3),
       (4, current_date, 'I wish for a smartphone', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQww4ShHveLCbmMWMC4H9mkoeByYJM-jFsI_w&usqp=CAU',
        'https://example.com/smartphone', 'Желтые тюльпаны', false, false, 1, 1),
       (5, current_date, 'I wish for a concert ticket',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHxMLgIziCAx1m0atR8Bv5tG2Hx9Bb58Cnsw&usqp=CAU',
        'https://example.com/concert', 'Сертификат на море', false, true, 4, 4),
       (6, current_date, 'I wish for a fitness tracker',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSrCcx_HNHCtB-B_QiWn8LV-3PAgpCxtAtTQ&usqp=CAU',
        'https://example.com/fitness', 'Билет в кино', false, false, 1, 1),
       (7, current_date, 'I wish for a designer handbag',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-gODRDDniM2VpOVlKfF3eiEkPox0UR4N_0A&usqp=CAU',
        'https://example.com/handbag', 'Dyson', true, false, 5, 5),
       (8, current_date, 'I wish for a spa day',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcTeto4633Puu2dMTZg9uamV59XExUkKo1fw&usqp=CAU',
        'https://example.com/spa', 'Toyota Supra', true, false, 2, 2),
       (9, current_date, 'I wish for a new camera',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9CPxr_3wvumc1gE7X8qWLLwl_J30RW6uD0A&usqp=CAU',
        'https://example.com/camera', 'MacBook', true, false, 3, 3);


INSERT INTO mailings (id, created_at, description, image, title)
VALUES (1, current_date, 'Don t miss our exclusive sale!',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnFxb8nrozvMh17gwlt9X1A2dZDLG0s00voA&usqp=CAU', 'Exclusive Sale'),
       (2, current_date, 'New arrivals are here!',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'New Arrivals'),
       (3, current_date, 'Get ready for summer with our latest collection',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'Summer Collection'),
       (4, current_date, 'Shop now for Mothers Day gifts!',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'Mothers Day Gifts'),
       (5, current_date, 'Dont forget to celebrate Fathers Day',
        'https://static.toiimg.com/thumb/resizemode-4,width-1200,height-900,msid-92257176/92257176.jpg', 'Fathers Day');


INSERT INTO users_friends(user_id, friends_id)
VALUES (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 4),
       (2, 5),
       (3, 1),
       (4, 1),
       (4, 2),
       (5, 2);

INSERT INTO users_requests_for_friends(user_id, requests_for_friends_id)
VALUES (1, 6),
       (1, 7),
       (1, 8);


INSERT INTO reserves (id, is_anonymous, charity_id, user_id, wish_id)
VALUES (1, false, null, 7, 7),
       (2, true, null, 8, 8),
       (3, false, null, 9, 9),
       (4, true, 1, 6, null),
       (5, true, 2, 7, null);

INSERT INTO complaints (id, complaint, seen, user_id)
VALUES (1, 'Проявление ненависти', false, 2),
       (2, 'Спам', false, 3);


INSERT INTO wishes_complaints(wish_id, complaints_id)
values (1, 1);


INSERT INTO charities_complaints(charity_id, complaints_id)
VALUES (1, 2);


INSERT INTO notifications(id, created_at, message, seen, type, charity_id, from_whom_user_id, reserve_id,
                          to_whom_user_id, wish_id)
VALUES (2, current_date, 'было забронировано', false, 'BOOKED_NOT_ANONYMOUSLY', null, 6,4, 1, null),
       (3, current_date, 'отправил(-a) запрос в друзья', false, 'FRIEND_REQUEST', null, 6,null, 1, null),
       (4, current_date, 'пожаловался(-ась) на', false, 'COMPLAINT', null, 2, null, 1, 1),
       (5, current_date, 'пожаловался(-ась) на', true, 'COMPLAINT', 1, 3, null, 1, null),
       (6, current_date, 'отправил(-a) запрос в друзья', true, 'FRIEND_REQUEST', null, 7, null, 1,null),
       (7, current_date, 'отправил(-a) запрос в друзья', false, 'FRIEND_REQUEST', null, 8, null, 1,null),
       (8, current_date, 'добавил(-а) желаемый подарок', false, 'ADD_GIFT_TO_WISH_LIST', null, 2, null,1, 2);