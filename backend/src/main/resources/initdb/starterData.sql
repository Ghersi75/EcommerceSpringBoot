CREATE TABLE store_item (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL
  display_order INT NOT NULL,
);

-- Modifier category. Classic Shirts, Seasonal Shirts, etc.
CREATE TABLE item_modifier {
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  item_id INT REFERENCES store_item(id) not null,
  display_order INT NOT NULL,
}

-- Modifier options. Red Classic Shirt, Blue Classic Shirt, Halloween Seasonal Shirt
CREATE TABLE item_modifier_option {
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  modifier_id INT REFERENCES item_modifier(id) NOT NULL,
  -- May be changed later to just pull item_modifier_image with displayOrder 0
  thumbnail_image_link TEXT NOT NULL
  display_order INT NOT NULL
}

-- All Images associated with each option above. Red Classic Shirt will have different options than
CREATE TABLE item_modifier_option_image {
  id SERIAL PRIMARY KEY,
  item_id INT REFERENCES store_item(id) NOT NULL,
  modifier_option_id INT REFERENCES item_modifier_option(id) NOT NULL,
  image_link TEXT NOT NULL,
  display_order INT NOT NULL
}

-- All items will have some sort of sizes
CREATE TABLE size {
  id SERIAL PRIMARY KEY,
  size_name VARCHAR(20) NOT NULL
}

-- Keep track of stock for each option and size
CREATE TABLE modifier_option_size_stock {
  id SERIAL PRIMARY KEY,
  size__id INT REFERENCES size(id) NOT NULL,
  item_option_id INT REFERENCES item_modifier_option(id) NOT NULL,
  available INT NOT NULL DEFAULT 0
}

-- Old table, will get removed once the rest works
CREATE TABLE store_item_image (
  id SERIAL PRIMARY KEY,
  store_item_id INT REFERENCES store_item(id) NOT NULL,
  image_link TEXT NOT NULL,
  display_order INT NOT NULL
);



-- Insert store items
INSERT INTO store_item (title, description) 
  VALUES  ('Classic Shirt', 'Our most popular shirt made of 100% finest quality cotton'),
          ('Basic Shirt', 'Our most basic shirt made of polyester'),
          ('Basic No Picture Shirt', 'Our most basic blue shirt made of cotton');

INSERT INTO item_modifier (name, item_id, thumbnail_image_link, display_order) 
  VALUES ()

-- Insert images for store items
INSERT INTO store_item_image (store_item_id, image_link, display_order) 
  VALUES  (1, 'https://img.sonofatailor.com/images/customizer/product/White_O_Crew_Regular_NoPocket.jpg', 1),
          (1, 'https://imgs.michaels.com/MAM/assets/1/5E3C12034D34434F8A9BAAFDDF0F8E1B/img/21177E8F66794CD1A9980FA921592DB1/10307717_11.jpg', 2),
          (1, 'https://static.owayo-cdn.com/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_whi.png', 3),
          (2, 'https://imgs.michaels.com/MAM/assets/1/5E3C12034D34434F8A9BAAFDDF0F8E1B/img/BD1E5035D0EB4350BB57BC0172BC0521/10503919_11.jpg', 1),
          (2, 'https://owayo-cdn.com/cdn-cgi/image/format=auto,fit=contain,width=490/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_brr.png', 2),
          (2, 'https://i5.walmartimages.com/seo/Kids-Cotton-Short-Sleeve-T-Shirt-Youth-Soft-Tee-Crewneck-T-Shirts-for-Boys-and-Girls-Solid-Color-Tops-Size-1-12-Years-Sky-Blue-12-18Months_9003d54e-8ae2-4be4-a596-77c12cce15fd.ed1c70acf94ae9b6d77737643af69db5.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF', 3);
