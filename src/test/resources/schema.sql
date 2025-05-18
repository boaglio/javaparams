DROP TABLE IF EXISTS jp_vote;
DROP TABLE IF EXISTS jp_user;
DROP TABLE IF EXISTS jp_parameter;

CREATE TABLE jp_parameter (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    total_likes BIGINT
);

CREATE TABLE jp_user (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    last_login TIMESTAMP
);

CREATE TABLE jp_vote (
    id BIGINT PRIMARY KEY,
    parameter_id BIGINT,
    user_id VARCHAR(255),
    liked BOOLEAN,
    CONSTRAINT fk_vote_parameter FOREIGN KEY (parameter_id) REFERENCES jp_parameter(id),
    CONSTRAINT fk_vote_user FOREIGN KEY (user_id) REFERENCES jp_user(id)
);
