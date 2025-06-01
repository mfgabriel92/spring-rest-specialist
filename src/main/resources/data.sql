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
VALUES ('d42fcf63-b8fc-4ac4-a3a0-893fa9dbb2a9', 'Italian'),
       ('c9ecf4cc-bc7d-4b85-a1c0-2c9e9a003fa4', 'French'),
       ('cc2f75bb-89ed-4d6f-a03c-f09f0f3a41a2', 'Japanese'),
       ('f2e8d739-58ea-4179-b329-4df8d6636c18', 'Chinese'),
       ('7a395d37-5d59-44f1-bb17-d72889d61a45', 'Thai');

INSERT INTO restaurants (id, name, delivery_fee, cuisine_id, created_at, updated_at, address_street, address_apartment_number, address_number, address_zip, address_city, is_active, is_open)
VALUES ('e218974b-16bd-49c5-9af6-7ef2843d6c80', 'Le Bistro', 8.46, 'c9ecf4cc-bc7d-4b85-a1c0-2c9e9a003fa4', '2017-09-23T11:42:18', '2017-09-23T11:42:18', 'Rue de Verdun', '12A', '33', '93370', 'Montfermeil', false, true),
       ('2ff391fd-f03f-47b0-8f22-eb735396d381', 'Trattoria Roma', 6.87, 'd42fcf63-b8fc-4ac4-a3a0-893fa9dbb2a9', '2015-06-04T04:13:35', '2015-06-04T04:13:35', null, null, null, null, null, false, false),
       ('d0c1c70e-620b-455e-8f1a-9dcf00fbfc25', 'La Provence', 3.13, 'c9ecf4cc-bc7d-4b85-a1c0-2c9e9a003fa4', '2021-12-30T03:59:44', '2021-12-30T03:59:44', null, null, null, null, null, false, true),
       ('6f76e734-5927-49cf-ae02-2ec45445495f', 'Tempura House', 10.55, 'cc2f75bb-89ed-4d6f-a03c-f09f0f3a41a2', '2019-01-06T07:55:41', '2019-01-06T07:55:41', null, null, null, null, null, false, true),
       ('a81d2e9a-bb41-43e1-97da-d775cf8620d5', 'Golden Wok', 19.04, 'f2e8d739-58ea-4179-b329-4df8d6636c18', '2018-08-20T18:14:26', '2018-08-20T18:14:26', null, null, null, null, null, false, true),
       ('802b7815-26fa-424f-ab44-78689f168fc5', 'Bamboo Leaf', 5.8, 'f2e8d739-58ea-4179-b329-4df8d6636c18', '2016-02-14T10:12:09', '2016-02-14T10:12:09', null, null, null, null, null, false, true),
       ('517c882a-c574-4987-b848-c152597378a6', 'Thai Spice', 14.61, '7a395d37-5d59-44f1-bb17-d72889d61a45', '2022-07-13T15:23:50', '2022-07-13T15:23:50', null, null, null, null, null, false, true),
       ('cb63e348-485b-41dd-b9e9-45c24265883d', 'Bangkok Taste', 17.97, '7a395d37-5d59-44f1-bb17-d72889d61a45', '2020-04-17T22:35:14', '2020-04-17T22:35:14', null, null, null, null, null, false, false),
       ('1a6c727c-c25e-4188-abea-cc8ed9efaee5', 'La Fiesta', 8.78, null, '2024-10-01T03:38:47', '2024-10-01T03:38:47', null, null, null, null, null, false, true);

