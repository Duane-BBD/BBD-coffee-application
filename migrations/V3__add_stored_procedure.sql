DELIMITER $$
 
CREATE PROCEDURE GetOrderDetails()
BEGIN
    SELECT
        orderlist.orderID,
        product.productName,
        office.officeName,
        CONCAT(appuser.firstName, ' ', appuser.lastName) AS userName,
        orderstatus.orderStatusValue,
        orderlist.quantity
    FROM
        orderList Ol
        INNER JOIN product P
        ON Ol.productID = P.productID
        INNER JOIN appuser Au
        ON Ol.userID = appuser.userID
        INNER JOIN office O
        ON Au.officeID= O.officeID
        INNER JOIN orderStatus Os
        ON Ol.orderStatusID = Os.orderStatusID;
END $$

DELIMITER;

DELIMITER $$
CREATE PROCEDURE GetProductAvailabilityByOffice(IN OfficeID INT)
BEGIN
    SELECT P.productName, O.officeName
    FROM availability A
    INNER JOIN product P ON A.productID = P.productID
    INNER JOIN office O ON A.officeID = O.officeID
    WHERE A.officeID = OfficeID;
END $$ 
DELIMITER;

DELIMITER $$
CREATE PROCEDURE CreateBaristaUser(
    IN userID INT,
    IN firstName VARCHAR(255),
    IN lastName VARCHAR(255),
    IN officeName VARCHAR(255),
    IN statusValue VARCHAR(255)
)
BEGIN
    DECLARE officeIDVal INT;
    DECLARE userStatusIDVal INT;
    DECLARE userTypeIDVal INT;
    SELECT officeID INTO officeIDVal
    FROM office O
    WHERE officeName = O.officeName
    LIMIT 1;
    SELECT userStatusID INTO userStatusIDVal
    FROM userStatus Us
    WHERE statusValue = Us.statusValue
    LIMIT 1;
    SELECT userTypeID INTO userTypeIDVal
    FROM userType
    WHERE userTypeValue = 'barista'
    LIMIT 1;
    INSERT INTO appUser (userID, firstName, lastName, officeID, userStatusID, userTypeID)
    VALUES (userID, firstName, lastName, officeIDVal, userStatusIDVal, userTypeIDVal);
END $$
DELIMITER ;