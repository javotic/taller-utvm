FROM postgres:16-alpine

ENV POSTGRES_USER=admin_db
ENV POSTGRES_PASSWORD=password_seguro
ENV POSTGRES_DB=mi_negocio_db

EXPOSE 5432