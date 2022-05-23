-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	"name" varchar(200) NOT NULL,
	CONSTRAINT category_pk PRIMARY KEY (id)
);

-- public.post definition

-- Drop table

-- DROP TABLE public.post;

CREATE TABLE public.post (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	title varchar(250) NULL,
	full_text varchar(250) NULL,
	category_id int4 NULL,
	CONSTRAINT post_pk PRIMARY KEY (id)
);


-- public.post foreign keys

ALTER TABLE public.post ADD CONSTRAINT post_fk FOREIGN KEY (category_id) REFERENCES public.category(id) ON DELETE CASCADE ON UPDATE CASCADE;

-- public."comment" definition

-- Drop table

-- DROP TABLE public."comment";

CREATE TABLE public."comment" (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	author varchar(200) NULL,
	message varchar(200) NULL,
	post_id int4 NULL,
	CONSTRAINT comment_pk PRIMARY KEY (id)
);


-- public."comment" foreign keys

ALTER TABLE public."comment" ADD CONSTRAINT comment_fk FOREIGN KEY (post_id) REFERENCES public.post(id) ON DELETE CASCADE ON UPDATE CASCADE;
