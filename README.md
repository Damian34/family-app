Family SPRING BOOT REST Api
====================

it is simple api to store some data like family by names and its members

The api is using libraries:\
Spring Web\
Spring Data JPA\
Flyway\
Postgres\
Thymeleaf <-- only to call custom error page\
Junit5\
etc.

the api can runs with docker,\
i personally use intellij docker plugin that allow me in docker-composer.yml eg.
to smoothly let me run only postgres image
on which can run api locally, but then needs to uncomment accesses to db in application.yml file or add env.
