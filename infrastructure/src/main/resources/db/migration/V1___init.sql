CREATE TABLE IF NOT EXISTS characters (
id BIGSERIAL NOT NULL,
name VARCHAR(255),
status VARCHAR(255),
species VARCHAR(255),
type VARCHAR(255),
gender VARCHAR(255),
origin VARCHAR(255),
location VARCHAR(255),
image VARCHAR(255),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS locations (
id BIGSERIAL NOT NULL,
name VARCHAR(255),
type VARCHAR(255),
dimension VARCHAR(255),
url VARCHAR(255),
created VARCHAR(255),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS character_episodes (
characters_id BIGINT NOT NULL,
title VARCHAR(255),
episodes VARCHAR(255),
FOREIGN KEY (characters_id) REFERENCES character (id)
);

CREATE TABLE IF NOT EXISTS location_residents (
location_id BIGINT NOT NULL,
residents_id VARCHAR(255),
FOREIGN KEY (location_id) REFERENCES location (id),
FOREIGN KEY (residents_id) REFERENCES characters (id),
PRIMARY KEY (location_id, residents_id)
);