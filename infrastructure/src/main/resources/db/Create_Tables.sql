CREATE TABLE IF NOT EXISTS character (
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

CREATE TABLE IF NOT EXISTS location (
id BIGSERIAL NOT NULL,
name VARCHAR(255),
type VARCHAR(255),
dimension VARCHAR(255),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS character_episodes (
character_id BIGINT NOT NULL,
episodes VARCHAR(255),
FOREIGN KEY (character_id) REFERENCES character (id)
);

CREATE TABLE IF NOT EXISTS location_residents (
location_id BIGINT NOT NULL,
residents VARCHAR(255),
FOREIGN KEY (location_id) REFERENCES location (id)
);