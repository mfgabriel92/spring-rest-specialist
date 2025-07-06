TRUNCATE TABLE cuisines CASCADE;
TRUNCATE TABLE restaurants CASCADE;
TRUNCATE TABLE payment_methods CASCADE;
TRUNCATE TABLE restaurants_payment_methods CASCADE;
TRUNCATE TABLE products CASCADE;
TRUNCATE TABLE users CASCADE;
TRUNCATE TABLE products CASCADE;
TRUNCATE TABLE groups CASCADE;
TRUNCATE TABLE permissions CASCADE;
TRUNCATE TABLE groups_permissions CASCADE;
TRUNCATE TABLE users CASCADE;
TRUNCATE TABLE users_groups CASCADE;
TRUNCATE TABLE orders CASCADE;
TRUNCATE TABLE order_items CASCADE;

INSERT INTO cuisines (id, name)
VALUES
    ('11eb5628-986c-42b4-9d18-f9e42377bd24', 'Italian'),
    ('ea11413a-569c-4e95-81ef-e34e6433a55b', 'Japanese'),
    ('5625390a-ef56-429e-902a-3c2341f5b753', 'Mexican'),
    ('2ad72324-8164-489e-b82f-b7c63e2e2bad', 'French'),
    ('701ce91e-0843-4609-955f-b174137f6ce6', 'Indian'),
    ('bf29805c-0bfe-4223-a18f-82920ac7b00a', 'Thai'),
    ('bf022f71-52b5-4292-86a3-8825725ce526', 'Chinese'),
    ('3a6d87f9-ea97-480b-a49a-254ea3cd03ed', 'Mediterranean'),
    ('d8c972ba-155f-406e-92d7-7de1d413cb88', 'Korean'),
    ('195b241c-a46c-4a5f-a947-9da5a7bccd93', 'Greek');

INSERT INTO restaurants (id, name, delivery_fee, cuisine_id, created_at, updated_at, address_street, address_apartment_number, address_number, address_zip, address_city, is_active, is_open)
VALUES
    ('2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72', 'Mama Mia Pizzeria', 3.50, '11eb5628-986c-42b4-9d18-f9e42377bd24', '2024-01-15 10:30:00', '2024-01-15 10:30:00', 'Via Roma', NULL, '123', '00100', 'Rome', TRUE, TRUE),
    ('444fee24-26f8-4901-acfb-36e8444b155d', 'Bella Vista Ristorante', 4.00, '11eb5628-986c-42b4-9d18-f9e42377bd24', '2024-02-08 09:15:00', '2024-02-08 09:15:00', 'Via Garibaldi', 'Apt 2A', '456', '20121', 'Milan', TRUE, FALSE),
    ('29ef1c9d-d6ec-44a5-9972-1166d4ce5924', 'Sakura Sushi Bar', 2.99, 'ea11413a-569c-4e95-81ef-e34e6433a55b', '2024-03-12 11:00:00', '2024-03-12 11:00:00', 'Shibuya', NULL, '1-15-8', '150-0002', 'Tokyo', TRUE, TRUE),
    ('e9bf8662-020f-48ae-8464-e7a044c10300', 'Tokyo Ramen House', 3.25, 'ea11413a-569c-4e95-81ef-e34e6433a55b', '2024-04-05 13:45:00', '2024-04-05 13:45:00', 'Shinjuku', 'Building 5F', '3-28-12', '160-0022', 'Tokyo', TRUE, TRUE),
    ('d0085f33-8582-4369-b9cb-3f830b46d023', 'Koi Japanese Cuisine', 4.50, 'ea11413a-569c-4e95-81ef-e34e6433a55b', '2024-05-20 15:20:00', '2024-05-20 15:20:00', 'Nippombashi', NULL, '2-7-3', '542-0073', 'Osaka', TRUE, FALSE),
    ('968bfbe9-8759-4b74-8249-b0dd30989ff3', 'El Corazón Cantina', 2.75, '5625390a-ef56-429e-902a-3c2341f5b753', '2024-06-10 12:30:00', '2024-06-10 12:30:00', 'Avenida Insurgentes', NULL, '1234', '06700', 'Mexico City', TRUE, TRUE),
    ('a8c24df6-62ac-499c-aaab-44f6cb45887c', 'Fiesta Mexicana', 3.00, '5625390a-ef56-429e-902a-3c2341f5b753', '2024-07-03 14:00:00', '2024-07-03 14:00:00', 'Calle Revolución', 'Local 15', '567', '22000', 'Tijuana', TRUE, TRUE),
    ('46ad95c4-444e-416b-bea7-a4b349faeadf', 'Le Petit Café', 5.00, '2ad72324-8164-489e-b82f-b7c63e2e2bad', '2024-08-14 10:45:00', '2024-08-14 10:45:00', 'Rue de Rivoli', NULL, '89', '75001', 'Paris', TRUE, TRUE),
    ('ad3bacf2-0a39-4528-bbf9-db1b61c52f09', 'Spice Palace', 2.50, '701ce91e-0843-4609-955f-b174137f6ce6', '2024-09-07 16:10:00', '2024-09-07 16:10:00', 'MG Road', 'Floor 2', '45', '560001', 'Bangalore', TRUE, TRUE),
    ('45d7ae48-5245-4c73-8675-29ec8655fb78', 'Curry Express', 3.75, '701ce91e-0843-4609-955f-b174137f6ce6', '2024-10-12 08:20:00', '2024-10-12 08:20:00', 'Connaught Place', NULL, '78', '110001', 'New Delhi', TRUE, FALSE),
    ('14df4ed8-d6d5-4729-a003-fb0e21ca88a0', 'Bangkok Garden', 3.25, 'bf29805c-0bfe-4223-a18f-82920ac7b00a', '2024-11-05 12:15:00', '2024-11-05 12:15:00', 'Sukhumvit Road', 'Unit 12A', '234', '10110', 'Bangkok', TRUE, TRUE),
    ('4c318b70-bef2-4349-a030-580248c5b38d', 'Thai Basil Kitchen', 2.99, 'bf29805c-0bfe-4223-a18f-82920ac7b00a', '2024-12-01 09:30:00', '2024-12-01 09:30:00', 'Khao San Road', NULL, '67', '10200', 'Bangkok', TRUE, TRUE),
    ('5d40f78a-5fc4-4ccb-93b7-f6a61587db90', 'Golden Dragon', 2.25, 'bf022f71-52b5-4292-86a3-8825725ce526', '2024-01-28 13:50:00', '2024-01-28 13:50:00', 'Nanjing Road', 'Suite 8B', '456', '200001', 'Shanghai', TRUE, TRUE),
    ('4ba14066-7033-4106-81f6-c3bc91021796', 'Olive Branch Bistro', 3.50, '3a6d87f9-ea97-480b-a49a-254ea3cd03ed', '2024-02-14 11:25:00', '2024-02-14 11:25:00', 'Panepistimiou Street', NULL, '123', '10679', 'Athens', TRUE, TRUE),
    ('bdcea9bc-a2fa-49ed-9400-22c02293057b', 'Mediterranean Delight', 4.25, '3a6d87f9-ea97-480b-a49a-254ea3cd03ed', '2024-03-30 14:40:00', '2024-03-30 14:40:00', 'Mitropoleos Street', 'Floor 3', '89', '54624', 'Thessaloniki', TRUE, FALSE),
    ('85db9108-c65f-446d-ab6e-12da1c711f54', 'Seoul Kitchen', 3.00, 'd8c972ba-155f-406e-92d7-7de1d413cb88', '2024-04-18 10:05:00', '2024-04-18 10:05:00', 'Gangnam-daero', NULL, '456', '06292', 'Seoul', TRUE, TRUE),
    ('320dbb65-102d-4c0e-b7ec-8aa4feae7f5a', 'Acropolis Taverna', 3.75, '195b241c-a46c-4a5f-a947-9da5a7bccd93', '2024-05-25 15:55:00', '2024-05-25 15:55:00', 'Adrianou Street', 'Apt 2C', '34', '10556', 'Athens', TRUE, TRUE),
    ('dc52e844-e698-48b2-94b9-7d4ed3362dc1', 'Zeus Greek Grill', 2.50, '195b241c-a46c-4a5f-a947-9da5a7bccd93', '2024-06-30 12:40:00', '2024-06-30 12:40:00', 'Ermou Street', NULL, '67', '85100', 'Rhodes', TRUE, FALSE);

