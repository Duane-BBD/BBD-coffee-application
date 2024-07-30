CREATE TABLE office(
    officeID INT AUTO_INCREMENT NOT NULL,
    officeName varchar(255) NOT NULL,
    PRIMARY KEY(officeID),
    UNIQUE(officeName)
);

CREATE TABLE userStatus(
    userStatusID INT AUTO_INCREMENT NOT NULL,
    statusValue VARCHAR(255) NOT NULL,
    PRIMARY KEY(userStatusID),
    UNIQUE(statusValue)
);

CREATE TABLE userType(
    userTypeID INT AUTO_INCREMENT NOT NULL,
    userTypeValue VARCHAR(255) NOT NULL,
    primary key(userTypeID),
    UNIQUE(userTypeValue)
);

CREATE TABLE appUser (
    userID INT NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    officeID INT NOT NULL,
    userStatusID INT NOT NULL,
    userTypeID INT NOT NULL,
    bannedUntil TIMESTAMP NULL,
    PRIMARY KEY (userID),
    CONSTRAINT FK_OfficeAppUser FOREIGN KEY (officeID) REFERENCES office(officeID)
    ON UPDATE CASCADE,
	CONSTRAINT FK_StatusAppUser FOREIGN KEY (userStatusID) REFERENCES userStatus(userStatusID)
    ON UPDATE CASCADE,
	CONSTRAINT FK_UserTypeAppUser FOREIGN KEY (userTypeID) REFERENCES userType(userTypeID)
	ON UPDATE CASCADE
);

CREATE TABLE product(
    productID INT AUTO_INCREMENT NOT NULL,
    productName VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY(productID),
    UNIQUE(productName)
);

CREATE TABLE orderStatus(
    orderStatusID INT AUTO_INCREMENT NOT NULL,
    orderStatusValue VARCHAR(255) NOT NULL,
    PRIMARY KEY(orderStatusID),
    UNIQUE(orderStatusValue)
);

CREATE TABLE milkType(
    milkTypeID INT AUTO_INCREMENT NOT NULL,
    milkTypeValue VARCHAR(255) NOT NULL,
    PRIMARY KEY(milkTypeID),
    UNIQUE(milkTypeValue)
);
 
CREATE TABLE orderList(
    orderID INT AUTO_INCREMENT NOT NULL,
    productID INT NOT NULL,
    orderStatusID INT NOT NULL,
    quantity INT NOT NULL,
    notes VARCHAR(255),
    userID INT NOT NULL,
    officeID INT NOT NULL,
    milkTypeID INT NOT NULL,
    PRIMARY KEY(orderID),
    CONSTRAINT FK_ProductOrderList FOREIGN KEY (productID) REFERENCES product(productID)	
    ON UPDATE CASCADE,
    CONSTRAINT FK_OrderStatusOrderList FOREIGN KEY (orderStatusID) REFERENCES orderStatus(orderStatusID)
    ON UPDATE CASCADE,
    CONSTRAINT FK_AppUserOrderList FOREIGN KEY (userID) REFERENCES appUser(userID)
    ON UPDATE CASCADE,
    CONSTRAINT FK_OfficeOrderList FOREIGN KEY (officeID) REFERENCES office(officeID)
    ON UPDATE CASCADE,
    CONSTRAINT FK_MilkTypeOrderList FOREIGN KEY (milkTypeID) REFERENCES milkType(milkTypeID)
    ON UPDATE CASCADE
);

CREATE TABLE orderHistory(
    orderHistoryID INT AUTO_INCREMENT NOT NULL,
    orderID INT NOT NULL,
    orderStatusID INT NOT NULL,
    orderTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(orderHistoryID),
    CONSTRAINT FK_OrderListHistory FOREIGN KEY (orderID) REFERENCES orderList(orderID)
    ON UPDATE CASCADE,
    CONSTRAINT FK_OrderStatusHistory FOREIGN KEY (orderStatusID) REFERENCES orderStatus(orderStatusID)
    ON UPDATE CASCADE
);

CREATE TABLE availability(
    availabilityID INT AUTO_INCREMENT NOT NULL,
    officeID INT NOT NULL,
    productID INT NOT NULL,
    PRIMARY KEY(availabilityID),
    CONSTRAINT FK_OfficeAvailability FOREIGN KEY (officeID) REFERENCES office(officeID)
    ON UPDATE CASCADE,
    CONSTRAINT FK_ProductAvailablity FOREIGN KEY (productID) REFERENCES product(productID)
    ON UPDATE CASCADE
);