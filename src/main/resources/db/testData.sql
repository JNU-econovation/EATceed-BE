INSERT INTO AGREEMENT_TB (AGREEMENT_PK, CREATED_DATE, UPDATED_DATE, AGREEMENT_IS_PRIVACY_POLICY_AGREE, AGREEMENT_IS_TERMS_SERVICE_AGREE, AGREEMENT_IS_OVER_AGE)
VALUES (1, '2023-11-01 08:00:00', '2023-11-01 08:00:00', true, true, true),
       (2, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (3, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (4, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (5, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (6, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (7, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (8, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (9, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true),
       (10, '2023-12-01 08:00:00', '2023-12-01 08:00:00', true, true, true);

INSERT INTO MEMBER_TB (MEMBER_PK, CREATED_DATE, UPDATED_DATE, MEMBER_ACTIVITY, MEMBER_AGE, MEMBER_ETC, MEMBER_GENDER,
                       MEMBER_HEIGHT, MEMBER_WEIGHT, MEMBER_TARGET_WEIGHT, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_ROLE, MEMBER_CHECKED, AGREEMENT_FK)
VALUES (1, '2023-11-01 08:00:00', '2024-07-02 09:00:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 175.0, 76.0, 78.0, 'abcd123!@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.0Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 1),
       (2, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 178.0, 72.0, 79.0, 'abcd234@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.2Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 2),
       (3, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 165.0, 60.0, 78.0, 'abcd345@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.3Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 3),
       (4, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 180.0, 75.0, 82.0, 'abcd456@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.4Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 4),
       (5, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 170.0, 68.0, 75.0, 'abcd567@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.5Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 5),
       (6, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 177.0, 71.0, 77.0, 'abcd678@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.6Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 6),
       (7, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 169.0, 69.0, 74.0, 'abcd789@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.7Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 7),
       (8, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 181.0, 74.0, 90.0, 'abcd890@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.8Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 8),
       (9, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 168.0, 65.0, 72.0, 'abcd901@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.9Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 9),
       (10, '2023-12-01 08:00:00', '2023-12-01 08:10:00', 'NOT_ACTIVE', 30, 'MdrkiRJZTJRgRVfYSlu8ug==', 1, 172.0, 66.0, 73.0, 'abcd012@@gmail.com',
        '$2a$10$pljAKl0Ad3LnjQyQei.Yz.0Cfcn3Zv/xeBMDwUHDaUrfG8Wm57c56', 'MEMBER', true, 10);


INSERT INTO HISTORY_TB(HISTORY_PK, CREATED_DATE, UPDATED_DATE, HISTORY_ACTIVITY,HISTORY_AGE,HISTORY_GENDER,HISTORY_HEIGHT, HISTORY_WEIGHT, HISTORY_TARGET_WEIGHT ,MEMBER_FK)

VALUES(1, '2023-11-13 11:00:00', '2023-11-13 11:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 69.0, 78.0, 1),
      (2, '2023-12-03 11:00:00', '2023-12-03 11:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 71.0, 78.0,1),
      (3, '2023-12-05 09:00:00', '2023-12-05 09:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 72.0, 78.0,1),
      (4, '2023-12-07 09:00:00', '2023-12-07 09:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 73.0, 78.0,1),
      (5, '2024-06-02 09:00:00', '2024-06-02 09:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 74.0, 78.0,1),
      (6, '2024-06-20 09:00:00', '2024-06-20 09:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 75.0, 78.0,1),
      (7, '2024-07-02 09:00:00', '2024-07-02 09:00:00', 'NOT_ACTIVE', 30, 1, 175.0, 76.0, 78.0,1);



INSERT INTO FOOD_TB (FOOD_PK, FOOD_CALORIE, FOOD_CARBOHYDRATE, FOOD_FAT, FOOD_NAME, FOOD_PROTEIN,
                     FOOD_SERVING_SIZE, FOOD_SUGARS, FOOD_DIETARY_FIBER, FOOD_SODIUM ,MEMBER_FK)
VALUES (1, 200.0, 30.0, 10.0, '사과', 2.0, 120.0, 3.1, 2.3,500, null),
       (2, 300.0, 40.0, 20.0, '바나나', 3.0, 120.0, 3.1, 2.3,500, null),
       (3, 400.0, 50.0, 30.0, '포도', 4.0, 120.0, 3.1, 2.3,500, null),
       (4, 500.0, 60.0, 40.0, '수박', 5.0, 120.0, 3.1, 2.3,500, null),
       (5, 600.0, 70.0, 50.0, '딸기', 6.0, 120.0, 3.1, 2.3,500, null),
       (6, 700.0, 80.0, 60.0, '복숭아', 7.0, 120.0, 3.1, 2.3,500, null),
       (7, 800.0, 90.0, 70.0, '오렌지', 8.0, 120.0, 3.1, 2.3,500, null),
       (8, 900.0, 10.0, 80.0, '키위', 9.0, 120.0, 3.1, 2.3,500, null),
       (9, 1000.0, 20.0, 90.0, '체리', 10.0, 120.0, 3.1, 2.3,500, null),
       (10, 1100.0, 30.0, 100.0, '레몬', 11.0, 120.0, 3.1, 2.3,500, null),
       (11, 1200.0, 40.0, 110.0, '자몽', 12.0, 120.0, 3.1, 2.3,500, null),
       (12, 1300.0, 50.0, 120.0, '망고', 13.0, 120.0, 3.1, 2.3,500, null),
       (13, 1400.0, 60.0, 130.0, '파인애플', 14.0, 120.0, 3.1, 2.3,500, null),
       (14, 1500.0, 70.0, 140.0, '아보카도', 15.0, 120.0, 3.1, 2.3,500, null),
       (15, 1600.0, 80.0, 150.0, '망고스틴', 16.0, 120.0, 3.1, 2.3,500, null),
       (16, 1700.0, 90.0, 160.0, '파파야', 17.0, 120.0, 3.1, 2.3,500, null),
       (17, 1800.0, 10.0, 170.0, '블루베리', 18.0, 120.0, 3.1, 2.3,500, null),
       (18, 1900.0, 20.0, 180.0, '라즈베리', 19.0, 120.0, 3.1, 2.3,500, null),
       (19, 2000.0, 30.0, 190.0, '블랙베리', 20.0, 120.0, 3.1, 2.3,500, null),
       (20, 200.0, 245.0, 1.3, '가자미구이', 37.4, 10.0, 3.1, 2.3,500, null),
       (21, 200.0, 275.0, 1.2, '갈치구이', 43.1, 11.0, 3.1, 2.3,500, null),
       (22, 200.0, 551.0, 0.4, '고등어구이', 47.7, 40.0, 3.1, 2.3,500, null),
       (23, 200.0, 679.0, 7.6, '고등어석쇠구이', 46.7, 51.4, 3.1, 2.3,500, null),
       (24, 150.0, 291.0, 0.1, '굴비구이', 28.0, 19.9, 3.1, 2.3,500, null),
       (25, 200.0, 604.0, 4.3, '꽁치구이', 49.4, 43.4, 3.1, 2.3,500, null),
       (26, 250.0, 397.0, 2.1, '도미구이', 61.1, 16.5, 3.1, 2.3,500, null),
       (27, 70.0, 261.0, 17.6, '뱅어포구이', 24.1, 10.6, 3.1, 2.3,500, null),
       (28, 250.0, 488.0, 0.2, '병어구이', 54.6, 30.8, 3.1, 2.3,500, null),
       (29, 100.0, 296.54, 11.6, '붕장어소금구이', 26.0, 16.2, 3.1, 2.3,500, null),
       (30, 200.0, 355.71, 8.48, '삼치구이', 37.83, 18.01, 3.1, 2.3,500, null),
       (31, 180.0, 260.0, 5.1, '새우구이', 42.1, 8.0, 3.1, 2.3,500, null),
       (32, 150.0, 433.35, 8.8, '양념장어구이', 30.77, 30.56, 3.1, 2.3,500, null),
       (33, 250.0, 494.0, 3.5, '임연수구이', 53.8, 29.4, 3.1, 2.3,500, null),
       (34, 180.0, 460.0, 36.4, '조기구이', 34.8, 19.5, 3.1, 2.3,500, null),
       (35, 5.0, 23.0, 1.4, '조미김', 1.0, 1.5, 3.1, 2.3,500, null),
       (36, 70.0, 238.0, 37.4, '쥐포구이', 21.7, 0.2, 3.1, 2.3,500, null),
       (37, 200.0, 326.21, 2.3, '짚불구이곰장어', 42.7, 16.2, 3.1, 2.3,500, null),
       (38, 180.0, 346.0, 2.5, '참치머리구이', 47.8, 16.2, 3.1, 2.3,500, null),
       (39, 180.0, 234.0, 18.8, '키조개구이', 31.4, 3.7, 3.1, 2.3,500, null),
       (40, 200.0, 437.57, 26.9, '황태구이', 47.8, 15.4, 3.1, 2.3,500, null),
       (41, 300.0, 740.0, 10.6, '간장양념닭다리구이', 68.9, 46.9, 3.1, 2.3,500, null),
       (42, 100.0, 142.0, 3.0, '그레이프 소스 스테이크', 10.0, 10.0, 3.1, 2.3,500, null),
       (43, 500.0, 368.8, 39.7, '꿩불고기', 33.5, 8.5, 3.1, 2.3,500, null),
       (44, 170.0, 416.0, 17.6, '닭고기대파꼬치구이', 30.3, 25.0, 3.1, 2.3,500, null),
       (45, 340.0, 872.0, 26.5, '닭구이', 89.1, 45.5, 3.1, 2.3,500, null),
       (46, 70.0, 177.51, 12.9, '닭꼬치', 12.35, 7.9, 3.1, 2.3,500, null),
       (47, 220.0, 431.0, 21.3, '닭발구이', 39.9, 20.7, 3.1, 2.3,500, null),
       (48, 220.0, 431.0, 21.3, '양구이', 39.9, 20.7, 3.1, 2.3,500, null),
       (49, 220.0, 431.0, 21.3, '소구이', 39.9, 20.7, 3.1, 2.3,500, null),
       (50, 220.0, 431.0, 21.3, '토끼구이', 39.9, 20.7, 3.1, 2.3,500, null),
       (51, 220.0, 431.0, 21.3, '멧돼지구이', 39.9, 20.7, 3.1, 2.3,500, null),
       (52, 220.0, 431.0, 21.3, '참새구이', 39.9, 20.7, 3.1, 2.3,500, null),
       (53, 100.0, 143.0, 8.0, '더블 체다 함박 스테이크', 12.0, 7.0, 3.1, 2.3,500, null),
       (54, 100.0, 248.52, 7.6, '돼지갈비', 19.95, 14.7, 3.1, 2.3,500, null),
       (55, 170.0, 339.0, 2.6, '돼지고기산적', 49.4, 14.6, 3.1, 2.3,500, null),
       (56, 200.0, 449.0, 8.1, '돼지불고기', 29.7, 33.1, 3.1, 2.3,500, 1);

INSERT INTO MEAL_TB (MEAL_PK, CREATED_DATE, UPDATED_DATE, MEAL_TYPE, MEMBER_FK)
VALUES
    (1, '2024-06-04 00:00:00', '2024-06-04 00:00:00', 'BREAKFAST', 1),
    (2, '2024-06-04 00:00:00', '2024-06-04 00:00:00', 'LUNCH', 1),
    (3, '2024-06-05 00:00:00', '2024-06-05 00:00:00', 'BREAKFAST', 1),
    (4, '2024-06-05 00:00:00', '2024-06-05 00:00:00', 'LUNCH', 1),
    (5, '2024-06-06 00:00:00', '2024-06-06 00:00:00', 'BREAKFAST', 1),
    (6, '2024-06-06 00:00:00', '2024-06-06 00:00:00', 'LUNCH', 1),
    (7, '2024-06-07 00:00:00', '2024-06-07 00:00:00', 'BREAKFAST', 1),
    (8, '2024-06-07 00:00:00', '2024-06-07 00:00:00', 'LUNCH', 1),
    (9, '2024-06-08 00:00:00', '2024-06-08 00:00:00', 'BREAKFAST', 1),
    (10, '2024-06-08 00:00:00', '2024-06-08 00:00:00', 'LUNCH', 1),
    (11, '2024-06-09 00:00:00', '2024-06-09 00:00:00', 'BREAKFAST', 1),
    (12, '2024-06-09 00:00:00', '2024-06-09 00:00:00', 'LUNCH', 1),
    (13, '2024-06-10 00:00:00', '2024-06-10 00:00:00', 'BREAKFAST', 1),
    (14, '2024-06-10 00:00:00', '2024-06-10 00:00:00', 'LUNCH', 1),
    (15, '2024-06-11 00:00:00', '2024-06-11 00:00:00', 'BREAKFAST', 1),
    (16, '2024-06-11 00:00:00', '2024-06-11 00:00:00', 'LUNCH', 1),
    (17, '2024-06-12 00:00:00', '2024-06-12 00:00:00', 'BREAKFAST', 1),
    (18, '2024-06-12 00:00:00', '2024-06-12 00:00:00', 'LUNCH', 1),
    (19, '2024-06-13 00:00:00', '2024-06-13 00:00:00', 'BREAKFAST', 1),
    (20, '2024-06-13 00:00:00', '2024-06-13 00:00:00', 'LUNCH', 1),
    (21, '2024-06-14 00:00:00', '2024-06-14 00:00:00', 'BREAKFAST', 1),
    (22, '2024-06-14 00:00:00', '2024-06-14 00:00:00', 'LUNCH', 1),
    (23, '2024-06-15 00:00:00', '2024-06-15 00:00:00', 'BREAKFAST', 1),
    (24, '2024-06-15 00:00:00', '2024-06-15 00:00:00', 'LUNCH', 1),
    (25, '2024-06-16 00:00:00', '2024-06-16 00:00:00', 'BREAKFAST', 1),
    (26, '2024-06-16 00:00:00', '2024-06-16 00:00:00', 'LUNCH', 1),
    (27, '2024-06-17 00:00:00', '2024-06-17 00:00:00', 'BREAKFAST', 1),
    (28, '2024-06-17 00:00:00', '2024-06-17 00:00:00', 'LUNCH', 1),
    (29, '2024-06-18 00:00:00', '2024-06-18 00:00:00', 'BREAKFAST', 1),
    (30, '2024-06-18 00:00:00', '2024-06-18 00:00:00', 'LUNCH', 1),
    (31, '2024-06-19 00:00:00', '2024-06-19 00:00:00', 'BREAKFAST', 1),
    (32, '2024-06-19 00:00:00', '2024-06-19 00:00:00', 'LUNCH', 1),
    (33, '2024-06-20 00:00:00', '2024-06-20 00:00:00', 'BREAKFAST', 1),
    (34, '2024-06-20 00:00:00', '2024-06-20 00:00:00', 'LUNCH', 1),
    (35, '2024-06-21 00:00:00', '2024-06-21 00:00:00', 'BREAKFAST', 1),
    (36, '2024-06-21 00:00:00', '2024-06-21 00:00:00', 'LUNCH', 1),
    (37, '2024-06-22 00:00:00', '2024-06-22 00:00:00', 'BREAKFAST', 1),
    (38, '2024-06-22 00:00:00', '2024-06-22 00:00:00', 'LUNCH', 1),
    (39, '2024-06-23 00:00:00', '2024-06-23 00:00:00', 'BREAKFAST', 1),
    (40, '2024-06-23 00:00:00', '2024-06-23 00:00:00', 'LUNCH', 1),
    (41, '2024-06-24 00:00:00', '2024-06-24 00:00:00', 'BREAKFAST', 1),
    (42, '2024-06-24 00:00:00', '2024-06-24 00:00:00', 'LUNCH', 1),
    (43, '2024-06-25 00:00:00', '2024-06-25 00:00:00', 'BREAKFAST', 1),
    (44, '2024-06-25 00:00:00', '2024-06-25 00:00:00', 'LUNCH', 1),
    (45, '2024-06-26 00:00:00', '2024-06-26 00:00:00', 'BREAKFAST', 1),
    (46, '2024-06-26 00:00:00', '2024-06-26 00:00:00', 'LUNCH', 1),
    (47, '2024-06-27 00:00:00', '2024-06-27 00:00:00', 'BREAKFAST', 1),
    (48, '2024-06-27 00:00:00', '2024-06-27 00:00:00', 'LUNCH', 1),
    (49, '2024-06-28 00:00:00', '2024-06-28 00:00:00', 'BREAKFAST', 1),
    (50, '2024-06-28 00:00:00', '2024-06-28 00:00:00', 'LUNCH', 1),
    (51, '2024-06-29 00:00:00', '2024-06-29 00:00:00', 'BREAKFAST', 1),
    (52, '2024-06-29 00:00:00', '2024-06-29 00:00:00', 'LUNCH', 1),
    (53, '2024-06-30 00:00:00', '2024-06-30 00:00:00', 'BREAKFAST', 1),
    (54, '2024-06-30 00:00:00', '2024-06-30 00:00:00', 'LUNCH', 1),
    (55, '2024-07-01 00:00:00', '2024-07-01 00:00:00', 'BREAKFAST', 1),
    (56, '2024-07-01 00:00:00', '2024-07-01 00:00:00', 'LUNCH', 1),
    (57, '2024-07-02 00:00:00', '2024-07-02 00:00:00', 'LUNCH', 1),
    (58, '2024-07-02 00:00:00', '2024-07-02 00:00:00', 'DINNER', 1),
    (59, '2024-07-03 00:00:00', '2024-07-03 00:00:00', 'SNACK', 1),
    (60, '2024-07-03 00:00:00', '2024-07-03 00:00:00', 'LUNCH', 1),
    (61, '2024-07-03 00:00:00', '2024-07-03 00:00:00', 'DINNER', 1),
    (62, '2024-07-04 00:00:00', '2024-07-04 00:00:00', 'BREAKFAST', 1),
    (63, '2024-07-04 00:00:00', '2024-07-04 00:00:00', 'SNACK', 1),
    (64, '2024-07-04 00:00:00', '2024-07-04 00:00:00', 'DINNER', 1),
    (65, '2024-07-05 00:00:00', '2024-07-05 00:00:00', 'BREAKFAST', 1),
    (66, '2024-07-05 00:00:00', '2024-07-05 00:00:00', 'LUNCH', 1),
    (67, '2024-07-05 00:00:00', '2024-07-05 00:00:00', 'DINNER', 1),
    (68, '2024-07-06 00:00:00', '2024-07-06 00:00:00', 'BREAKFAST', 1),
    (69, '2024-07-06 00:00:00', '2024-07-06 00:00:00', 'LUNCH', 1);

INSERT INTO MEAL_FOOD_TB (MEAL_FOOD_PK, CREATED_DATE, UPDATED_DATE, FOOD_FK, MEAL_FK, MEAL_FOOD_MULTIPLE, MEAL_FOOD_G)
VALUES
    (1, '2024-06-04 00:00:00', '2024-06-04 00:00:00', 1, 1, 1.0, null),
    (2, '2024-06-04 00:00:00', '2024-06-04 00:00:00', 2, 2, null, 200),
    (3, '2024-06-05 00:00:00', '2024-06-05 00:00:00', 3, 3, 1.5, null),
    (4, '2024-06-05 00:00:00', '2024-06-05 00:00:00', 4, 4, null, 150),
    (5, '2024-06-06 00:00:00', '2024-06-06 00:00:00', 5, 5, 2.0, null),
    (6, '2024-06-06 00:00:00', '2024-06-06 00:00:00', 6, 6, null, 100),
    (7, '2024-06-07 00:00:00', '2024-06-07 00:00:00', 7, 7, 0.5, null),
    (8, '2024-06-07 00:00:00', '2024-06-07 00:00:00', 8, 8, null, 250),
    (9, '2024-06-08 00:00:00', '2024-06-08 00:00:00', 9, 9, 1.2, null),
    (10, '2024-06-08 00:00:00', '2024-06-08 00:00:00', 10, 10, null, 180),
    (11, '2024-06-09 00:00:00', '2024-06-09 00:00:00', 11, 11, 1.3, null),
    (12, '2024-06-09 00:00:00', '2024-06-09 00:00:00', 12, 12, null, 170),
    (13, '2024-06-10 00:00:00', '2024-06-10 00:00:00', 12, 13, 1.1, null),
    (14, '2024-06-10 00:00:00', '2024-06-10 00:00:00', 1, 14, null, 210),
    (15, '2024-06-11 00:00:00', '2024-06-11 00:00:00', 2, 15, 1.4, null),
    (16, '2024-06-11 00:00:00', '2024-06-11 00:00:00', 3, 16, null, 160),
    (17, '2024-06-12 00:00:00', '2024-06-12 00:00:00', 4, 17, 1.6, null),
    (18, '2024-06-12 00:00:00', '2024-06-12 00:00:00', 5, 18, null, 140),
    (19, '2024-06-13 00:00:00', '2024-06-13 00:00:00', 6, 19, 1.8, null),
    (20, '2024-06-13 00:00:00', '2024-06-13 00:00:00', 7, 20, null, 120),
    (21, '2024-06-14 00:00:00', '2024-06-14 00:00:00', 8, 21, 2.0, null),
    (22, '2024-06-14 00:00:00', '2024-06-14 00:00:00', 9, 22, null, 110),
    (23, '2024-06-15 00:00:00', '2024-06-15 00:00:00', 10, 23, 0.8, null),
    (24, '2024-06-15 00:00:00', '2024-06-15 00:00:00', 11, 24, null, 190),
    (25, '2024-06-16 00:00:00', '2024-06-16 00:00:00', 12, 25, 1.7, null),
    (26, '2024-06-16 00:00:00', '2024-06-16 00:00:00', 12, 26, null, 130),
    (27, '2024-06-17 00:00:00', '2024-06-17 00:00:00', 1, 27, 1.2, null),
    (28, '2024-06-17 00:00:00', '2024-06-17 00:00:00', 2, 28, null, 200),
    (29, '2024-06-18 00:00:00', '2024-06-18 00:00:00', 3, 29, 1.5, null),
    (30, '2024-06-18 00:00:00', '2024-06-18 00:00:00', 4, 30, null, 150),
    (31, '2024-06-19 00:00:00', '2024-06-19 00:00:00', 5, 31, 2.0, null),
    (32, '2024-06-19 00:00:00', '2024-06-19 00:00:00', 6, 32, null, 100),
    (33, '2024-06-20 00:00:00', '2024-06-20 00:00:00', 7, 33, 0.5, null),
    (34, '2024-06-20 00:00:00', '2024-06-20 00:00:00', 8, 34, null, 250),
    (35, '2024-06-21 00:00:00', '2024-06-21 00:00:00', 9, 35, 1.2, null),
    (36, '2024-06-21 00:00:00', '2024-06-21 00:00:00', 10, 36, null, 180),
    (37, '2024-06-22 00:00:00', '2024-06-22 00:00:00', 11, 37, 1.3, null),
    (38, '2024-06-22 00:00:00', '2024-06-22 00:00:00', 12, 38, null, 170),
    (39, '2024-06-23 00:00:00', '2024-06-23 00:00:00', 12, 39, 1.1, null),
    (40, '2024-06-23 00:00:00', '2024-06-23 00:00:00', 1, 40, null, 210),
    (41, '2024-06-24 00:00:00', '2024-06-24 00:00:00', 2, 41, 1.4, null),
    (42, '2024-06-24 00:00:00', '2024-06-24 00:00:00', 3, 42, null, 160),
    (43, '2024-06-25 00:00:00', '2024-06-25 00:00:00', 4, 43, 1.6, null),
    (44, '2024-06-25 00:00:00', '2024-06-25 00:00:00', 5, 44, null, 140),
    (45, '2024-06-26 00:00:00', '2024-06-26 00:00:00', 6, 45, 1.8, null),
    (46, '2024-06-26 00:00:00', '2024-06-26 00:00:00', 7, 46, null, 120),
    (47, '2024-06-27 00:00:00', '2024-06-27 00:00:00', 8, 47, 2.0, null),
    (48, '2024-06-27 00:00:00', '2024-06-27 00:00:00', 9, 48, null, 110),
    (49, '2024-06-28 00:00:00', '2024-06-28 00:00:00', 10, 49, 0.8, null),
    (50, '2024-06-28 00:00:00', '2024-06-28 00:00:00', 11, 50, null, 190),
    (51, '2024-06-29 00:00:00', '2024-06-29 00:00:00', 12, 51, 1.7, null),
    (52, '2024-06-29 00:00:00', '2024-06-29 00:00:00', 12, 52, null, 130),
    (53, '2024-06-30 00:00:00', '2024-06-30 00:00:00', 1, 53, 1.2, null),
    (54, '2024-06-30 00:00:00', '2024-06-30 00:00:00', 2, 54, null, 200),
    (55, '2024-07-01 00:00:00', '2024-07-01 00:00:00', 3, 55, 1.5, null),
    (56, '2024-07-01 00:00:00', '2024-07-01 00:00:00', 4, 56, null, 150),
    (57, '2024-07-02 00:00:00', '2024-07-02 00:00:00', 5, 57, 2.0, null),
    (58, '2024-07-02 00:00:00', '2024-07-02 00:00:00', 6, 58, null, 100),
    (59, '2024-07-03 00:00:00', '2024-07-03 00:00:00', 7, 59, 0.5, null),
    (60, '2024-07-03 00:00:00', '2024-07-03 00:00:00', 8, 60, null, 250),
    (61, '2024-07-03 00:00:00', '2024-07-03 00:00:00', 9, 61, 1.2, null),
    (62, '2024-07-04 00:00:00', '2024-07-04 00:00:00', 10, 62, null, 8),
    (63, '2024-07-04 00:00:00', '2024-07-04 00:00:00', 11, 63, 0.3, null),
    (64, '2024-07-04 00:00:00', '2024-07-04 00:00:00', 12, 64, null, 7),
    (65, '2024-07-05 00:00:00', '2024-07-05 00:00:00', 12, 65, 1.1, null),
    (66, '2024-07-05 00:00:00', '2024-07-05 00:00:00', 1, 66, null, 210),
    (67, '2024-07-05 00:00:00', '2024-07-05 00:00:00', 2, 67, 1.4, null),
    (68, '2024-07-06 00:00:00', '2024-07-06 00:00:00', 3, 68, null, 160),
    (69, '2024-07-06 00:00:00', '2024-07-06 00:00:00', 4, 69, 1.6, null),
    (70, '2024-07-06 00:00:00', '2024-07-06 00:00:00', 5, 69, null, 140),
    (71, '2024-07-06 00:00:00', '2024-07-06 00:00:00', 6, 69, 1.8, null);

