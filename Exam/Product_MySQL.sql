create database product
use product

CREATE TABLE `products` (
  `id` VARCHAR(36) NOT NULL,
  `code` VARCHAR(9) NOT NULL,
  `name` VARCHAR(90) NOT NULL,
  `category` VARCHAR(28) NOT NULL,
  `brand` VARCHAR(28) DEFAULT NULL,
  `type` VARCHAR(21) DEFAULT NULL,
  `description` VARCHAR(180) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UX_product_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

drop table products;

create table `user` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `username` varchar(90) not null,
    `password` varchar(90) not null,
    `role` varchar(20) not null,
    PRIMARY KEY (`id`),
	UNIQUE KEY `uni_username` (`username`),
    constraint chk_role check (role = 'USER' or role = 'ADMIN')
);

DROP TABLE `user`;

CREATE TABLE `audit_logs` (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    method_name VARCHAR(255),
    result TEXT,
    timestamp DATETIME
);

drop table `audit_logs`;


INSERT INTO `products` (`id`, `code`, `name`, `category`, `brand`, `type`, `description`) VALUES 
  (UUID(), "P001", "MASK ADULT Surgical 3 ply 50'S MEDICOS with box", "Health Accessories", "Medicos", "Hygiene", "Colour: Blue (ear loop outside, ear loop inside- random assigned), Green, Purple, White, Lime Green, Yellow, Pink"),
  (UUID(), "P002", "Party Cosplay Player Unknown Battlegrounds Clothes Hallowmas PUBG", "Men's Clothing", "No Brand", NULL, "Suitable for adults and children."),
  (UUID(), "P003", "Xiaomi REDMI 8A Official Global Version 5000 mAh battery champion 31 days 2GB+32GB", "Mobile & Gadgets", "Xiaomi", "Mobile Phones", "Xiaomi Redmi 8A"),
  (UUID(), "P004", "Naelofar Sofis - Printed Square", "Hijab", "Naelofar", "Multi Colour Floral", "Ornate Iris flower composition with intricate growing foliage"),
  (UUID(), "P005", "Philips HR2051 / HR2056 / HR2059 Ice Crushing Blender Jar Mill", "Small Kitchen Appliances", "Philips", "Mixers & Blenders", "Philips HR2051 Blender (350W, 1.25L Plastic Jar, 4 stars stainless steel blade)"),
  (UUID(), "P006", "Gemei GM-6005 Rechargeable Trimmer Hair Cutter Machine", "Hair Styling Tools", "Gemei", "Trimmer", "The GEMEI hair clipper is intended for professional use."),
  (UUID(), "P007", "Oreo Crumb Small Crushed Cookie Pieces 454g", "Snacks", "Oreo", "Biscuits & Cookies", "Oreo Crumb Small Crushed Cookie Pieces 454g - Retail & Wholesale New Stock Long Expiry!!!"),
  (UUID(), "P008", "Non-contact Infrared Forehead Thermometer ABS", "Kids Health & Skincare", "No Brand", NULL, "Non-contact Infrared Forehead Thermometer ABS for Adults and Children with LCD Display Digital"),
  (UUID(), "P009", "Nordic Marble Starry Sky Bedding Sets", "Bedding", "No Brand", "Bedding Sheets", "Printing process: reactive printing. Package：quilt cover ,bed sheet ,pillow case. Not include comforter or quilt."),
  (UUID(), "P010", "Samsung Galaxy Tab A 10.1", "Mobile & Gadgets", "Samsung", "Tablets", "4GB RAM. - 64GB ROM. - 1.5 ghz Processor. - 10.1 inches LCD Display"),
  (UUID(), "P011", "REALME 5 PRO 6+128GB", "Mobile & Gadgets", "Realme", "Mobile Phones", "REALME 5 PRO 6+128GB"),
  (UUID(), "P012", "Nokia 2.3 - Cyan Green", "Mobile & Gadgets", "Nokia", "Mobile Phones", "Nokia smartphones get 2 years of software upgrades and 3 years of monthly security updates."),
  (UUID(), "P013", "AKEMI Cotton Select Fitted Bedsheet Set - Adore 730TC", "Bedding", "Akemi", "Bedding Sheets", "100% Cotton Twill. Super Single."),
  (UUID(), "P014", "Samsung Note10+ Phone", "Mobile & Gadgets", "OEM", "Mobile Phones", "OEM Phone Models"),
  (UUID(), "P015", "Keknis Basic Wide Long Shawl", "Hijab", "No Brand", "Plain Shawl", "1.8m X 0.7m (+/-). Heavy chiffon (120 gsm).");

insert into `user` (`username`, `password`, `role`) values
    ("user01", "$2a$10$TV2PZ2f0jF.E0S7JBZsJlO60rWJsVlahVVpaVxrtWYeGAdgt27M0m", "USER"),
    ("admin01", "$2a$10$qD0.FLgu0i1DHLNEoPl2GOrfIvCuZlpKr8dasDtG0em0.osT0vkEi", "ADMIN");


select * from products;
select * from `user`;

select * from audit_logs;

SET SQL_SAFE_UPDATES = 0;


-- Thay đổi kiểu dữ liệu cột nếu cần
-- ALTER TABLE products
-- MODIFY COLUMN id VARCHAR(36) NOT NULL;

-- Cập nhật dữ liệu với UUID mới
-- UPDATE products
-- SET id = UUID();

-- Thay đổi kiểu dữ liệu cột sang BINARY(16)
-- ALTER TABLE products
-- MODIFY COLUMN id BINARY(16) NOT NULL;

-- Chuyển đổi dữ liệu từ CHAR(36) sang BINARY(16)
-- UPDATE products
-- SET id = UNHEX(REPLACE(id, '-', ''));

