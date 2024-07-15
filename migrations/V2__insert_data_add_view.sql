INSERT INTO product(`productID`, `productName`)
VALUES (1,'Espresso'),(2,'Latte'), (3,'Cappuccino'), (4,'Americano'), (5,'Macchiato'),(6,'Mocha');

INSERT INTO office(`officeID`, `officeName`)
VALUES (1,'Pune '), (2,'Cape town '),(3,'London'),(4,'Amsterdam'),(5,'Pretoria'),(6,'Johannseburg');

INSERT INTO availability(`availabilityID`, `officeID`, `productID`)
VALUES (1,3,4), (2,1,6), (3,2,2);

INSERT INTO orderStatus(`orderStatusID`, `orderStatusValue`)
VALUES (1,'Pending'),(2,'In progress'),(3,'Prepared'),(4,'Complete'),(5,'Cancelled');

INSERT INTO userStatus(`userStatusID`, `statusValue`)
VALUES (1,'Active'),(2,'Inactive'),(3,'Ban');

INSERT INTO userType(`userTypeID`, `userTypeValue`)
VALUES (1,'Employee'),(2,'Barista');

INSERT INTO appUser(`userID`, `firstName`, `lastName`, `officeID`, `userStatusID`, `userTypeID`) 
VALUES ('1025', 'swizel', 'antao', '2', '1', '1'), ('1056', 'duane', 'rodrigues', '5', '2', '2'), ('1028', 'sanketh', 'shenoy', '1', '3', '1');

INSERT INTO orderList(`orderID`, `productID`, `orderStatusID`, `quantity`, `userID`) 
VALUES ('1', '1', '2', '2', '1025'), ('2', '5', '2', '2', '1025'), ('3', '2', '1', '1', '1028');



Create view addToCart
AS
SELECT p.productID, p.productName, o.officeName
FROM product p 
JOIN availability a on p.productID=a.productID
JOIN office o on a.officeID=o.officeID


CREATE VIEW orderdetails
AS 
SELECT ol.orderID, ol.productID, p.productName, ol.quantity, ol.timeForBan,s.orderStatusValue
FROM orderList ol
JOIN product p ON ol.productID = p.productID
JOIN orderstatus s ON s.orderStatusID=ol.orderStatusID;

 