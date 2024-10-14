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
  VALUES  ('Classic Shirt', 'Our most popular shirt made of 100% finest quality cotton'),
          ('Basic Shirt', 'Our most basic shirt made of polyester'),
          ('Basic No Picture Shirt', 'Our most basic blue shirt made of cotton');

-- Insert images for store items
INSERT INTO store_item_image (store_item_id, image_link, display_order) 
  VALUES  (1, 'https://img.sonofatailor.com/images/customizer/product/White_O_Crew_Regular_NoPocket.jpg', 1),
          (1, 'https://imgs.michaels.com/MAM/assets/1/5E3C12034D34434F8A9BAAFDDF0F8E1B/img/21177E8F66794CD1A9980FA921592DB1/10307717_11.jpg', 2),
          (1, 'https://static.owayo-cdn.com/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_whi.png', 3),
          (2, 'https://imgs.michaels.com/MAM/assets/1/5E3C12034D34434F8A9BAAFDDF0F8E1B/img/BD1E5035D0EB4350BB57BC0172BC0521/10503919_11.jpg', 1),
          (2, 'https://owayo-cdn.com/cdn-cgi/image/format=auto,fit=contain,width=490/newhp/img/productHome/productSeitenansicht/productservice/tshirts_classic_herren_basic_productservice/st2020_brr.png', 2),
          (2, 'https://i5.walmartimages.com/seo/Kids-Cotton-Short-Sleeve-T-Shirt-Youth-Soft-Tee-Crewneck-T-Shirts-for-Boys-and-Girls-Solid-Color-Tops-Size-1-12-Years-Sky-Blue-12-18Months_9003d54e-8ae2-4be4-a596-77c12cce15fd.ed1c70acf94ae9b6d77737643af69db5.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF', 3);
