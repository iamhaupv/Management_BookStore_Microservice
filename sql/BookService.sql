select * from categories
select * from books
-- categories
SET IDENTITY_INSERT [dbo].[categories] ON 

insert into categories values('Love')
insert into categories values('Life')
insert into categories values('CartToon')
SET IDENTITY_INSERT [dbo].[categories] OFF

-- books
SET IDENTITY_INSERT [dbo].[books] ON 

insert into books(author, available, des, discount, image, name, publisher, publishing_year, quantity, unit_price, category_id)
values ('Pham Van Hau', 'True', 'Love is a powerful, vibrant emotion. Its a deep connection between two individuals that makes them feel special and complete.',
10, 'https://i.imgur.com/9h0eAki.jpeg', 'My Love', 'Hau Pham Van', '2002-06-09', 100, 100000, 1)
insert into books(author, available, des, discount, image, name, publisher, publishing_year, quantity, unit_price, category_id)
values ('Pham Van Hau', 'True', 'Love is a powerful, vibrant emotion. Its a deep connection between two individuals that makes them feel special and complete.',
10, 'https://i.imgur.com/9h0eAki.jpeg', 'My Love', 'Hau Pham Van', '2002-06-09', 100, 100000, 1)
insert into books(author, available, des, discount, image, name, publisher, publishing_year, quantity, unit_price, category_id)
values ('Pham Van Hau', 'True', 'Love is a powerful, vibrant emotion. Its a deep connection between two individuals that makes them feel special and complete.',
10, 'https://i.imgur.com/9h0eAki.jpeg', 'My Love', 'Hau Pham Van', '2002-06-09', 100, 100000, 1)

SET IDENTITY_INSERT [dbo].[books] OFF 