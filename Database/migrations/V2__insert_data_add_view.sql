INSERT INTO product(`productName`, `description`)
VALUES 
    ('Espresso', 'A concentrated coffee brewed with 30 ml of hot water forced through finely-ground beans. Each shot delivers a bold flavor with a rich crema on top.'), 
    ('Latte', 'Made with a single shot of espresso (30 ml) and 200 ml of steamed milk, topped with a light layer of milk foam. It’s smooth and creamy, ideal for a comforting coffee break.'), 
    ('Cappuccino', 'Consists of 30 ml of espresso, 60 ml of steamed milk, and 60 ml of milk foam. This classic drink offers a balanced mix of bold coffee flavor and creamy texture.'), 
    ('Americano', 'Prepared with a single shot of espresso (30 ml) diluted with 150 ml of hot water. It’s a smooth, less intense coffee, ideal for a classic black coffee experience.'), 
    ('Macchiato', 'A single shot of espresso (30 ml) topped with a small amount of frothy milk or foam (approximately 10 ml). This strong coffee drink has a slight creaminess with minimal milk.'), 
    ('Mocha', 'Blends a single shot of espresso (30 ml) with 200 ml of steamed milk and 20 ml of chocolate syrup, topped with whipped cream. It’s a rich combination of coffee and chocolate flavors.');

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
VALUES 
    (1025, 'swizel', 'antao', 2, 1, 1), 
    (1056, 'duane', 'rodrigues', 5, 2, 2), 
    (1028, 'sanketh', 'shenoy', 1, 3, 1);

INSERT INTO milkType(`milkTypeValue`)
VALUES ('Full cream milk'), ('Oat milk'), ('Almond milk'), ('Lactose free milk');

INSERT INTO orderList(`productID`, `orderStatusID`, `quantity`, `userID`, `officeID`, `milkTypeID`) 
VALUES (1, 2, 2, 1025, 1, 1), (5, 2, 2, 1025, 1, 3), (2, 1, 1, 1028, 3, 4);



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