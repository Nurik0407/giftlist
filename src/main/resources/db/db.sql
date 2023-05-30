insert into user_infos (id, clothing_size, country, date_of_birth, facebook, hobby, image, important, instagram,
                        phone_number, reset_token, shoe_size, telegram, whats_app)
values (1, 'L', 'Kyrgyzstan', '2002-10-12', 'https://www.facebook.com/profile.php?id=100076926076401',
        'play need for speed',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996999234595',
        null, 36, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (2, 'XXS', 'Kyrgyzstan', '2004-12-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play cs go',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996999234554',
        null, 43, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (3, 'L', 'Kyrgyzstan', '2004-10-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play tennis',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996709899876',
        null, 44, 'http://t.me/nurkanowich', 'http://wa.me/996508206602'),
       (4, 'S', 'Kyrgyzstan', '2000-12-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play cs source',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996709465733',
        null, 39, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (5, 'M', 'Kyrgyzstan', '2004-11-11', 'https://www.facebook.com/profile.php?id=100076926076401', 'play minecraft',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996559234595',
        null, 41, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (6, 'L', 'Kyrgyzstan', '1998-10-09', 'https://www.facebook.com/profile.php?id=100076926076401', 'play pes 2013',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996559234595',
        null, 40, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (7, 'XXL', 'Kyrgyzstan', '2000-10-05', 'https://www.facebook.com/profile.php?id=100076926076401', 'play cs 1.6',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996559290595',
        null, 37, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (8, 'XXL', 'Kyrgyzstan', '1997-12-03', 'https://www.facebook.com/profile.php?id=100076926076401', 'play warface',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996959234845',
        null, 43, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (9, 'XL', 'Kyrgyzstan', '1998-12-12', 'https://www.facebook.com/profile.php?id=100076926076401', 'play aviator',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
        'alrgiasy bar', 'https://instagram.com/nurkanowich?utm_medium=copy_link', '+996999234595',
        null, 38, 'http://t.me/adilet_524', 'http://wa.me/996508206602'),
       (10, 'XS', 'Kyrgyzstan', '2002-9-12', 'https://www.facebook.com/profile.php?id=100076926076401',
        'play need for speed',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtYqXjw6IR_opev4UADLjT8TPcLmWYQsx_YQ&usqp=CAU',
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

INSERT INTO charities (id, category, date_of_issue, description, image, name, state,sub_category,is_blocked, user_id)
VALUES (1, 'Книги', current_date, '«Отве́рженные» — роман-эпопея французского классика Виктора Гюго.',
        'https://avatars.mds.yandex.net/get-mpic/4399709/img_id4103982150204587909.jpeg/orig', 'Отверженные', 'Новое',
        'Драма',false, 2),
       (2, 'Электроника', current_date, 'Беспроводные наушники Sony WI-C310 синие',
        'https://www.kivano.kg/images/product/87444/full/1609232285_79466800.jpg', 'Наушник', 'Б/У', 'Аксессуары', true,3),
       (3, 'Одежда',current_date,
        'Niyar style Представляю вашему вниманию бренд одежды, исключительно новые модели. Всё выполнено в индивидуальном стиле Шьём в быстрые сроки и в высоком качестве',
        'https://s.optlist.ru/i/54/78/16c4007793e3cf48-5478-1.jpg', 'Рубашка', 'Все', 'Рубашка',false, 4),
       (4, 'Одежда', current_date, 'Boys Chest Stripe Sun Farer Polo Shirt | Southern Tide',
        'https://cdn.shopify.com/s/files/1/2294/8559/products/youth-mesa-sun-farer-polo-shirt-9667_2048x2048.jpg?v=1676045990',
        'Polo', 'новое', 'Рубашка',false, 5),
       (5, 'Электроника', current_date, 'СЕТЕВОЕ ЗАРЯДНОЕ УСТРОЙСТВО HOCO C26 QUICK CHARGE QUALCOMM QC3.0',
        'https://softech.kg/image/cache/f4d29a07c9a0b69ba9cd6b03c4fb24b2.jpg', 'Зарядка', 'Все', 'Аксессуары',false, 6),
       (6, 'Книги', current_date,
        'На высоком холме стоит очень странный дом. С его хозяйкой, мисс Корицей, явно что-то не так! Она терпеть не может людей, и поэтому в доме не бывает гостей. По хозяйству странной мисс помогают ',
        'https://moreknig.org/uploads/posts/covers/d7/90/medium/strannyy-dom-miss-koricy-hay-magdalena-359029.jpg', '',
        'Б/У', 'Фантастика',false, 7),
       (7, 'Электроника', current_date,
        'Сверхъемкий внешний аккумулятор Oarmio 23 000 mAh предназначен для использования в длительных путешествиях и зарядки большого количества девайсов. Cправ  другой мобильной техники. ',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8_qNmGALnxvCp0YWpwN182ee3cAo1YPU4HA&usqp=CAU',
        'Повербанк', 'Новое', 'Аксессуары',false, 8),
       (8, 'Книги', current_date, 'В Лектории «Прямая речь» каждый день выступают выдающиеся ученые, писатели.',
        'https://cdn.ast.ru/v2/ASE000000000846056/COVER/cover1__w220.jpg', 'Русская литература: страсть и власть',
        'Все', 'Литература', false,9),
       (9, 'Одежда', current_date, 'Джинсы широкие мужские',
        'https://img.joomcdn.net/13ac3e05cdae7a01fbff88ef7d8513972bf08961_original.jpeg', 'Джинсы', 'Новое', 'Брюки',
        false,10);

INSERT INTO holidays (id, date, image, name, user_id)
VALUES (1, current_date, 'https://contenthub-static.grammarly.com/blog/wp-content/uploads/2019/12/happy-new-year.jpeg',
        'New Year', 1),
       (2, current_date,
        'https://www.hindustantimes.com/ht-img/img/2023/02/13/1600x900/valentines_day_2023_1676267034832_1676267046643_1676267046643.jpg',
        'Valentine''s Day', 2),
       (3, current_date,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJlLKCE994s5WD3j-odRAY46uBhyvc6xoeE3Q-zHoxWWkESbgfh-PqzVVeX7it1vPriCI&usqp=CAU',
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


INSERT INTO wishes (id, date_of_holiday, description, image, link_gift, name, status,is_blocked, holiday_id, user_id)
VALUES (1, current_date, 'I wish for a new laptop',
        'https://media.wired.com/photos/631bb97dd884b4dcc94164e3/3:2/w_2400,h_1600,c_limit/How-to-Choose-a-Laptop-Gear-GettyImages-1235728903.jpg',
        'https://example.com/laptop', 'John Doe', false,false, 1, 1),
       (2, current_date, 'I wish for a vacation to Hawaii',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVuOwrxDw_RbgHYCUKb21bmPIlDOr0kRFnpw&usqp=CAU',
        'https://example.com/hawaii', 'Jane Smith', false, false,2, 2),
       (3, current_date, 'I wish for a new car',
        'https://cdni.autocarindia.com/utils/imageresizer.ashx?n=https://cms.haymarketindia.net/model/uploads/modelimages/Hyundai-Grand-i10-Nios-200120231541.jpg',
        'https://example.com/car', 'Michael Johnson', false,false, 3, 2),
       (4, current_date, 'I wish for a smartphone', 'https://guide-images.cdn.ifixit.com/igi/o4OjCNmNeOhvsS1P.medium',
        'https://example.com/smartphone', 'Sarah Williams', false, false,1, 3),
       (5, current_date, 'I wish for a concert ticket',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'https://example.com/concert', 'David Brown', false,true, 4, 4),
       (6, current_date, 'I wish for a fitness tracker',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'https://example.com/fitness', 'Emily Davis', false,false, 1, 5),
       (7, current_date, 'I wish for a designer handbag',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'https://example.com/handbag', 'Jessica Wilson', true,false, 5, 6),
       (8, current_date, 'I wish for a spa day',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSy-V3K6s24J3pPaFZPruuzQ4d9mJXQ2fxBfA&usqp=CAU',
        'https://example.com/spa', 'Alex Turner', true,false, 2, 7),
       (9, current_date, 'I wish for a new camera',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'https://example.com/camera', 'Olivia Thompson', true,false, 3, 8);


INSERT INTO mailings (id, created_at, description, image, title)
VALUES (1, current_date, 'Don t miss our exclusive sale!',
        'https://www.shutterstock.com/image-vector/brush-sale-banner-vector-260nw-1090866878.jpg', 'Exclusive Sale'),
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
        'https://static.toiimg.com/thumb/resizemode-4,width-1200,height-900,msid-92257176/92257176.jpg', 'Fathers Day'),
       (6, current_date, 'Get your back-to-school wardrobe ready',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'Back-to-School'),
       (7, current_date, 'Fall in love with our fall fashion collection',
        'https://thumbs.dreamstime.com/b/new-collection-banner-autumn-fall-leaves-colorful-seasonal-rowan-acorns-shopping-discount-promotion-128357091.jpg',
        'Fall Collection'),
       (8, current_date, 'Shop our holiday gift guide',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1fKdHV-51JT9qchdVc-l0BYuGfK2BJSfiFw&usqp=CAU',
        'Holiday Gift Guide'),
       (9, current_date, 'New year, new you! Shop our activewear collection',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeY2IeB7EpYk8T9pbeKkrn3zoYFD_rfS1ETQ&usqp=CAU',
        'Activewear Collection'),
       (10, current_date, 'Find the perfect Valentines Day gift',
        'https://www.hindustantimes.com/ht-img/img/2023/02/13/1600x900/valentines_day_2023_1676267034832_1676267046643_1676267046643.jpg',
        'Valentines Day Gifts');


INSERT INTO users_friends(user_id, friends_id)
VALUES (1, 2),
       (1, 3),
       (1, 4),
       (2, 3),
       (2, 4),
       (2, 5),
       (3, 3),
       (3, 5),
       (3, 6);

INSERT INTO users_requests_for_friends(user_id, requests_for_friends_id)
VALUES (1, 6),
       (1, 7),
       (1, 8);


INSERT INTO reserves (id, is_anonymous, charity_id, user_id, wish_id)
VALUES (1, false, null, 7, 7),
       (2, false, null, 8, 8),
       (3, false, null, 9, 9),
       (4, true, 1, 6, null),
       (5, true, 2, 7, null);

INSERT INTO complaints (id, complaint, seen, user_id)
VALUES (1, 'мага жаккан жок', true, 2),
       (2, 'Буга КР каршы', false, 3);


INSERT INTO wishes_complaints(wish_id, complaints_id)
values (1, 1);


INSERT INTO charities_complaints(charity_id, complaints_id)
VALUES (1, 2);


INSERT INTO notifications(id, created_at, message, seen, type, charity_id, from_whom_user_id, reserve_id,
                          to_whom_user_id, wish_id)
VALUES (3, current_date, 'Nurkanov Nurislam добавил желаемый подарок.', false, 'ADD_GIFT_TO_WISH_LIST', null, 2, null,
        3, 2),
       (4, current_date, 'Alex Turner было забронировано Ravshanbekov Syimyk', false, 'BOOKED_NOT_ANONYMOUSLY', null, 3,
        2, 3, null),
       (5, current_date, 'Nurmatova Nuraim отправил запрос в друзья.', false, 'FRIEND_REQUEST', null, 6,
        null, 1, null);