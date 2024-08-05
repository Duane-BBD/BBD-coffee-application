INSERT INTO tags(`tagName`)
VALUES 
    ('Coffee'), ('Hot'), ('Strong'), ('Classic'), ('Caffeinated'), 
    ('Milk'), ('Smooth'), ('Foamy'), ('Black'), ('Chocolate'), 
    ('Sweet'), ('Cold'), ('Refreshing'), ('Green Tea'), 
    ('Antioxidants'), ('Spiced'), ('Comfort'), ('Non-Caffeinated'), 
    ('Light'), ('Citrus'), ('Fruit'), ('Vitamin C'), ('Snack'), 
    ('Savory'), ('Bread'), ('Breakfast'), ('Pastry'), ('Buttery'), 
    ('Dessert'), ('Healthy'), ('Oats'), ('Portable'), ('Yogurt');


INSERT INTO product(`productName`, `description`, `associatedTags`)
VALUES 
    ("Espresso", "A concentrated coffee brewed with 30 ml of hot water forced through finely-ground beans. Each shot delivers a bold flavor with a rich crema on top.", '[1, 2, 3, 4, 5]'),
    ("Latte", "Made with a single shot of espresso (30 ml) and 200 ml of steamed milk, topped with a light layer of milk foam. It’s smooth and creamy, ideal for a comforting coffee break.", '[1, 2, 6, 7, 5]'),
    ("Cappuccino", "Consists of 30 ml of espresso, 60 ml of steamed milk, and 60 ml of milk foam. This classic drink offers a balanced mix of bold coffee flavor and creamy texture.", '[1, 2, 6, 8, 5]'),
    ("Americano", "Prepared with a single shot of espresso (30 ml) diluted with 150 ml of hot water. It’s a smooth, less intense coffee, ideal for a classic black coffee experience.", '[1, 2, 9, 4, 5]'),
    ("Macchiato", "A single shot of espresso (30 ml) topped with a small amount of frothy milk or foam (approximately 10 ml). This strong coffee drink has a slight creaminess with minimal milk.", '[1, 2, 6, 3, 5]'),
    ("Mocha", "Blends a single shot of espresso (30 ml) with 200 ml of steamed milk and 20 ml of chocolate syrup, topped with whipped cream. It’s a rich combination of coffee and chocolate flavors.", '[1, 2, 10, 6, 11, 5]'),
    ("Iced Coffee", "A chilled version of classic coffee, brewed and served over ice. It’s refreshing and perfect for a warm day.", '[1, 12, 13, 5, 9]'),
    ("Cold Brew", "Made by steeping coarsely ground coffee beans in cold water for an extended period, resulting in a smooth, strong coffee that is served cold.", '[1, 12, 3, 7, 5]'),
    ("Flat White", "A coffee drink consisting of a single shot of espresso and microfoam (steamed milk with fine bubbles), offering a strong yet smooth coffee flavor.", '[1, 2, 6, 3, 5]'),
    ("Matcha Latte", "A blend of matcha green tea powder with steamed milk, often sweetened. It’s a smooth and creamy drink with a distinct, earthy flavor.", '[14, 2, 6, 14, 15, 5]'),
    ("Chai Latte", "A spiced tea blend with steamed milk and a touch of sweetness. This warming drink is rich in flavors like cinnamon, cardamom, and ginger.", '[14, 2, 16, 6, 5, 17]'),
    ("Hot Chocolate", "A comforting, sweet drink made from melted chocolate or cocoa powder mixed with steamed milk. It’s a rich and indulgent treat, often topped with whipped cream.", '[18, 2, 10, 11, 17, 18]'),
    ("Iced Tea", "A chilled, refreshing tea, often served with lemon and a hint of sweetness. It’s light and perfect for warm weather.", '[14, 12, 13, 19, 18]'),
    ("Lemonade", "A classic, refreshing drink made from freshly squeezed lemon juice, water, and sugar. It’s tart and sweet, perfect for cooling down on a hot day.", '[18, 12, 13, 20, 18]'),
    ("Orange Juice", "Freshly squeezed orange juice, rich in vitamin C and refreshing with a natural sweetness.", '[18, 12, 21, 13, 22, 18]'),
    ("Bagel with Cream Cheese", "A toasted bagel served with a generous spread of cream cheese. It’s a simple, satisfying snack or light breakfast.", '[23, 24, 25, 26, 19]'),
    ("Croissant", "A flaky, buttery pastry that is light and airy. Perfect for breakfast or a snack.", '[23, 27, 28, 26, 19]'),
    ("Muffin", "A sweet, baked good that comes in a variety of flavors, such as blueberry or chocolate chip. Great for breakfast or dessert.", '[23, 11, 27, 26, 29]'),
    ("Granola Bar", "A healthy, portable snack made from oats, nuts, and dried fruit. It’s perfect for on-the-go snacking.", '[23, 30, 31, 32, 19]'),
    ("Fruit Salad", "A refreshing mix of fresh fruits, such as berries, melons, and citrus. A healthy and light snack option.", '[23, 30, 21, 13, 19]'),
    ("Yogurt Parfait", "Layers of creamy yogurt, fresh fruit, and crunchy granola. It’s a healthy and satisfying breakfast or snack.", '[23, 30, 33, 21, 26, 19]');

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