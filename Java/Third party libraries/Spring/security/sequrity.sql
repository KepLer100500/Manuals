CREATE TABLE IF NOT EXISTS "authorities" (
	"username" VARCHAR(50) NOT NULL,
	"authority" VARCHAR(100) NOT NULL,
	CONSTRAINT "FK__users" FOREIGN KEY ("username") REFERENCES "public"."users" ("username") ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO "authorities" ("username", "authority") VALUES
	('admin', 'ROLE_ADMINISTRATOR'),
	('moderator', 'ROLE_MODERATOR'),
	('user', 'ROLE_USER'),
	('admin', 'ROLE_MODERATOR'),
	('admin', 'ROLE_USER'),
	('moderator', 'ROLE_USER');

CREATE TABLE IF NOT EXISTS "users" (
	"username" VARCHAR(50) NOT NULL,
	"password" VARCHAR(100) NOT NULL,
	"enabled" SMALLINT NOT NULL,
	PRIMARY KEY ("username")
);

INSERT INTO "users" ("username", "password", "enabled") VALUES
	('user', '{bcrypt}$2a$12$PJVLkhGp23QkWLLsAzjxQe88IkyBy4uwXJDZQvx5tYcomwqTGRRr2', 1),
	('moderator', '{bcrypt}$2a$12$Pdpv8QwNY77jRjQ3Picuge8KFuvgg.ZEtbYpsumemlRzpsDgSDOfa', 1),
	('admin', '{bcrypt}$2a$12$B7e6b.2yCvVYK0TXlevbwu35TJIxS3uVYOnF3lESlWM0mHeocm626', 1);
