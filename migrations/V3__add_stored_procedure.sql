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
        orderList 
        INNER JOIN product  ON orderlist.productID = product.productID
        INNER JOIN appuser  ON orderlist.userID = appuser.userID
        INNER JOIN office  ON appuser.officeID= office.officeID
        INNER JOIN orderStatus  ON orderlist.orderStatusID = orderstatus.orderStatusID;
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