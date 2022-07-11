# Added Initial Setup

## Dependencies Added
- Lombok 
- MySql Driver 
- Spring Data Jpa 
- Spring Web 
- Flyway Core 
- Flyway Mysql 
- Log4J2
- Keycloak Adapter
- Keycloak Starter
- H2 Database


## Added packages
- Controllers 
- Exceptions 
- Models 
- Repositories 
- Services

### Flyway Integration
- Flyway is an open-source database migration tool. It strongly favors simplicity and convention over configuration.It is based around just 7 basic commands: Migrate, Clean, Info, Validate, Undo, Baseline and Repair.
. Flyway is an open-source database migration tool. It strongly favors simplicity and convention over configuration.It is based around just 7 basic commands: Migrate, Clean, Info, Validate, Undo, Baseline and Repair.
 the classpath of the directory is db/migration

# Keycloak Integration - Embedded Server
The standalone operating mode is only useful when you want to run one, and only one Keycloak server instance. This mode is really only useful to test drive and play with the features of Keycloak

To boot the server:

Linux/Mac

> $ .../bin/standalone.sh

Windows

> ...\bin\standalone.bat

## Installing and booting Keycloak from server distribution:

- Download the Keycloak Server from the official website. I'm using the latest release of the standalone server distribution

- Let's extract the folder from the zip (or tar) archive: it contains all we need to run the Keycloak server.

- From the bin/ directory of the Keycloak distribution, we can boot the Keycloak server by running either the standalone.sh script (macOS and Linux) or the standalone.bat file (Windows).


- By default, the Keycloak server will be reachable on the 8080 port. We could set custom port by setting optional param while starting keycloak server “jboss.socket.binding.port-offset“


## Run Keycloak with persisting data:

Run Keycloak using Docker compose file
```
    docker-compose -f docker-compose-keycloak.yml up -d 
```
- Keycloak will be available on http://localhost:8081/
- Create a realm `myrealm` and client `myclient`
- Create a user and add necessary roles
- [Reference](https://medium.com/@max.mayr/keycloak-and-spring-boot-security-b069306b0fb0)
##Installing and booting Keycloak as a Docker container:

- We can also run Keycloak in a Docker container, relying on the official Docker image.

- From a Terminal window, you can run a Keycloak Docker container with the following command.


> docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=password -p 8080:8080 --name keycloak-server -d jboss/keycloak:10.0.1

##Setting up RDBMS for Keycloak is simpler in a docker container, it can be configured while docker-compose:
Save the following snippet as yml file and run using docker-compose
Note: docker-compose -f <Name of File>.yml up
> Follow the link for the file  
> https://medium.com/@max.mayr/keycloak-and-spring-boot-security-b069306b0fb0
