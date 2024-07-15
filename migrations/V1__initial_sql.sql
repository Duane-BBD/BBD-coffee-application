create table office(
officeID int NOT NULL,
officeName varchar(255) NOT NULL,
PRIMARY KEY(officeID)
);
 
 create table userStatus(
userStatusID INT AUTO_INCREMENT NOT NULL,
statusValue VARCHAR(255) NOT NULL,
PRIMARY KEY(userStatusID)
);

CREATE TABLE userType(
userTypeID INT AUTO_INCREMENT NOT NULL,
userTypeValue VARCHAR(255) NOT NULL,
primary key(userTypeID));
 
CREATE TABLE appUser (
    userID INT NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    officeID INT NOT NULL,
    userStatusID INT NOT NULL,
    userTypeID INT NOT NULL,
    bannedUntil TIMESTAMP NULL,
    PRIMARY KEY (userID),
    CONSTRAINT FK_OfficeAppUser FOREIGN KEY (officeID) REFERENCES office(officeID),
	CONSTRAINT FK_StatusAppUser FOREIGN KEY (userStatusID) REFERENCES userStatus(userStatusID),
	CONSTRAINT FK_UserTypeAppUser FOREIGN KEY (userTypeID) REFERENCES userType(userTypeID)
	ON UPDATE CASCADE
	ON DELETE CASCADE
);
 
CREATE TABLE product(
productID INT AUTO_INCREMENT NOT NULL,
productName VARCHAR(255) NOT NULL,
PRIMARY KEY(productID));
 
 CREATE TABLE orderStatus(
orderStatusID INT AUTO_INCREMENT NOT NULL,
orderStatusValue VARCHAR(255) NOT NULL,
PRIMARY KEY(orderStatusID));
 
CREATE TABLE orderList(
orderID INT AUTO_INCREMENT NOT NULL ,
productID INT NOT NULL,
orderStatusID INT NOT NULL,
quantity INT NOT NULL,
userID INT NOT NULL,
timeForBan TIMESTAMP NULL,
PRIMARY KEY(orderID),
CONSTRAINT FK_ProductOrderList FOREIGN KEY (productID) REFERENCES product(productID),
CONSTRAINT FK_OrderStatusOrderList FOREIGN KEY (orderStatusID) REFERENCES orderStatus(orderStatusID),
CONSTRAINT FK_AppUserOrderList FOREIGN KEY (userID) REFERENCES appUser(userID)
ON UPDATE CASCADE
ON DELETE CASCADE
);

CREATE TABLE availability(
availabilityID INT AUTO_INCREMENT NOT NULL ,
officeID INT NOT NULL,
productID INT NOT NULL,
PRIMARY KEY(availabilityID),
CONSTRAINT FK_OfficeAvailability FOREIGN KEY (officeID) REFERENCES office(officeID),
CONSTRAINT FK_ProductAvailablity FOREIGN KEY (productID) REFERENCES product(productID)
ON UPDATE CASCADE
ON DELETE CASCADE
);
