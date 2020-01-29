
delete FROM user where id>0;
delete FROM product where id>0;
INSERT INTO user (id, name, user_name, surname, password, email, is_admin) VALUES
  (1, 'admin','admin','admin surname', '$2a$10$jPd2l5nm9lBnuv1WKS72AeHuPn5lPH8ZuY.bcGC2wAJDk8GxH1OKC', 'admin@admin.com', true),
  (2, 'user','user', 'user', '$2a$10$Een60e/G9kft4B58OMG.CeFrsODH6ORMpxy3DBFHm127O3vDxAab.', 'vahagn@admin.com', false);

INSERT INTO product (id, name, type, price, count_in_stock) VALUES
    (1, 'nokia', 'phone', 10000, 10),
    (2, 'samsung', 'phone', 11000, 20),
    (3, 'lg', 'tv', 50000, 10),
    (4, 'sony', 'tv', 55000, 10),
    (5, 'macbook', 'laptop', 155000, 10),
    (6, 'dell', 'laptop', 120000, 10);