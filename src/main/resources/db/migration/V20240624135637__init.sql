CREATE TABLE `users` (
    `id` int AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(255),
    `phone` VARCHAR(255),
    `nickname` VARCHAR(255),
    `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);

CREATE TABLE `orders` (
    `oid` int AUTO_INCREMENT NOT NULL,
    `uid` VARCHAR(255),
    `pid` VARCHAR(255),
    `product_name` VARCHAR(255),
    `price` DECIMAL(19, 2),
    `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`oid`)
);

CREATE TABLE `products` (
    `id` int AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(255),
    `price` VARCHAR(255),
    `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);