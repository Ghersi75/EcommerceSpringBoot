CREATE TABLE store_item (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL,
  display_order INT NOT NULL,
  price INT NOT NULL,
  discount_price INT DEFAULT NULL,
  thumbnail_image_link TEXT NOT NULL
  -- TODO: Maybe add a thumbnail here for the main page
  -- Surprised I didn't think about this earlier, now frontend is gonna be broken 😭
);

-- Modifier category. Classic Shirts, Seasonal Shirts, etc.
CREATE TABLE item_modifier (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  item_id INT REFERENCES store_item(id) not null,
  display_order INT NOT NULL
);

-- Modifier options. Red Classic Shirt, Blue Classic Shirt, Halloween Seasonal Shirt
CREATE TABLE item_modifier_option (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  modifier_id INT REFERENCES item_modifier(id) NOT NULL,
  -- May be changed later to just pull item_modifier_image with displayOrder 0
  thumbnail_image_link TEXT NOT NULL,
  display_order INT NOT NULL
);

-- All Images associated with each option above. Red Classic Shirt will have different options than
CREATE TABLE item_modifier_option_image (
  id SERIAL PRIMARY KEY,
  item_id INT REFERENCES store_item(id) NOT NULL,
  modifier_option_id INT REFERENCES item_modifier_option(id) NOT NULL,
  image_link TEXT NOT NULL,
  display_order INT NOT NULL
);

-- All items will have some sort of sizes
CREATE TABLE size (
  id SERIAL PRIMARY KEY,
  size_name VARCHAR(20) NOT NULL
);

-- Keep track of stock for each option and size
CREATE TABLE modifier_option_size_stock (
  id SERIAL PRIMARY KEY,
  size__id INT REFERENCES size(id) NOT NULL,
  item_option_id INT REFERENCES item_modifier_option(id) NOT NULL,
  available INT NOT NULL DEFAULT 0
);

-- Old table, will get removed once the rest works
CREATE TABLE store_item_image (
  id SERIAL PRIMARY KEY,
  store_item_id INT REFERENCES store_item(id) NOT NULL,
  image_link TEXT NOT NULL,
  display_order INT NOT NULL
);



-- Insert store items
INSERT INTO store_item (title, description, display_order, price, discount_price, thumbnail_image_link)
  VALUES  ('Classic Shirt', 'Our most popular shirt made of 100% finest quality cotton', 0, 1199, 999, 'https://i.pinimg.com/736x/2e/88/a5/2e88a52be17ccbce0306aae0a295138c.jpg'),
          ('Basic Shirt', 'Our most basic shirt made of polyester', 1, 1299, NULL, 'https://i.pinimg.com/736x/2e/88/a5/2e88a52be17ccbce0306aae0a295138c.jpg'),
          ('Basic No Picture Shirt', 'Our most basic blue shirt made of cotton', 2, 1399, 499, 'https://i.pinimg.com/736x/2e/88/a5/2e88a52be17ccbce0306aae0a295138c.jpg');
-- Shirt 1 Classics, Shirt 1 Seasonal, Shirt 2 Classics, Shirt 2 Seasonal
INSERT INTO item_modifier (name, item_id, display_order) 
  VALUES  ('Classics', 1, 0),
          ('Seasonal', 1, 1),
          ('Classics', 2, 0),
          ('Seasonal', 2, 1);
-- Shirt 1 Classics Red and Black, Shirt 1 Seasonal Halloween and Christmas, Shirt 2 Classics Red and Black, Shirt 2 Halloween and Christmas
INSERT INTO item_modifier_option (name, modifier_id, display_order, thumbnail_image_link)
  VALUES  ('Red', 1, 0, 'https://image.similarpng.com/very-thumbnail/2020/12/Realistic-Red-shirt-for-men-on-transparent-background-PNG-1.png'),
          ('Black', 1, 1, 'https://i.pinimg.com/736x/2e/88/a5/2e88a52be17ccbce0306aae0a295138c.jpg'),
          ('Halloween', 2, 0, 'https://ih1.redbubble.net/image.4365502368.5410/ssrco,slim_fit_t_shirt,flatlay,101010:01c5ca27c6,front,wide_portrait,750x1000-bg,f8f8f8.jpg'),
          ('Christmas', 2, 1, 'https://static.vecteezy.com/system/resources/previews/001/868/599/non_2x/children-playing-with-snowman-in-christmas-theme-on-t-shirt-on-transparent-background-free-vector.jpg'),
          ('Red', 3, 0, 'https://img.freepik.com/premium-psd/red-tshirt-front-view-mockup-image-png_584197-1676.jpg?semt=ais_hybrid'),
          ('Black', 3, 1, 'https://img.freepik.com/free-psd/plain-black-tshirt-transparent-background_125540-4055.jpg'),
          ('Halloween', 4, 0, 'https://i5.walmartimages.com/seo/Black-Halloween-TShirt-with-Glowing-Orange-O-Face-Design-Kids-Adults-Graphic-Tee-Print-on-Demand-No-Background_ede89872-4478-48fb-8c72-3eed27a82db2.80476f9d7aa2d26aabee49f75e9575b2.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF'),
          ('Christmas', 4, 1, 'https://i.etsystatic.com/35806090/r/il/ba3529/5571871615/il_570xN.5571871615_5n0l.jpg');

-- Insert images for store items
INSERT INTO store_item_image (store_item_id, image_link, display_order) 
  VALUES  (1, 'https://img.sonofatailor.com/images/customizer/product/White_O_Crew_Regular_NoPocket.jpg', 1),
          (1, 'https://imgs.michaels.com/MAM/assets/1/5E3C12034D34434F8A9BAAFDDF0F8E1B/img/21177E8F66794CD1A9980FA921592DB1/10307717_11.jpg', 2),
          (1, 'https://static.owayo-cdn.com/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_whi.png', 3),
          (2, 'https://imgs.michaels.com/MAM/assets/1/5E3C12034D34434F8A9BAAFDDF0F8E1B/img/BD1E5035D0EB4350BB57BC0172BC0521/10503919_11.jpg', 1),
          (2, 'https://owayo-cdn.com/cdn-cgi/image/format=auto,fit=contain,width=490/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_brr.png', 2),
          (2, 'https://i5.walmartimages.com/seo/Kids-Cotton-Short-Sleeve-T-Shirt-Youth-Soft-Tee-Crewneck-T-Shirts-for-Boys-and-Girls-Solid-Color-Tops-Size-1-12-Years-Sky-Blue-12-18Months_9003d54e-8ae2-4be4-a596-77c12cce15fd.ed1c70acf94ae9b6d77737643af69db5.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF', 3);