INSERT INTO payment_methods (id, name)
VALUES
    ('82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'Credit Card'),
    ('0f613a9f-5a1b-44de-873a-49abd07c5a37', 'Debit Card'),
    ('4f7e0b24-7e01-4fd4-8cb6-e2a4cf7c0a17', 'Bancomat'),
    ('8e126d83-b5ee-4f1a-8f55-8cbbf3deec61', 'Postepay'),
    ('25f6b909-b7c8-495a-bb58-b3583e223f38', 'CartaSi'),
    ('ef3ac9c3-3f23-49f6-8f1d-d3b214f4d69d', 'PayPay'),
    ('cd8ba48e-e2c4-4a65-96fa-521bf472c77c', 'Rakuten Pay'),
    ('a776659c-6404-4222-91aa-96d1696cde98', 'Suica Card'),
    ('da7bb7f1-195b-4b4c-8fd3-2a3c6cb02152', 'OXXO Pay'),
    ('fc22be56-f54c-4ef9-a1ce-d77d2894b391', 'SPEI'),
    ('973ce123-059f-4237-a1e6-0bc20e951cc0', 'BBVA Wallet'),
    ('11dbf25b-9c12-42cf-9dc4-6e49bb3e3547', 'Carte Bancaire'),
    ('2a9a6a3a-5531-42ea-92dc-e7c0ab90f75a', 'Paylib'),
    ('ca59f014-f777-45cb-8d3e-bab2be84311b', 'Lydia'),
    ('d6aa8935-8fc3-471e-9a92-210c6caa3c09', 'UPI'),
    ('6e6f2e64-e878-4095-bde2-49c8c2418b26', 'Paytm'),
    ('f132e2dc-c1f9-4460-97ae-08d30e5b5a2e', 'PhonePe'),
    ('e63bd612-b3c8-4b49-b16f-d8e07e2041f3', 'PromptPay'),
    ('a9672a8e-c3ec-4b4c-a0ab-25cc42a1e5c9', 'TrueMoney Wallet'),
    ('15c88e3f-6bd6-4a91-9a2c-bd7fdf0e27f0', 'Rabbit LINE Pay'),
    ('873ef6f4-8d0f-45c6-93db-5a6c3adbd536', 'Alipay'),
    ('bbf9a75e-9adf-4c76-b28d-9328c29f4691', 'WeChat Pay'),
    ('1f0c1161-0a9a-4995-b22e-98cfdd3d8263', 'UnionPay QR'),
    ('8e097a79-7b7c-4ec1-ae6e-48e961d88b19', 'Viva Wallet'),
    ('22cbde0a-c918-4b95-b68c-87268ac0138f', 'IRIS Online Payments'),
    ('bdcfb979-ffbb-4bb3-bc20-d81df06c2d1c', 'Alpha Bank e-Pay'),
    ('fae9f12c-1804-4e8c-9be1-d0976eb9b62f', 'KakaoPay'),
    ('e42d79a1-c1c0-4f5a-80c9-5588d0f7d09e', 'Naver Pay'),
    ('5cb228db-91f3-44f8-9b1f-003bcd1788b9', 'Toss');

-- Italian (Rome, Milan)
INSERT INTO restaurants_payment_methods (restaurant_id, payment_method_id)
VALUES
    ('2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72', '4f7e0b24-7e01-4fd4-8cb6-e2a4cf7c0a17'),
    ('444fee24-26f8-4901-acfb-36e8444b155d', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('444fee24-26f8-4901-acfb-36e8444b155d', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('444fee24-26f8-4901-acfb-36e8444b155d', '25f6b909-b7c8-495a-bb58-b3583e223f38'),
    ('29ef1c9d-d6ec-44a5-9972-1166d4ce5924', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('29ef1c9d-d6ec-44a5-9972-1166d4ce5924', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('29ef1c9d-d6ec-44a5-9972-1166d4ce5924', 'ef3ac9c3-3f23-49f6-8f1d-d3b214f4d69d'),
    ('e9bf8662-020f-48ae-8464-e7a044c10300', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('e9bf8662-020f-48ae-8464-e7a044c10300', 'a776659c-6404-4222-91aa-96d1696cde98'),
    ('d0085f33-8582-4369-b9cb-3f830b46d023', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('d0085f33-8582-4369-b9cb-3f830b46d023', 'cd8ba48e-e2c4-4a65-96fa-521bf472c77c'),
    ('968bfbe9-8759-4b74-8249-b0dd30989ff3', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('968bfbe9-8759-4b74-8249-b0dd30989ff3', 'da7bb7f1-195b-4b4c-8fd3-2a3c6cb02152'),
    ('a8c24df6-62ac-499c-aaab-44f6cb45887c', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('a8c24df6-62ac-499c-aaab-44f6cb45887c', 'fc22be56-f54c-4ef9-a1ce-d77d2894b391'),
    ('46ad95c4-444e-416b-bea7-a4b349faeadf', '11dbf25b-9c12-42cf-9dc4-6e49bb3e3547'),
    ('46ad95c4-444e-416b-bea7-a4b349faeadf', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('46ad95c4-444e-416b-bea7-a4b349faeadf', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('ad3bacf2-0a39-4528-bbf9-db1b61c52f09', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('ad3bacf2-0a39-4528-bbf9-db1b61c52f09', 'd6aa8935-8fc3-471e-9a92-210c6caa3c09'),
    ('45d7ae48-5245-4c73-8675-29ec8655fb78', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('45d7ae48-5245-4c73-8675-29ec8655fb78', '6e6f2e64-e878-4095-bde2-49c8c2418b26'),
    ('14df4ed8-d6d5-4729-a003-fb0e21ca88a0', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('14df4ed8-d6d5-4729-a003-fb0e21ca88a0', '15c88e3f-6bd6-4a91-9a2c-bd7fdf0e27f0'),
    ('4c318b70-bef2-4349-a030-580248c5b38d', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('4c318b70-bef2-4349-a030-580248c5b38d', 'a9672a8e-c3ec-4b4c-a0ab-25cc42a1e5c9'),
    ('5d40f78a-5fc4-4ccb-93b7-f6a61587db90', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('5d40f78a-5fc4-4ccb-93b7-f6a61587db90', '873ef6f4-8d0f-45c6-93db-5a6c3adbd536'),
    ('5d40f78a-5fc4-4ccb-93b7-f6a61587db90', 'bbf9a75e-9adf-4c76-b28d-9328c29f4691'),
    ('4ba14066-7033-4106-81f6-c3bc91021796', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('4ba14066-7033-4106-81f6-c3bc91021796', 'bdcfb979-ffbb-4bb3-bc20-d81df06c2d1c'),
    ('bdcea9bc-a2fa-49ed-9400-22c02293057b', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('bdcea9bc-a2fa-49ed-9400-22c02293057b', '22cbde0a-c918-4b95-b68c-87268ac0138f'),
    ('85db9108-c65f-446d-ab6e-12da1c711f54', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('85db9108-c65f-446d-ab6e-12da1c711f54', 'fae9f12c-1804-4e8c-9be1-d0976eb9b62f'),
    ('85db9108-c65f-446d-ab6e-12da1c711f54', 'e42d79a1-c1c0-4f5a-80c9-5588d0f7d09e'),
    ('320dbb65-102d-4c0e-b7ec-8aa4feae7f5a', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('320dbb65-102d-4c0e-b7ec-8aa4feae7f5a', 'bdcfb979-ffbb-4bb3-bc20-d81df06c2d1c'),
    ('dc52e844-e698-48b2-94b9-7d4ed3362dc1', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('dc52e844-e698-48b2-94b9-7d4ed3362dc1', '22cbde0a-c918-4b95-b68c-87268ac0138f');


INSERT INTO products (id, name, description, price, active, restaurant_id)
VALUES
    ('70ed424e-712e-41d0-9601-c88d58079f25', 'Butter Naan', NULL, 9.88, TRUE, '2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72'),
    ('50910e58-5e70-4a58-a326-bf760c7a3510', 'Sweet and Sour Pork', NULL, 20.74, TRUE, '2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72'),
    ('f1fba2e5-8d9b-4e68-8045-04a8469d3192', 'Spaghetti Carbonara', NULL, 12.74, FALSE, '2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72'),
    ('ac837183-fb6d-42ff-a1eb-3d4f9c5e0b4a', 'Butter Naan', NULL, 11.39, FALSE, '444fee24-26f8-4901-acfb-36e8444b155d'),
    ('7e24503d-3055-4e9d-80de-4214f338e02f', 'Pad Thai', NULL, 7.79, FALSE, '444fee24-26f8-4901-acfb-36e8444b155d'),
    ('b63e3bb7-ec83-4350-813e-63d47df71a27', 'Moussaka', NULL, 11.80, TRUE, '444fee24-26f8-4901-acfb-36e8444b155d'),
    ('47acb90b-cb45-445f-8b44-799a748d1a16', 'Green Curry', NULL, 13.99, TRUE, '29ef1c9d-d6ec-44a5-9972-1166d4ce5924'),
    ('ec1fc92e-7a7b-40a0-a748-d4b24a6a2ef7', 'Souvlaki', NULL, 11.16, TRUE, '29ef1c9d-d6ec-44a5-9972-1166d4ce5924'),
    ('d258417e-0388-4cd7-8dc3-05f9d2057d92', 'Tacos al Pastor', NULL, 24.95, FALSE, '29ef1c9d-d6ec-44a5-9972-1166d4ce5924'),
    ('171b2c63-83c6-4191-8ea7-96717e089709', 'Butter Naan', NULL, 10.26, FALSE, 'e9bf8662-020f-48ae-8464-e7a044c10300'),
    ('bffdb04b-f3be-4039-b015-56983dfc6a31', 'Pad Thai', NULL, 6.94, FALSE, 'e9bf8662-020f-48ae-8464-e7a044c10300'),
    ('418efaa6-c53c-4eb3-9673-f557b0b26997', 'California Roll', NULL, 23.30, FALSE, 'e9bf8662-020f-48ae-8464-e7a044c10300'),
    ('e3c816be-fde3-4b3f-ae3f-2057c2f4fa52', 'California Roll', NULL, 24.09, TRUE, 'd0085f33-8582-4369-b9cb-3f830b46d023'),
    ('c401ba01-1706-4299-90fe-b4d607290010', 'Croissant', NULL, 24.57, FALSE, 'd0085f33-8582-4369-b9cb-3f830b46d023'),
    ('8b325c86-17f7-47a2-9e3f-2823db1213dc', 'Souvlaki', NULL, 13.76, TRUE, 'd0085f33-8582-4369-b9cb-3f830b46d023'),
    ('3c4f78c1-27bb-4318-9282-f4c510d4d3c1', 'Pad Thai', NULL, 21.27, FALSE, '968bfbe9-8759-4b74-8249-b0dd30989ff3'),
    ('1c541aac-c8cf-4da4-bbe7-00c8a2cdff43', 'Green Curry', NULL, 11.84, FALSE, '968bfbe9-8759-4b74-8249-b0dd30989ff3'),
    ('c28ef731-9865-49e4-9d42-e2b4c740f2f4', 'Burrito', NULL, 13.59, TRUE, '968bfbe9-8759-4b74-8249-b0dd30989ff3'),
    ('aab826b4-958e-45b9-b2df-b1f72fd421fd', 'Paneer Butter Masala', NULL, 14.74, FALSE, 'a8c24df6-62ac-499c-aaab-44f6cb45887c'),
    ('2a517162-8ae9-4ae0-80fc-80c5fa4a1f4a', 'Tacos al Pastor', NULL, 8.03, FALSE, 'a8c24df6-62ac-499c-aaab-44f6cb45887c'),
    ('51fe2eb4-4d76-4996-9b6c-f4d4dd080f17', 'Spring Rolls', NULL, 21.44, FALSE, 'a8c24df6-62ac-499c-aaab-44f6cb45887c'),
    ('43c44f82-4737-4435-9e4b-e11a81de58e4', 'Moussaka', NULL, 11.73, FALSE, '46ad95c4-444e-416b-bea7-a4b349faeadf'),
    ('a28108c2-b187-453a-8202-89f7c90a00b6', 'California Roll', NULL, 13.77, TRUE, '46ad95c4-444e-416b-bea7-a4b349faeadf'),
    ('2e77eb30-6377-4fc2-96f1-e9bd7cf39133', 'Tom Yum Soup', NULL, 13.53, FALSE, '46ad95c4-444e-416b-bea7-a4b349faeadf'),
    ('c3f05c20-3045-4d48-9d02-0d7c7783f4cf', 'Kimchi Stew', NULL, 18.14, TRUE, 'ad3bacf2-0a39-4528-bbf9-db1b61c52f09'),
    ('801b9b86-d65f-4b49-b45f-128e01a25813', 'Souvlaki', NULL, 10.92, FALSE, 'ad3bacf2-0a39-4528-bbf9-db1b61c52f09'),
    ('d28bc435-3d84-452b-a576-865c2ec4dc5a', 'Butter Naan', NULL, 8.23, FALSE, 'ad3bacf2-0a39-4528-bbf9-db1b61c52f09'),
    ('5dcafec5-d195-4395-b9f4-8f9d86f2067d', 'Hummus Plate', NULL, 20.19, FALSE, '45d7ae48-5245-4c73-8675-29ec8655fb78'),
    ('00d4cd11-d246-4d5a-b9b3-7dbe2402e3f6', 'Paneer Butter Masala', NULL, 11.68, FALSE, '45d7ae48-5245-4c73-8675-29ec8655fb78'),
    ('885e3cbb-5a18-4f8e-83d5-86ff8893724a', 'Croissant', NULL, 9.21, TRUE, '45d7ae48-5245-4c73-8675-29ec8655fb78'),
    ('f0156fd7-8319-4b82-8400-1f884810d7aa', 'Bibimbap', NULL, 19.37, FALSE, '14df4ed8-d6d5-4729-a003-fb0e21ca88a0'),
    ('6e49648f-0905-48df-9119-e267f682f79b', 'Sweet and Sour Pork', NULL, 11.32, TRUE, '14df4ed8-d6d5-4729-a003-fb0e21ca88a0'),
    ('7853d7ee-3b88-44b8-89c2-c1c7a04d29a2', 'Souvlaki', NULL, 16.23, FALSE, '14df4ed8-d6d5-4729-a003-fb0e21ca88a0'),
    ('c6684cbb-bd6b-4d0c-829f-c6d63d47e3e2', 'Tacos al Pastor', NULL, 24.31, TRUE, '4c318b70-bef2-4349-a030-580248c5b38d'),
    ('6b384092-06a3-4d98-9edc-7809f5b39535', 'Spaghetti Carbonara', NULL, 10.66, FALSE, '4c318b70-bef2-4349-a030-580248c5b38d'),
    ('b1bc3a02-679a-4d18-9993-f06f5d7e9a24', 'Butter Naan', NULL, 9.73, FALSE, '4c318b70-bef2-4349-a030-580248c5b38d'),
    ('af5841a7-742e-40d1-81cb-9a0e11a0d54e', 'Croissant', NULL, 14.15, TRUE, '5d40f78a-5fc4-4ccb-93b7-f6a61587db90'),
    ('e4f84724-276b-44ed-a6e1-febcf425fcaf', 'Bibimbap', NULL, 12.37, TRUE, '5d40f78a-5fc4-4ccb-93b7-f6a61587db90'),
    ('2c7d09f4-394b-4ae0-80ca-e6c42fce7a18', 'Hummus Plate', NULL, 6.29, TRUE, '5d40f78a-5fc4-4ccb-93b7-f6a61587db90'),
    ('cc1e67a6-e3b0-4b1b-8bb4-86500a0f42a0', 'Paneer Butter Masala', NULL, 18.66, FALSE, '4ba14066-7033-4106-81f6-c3bc91021796'),
    ('34b292a8-666e-4d63-b5a3-628f955c1ec1', 'Green Curry', NULL, 7.23, TRUE, '4ba14066-7033-4106-81f6-c3bc91021796'),
    ('15edbcb6-c4d6-4f4c-8c4b-c5c4c6ec69b4', 'Kimchi Stew', NULL, 7.54, FALSE, '4ba14066-7033-4106-81f6-c3bc91021796'),
    ('d8a9dbd7-e922-4eec-9f68-5a90a4cbdd88', 'Spaghetti Carbonara', NULL, 8.88, TRUE, 'bdcea9bc-a2fa-49ed-9400-22c02293057b'),
    ('a7bb1a6e-2d8f-4eb9-9b99-9e7c5781b9af', 'Tom Yum Soup', NULL, 21.50, TRUE, 'bdcea9bc-a2fa-49ed-9400-22c02293057b'),
    ('06ff1db7-f569-4e92-8312-872b60ed108d', 'Tacos al Pastor', NULL, 8.79, FALSE, 'bdcea9bc-a2fa-49ed-9400-22c02293057b'),
    ('6230dd89-08c2-4a7f-9eb2-124634a3af58', 'Burrito', NULL, 23.03, TRUE, '320dbb65-102d-4c0e-b7ec-8aa4feae7f5a'),
    ('7eabd7d2-9b43-4c52-bd47-6872d1284e19', 'Butter Naan', NULL, 18.20, TRUE, '320dbb65-102d-4c0e-b7ec-8aa4feae7f5a'),
    ('594dce08-123b-4b35-a02b-37f11a071354', 'Spring Rolls', NULL, 23.96, FALSE, '320dbb65-102d-4c0e-b7ec-8aa4feae7f5a'),
    ('9832e3b8-8ea1-4d89-98cb-312cc96784de', 'Souvlaki', NULL, 24.17, TRUE, '85db9108-c65f-446d-ab6e-12da1c711f54'),
    ('5c9b091e-ef4a-4f89-b28a-30478a7c1671', 'Pad Thai', NULL, 11.96, FALSE, '85db9108-c65f-446d-ab6e-12da1c711f54'),
    ('a7fbbf15-e2a0-4b12-bb45-2e7d28f3db39', 'Moussaka', NULL, 7.49, FALSE, '85db9108-c65f-446d-ab6e-12da1c711f54');

INSERT INTO groups (id, name)
VALUES
    ('0cc1a34c-3015-457b-8593-19e21989d3ba', 'user');

INSERT INTO users (id, name, email, password, created_at, updated_at)
VALUES
    ('3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', 'Alice Johnson', 'alice.johnson@example.com', 'pbkdf2_sha256$260000$abc123$hashedpassword1', '2025-07-01 10:15:00', '2025-07-01 10:15:00'),
    ('bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', 'Bob Martinez', 'bob.martinez@example.com', 'pbkdf2_sha256$260000$def456$hashedpassword2', '2025-07-02 14:25:30', '2025-07-02 14:25:30'),
    ('f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', 'Clara Nguyen', 'clara.nguyen@example.com', 'pbkdf2_sha256$260000$ghi789$hashedpassword3', '2025-07-03 09:00:00', '2025-07-03 09:00:00');

INSERT INTO orders (id, subtotal, delivery_fee, grand_total, address_street, address_apartment_number, address_number, address_city, address_zip, status, payment_method_id, restaurant_id, client_id, created_at, confirmed_at, delivered_at, cancelled_at)
VALUES
    ('af674353-86eb-47a9-9d74-a4c86bd9d99c', 21.63, 3.50, 23.63, 'Via Roma', NULL, '123', 'Rome', '00100', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-01 11:00:00', '2025-07-01 11:10:00', '2025-07-01 11:40:00', NULL),
    ('7c57ebd0-107a-4ec2-b0c2-60a590178ea4', 35.00, 3.50, 38.50, 'Via Roma', 'Apt 5', '123', 'Rome', '00100', 'DELIVERED', '4f7e0b24-7e01-4fd4-8cb6-e2a4cf7c0a17', '2dfbb0ec-d84c-4fd9-8bee-9488a4d2ae72', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-02 12:00:00', '2025-07-02 12:05:00', '2025-07-02 12:35:00', NULL),
    ('de7f90c2-18f0-456c-a5d1-697e55d8d0c7', 28.00, 4.00, 32.00, 'Via Garibaldi', 'Apt 2A', '456', 'Milan', '20121', 'DELIVERED', '0f613a9f-5a1b-44de-873a-49abd07c5a37', '444fee24-26f8-4901-acfb-36e8444b155d', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-01 10:00:00', '2025-07-01 10:12:00', '2025-07-01 10:45:00', NULL),
    ('de3fbb7d-c05f-4eb7-b0f6-8e77ed5d17e1', 15.00, 4.00, 19.00, 'Via Garibaldi', 'Apt 4B', '456', 'Milan', '20121', 'CANCELED', '25f6b909-b7c8-495a-bb58-b3583e223f38', '444fee24-26f8-4901-acfb-36e8444b155d', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-02 09:00:00', NULL, NULL, '2025-07-02 09:20:00'),
    ('78a235ec-1801-40cc-8c50-5c38ac4451f2', 40.00, 2.99, 42.99, 'Shibuya', NULL, '1-15-8', 'Tokyo', '150-0002', 'DELIVERED', 'ef3ac9c3-3f23-49f6-8f1d-d3b214f4d69d', '29ef1c9d-d6ec-44a5-9972-1166d4ce5924', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-01 13:00:00', '2025-07-01 13:10:00', '2025-07-01 13:50:00', NULL),
    ('a3d5a4a4-6344-4f57-a104-60e5d4642a62', 30.00, 2.99, 32.99, 'Shibuya', 'Suite 202', '1-15-8', 'Tokyo', '150-0002', 'CANCELED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '29ef1c9d-d6ec-44a5-9972-1166d4ce5924', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-02 14:00:00', '2025-07-02 14:20:00', '2025-07-02 14:55:00', NULL),
    ('58815287-8ce7-422c-ba1b-6ce171703b07', 50.00, 2.99, 52.99, 'Shibuya', NULL, '1-15-8', 'Tokyo', '150-0002', 'REFUNDED', '0f613a9f-5a1b-44de-873a-49abd07c5a37', '29ef1c9d-d6ec-44a5-9972-1166d4ce5924', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-03 16:00:00', '2025-07-03 16:15:00', NULL, NULL),
    ('637f6e0c-7aa6-4aac-91f1-ea53e1d48931', 25.00, 3.25, 28.25, 'Shinjuku', 'Building 5F', '3-28-12', 'Tokyo', '160-0022', 'DELIVERED', 'a776659c-6404-4222-91aa-96d1696cde98', 'e9bf8662-020f-48ae-8464-e7a044c10300', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-01 11:30:00', '2025-07-01 11:45:00', '2025-07-01 12:10:00', NULL),
    ('696cd927-dede-4e4b-8ca5-66b90551531e', 30.00, 3.25, 33.25, 'Shinjuku', NULL, '3-28-12', 'Tokyo', '160-0022', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'e9bf8662-020f-48ae-8464-e7a044c10300', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-02 15:00:00', '2025-07-02 15:10:00', '2025-07-02 15:40:00', NULL),
    ('19dd6c5b-5973-4f42-8c52-4646900e98ff', 45.00, 4.50, 49.50, 'Nippombashi', NULL, '2-7-3', 'Osaka', '542-0073', 'OPEN', 'cd8ba48e-e2c4-4a65-96fa-521bf472c77c', 'd0085f33-8582-4369-b9cb-3f830b46d023', '3a7f5e36-9428-4a25-8f5c-0c7e5f93cdd4', '2025-07-01 10:20:00', '2025-07-01 10:30:00', '2025-07-01 11:00:00', NULL),
    ('d0b10435-eb32-4bb2-b759-e75107d4ac2a', 35.00, 4.50, 39.50, 'Nippombashi', 'Room 202', '2-7-3', 'Osaka', '542-0073', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'd0085f33-8582-4369-b9cb-3f830b46d023', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-02 14:00:00', '2025-07-02 14:05:00', '2025-07-02 14:40:00', NULL),
    ('02354f17-b789-4674-8741-ed45e0f00f34', 22.00, 2.75, 24.75, 'Avenida Insurgentes', NULL, '1234', 'Mexico City', '06700', 'DELIVERED', 'da7bb7f1-195b-4b4c-8fd3-2a3c6cb02152', '968bfbe9-8759-4b74-8249-b0dd30989ff3', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-01 09:30:00', '2025-07-01 09:40:00', '2025-07-01 10:00:00', NULL),
    ('e05a4c46-98bc-42e6-aeb5-c2353a6e2e70', 30.00, 2.75, 32.75, 'Avenida Insurgentes', 'Suite 1', '1234', 'Mexico City', '06700', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '968bfbe9-8759-4b74-8249-b0dd30989ff3', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-02 11:00:00', '2025-07-02 11:15:00', '2025-07-02 11:45:00', NULL),
    ('fef425a7-c74c-44cc-b21e-d53eb8a9e3cf', 18.00, 2.75, 20.75, 'Avenida Insurgentes', NULL, '1234', 'Mexico City', '06700', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '968bfbe9-8759-4b74-8249-b0dd30989ff3', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-03 12:00:00', '2025-07-03 12:10:00', NULL, NULL),
    ('867db3d8-5308-4bff-a05a-9062960c6f7d', 27.00, 3.00, 30.00, 'Calle Revolución', 'Local 15', '567', 'Tijuana', '22000', 'DELIVERED', 'fc22be56-f54c-4ef9-a1ce-d77d2894b391', 'a8c24df6-62ac-499c-aaab-44f6cb45887c', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-01 13:30:00', '2025-07-01 13:45:00', '2025-07-01 14:10:00', NULL),
    ('3369aed2-601f-4028-9ba3-d61020a0be6a', 19.00, 3.00, 22.00, 'Calle Revolución', NULL, '567', 'Tijuana', '22000', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'a8c24df6-62ac-499c-aaab-44f6cb45887c', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-02 10:00:00', '2025-07-02 10:10:00', '2025-07-02 10:35:00', NULL),
    ('e55e22c3-7291-4a57-8341-f2c78aa45c6d', 15.00, 2.00, 17.00, 'Rue de Rivoli', NULL, '10', 'Paris', '75001', 'CANCELED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '46ad95c4-444e-416b-bea7-a4b349faeadf', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-01 08:00:00', '2025-07-01 08:10:00', '2025-07-01 08:30:00', NULL),
    ('02791dea-e09c-4540-a58d-6634b7351a66', 22.00, 2.00, 24.00, 'Rue de Rivoli', '3B', '10', 'Paris', '75001', 'DELIVERED', '11dbf25b-9c12-42cf-9dc4-6e49bb3e3547', '46ad95c4-444e-416b-bea7-a4b349faeadf', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-02 09:00:00', '2025-07-02 09:15:00', '2025-07-02 09:45:00', NULL),
    ('5adcfdb8-5946-4254-a322-81a8b57dece1', 18.00, 2.00, 20.00, 'Rue de Rivoli', NULL, '10', 'Paris', '75001', 'DELIVERED', '0f613a9f-5a1b-44de-873a-49abd07c5a37', '46ad95c4-444e-416b-bea7-a4b349faeadf', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-03 10:00:00', '2025-07-03 10:05:00', NULL, NULL),
    ('5bbfca16-e736-4ab1-93c7-2e1ccf26826f', 25.00, 3.50, 28.50, 'Boulevard Haussmann', NULL, '50', 'Paris', '75009', 'DELIVERED', 'bdcfb979-ffbb-4bb3-bc20-d81df06c2d1c', '4ba14066-7033-4106-81f6-c3bc91021796', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-01 11:00:00', '2025-07-01 11:10:00', '2025-07-01 11:40:00', NULL),
    ('09ae9a5d-1093-4e3f-9aa0-785ace90c3bc', 30.00, 3.50, 33.50, 'Boulevard Haussmann', 'Apt 7', '50', 'Paris', '75009', 'CONFIRMED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '4ba14066-7033-4106-81f6-c3bc91021796', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-02 12:00:00', '2025-07-02 12:15:00', '2025-07-02 12:45:00', NULL),
    ('832d18b9-7239-4d65-b863-1cfeb7f8fa76', 20.00, 3.00, 23.00, 'Calle 123', NULL, '8', 'Bogotá', '110111', 'CONFIRMED', '22cbde0a-c918-4b95-b68c-87268ac0138f', 'bdcea9bc-a2fa-49ed-9400-22c02293057b', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-01 10:30:00', '2025-07-01 10:45:00', '2025-07-01 11:10:00', NULL),
    ('0fdda351-e99d-444b-bced-09f331829105', 27.00, 3.00, 30.00, 'Calle 123', 'Apt 4', '8', 'Bogotá', '110111', 'OPEN', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'bdcea9bc-a2fa-49ed-9400-22c02293057b', 'bd91f3b4-5597-4e9e-a4b7-c598fa2e1bc2', '2025-07-02 14:00:00', '2025-07-02 14:10:00', '2025-07-02 14:40:00', NULL),
    ('efa98a01-8499-4069-bb11-ecf4efabf696', 35.00, 3.75, 38.75, 'Adrianou Street', 'Apt 2C', '34', 'Athens', '10556', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '320dbb65-102d-4c0e-b7ec-8aa4feae7f5a', 'f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', '2025-07-03 11:00:00', '2025-07-03 11:10:00', '2025-07-03 11:50:00', NULL),
    ('65016e1a-309d-4050-8e89-66344240ad9b', 40.00, 3.75, 43.75, 'Adrianou Street', NULL, '36', 'Athens', '10556', 'DELIVERED', 'bdcfb979-ffbb-4bb3-bc20-d81df06c2d1c', '320dbb65-102d-4c0e-b7ec-8aa4feae7f5a', 'f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', '2025-07-04 13:15:00', '2025-07-04 13:30:00', '2025-07-04 14:00:00', NULL),
    ('436890cd-2beb-4c86-8d7f-dcb3e5504d35', 22.00, 2.50, 24.50, 'Ermou Street', NULL, '67', 'Rhodes', '85100', 'DELIVERED', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'dc52e844-e698-48b2-94b9-7d4ed3362dc1', 'f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', '2025-07-03 15:00:00', '2025-07-03 15:10:00', '2025-07-03 15:45:00', NULL),
    ('eae1865e-889c-46a2-b13c-6e8646326489', 30.00, 2.50, 32.50, 'Ermou Street', 'Shop 3', '69', 'Rhodes', '85100', 'CONFIRMED', '22cbde0a-c918-4b95-b68c-87268ac0138f', 'dc52e844-e698-48b2-94b9-7d4ed3362dc1', 'f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', '2025-07-05 12:30:00', '2025-07-05 12:50:00', '2025-07-05 13:15:00', NULL),
    ('9b018342-d515-49f4-91c4-37f0fd6f16a8', 28.00, 2.25, 30.25, 'Nanjing Road', 'Suite 8B', '456', 'Shanghai', '200001', 'OPEN', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', '5d40f78a-5fc4-4ccb-93b7-f6a61587db90', 'f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', '2025-07-06 18:00:00', '2025-07-06 18:15:00', '2025-07-06 18:45:00', NULL),
    ('6817a3e4-8cfe-467b-ae6c-30bc242b40ee', 35.00, 2.25, 37.25, 'Nanjing Road', NULL, '458', 'Shanghai', '200001', 'CANCELED', '873ef6f4-8d0f-45c6-93db-5a6c3adbd536', '5d40f78a-5fc4-4ccb-93b7-f6a61587db90', 'f0c5a7d3-8f8a-4e6e-9914-fc417e52a763', '2025-07-07 19:30:00', '2025-07-07 19:45:00', '2025-07-07 20:10:00', NULL);

INSERT INTO order_items (id, unit_price, promotional_discount, grand_total, quantity, obs, order_id, product_id)
VALUES
    ('c24aab15-3595-4f2e-8576-91e901e98465', 12.74, 0, 12.74, 1, 'Extra sauce pls', 'af674353-86eb-47a9-9d74-a4c86bd9d99c', 'f1fba2e5-8d9b-4e68-8045-04a8469d3192'),
    ('f0cb3cb3-4add-4ddf-939e-4a205642e41a', 9.88, 1, 8.88, 1, NULL, 'af674353-86eb-47a9-9d74-a4c86bd9d99c', '70ed424e-712e-41d0-9601-c88d58079f25'),
    ('a66b1138-ce6b-4fae-a308-46a09c761f0c', 12.74, 0, 12.74, 1, 'Extra sauce', '7c57ebd0-107a-4ec2-b0c2-60a590178ea4', 'f1fba2e5-8d9b-4e68-8045-04a8469d3192');
