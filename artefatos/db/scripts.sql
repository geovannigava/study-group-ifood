-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.3-beta
-- PostgreSQL version: 12.0
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: "ifood-spatial" | type: DATABASE --
-- -- DROP DATABASE IF EXISTS "ifood-spatial";
-- CREATE DATABASE "ifood-spatial";
-- -- ddl-end --
-- 

-- object: routes | type: SCHEMA --
-- DROP SCHEMA IF EXISTS routes CASCADE;
CREATE SCHEMA routes;
-- ddl-end --
ALTER SCHEMA routes OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,routes;
-- ddl-end --

-- object: postgis | type: EXTENSION --
-- DROP EXTENSION IF EXISTS postgis CASCADE;
CREATE EXTENSION postgis
WITH SCHEMA public;
-- ddl-end --

-- object: routes.geometry_demo | type: TABLE --
-- DROP TABLE IF EXISTS routes.geometry_demo CASCADE;
CREATE TABLE routes.geometry_demo (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START WITH 1 CACHE 1 ),
	geom geometry(GEOMETRY, 4674) NOT NULL,
	CONSTRAINT geometry_pk PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE routes.geometry_demo OWNER TO postgres;
-- ddl-end --


