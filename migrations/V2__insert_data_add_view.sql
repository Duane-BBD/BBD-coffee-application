INSERT INTO product(productID,productName)
VALUES (1,'Espresso'),(2,'Latte'), (3,'Cappuccino'), (4,'Americano'), (5,'Macchiato'),(6,'Mocha');

INSERT INTO office(officeID,officeName)
VALUES (1,'Pune '), (2,'Cape town '),(3,'London'),(4,'Amsterdam'),(5,'Pretoria'),(6,'Johannseburg');

INSERT INTO availability(availabilityID,officeID,productID)
VALUES (1,3,4), (2,1,7), (3,2,2)

INSERT INTO orderstatus(orderStatusID,orderStatusValue)
VALUES (1,'Pending'),(2,'In progress'),(3,'Prepared'),(4,'Complete'),(5,'Cancelled');

INSERT INTO userstatus(userStatusID,statusValue)
VALUES (1,'Active'),(2,'Inactive'),(3,'Ban');

INSERT INTO usertype(userTypeID,userTypeValue)
VALUES (1,'Employee'),(2,'Barista');

INSERT INTO appuser (userID, firstName, lastName, officeID, userStatusID, userTypeID) 
VALUES ('1025', 'swizel', 'antao', '2', '1', '1'), ('1056', 'duane', 'rodrigues', '5', '2', '2'), ('1025', 'sanketh', 'shenoy', '1', '3', '1');

INSERT INTO orderlist (orderID, productID, orderStatusID, quantity, userID) 
VALUES ('1', '1', '2', '2', '1025'), ('2', '5', '2', '2', '1025'), ('3', '2', '1', '1', '1028');


CREATE VIEW selectedProduct AS SELECT
availabilityID,
officeID,
productID
FROM availability;

INSERT INTO selectedProduct(availabilityID,officeID,productID)
VALUES (1,3,4), (2,1,6), (3,2,2);