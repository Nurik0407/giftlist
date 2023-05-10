


insert into user_infos (id,clothing_size,country,date_of_birth,facebook,hobby,image,important,instagram,phone_number,shoe_size,telegram,whats_app)
values (2,'XXS','Kyrgyzstan','2004-12-12','https://www.facebook.com/profile.php?id=100076926076401','play cs go','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996999234554','THIRTY_FIVE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (3,'L','Kyrgyzstan','2004-10-12','https://www.facebook.com/profile.php?id=100076926076401','play tennis','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996709899876','FORTY_THREE','http://t.me/nurkanowich','http://wa.me/996508206602'),
       (4,'S','Kyrgyzstan','2000-12-12','https://www.facebook.com/profile.php?id=100076926076401','play cs source','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996709465733','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (5,'M','Kyrgyzstan','2004-11-11','https://www.facebook.com/profile.php?id=100076926076401','play minecraft','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996559234595','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (6,'L','Kyrgyzstan','1998-10-09','https://www.facebook.com/profile.php?id=100076926076401','play pes 2013','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996559234595','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (7,'XXL','Kyrgyzstan','2000-10-05','https://www.facebook.com/profile.php?id=100076926076401','play cs 1.6','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996559290595','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (8,'XXL','Kyrgyzstan','1997-12-03','https://www.facebook.com/profile.php?id=100076926076401','play warface','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996959234845','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (9,'XL','Kyrgyzstan','1998-12-12','https://www.facebook.com/profile.php?id=100076926076401','play aviator','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996999234595','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (1,'L','Kyrgyzstan','2002-10-12','https://www.facebook.com/profile.php?id=100076926076401','play need for speed','alrgiasy kyzdarga bar','image','https://instagram.com/nurkanowich?utm_medium=copy_link','+996999234595','FORTY_THREE','http://t.me/adilet_524','http://wa.me/996508206602'),
       (10,'XS','Kyrgyzstan','2002-9-12','https://www.facebook.com/profile.php?id=100076926076401','play need for speed','alrgiasy kyzdarga bar','image','https://instagran.com/nurkanowich?utm_medium=copy_link','+996999234535','FORTY_THREE','http://t.me/adilet_324','http://wa.me/996408206602');

insert into users (id, email, first_name, is_blocked,last_name,password,role,user_info_id)
values (2,'nurislamnurkanov@gmail.com','Nurislam',false,'Nurkanov','$2a$12$cD/vVybmpIXV9vgW4mdsJ.GWOTQ9JPIuj1AscLPaQSgsl0RLT5NQ6','USER',2),
       (3,'nursultan@gmail.com','Syimyk',false,'Odesov','$2a$12$L.8HX7N70zwbxhgw3RE3outmnLGIgVlizD6bgkxsQuWLItdZjPsdG','USER',3),
       (4,'jumakadyrovadilet@gmail.com','Adilet',false,'Jumakadyrov','$2a$12$exhDiK8fE1KZtgsh1TPh7OblsSmwh7/JN/LlvYA3iF4LneNryzY3u','USER',4),
       (5,'eldiarro2004@gmail.com','Eldiar',false,'Rasulov','$2a$12$x.qXoudu3jdc8SkNg3KLMuuyUTH7Ly8Nlb/bNv/sjc9d.2cOcVX4K','USER',5),
       (6,'nurmatova161196@gmail.com','',false,'Nuraim','$2a$12$Cisx6qiDTPkmTQ1VT5nnnukPyoKZpAIBS/7XzeobdSBIaKWUwKXrq','USER',6),
       (7,'nurisa.abdykalykova03@gmail.com','Nurisa',false,'Abdykalykova','$2a$12$p2A8jzY9iGSu.GpG0BFLM.jMQH8r7bsczOf4JbIy0DmAzewp1OZSe','USER',7),
       (8,'programmist00707@gmail.com','Syimyk',false,'Ravshanbekov','$2a$12$hLlrlPOZ8zmSR82irl7xPeS3fmpoHykRkMz.UEjoJYTfpzM/D0wsO','USER',8),
       (9,'adinai.sharshekeeva.kk@gmail.com','Adinai',false,'Sharshekeeva','$2a$12$cpWhg3i4u2RUL0Sb70tC5OMUBF5PRUW1qEIJJiVM/ervhmuUagaVO','USER',9),
       (1,'a.asangazieva@gmail.com','Aijamal',false,'Asangazieva','$2a$12$a9cpi5sb2U7bhhgh3P4kiexwI.aIRczOeY6SUdtmAQCrfgH36jSm.','USER',1),
       (10,'adminadminov@gmail.com','Admin',false,'Admin','$2a$12$TMQHpAfvViIwqb0aQPEJzueRqZvEUzzDkeT039fuP1xTD7i8lwota','ADMIN',10);




-- INSERT INTO charities (id,category,date_of_issue,description, name, state, sub_category,user_id)
-- VALUES
--     (1, 'Книги',current_date,'«Отве́рженные» — роман-эпопея французского классика Виктора Гюго. Широко признан мировой литературной критикой и мировой общественностью апофеозом творчества писателя и одним из величайших романов XIX столетия. Впервые опубликован в 1862 году.', 'Отверженные', 'Новое', 'Драма', 2),
--     (2, 'Электроника',current_date,'Description 2', 'Name 2', 'state 2', 'Sub-Category 2', 3),
--     (3, 'Одежда',current_date,'Description 3', 'Name 3', 'state 3', 'Sub-Category 3', 4),
--     (4, 'Одежда',current_date,'Description 4', 'Name 4', 'state 4', 'Sub-Category 4', 5),
--     (5, 'Электроника',current_date,'Description 5', 'Name 5', 'state 5', 'Sub-Category 5', 6),
--     (6, 'Книги',current_date,'Description 6', 'Name 6', 'state 6', 'Sub-Category 6', 7),
--     (7, 'Электроника',current_date,'Description 7', 'Name 7', 'state 7', 'Sub-Category 7', 8),
--     (8, 'Книги',current_date,'Description 8', 'Name 8', 'state 8', 'Sub-Category 8', 9),
--     (9, 'Одежда',current_date,'Description 9', 'Name 9', 'state 9', 'Sub-Category 9', 10);
INSERT INTO charities (id,category,date_of_issue,description,image, name, state, sub_category,user_id)
VALUES
    (1, 'Книги',current_date,'«Отве́рженные» — роман-эпопея французского классика Виктора Гюго. Широко признан мировой литературной критикой и мировой общественностью апофеозом творчества писателя и одним из величайших романов XIX столетия. Впервые опубликован в 1862 году.','https://avatars.mds.yandex.net/get-mpic/4399709/img_id4103982150204587909.jpeg/orig', 'Отверженные', 'Новое', 'Драма', 2),
    (2, 'Электроника',current_date,'Беспроводные наушники Sony WI-C310 синие','https://www.kivano.kg/images/product/87444/full/1609232285_79466800.jpg', 'Наушник', 'Б/У', 'Аксессуары', 3),
    (3, 'Одежда',current_date,'Niyar style Представляю вашему вниманию бренд одежды, исключительно новые модели. Всё выполнено в индивидуальном стиле Шьём в быстрые сроки и в высоком качестве','https://s.optlist.ru/i/54/78/16c4007793e3cf48-5478-1.jpg', 'Рубашка', 'Все', 'Рубашка', 4),
    (4, 'Одежда',current_date,'Boys Chest Stripe Sun Farer Polo Shirt | Southern Tide','https://cdn.shopify.com/s/files/1/2294/8559/products/youth-mesa-sun-farer-polo-shirt-9667_2048x2048.jpg?v=1676045990', 'Polo', 'новое', 'Рубашка', 5),
    (5, 'Электроника',current_date,'СЕТЕВОЕ ЗАРЯДНОЕ УСТРОЙСТВО HOCO C26 QUICK CHARGE QUALCOMM QC3.0','https://softech.kg/image/cache/f4d29a07c9a0b69ba9cd6b03c4fb24b2.jpg', 'Зарядка', 'Все', 'Аксессуары', 6),
    (6, 'Книги',current_date,'На высоком холме стоит очень странный дом. С его хозяйкой, мисс Корицей, явно что-то не так! Она терпеть не может людей, и поэтому в доме не бывает гостей. По хозяйству странной мисс помогают двенадцать обезьян в шляпах, а в саду разгуливают бенгальские тигры. Но однажды в дверь мисс Корицы позвонили! На пороге стоял неопрятный и очень настойчивый мальчишка. Откуда он здесь взялся? И что ему нужно? Пекка Петтерссон уверяет, что потерял в доме мисс Корицы кое-что важное. Получится ли у него отыскать пропажу? А заодно раскрыть тайны странного дома на холме?','https://moreknig.org/uploads/posts/covers/d7/90/medium/strannyy-dom-miss-koricy-hay-magdalena-359029.jpg', '', 'Б/У', 'Фантастика', 7),
    (7, 'Электроника',current_date,'Сверхъемкий внешний аккумулятор Oarmio 23 000 mAh предназначен для использования в длительных путешествиях и зарядки большого количества девайсов. Cправится с зарядкой любых телефонов, смартфонов, планшетов, экшн камер, портативных колонок, GPS навигаторов, эхолотов, электронных книг, фото и видео камер, LED фонарей и другой мобильной техники. ','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8_qNmGALnxvCp0YWpwN182ee3cAo1YPU4HA&usqp=CAU', 'Повербанк', 'Новое', 'Аксессуары', 8),
    (8, 'Книги',current_date,'В Лектории «Прямая речь» каждый день выступают выдающиеся ученые, писатели, актеры и популяризаторы науки. Их оценки и мнения часто не совпадают с устоявшейся точкой зрения — идеи, мысли и открытия рождаются прямо на глазах слушателей. Вот уже десять лет визитная карточка «Прямой речи» — лекции Дмитрия Быкова по литературе. Быков приучает обращаться к знакомым текстам за советом и утешением, искать и находить в них ответы на вызовы нового дня. Его лекции — всегда события. Теперь они есть и в формате книги.«Русская литература: страсть и власть» — первая книга лекций Дмитрия Быкова. Протопоп Аввакум, Ломоносов, Крылов, Пушкин, Лермонтов, Гоголь, Некрасов, Тургенев, Гончаров, Толстой, Достоевский...','https://cdn.ast.ru/v2/ASE000000000846056/COVER/cover1__w220.jpg', 'Русская литература: страсть и власть', 'Все', 'Литература', 9),
    (9, 'Одежда',current_date,'Джинсы широкие мужские','data:image/jpeg;base64,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', 'Джинсы', 'Новое', 'Брюки', 10);


INSERT INTO holidays (id, date, image, name, user_id)
VALUES
    (1, '2023-01-01', 'image1.jpg', 'New Year', 1),
    (2, '2023-02-14', 'image2.jpg', 'Valentine''s Day', 2),
    (3, '2023-03-08', 'image3.jpg', 'International Women''s Day', 3),
    (4, '2023-04-01', 'image4.jpg', 'April Fool''s Day', 4),
    (5, '2023-05-01', 'image5.jpg', 'Labor Day', 5),
    (6, '2023-06-12', 'image6.jpg', 'Russia Day', 6),
    (7, '2023-07-04', 'image7.jpg', 'Independence Day', 7),
    (8, '2023-09-01', 'image8.jpg', 'Knowledge Day', 8),
    (9, '2023-10-31', 'image9.jpg', 'Halloween', 9);


INSERT INTO wishes (id, date_of_holiday, description, image, link_gift, name, status, holiday_id, user_id)
VALUES
    (1, '2023-01-01', 'Description 1','image1.jpg', 'https://www.amazon.com/giftcard', 'Amazon Gift Card',true, 1, 1),
    (2, '2023-02-14', 'Description 2','image2.jpg', 'https://www.sephora.com/giftcard', 'Sephora Gift Card',true, 2, 2),
    (3, '2023-03-08', 'Description 3','image3.jpg', 'https://www.etsy.com/giftcard', 'Etsy Gift Card',false, 3, 3),
    (4, '2023-04-01', 'Description 4','image4.jpg', 'https://www.target.com/giftcard', 'Target Gift Card',true, 4, 4),
    (5, '2023-05-01', 'Description 5','image5.jpg', 'https://www.bestbuy.com/giftcard', 'Best Buy Gift Card',true, 5, 5),
    (6, '2023-06-12', 'Description 6','image6.jpg', 'https://www.nike.com/giftcard', 'Nike Gift Card',false, 6, 6),
    (7, '2023-07-04', 'Description 7','image7.jpg', 'https://www.apple.com/giftcard', 'Apple Gift Card',true, 7, 7),
    (8, '2023-09-01', 'Description 8','image8.jpg', 'https://www.starbucks.com/giftcard', 'Starbucks Gift Card',false, 8, 8),
    (9, '2023-10-31', 'Description 9','image9.jpg', 'https://www.netflix.com/giftcard', 'Netflix Gift Card',true, 9, 9);

INSERT INTO mailings (id, created_at, description, image, title)
VALUES
    (1, '2023-04-05 09:00:00', 'Описание рассылки 1', 'image1.jpg', 'Заголовок рассылки 1'),
    (2, '2023-04-06 10:00:00', 'Описание рассылки 2', 'image2.jpg', 'Заголовок рассылки 2'),
    (3, '2023-04-07 11:00:00', 'Описание рассылки 3', 'image3.jpg', 'Заголовок рассылки 3'),
    (4, '2023-04-08 12:00:00', 'Описание рассылки 4', 'image4.jpg', 'Заголовок рассылки 4'),
    (5, '2023-04-09 13:00:00', 'Описание рассылки 5', 'image5.jpg', 'Заголовок рассылки 5'),
    (6, '2023-04-10 14:00:00', 'Описание рассылки 6', 'image6.jpg', 'Заголовок рассылки 6'),
    (7, '2023-04-11 15:00:00', 'Описание рассылки 7', 'image7.jpg', 'Заголовок рассылки 7'),
    (8, '2023-04-12 16:00:00', 'Описание рассылки 8', 'image8.jpg', 'Заголовок рассылки 8'),
    (9, '2023-04-13 17:00:00', 'Описание рассылки 9', 'image9.jpg', 'Заголовок рассылки 9');

INSERT INTO users_friends(user_id, friends_id)
VALUES
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 3),
    (2, 4),
    (2, 5),
    (3, 4),
    (3, 5),
    (3, 6);

INSERT INTO users_requests_for_friends(user_id, requests_for_friends_id)
VALUES
    (1, 6),
    (1, 7),
    (1, 8);


INSERT INTO reserves (id, is_anonymous, charity_id, user_id, wish_id)
VALUES
    (1, false, 9, 7, 7),
    (2, false, 2, 8, 8),
    (3, false, 3, 9, 9);

INSERT INTO complaints (id, complaint, seen, user_id)
VALUES
    (1, 'Complaint 10', false, 2),
    (2, 'Complaint 2', true, 3);


INSERT INTO wishes_complaints(wish_id, complaints_id)
values (1,2);


INSERT INTO charities_complaints(charity_id, complaints_id)
VALUES
    (1,2);


INSERT INTO notifications(id, created_at, message, seen, type, charity_id, from_whom_user_id, reserve_id, wish_id)
VALUES
    (3, '2023-04-14', 'У вас новое уведомление', false, 'ADD_GIFT_TO_WISH_LIST', 2, 2, 2, 2),
    (4, '2023-04-14 12:48:27', 'Вы получили новое сообщение', false, 'ADD_GIFT_TO_WISH_LIST', null, 3, 2, 3),
    (5, '2023-04-14 12:49:27', 'Вы получили новый запрос на добавление в друзья', false, 'ADD_GIFT_TO_WISH_LIST', null, 4, 2, 4);
