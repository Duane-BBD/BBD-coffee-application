INSERT INTO tags(`tagName`)
VALUES 
    ('Coffee'), ('Hot'), ('Strong'), ('Classic'), ('Caffeinated'), 
    ('Milk'), ('Smooth'), ('Foamy'), ('Black'), ('Chocolate'), 
    ('Sweet'), ('Cold'), ('Refreshing'), ('Green Tea'), 
    ('Antioxidants'), ('Spiced'), ('Comfort'), ('Non-Caffeinated'), 
    ('Light'), ('Citrus'), ('Fruit'), ('Vitamin C'), ('Snack'), 
    ('Savory'), ('Bread'), ('Breakfast'), ('Pastry'), ('Buttery'), 
    ('Dessert'), ('Healthy'), ('Oats'), ('Portable'), ('Yogurt');


INSERT INTO product(`productName`, `description`, `associatedTags`, `imageURL`)
VALUES 
    ("Espresso", "A concentrated coffee brewed with 30 ml of hot water forced through finely-ground beans. Each shot delivers a bold flavor with a rich crema on top.", '[1, 2, 3, 4, 5]', 'https://www.thespruceeats.com/thmb/HJrjMfXdLGHbgMhnM0fMkDx9XPQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/what-is-espresso-765702-hero-03_cropped-ffbc0c7cf45a46ff846843040c8f370c.jpg'), 
    ("Latte", "Made with a single shot of espresso (30 ml) and 200 ml of steamed milk, topped with a light layer of milk foam. It’s smooth and creamy, ideal for a comforting coffee break.", '[1, 2, 6, 7, 5]', 'https://img.freepik.com/free-photo/latte-coffee_1122-2728.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1722816000&semt=ais_hybrid'),
    ("Cappuccino", "Consists of 30 ml of espresso, 60 ml of steamed milk, and 60 ml of milk foam. This classic drink offers a balanced mix of bold coffee flavor and creamy texture.", '[1, 2, 6, 8, 5]', 'https://media.istockphoto.com/id/505168330/photo/cup-of-cafe-latte-with-coffee-beans-and-cinnamon-sticks.jpg?s=612x612&w=0&k=20&c=h7v8kAfWOpRapv6hrDwmmB54DqrGQWxlhP_mTeqTQPA='),
    ("Americano", "Prepared with a single shot of espresso (30 ml) diluted with 150 ml of hot water. It’s a smooth, less intense coffee, ideal for a classic black coffee experience.", '[1, 2, 9, 4, 5]', 'https://berrynco.com/wp-content/uploads/2023/06/Americano-Coffee-thmbnail.jpg'),
    ("Macchiato", "A single shot of espresso (30 ml) topped with a small amount of frothy milk or foam (approximately 10 ml). This strong coffee drink has a slight creaminess with minimal milk.", '[1, 2, 6, 3, 5]', 'https://media.istockphoto.com/id/1304797091/photo/latte-macchiato-coffee-cup-on-wooden-table-with-roasted-coffee-beans.webp?b=1&s=170667a&w=0&k=20&c=y-kjYVY_bUxoG5vO4dQ1G5AJoF0PvcnXkPkI_YMOyHQ='),
    ("Mocha", "Blends a single shot of espresso (30 ml) with 200 ml of steamed milk and 20 ml of chocolate syrup, topped with whipped cream. It’s a rich combination of coffee and chocolate flavors.", '[1, 2, 10, 6, 11, 5]', 'https://media.istockphoto.com/id/157675911/photo/cappuccino-topped-with-swirls-of-chocolate-sauce.jpg?s=612x612&w=0&k=20&c=606NMYMjVnTmpSnJI537_IjW3lqfNJaH7Lc9Qg0BXPU='),
    ("Iced Coffee", "A chilled version of classic coffee, brewed and served over ice. It’s refreshing and perfect for a warm day.", '[1, 12, 13, 5, 9]', 'https://cdn.pixabay.com/photo/2024/06/26/06/58/ai-generated-8854172_1280.jpg'),
    ("Cold Brew", "Made by steeping coarsely ground coffee beans in cold water for an extended period, resulting in a smooth, strong coffee that is served cold.", '[1, 12, 3, 7, 5]', 'https://media.istockphoto.com/id/1483663560/photo/cold-refreshing-iced-cold-brew-coffee.webp?b=1&s=170667a&w=0&k=20&c=qEDYFJud_Z2rpLgA2tN2rUDaMCh59M4DfNR9tX_lYbw='),
    ("Flat White", "A coffee drink consisting of a single shot of espresso and microfoam (steamed milk with fine bubbles), offering a strong yet smooth coffee flavor.", '[1, 2, 6, 3, 5]', 'https://www.foodandwine.com/thmb/xQZv2CX6FO5331PYK7uGPF1we9Q=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Partners-Flat-White-FT-BLOG0523-b11f6273c2d84462954c2163d6a1076d.jpg'),
    ("Matcha Latte", "A blend of matcha green tea powder with steamed milk, often sweetened. It’s a smooth and creamy drink with a distinct, earthy flavor.", '[14, 2, 6, 14, 15, 5]', 'https://media.istockphoto.com/id/1325991061/photo/matcha-latte-green-milk-foam-cup-on-wood-table-at-cafe-trendy-powered-tea-trend-from-japan.jpg?s=612x612&w=0&k=20&c=a7cV9mdPwPj93BrxoFrJXEdA71RsOnXIOzVF90CYPsQ='),
    ("Chai Latte", "A spiced tea blend with steamed milk and a touch of sweetness. This warming drink is rich in flavors like cinnamon, cardamom, and ginger.", '[14, 2, 16, 6, 5, 17]', 'https://t4.ftcdn.net/jpg/07/54/11/69/360_F_754116934_j9s5Fc8zr3csF1iH1iNNvsIjHgdhrFB8.jpg'),
    ("Hot Chocolate", "A comforting, sweet drink made from melted chocolate or cocoa powder mixed with steamed milk. It’s a rich and indulgent treat, often topped with whipped cream.", '[18, 2, 10, 11, 17, 18]', 'https://media.istockphoto.com/id/1167197311/photo/chocolate-hot-drink.jpg?s=612x612&w=0&k=20&c=vvtoauOyWfdg4qZ9hiAywK5vNF6aTPtJt4GW6gG2EcY='),
    ("Iced Tea", "A chilled, refreshing tea, often served with lemon and a hint of sweetness. It’s light and perfect for warm weather.", '[14, 12, 13, 19, 18]', 'https://img.ws.mms.shopee.co.id/ad37690ae8e69dd79068158592088447'),
    ("Lemonade", "A classic, refreshing drink made from freshly squeezed lemon juice, water, and sugar. It’s tart and sweet, perfect for cooling down on a hot day.", '[18, 12, 13, 20, 18]', 'https://img.freepik.com/premium-photo/natural-lemonade-with-mint-fresh-fruit-wooden-table_158023-2875.jpg'),
    ("Orange Juice", "Freshly squeezed orange juice, rich in vitamin C and refreshing with a natural sweetness.", '[18, 12, 21, 13, 22, 18]', 'https://media.istockphoto.com/id/825882916/photo/fresh-glass-of-orange-juice-on-rustic-table-top.jpg?s=612x612&w=0&k=20&c=Yt4RSm_9tNRkXw4GMJofqa3keZTWv3iAHHJLLl9e-lg='),
    ("Bagel with Cream Cheese", "A toasted bagel served with a generous spread of cream cheese. It’s a simple, satisfying snack or light breakfast.", '[23, 24, 25, 26, 19]', 'https://st4.depositphotos.com/1692343/39081/i/450/depositphotos_390810964-stock-photo-homemade-cream-cheese-bagel-ready.jpg'),
    ("Croissant", "A flaky, buttery pastry that is light and airy. Perfect for breakfast or a snack.", '[23, 27, 28, 26, 19]', 'https://media.istockphoto.com/id/1614842743/photo/fresh-butter-croissant-on-plate-isolated-on-white-background.webp?b=1&s=170667a&w=0&k=20&c=5ineu_RXS5_-zBmrm0deJCkVWau1zpVVbxQKlWzNCnM='),
    ("Muffin", "A sweet, baked good that comes in a variety of flavors, such as blueberry or chocolate chip. Great for breakfast or dessert.", '[23, 11, 27, 26, 29]', 'https://st.depositphotos.com/1170638/3787/i/450/depositphotos_37876715-stock-photo-blueberry-muffin.jpg'),
    ("Granola Bar", "A healthy, portable snack made from oats, nuts, and dried fruit. It’s perfect for on-the-go snacking.", '[23, 30, 31, 32, 19]', 'https://media.istockphoto.com/id/185099151/photo/granola-bar.jpg?s=612x612&w=0&k=20&c=GRljdDmAca8zxsY7fLZsxy3N_MKzEi-ANWtBL7Txj3g='),
    ("Fruit Salad", "A refreshing mix of fresh fruits, such as berries, melons, and citrus. A healthy and light snack option.", '[23, 30, 21, 13, 19]', 'https://thumbs.dreamstime.com/b/fresh-fruit-salad-bowl-healthy-wooden-background-top-view-51971994.jpg'),
    ("Yogurt Parfait", "Layers of creamy yogurt, fresh fruit, and crunchy granola. It’s a healthy and satisfying breakfast or snack.", '[23, 30, 33, 21, 26, 19]', 'https://www.allrecipes.com/thmb/PIqxvUIl8Ccf1gJbETkLJyjz_w8=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/407889-Yogurt-Parfait-Alberta-Rose-4x3-1-73a635ff9d0e47608a138aa9eac518ed.jpg');

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