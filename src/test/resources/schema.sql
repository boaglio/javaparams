DROP TABLE IF EXISTS jp_vote;
DROP TABLE IF EXISTS jp_parameter;
DROP SEQUENCE IF EXISTS seq_jp_vote;

CREATE SEQUENCE seq_jp_vote;

CREATE TABLE jp_parameter (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    total_likes BIGINT
);

CREATE TABLE jp_vote (
    id BIGINT PRIMARY KEY,
    parameter_id BIGINT,
    username VARCHAR(255),
    voted_at TIMESTAMP,
    CONSTRAINT fk_vote_parameter FOREIGN KEY (parameter_id) REFERENCES jp_parameter(id)
);
