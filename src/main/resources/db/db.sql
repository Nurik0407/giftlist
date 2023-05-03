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


INSERT INTO charities (id,category,date_of_issue,description, name, state, sub_category,user_id)
VALUES
    (1, 'Category 1',current_date,'Description 1', 'Name 1', 'state 1', 'Sub-Category 1', 2),
    (2, 'Category 2',current_date,'Description 2', 'Name 2', 'state 2', 'Sub-Category 2', 3),
    (3, 'Category 3',current_date,'Description 3', 'Name 3', 'state 3', 'Sub-Category 3', 4),
    (4, 'Category 4',current_date,'Description 4', 'Name 4', 'state 4', 'Sub-Category 4', 5),
    (5, 'Category 5',current_date,'Description 5', 'Name 5', 'state 5', 'Sub-Category 5', 6),
    (6, 'Category 6',current_date,'Description 6', 'Name 6', 'state 6', 'Sub-Category 6', 7),
    (7, 'Category 7',current_date,'Description 7', 'Name 7', 'state 7', 'Sub-Category 7', 8),
    (8, 'Category 8',current_date,'Description 8', 'Name 8', 'state 8', 'Sub-Category 8', 9),
    (9, 'Category 9',current_date,'Description 9', 'Name 9', 'state 9', 'Sub-Category 9', 10);


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