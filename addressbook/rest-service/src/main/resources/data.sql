INSERT INTO contact (contactid, company, email, firstname, lastname) VALUES
( 1, 'HR', 'Alex.Hr@mail.com', 'Alex', 'Mueir'),
( 2, 'RCH', 'Sussan.doc@mail.com', 'Susan', 'Doctor'),
( 3, '', 'steevan.winter@mail.com', 'steevan', 'winter'),
( 4, 'sun', 'david.oc@mail.com', 'david', 'oc'),
( 5, 'bmw', 'bella.c@mail.com', 'bella', 'bmw');

INSERT INTO phone_numbers (id, phone_number, phone_type, contactid) VALUES
( 1, '370215244', 'home', 1),
( 2, '370257244', 'work', 1),
( 3, '370015244', 'home', 2),
( 4, '370915244', 'home', 3),
( 5, '370015244', 'work', 4),
( 6, '370015234', 'home', 5);

INSERT INTO address_book (address_book_id, Contactlist) VALUES
( 'android', '1,2,4,5'),
( 'iphone', '1,2,3');




