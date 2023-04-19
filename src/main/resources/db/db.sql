insert into user_infos (id,clothing_size,country,date_of_birth,facebook,hobby,image,important,instagram,phone_number,shoe_size,telegram,whats_app)
values (2,33,'Kyrgyzstan','2004-12-12','https://www.facebook.com/profile.php?id=100076926076401','play cs go','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996999234554',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (3,34,'Kyrgyzstan','2004-10-12','https://www.facebook.com/profile.php?id=100076926076401','play tennis','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996709899876',43,'http://t.me/nurkanowich','http://wa.me/996508206602'),
       (4,37,'Kyrgyzstan','2000-12-12','https://www.facebook.com/profile.php?id=100076926076401','play cs source','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996709465733',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (5,36,'Kyrgyzstan','2004-11-11','https://www.facebook.com/profile.php?id=100076926076401','play minecraft','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996559234595',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (6,48,'Kyrgyzstan','1998-10-09','https://www.facebook.com/profile.php?id=100076926076401','play pes 2013','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996559234595',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (7,46,'Kyrgyzstan','2000-10-05','https://www.facebook.com/profile.php?id=100076926076401','play cs 1.6','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996559290595',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (8,45,'Kyrgyzstan','1997-12-03','https://www.facebook.com/profile.php?id=100076926076401','play warface','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996959234845',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (9,42,'Kyrgyzstan','1998-12-12','https://www.facebook.com/profile.php?id=100076926076401','play aviator','image','alrgiasy kyzdarga bar','https://instagram.com/nurkanowich?utm_medium=copy_link','+996999234595',43,'http://t.me/adilet_524','http://wa.me/996508206602'),
       (10,34,'Kyrgyzstan','2002-10-12','https://www.facebook.com/profile.php?id=100076926076401','play need for speed','alrgiasy kyzdarga bar','image','https://instagram.com/nurkanowich?utm_medium=copy_link','+996999234595',43,'http://t.me/adilet_524','http://wa.me/996508206602');



insert into users (id, email, first_name, is_blocked,last_name,password,role,user_info_id)
values (2,'nurislamnurkanov@gmail.com','Nurislam',false,'Nurkanov','nurislam1234','USER',2),
       (3,'nursultan@gmail.com','Nursuldan',false,'Odesov','nursultan1234','USER',3),
       (4,'jumakadyrovadilet@gmail.com','Adilet',false,'Jumakadyrov','adilet524','USER',4),
       (5,'eldiarro2004@gmail.com','Eldiar',false,'Rasulov','aldiar1234','USER',5),
       (6,'nurmatova161196@gmail.com','',false,'','','USER',6),
       (7,'nurisa.abdykalykova03@gmail.com','Nurisa',false,'Abdykalykova','nurisa1234','USER',7),
       (8,'programmist00707@gmail.com','Syimyk',false,'Ravshanbekov','admin1234','USER',8),
       (9,'adinai.sharshekeeva.kk@gmail.com','Adinai',false,'Sharshekeeva','sharshekeeva1234','USER',9),
       (10,'a.asangazieva@gmail.com','Aijamal',false,'Asangazieva','asangazieva1234','USER',10);



-- INSERT INTO charities (id, category, condition, description, sub_category, date,title, user_id)
INSERT INTO charities (id,category, description, name, state,date, sub_category,user_id)
VALUES
    (1, 'Category 1', 'Description 1', 'Name 1', 'state 1','2023-01-02', 'Sub-Category 1', 2),
    (2, 'Category 2', 'Description 2', 'Name 2', 'state 2','2023-02-03',  'Sub-Category 2', 3),
    (3, 'Category 3', 'Description 3', 'Name 3', 'state 3','2022-02-04',  'Sub-Category 3', 4),
    (4, 'Category 4', 'Description 4', 'Name 4', 'state 4','2023-05-07',  'Sub-Category 4', 5),
    (5, 'Category 5', 'Description 5', 'Name 5', 'state 5', '2022-02-01', 'Sub-Category 5', 6),
    (6, 'Category 6', 'Description 6', 'Name 6', 'state 6','2023-02-03',  'Sub-Category 6', 7),
    (7, 'Category 7', 'Description 7', 'Name 7', 'state 7', '2022-10-05', 'Sub-Category 7', 8),
    (8, 'Category 8', 'Description 8', 'Name 8', 'state 8','2023-01-25',  'Sub-Category 8', 9),
    (9, 'Category 9', 'Description 9', 'Name 9', 'state 9','2021-02-07',  'Sub-Category 9', 10);


INSERT INTO charity_images(charity_id, images)
VALUES
    (1, 'image1.jpg'),
    (1, 'image2.jpg'),
    (1, 'image3.jpg'),
    (2, 'image4.jpg'),
    (2, 'image5.jpg'),
    (2, 'image6.jpg'),
    (3, 'image7.jpg'),
    (3, 'image8.jpg'),
    (3, 'image9.jpg'),
    (4, 'image10.jpg'),
    (4, 'image11.jpg'),
    (4, 'image12.jpg'),
    (5, 'image13.jpg'),
    (5, 'image14.jpg'),
    (5, 'image15.jpg'),
    (6, 'image16.jpg'),
    (7, 'image17.jpg');

INSERT INTO holidays (id, date, image, name, user_id)
VALUES
    (1, '2023-01-01', 'image1.jpg', 'New Year', 10),
    (2, '2023-02-14', 'image2.jpg', 'Valentine''s Day', 2),
    (3, '2023-03-08', 'image3.jpg', 'International Women''s Day', 3),
    (4, '2023-04-01', 'image4.jpg', 'April Fool''s Day', 4),
    (5, '2023-05-01', 'image5.jpg', 'Labor Day', 5),
    (6, '2023-06-12', 'image6.jpg', 'Russia Day', 6),
    (7, '2023-07-04', 'image7.jpg', 'Independence Day', 7),
    (8, '2023-09-01', 'image8.jpg', 'Knowledge Day', 8),
    (9, '2023-10-31', 'image9.jpg', 'Halloween', 9);


-- INSERT INTO wishes (id, date_of_holiday, image, link_of_gift, title, holiday_id, user_id)
INSERT INTO wishes (id, date_of_holiday, description, image, link_gift, name, status, holiday_id, user_id)
VALUES
    (1, '2023-01-01', 'Description 1','image1.jpg', 'https://www.amazon.com/giftcard', 'Amazon Gift Card',true, 1, 10),
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
    (10, 2),
    (10, 3),
    (10, 4),
    (2, 3),
    (2, 4),
    (2, 5),
    (3, 4),
    (3, 5),
    (3, 6);

INSERT INTO users_requests_for_friends(user_id, requests_for_friends_id)
VALUES
    (10, 6),
    (10, 7),
    (10, 8);

INSERT INTO reserves (id, is_anonymous, charity_id, user_id, wish_id)
VALUES
--     (1, false, 1, 1, 1),
--     (2, false, 2, 2, 2),
--     (3, false, 3, 3, 3),
--     (4, true, 1, 4, 4),
--     (5, true, 2, 5, 5),
--     (6, true, 3, 6, 6),
(1, false, 9, 7, 7),
(2, false, 2, 8, 8),
(3, false, 3, 9, 9);

INSERT INTO complaints (id, complaint, seen, user_id)
VALUES
    (1, 'Complaint 10', false, 2),
    (2, 'Complaint 2', true, 3);
--     (3, 'Complaint 3', false, 3, 3, 3),
--     (4, 'Complaint 4', true, 4, 4, 4),
--     (5, 'Complaint 5', false, 5, 5, 5),
--     (6, 'Complaint 6', true, 6, 6, 6),
--     (7, 'Complaint 7', false, 7, 7, 7),
--     (8, 'Complaint 8', true, 8, 8, 8),
--     (9, 'Complaint 9', false, 9, 9, 9);

INSERT INTO wishes_complaints(wish_id, complaints_id)
values (1,2);


INSERT INTO charities_complaints(charity_id, complaints_id)
VALUES
    (1,2);



INSERT INTO notifications(id, created_at, message, seen, type, charity_id, from_whom_user_id, reserve_id, wish_id)
VALUES
    (3, '2023-04-14', 'У вас новое уведомление', false, 2, 2, 2, 2, 2),
    (4, '2023-04-14 12:48:27', 'Вы получили новое сообщение', false, 2, null, 3, 2, 3),
    (5, '2023-04-14 12:49:27', 'Вы получили новый запрос на добавление в друзья', false, 3, null, 4, 2, 4);

-- INSERT INTO notifications(id, created_at, message, seen, type, charity_id, from_whom_user_id, reserve_id, wish_id)
-- VALUES
--     (1, '2023-04-14 12:47:27', 'У вас новое уведомление', false, 'type1', 1, 10, 100, 1000),
--     (2, '2023-04-14 12:48:27', 'Вы получили новое сообщение', false, 'type2', 2, 20, 200, 2000),
--     (3, '2023-04-14 12:49:27', 'Вы получили новый запрос на добавление в друзья', false, 'type3', 3, 30, 300, 3000);


-- INSERT INTO notifications(id, created_at, message, seen, type, charity_id, from_whom_user_id, reserve_id, wish_id)
-- values
--     (1, '2022-04-05', 'Notification message 1', false, 3, 1, 2, 1, 1);
