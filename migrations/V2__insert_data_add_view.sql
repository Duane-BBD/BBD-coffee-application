INSERT INTO product(`productName`)
VALUES ('Espresso'),('Latte'), ('Cappuccino'), ('Americano'), ('Macchiato'),('Mocha');

INSERT INTO office(`officeName`)
VALUES ('Pune'), ('Cape town'),('London'),('Amsterdam'),('Pretoria'),('Johannseburg');

INSERT INTO availability(`officeID`, `productID`)
VALUES (3,4), (1,6), (2,2);

INSERT INTO orderStatus(`orderStatusValue`)
VALUES ('Pending'),('In progress'),('Prepared'),('Complete'),('Cancelled');

INSERT INTO userStatus(`statusValue`)
VALUES ('Active'),('Inactive'),('Ban');

INSERT INTO userType(`userTypeValue`)
VALUES ('Employee'),('Barista');

INSERT INTO appUser(`userID`, `firstName`, `lastName`, `officeID`, `userStatusID`, `userTypeID`) 
VALUES ('1025', 'swizel', 'antao', '2', '1', '1'), ('1056', 'duane', 'rodrigues', '5', '2', '2'), ('1028', 'sanketh', 'shenoy', '1', '3', '1');

INSERT INTO orderList(`productID`, `orderStatusID`, `quantity`, `userID`) 
VALUES ('1', '2', '2', '1025'), ('5', '2', '2', '1025'), ('2', '1', '1', '1028');



Create view availabilityView
AS
SELECT p.productID, p.productName, o.officeName
FROM product p
INNER JOIN availability a on p.productID=a.productID
INNER JOIN office o on a.officeID=o.officeID


CREATE VIEW orderdetails
AS 
SELECT ol.orderID, ol.productID, p.productName, ol.quantity, ol.timeForBan,s.orderStatusValue
FROM orderList ol
INNER JOIN product p ON ol.productID = p.productID
INNER JOIN orderstatus s ON s.orderStatusID=ol.orderStatusID;