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