INSERT INTO payment_methods (id, name)
VALUES
    ('82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'Credit Card'),
    ('0f613a9f-5a1b-44de-873a-49abd07c5a37', 'Debit Card'),
    ('ca8101c6-f5b5-4a44-a078-a673e353b7bc', 'Bancomat'),
    ('b4255b91-9acb-445d-8929-360071e7dbdb', 'PagoBancomat'),
    ('87454fe9-ecb7-4f5c-8d32-d84861a2848c', 'Postepay'),
    ('ed6b3fd9-b854-47ab-849d-00cc332cd2de', 'Nexi'),
    ('6ed69ccf-e178-467d-b5e9-4dd7690e053a', 'Satispay'),
    ('b76ca246-64cb-4596-8c67-58a507d3d73d', 'Carte Bancaire'),
    ('ae236ea2-4b47-46eb-b386-5a4ad681e1ea', 'Paylib'),
    ('49275c4a-95a9-4da3-a78b-485e5fff9d84', 'Lydia'),
    ('463a87f1-b20f-4c66-a30d-b37a9e99276a', 'Orange Money'),
    ('57fb5336-47ca-4ef3-b455-d079e590b2d0', 'Suica'),
    ('ce8c2117-dc13-4d01-be87-43ef464199d8', 'Pasmo'),
    ('60b87688-4165-4a58-a77b-239a251b24b3', 'PayPay'),
    ('5da1e2e8-fc12-4a9b-9273-858d78f6effc', 'Rakuten Pay'),
    ('dc4b89f6-8843-43a1-83c2-3ba7bf6d9946', 'Line Pay'),
    ('ec02d10c-b55a-4845-9fec-300655468d43', 'Alipay'),
    ('8542c28d-bc24-469b-9d2e-922a9bf605ad', 'WeChat Pay'),
    ('c8dd4b9d-12a0-4ffa-92c1-572063e14890', 'UnionPay'),
    ('b65a2fbf-0b9f-400f-9376-7eef219b0816', 'JD Pay'),
    ('63ef0ae6-c6d0-49cf-beb5-bcdb7bdd40fc', 'PromptPay'),
    ('be70d168-f8cf-4575-9824-0f5004fdd760', 'TrueMoney Wallet'),
    ('63ba1787-1945-422a-b853-facc134f3853', 'Rabbit LINE Pay'),
    ('9f235ead-08ac-400a-a8dd-2c8697da8ac7', 'SCB Easy');

INSERT INTO restaurants_payment_methods (restaurant_id, payment_method_id)
VALUES
    ('e218974b-16bd-49c5-9af6-7ef2843d6c80', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('e218974b-16bd-49c5-9af6-7ef2843d6c80', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('e218974b-16bd-49c5-9af6-7ef2843d6c80', 'ae236ea2-4b47-46eb-b386-5a4ad681e1ea'),
    ('2ff391fd-f03f-47b0-8f22-eb735396d381', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('2ff391fd-f03f-47b0-8f22-eb735396d381', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('2ff391fd-f03f-47b0-8f22-eb735396d381', '6ed69ccf-e178-467d-b5e9-4dd7690e053a'),
    ('2ff391fd-f03f-47b0-8f22-eb735396d381', 'ca8101c6-f5b5-4a44-a078-a673e353b7bc'),
    ('2ff391fd-f03f-47b0-8f22-eb735396d381', 'ed6b3fd9-b854-47ab-849d-00cc332cd2de'),
    ('d0c1c70e-620b-455e-8f1a-9dcf00fbfc25', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('d0c1c70e-620b-455e-8f1a-9dcf00fbfc25', '463a87f1-b20f-4c66-a30d-b37a9e99276a'),
    ('d0c1c70e-620b-455e-8f1a-9dcf00fbfc25', '49275c4a-95a9-4da3-a78b-485e5fff9d84'),
    ('d0c1c70e-620b-455e-8f1a-9dcf00fbfc25', 'ae236ea2-4b47-46eb-b386-5a4ad681e1ea'),
    ('6f76e734-5927-49cf-ae02-2ec45445495f', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('6f76e734-5927-49cf-ae02-2ec45445495f', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('6f76e734-5927-49cf-ae02-2ec45445495f', '57fb5336-47ca-4ef3-b455-d079e590b2d0'),
    ('6f76e734-5927-49cf-ae02-2ec45445495f', 'ce8c2117-dc13-4d01-be87-43ef464199d8'),
    ('6f76e734-5927-49cf-ae02-2ec45445495f', '5da1e2e8-fc12-4a9b-9273-858d78f6effc'),
    ('a81d2e9a-bb41-43e1-97da-d775cf8620d5', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('a81d2e9a-bb41-43e1-97da-d775cf8620d5', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('a81d2e9a-bb41-43e1-97da-d775cf8620d5', 'ec02d10c-b55a-4845-9fec-300655468d43'),
    ('a81d2e9a-bb41-43e1-97da-d775cf8620d5', 'b65a2fbf-0b9f-400f-9376-7eef219b0816'),
    ('802b7815-26fa-424f-ab44-78689f168fc5', 'b65a2fbf-0b9f-400f-9376-7eef219b0816'),
    ('517c882a-c574-4987-b848-c152597378a6', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('517c882a-c574-4987-b848-c152597378a6', '0f613a9f-5a1b-44de-873a-49abd07c5a37'),
    ('517c882a-c574-4987-b848-c152597378a6', '63ba1787-1945-422a-b853-facc134f3853'),
    ('517c882a-c574-4987-b848-c152597378a6', '9f235ead-08ac-400a-a8dd-2c8697da8ac7'),
    ('517c882a-c574-4987-b848-c152597378a6', '63ef0ae6-c6d0-49cf-beb5-bcdb7bdd40fc'),
    ('cb63e348-485b-41dd-b9e9-45c24265883d', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162'),
    ('cb63e348-485b-41dd-b9e9-45c24265883d', '9f235ead-08ac-400a-a8dd-2c8697da8ac7'),
    ('cb63e348-485b-41dd-b9e9-45c24265883d', '63ba1787-1945-422a-b853-facc134f3853'),
    ('cb63e348-485b-41dd-b9e9-45c24265883d', 'be70d168-f8cf-4575-9824-0f5004fdd760');

INSERT INTO products (id, name, description, price, active, restaurant_id)
VALUES
    ('f2718bf7-3b40-403a-a35b-703613237eae','Coq au Vin', NULL, 18.50, true, 'e218974b-16bd-49c5-9af6-7ef2843d6c80'),
    ('5c6b56a9-aef0-4174-a524-acd2fd9f422d','Duck Confit', null, 22.00, true, 'e218974b-16bd-49c5-9af6-7ef2843d6c80'),
    ('993a89ba-b52d-4c5f-b67b-79678a2288c9','Ratatouille', null, 14.75, true, 'e218974b-16bd-49c5-9af6-7ef2843d6c80'),
    ('f794bf19-403d-4cec-b9c3-51f6edf56796','Bouillabaisse', null, 24.30, true, 'e218974b-16bd-49c5-9af6-7ef2843d6c80'),
    ('4e0c4a23-6256-4af0-8044-bc3cc76c8d74','Spaghetti Carbonara', null, 12.00, true, '2ff391fd-f03f-47b0-8f22-eb735396d381'),
    ('746fd7c0-94c0-4d84-91b9-4c49c7b1aebc','Lasagna Bolognese', null, 14.00, true, '2ff391fd-f03f-47b0-8f22-eb735396d381'),
    ('2760b2a0-3133-495b-b099-af6ac2a996b3','Margherita Pizza', null, 10.50, false, '2ff391fd-f03f-47b0-8f22-eb735396d381'),
    ('0266d927-95e9-4703-955a-bf66742aeb39','Risotto ai Funghi', null, 13.20, true, '2ff391fd-f03f-47b0-8f22-eb735396d381'),
    ('3f965abe-6b74-4840-8c66-240e27b88209','Quiche Lorraine', null, 11.00, true, 'd0c1c70e-620b-455e-8f1a-9dcf00fbfc25'),
    ('19c06725-eee9-47c7-8a1e-78ed1efde459','Salade Niçoise', null, 12.50, true, 'd0c1c70e-620b-455e-8f1a-9dcf00fbfc25'),
    ('241ba1c5-e446-4744-b324-b481a2d1f85b','Tarte Tatin', null, 9.00, true, 'd0c1c70e-620b-455e-8f1a-9dcf00fbfc25'),
    ('37b0cf4b-de28-4671-8708-f47eeb57842a','Shrimp Tempura', null, 13.40, true, '6f76e734-5927-49cf-ae02-2ec45445495f'),
    ('07da7602-ea66-4414-a36b-3d4cb6aa268c','Chicken Katsu', null, 12.00, true, '6f76e734-5927-49cf-ae02-2ec45445495f'),
    ('a9cea7fa-106e-4935-9d2a-3243b38c2e27','Udon Noodle Soup', null, 11.20, true, '6f76e734-5927-49cf-ae02-2ec45445495f'),
    ('eb8eb3a3-af09-49be-8330-8766165b38ee','Sashimi Platter', null, 19.60, true, '6f76e734-5927-49cf-ae02-2ec45445495f'),
    ('0463b5dd-3374-4c6b-a92f-c486eeeb5841','Kung Pao Chicken', null, 11.50, false, 'a81d2e9a-bb41-43e1-97da-d775cf8620d5'),
    ('bc6c5cd2-fdc0-4839-8726-7a6444c22584','Sweet and Sour Pork', null, 10.80, true, 'a81d2e9a-bb41-43e1-97da-d775cf8620d5'),
    ('9bb19878-8056-4d14-9f3e-b928c82ebe0b','Fried Rice', null, 9.00, true, 'a81d2e9a-bb41-43e1-97da-d775cf8620d5'),
    ('9614ba5a-ffca-4c01-8822-1a66543c7e2e','Mapo Tofu', null, 12.20, false, 'a81d2e9a-bb41-43e1-97da-d775cf8620d5'),
    ('1091f160-1c23-4b6a-b82c-4136ccf045d4','Dim Sum Platter', null, 15.00, true, '802b7815-26fa-424f-ab44-78689f168fc5'),
    ('dcf26625-81c0-4a9a-9aca-57fad5823ef0','Beef Chow Fun', null, 13.00, true, '802b7815-26fa-424f-ab44-78689f168fc5'),
    ('42e6b398-0a04-4d8d-948d-a90452306192','Hot and Sour Soup', null, 8.00, true, '802b7815-26fa-424f-ab44-78689f168fc5'),
    ('941c4d9f-51c1-4bb6-a098-4f07270639a2','Green Curry Chicken', null, 13.00, true, '517c882a-c574-4987-b848-c152597378a6'),
    ('449eff75-3412-4904-9ac5-70f1d030db64','Pad Thai', null, 11.50, true, '517c882a-c574-4987-b848-c152597378a6'),
    ('e475a618-0cc0-4ed7-b289-33610732674a','Tom Yum Soup', null, 9.50, true, '517c882a-c574-4987-b848-c152597378a6'),
    ('c4012a71-2eb9-4450-a942-797a8a87d2be','Massaman Curry', null, 13.70, true, 'cb63e348-485b-41dd-b9e9-45c24265883d'),
    ('0b3b3a41-97b6-4e89-8076-cdd44fc21562','Pineapple Fried Rice', null, 10.90, true, 'cb63e348-485b-41dd-b9e9-45c24265883d'),
    ('78796aa9-8982-480f-bdb5-9fcb4ac4b21d','Larb Gai', null, 11.10, true, 'cb63e348-485b-41dd-b9e9-45c24265883d'),
    ('02cbe455-cecf-48e5-a1e4-ed28b481347a','Tacos al Pastor', null, 9.50, true, '1a6c727c-c25e-4188-abea-cc8ed9efaee5'),
    ('9dc8f668-0ccc-4115-ba7b-3a37f7b9422e','Chicken Enchiladas', null, 11.20, false, '1a6c727c-c25e-4188-abea-cc8ed9efaee5'),
    ('b1150c0f-8dbd-4abf-ac90-00b5088910f8','Guacamole & Chips', null, 7.50, true, '1a6c727c-c25e-4188-abea-cc8ed9efaee5');

INSERT INTO groups (id, name)
VALUES
    ('0cc1a34c-3015-457b-8593-19e21989d3ba', 'user');

INSERT INTO users (id, name, email, password, created_at, updated_at)
VALUES
    ('bf91236e-4595-499b-933d-1703b8ca1f77', 'John Malone Doe', 'johndoe@gmail.com', '12345678', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO orders (id, subtotal, delivery_fee, grand_total, address_street, address_apartment_number, address_number, address_city, address_zip, status, payment_method_id, restaurant_id, client_id, created_at, confirmed_at, delivered_at, cancelled_at)
VALUES ('046986fb-bc0e-43ef-be9f-fbe7d4cf7835', 106.75, 8.46, 115.21, 'Rue de Verdun', null, '33', 'Montfermeil', '93370', 'OPEN', '82536ca4-e2ae-41c1-8e1a-2dcab4efc162', 'e218974b-16bd-49c5-9af6-7ef2843d6c80', 'bf91236e-4595-499b-933d-1703b8ca1f77', CURRENT_TIMESTAMP, NULL, NULL, NULL);

INSERT INTO order_items (id, unit_price, promotional_discount, grand_total, quantity, obs, order_id, product_id)
VALUES
    ('c24aab15-3595-4f2e-8576-91e901e98465', 18.50, 0, 18.50, 1, NULL, '046986fb-bc0e-43ef-be9f-fbe7d4cf7835', 'f2718bf7-3b40-403a-a35b-703613237eae'),
    ('5dac0c82-bc0a-485c-9f31-db121913498c', 22.00, 0, 44.00, 2, 'No pepper', '046986fb-bc0e-43ef-be9f-fbe7d4cf7835', '5c6b56a9-aef0-4174-a524-acd2fd9f422d'),
    ('b6248d6b-152c-43c1-a7c3-64b0fa7f37bf', 14.75, 0, 44.25, 3, NULL, '046986fb-bc0e-43ef-be9f-fbe7d4cf7835', '993a89ba-b52d-4c5f-b67b-79678a2288c9');