CREATE TABLE store_item (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE store_item_image (
  id SERIAL PRIMARY KEY,
  store_item_id INT REFERENCES store_item(id) NOT NULL,
  image_link TEXT NOT NULL,
  display_order INT NOT NULL
);

-- Insert store items
INSERT INTO store_item (title, description) 
  VALUES ('Classic Shirt', 'Our most popular shirt made of 100% finest quality cotton'),
         ('Basic Shirt', 'Our most basic shirt made of polyester');

-- Insert images for store items
INSERT INTO store_item_image (store_item_id, image_link, display_order) 
  VALUES (1, 'https://img.sonofatailor.com/images/customizer/product/White_O_Crew_Regular_NoPocket.jpg', 1),
         (2, 'https://static.owayo-cdn.com/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_whi.png', 1);
