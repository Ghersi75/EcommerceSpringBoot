CREATE TABLE store_item (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL,
  -- Just to be safe
  image_link VARCHAR(2000) NOT NULL
);

INSERT INTO store_item (title, description, image_link) 
  VALUES ('Classic Shirt', 'Our most popular shirt made of 100% finest quality cotton', 'https://img.sonofatailor.com/images/customizer/product/White_O_Crew_Regular_NoPocket.jpg'),
         ('Basic Shirt', 'Our most basic shirt made of polyester', 'https://static.owayo-cdn.com/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_whi.png');