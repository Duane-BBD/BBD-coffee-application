INSERT INTO product(`productName`)
VALUES ('Espresso'), ('Latte'), ('Cappuccino'), ('Americano'), ('Macchiato'), ('Mocha');

INSERT INTO office(`officeName`)
VALUES ('Pune'), ('Cape town'), ('London'), ('Amsterdam'), ('Pretoria'), ('Johannseburg');

INSERT INTO availability(`officeID`, `productID`)
VALUES (3,4), (1,6), (2,2);

INSERT INTO orderStatus(`orderStatusValue`)
VALUES ('Pending'), ('In progress'), ('Prepared'), ('Complete'), ('Cancelled');

INSERT INTO userStatus(`statusValue`)
VALUES ('Active'), ('Inactive'), ('Ban');

INSERT INTO userType(`userTypeValue`)
VALUES ('Employee'), ('Barista'), ('Admin');

INSERT INTO appUser(`userID`, `firstName`, `lastName`, `officeID`, `userStatusID`, `userTypeID`) 
VALUES ('1025', 'swizel', 'antao', '2', '1', '1'), ('1056', 'duane', 'rodrigues', '5', '2', '2'), ('1028', 'sanketh', 'shenoy', '1', '3', '1');

INSERT INTO orderList(`productID`, `orderStatusID`, `quantity`, `userID`, `officeID`) 
VALUES ('1', '2', '2', '1025', '1'), ('5', '2', '2', '1025', '1'), ('2', '1', '1', '1028', '3');



CREATE VIEW availabilityView
AS
SELECT p.productID, p.productName, o.officeName
FROM product p
INNER JOIN availability a on p.productID=a.productID
INNER JOIN office o on a.officeID=o.officeID;


CREATE VIEW orderDetails
AS 
    SELECT
        Ol.orderID,
        P.productName,
        O.officeName,
        CONCAT(Au.firstName, ' ', Au.lastName) AS userName,
        Os.orderStatusValue,
        Ol.quantity
    FROM
        orderList Ol
        INNER JOIN product P ON Ol.productID = P.productID
        INNER JOIN appuser Au ON Ol.userID = Au.userID
        INNER JOIN office O ON Au.officeID= O.officeID
        INNER JOIN orderStatus Os ON Ol.orderStatusID = Os.orderStatusID;