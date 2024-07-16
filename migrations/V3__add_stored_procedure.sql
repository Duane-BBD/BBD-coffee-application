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
    WHERE officeName = O.officeName;
    SELECT userStatusID INTO userStatusIDVal
    FROM userStatus Us
    WHERE statusValue = Us.statusValue;
    SELECT userTypeID INTO userTypeIDVal
    FROM userType
    WHERE userTypeValue = 'barista';
    INSERT INTO appUser (userID, firstName, lastName, officeID, userStatusID, userTypeID)
    VALUES (userID, firstName, lastName, officeIDVal, userStatusIDVal, userTypeIDVal);
END $$
DELIMITER ;