insert into users (id, name, phone, nickname)
values (1, 'test1', '0901', 'nickname1')
,(2, 'test2', '0902', 'nickname2')
,(3, 'test3', '0903', 'nickname3')
,(4, 'test4', '0904', 'nickname4')
,(5, 'test5', '0905', 'nickname5')
,(6, 'test6', '0906', 'nickname6')
,(7, 'test7', '0907', 'nickname7')
,(8, 'test8', '0908', 'nickname8')
,(9, 'test9', '0909', 'nickname9')
,(10, 'test10', '0910', 'nickname10');

insert into products (id, name, price)
values (1, '小米手環', 1998)
,(2, '小米電視', 9888)
,(3, '小米洗衣機', 19999)
,(4, '小米吸塵器', 5800)
,(5, '小米除濕機', 5999)
,(6, '小米電燈泡', 99);

insert into orders (uid, pid, product_name, price)
values (1, 1, '小米手環', 1998)
,(1, 2, '小米電視', 9888)
,(1, 3, '小米洗衣機', 19999)

,(1, 4, '小米吸塵器', 5800)
,(1, 5, '小米除濕機', 5999)
,(2, 3, '小米洗衣機', 19999)
,(2, 5, '小米除濕機', 5999)
,(2, 6, '小米電燈泡', 99)
,(3, 5, '小米手環', 1998);