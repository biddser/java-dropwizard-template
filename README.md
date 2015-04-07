# java-dropwizard-template
A simple Java DropWizard application template for IntelliJ IDEA with support for:

- Dropwizard
- Postgres
- Liquibase
- Maven building
- Docker Containers
- Vagrant 

Example classes, pojo's (Plain old Java Objects), and source code have been included in this project in addition to some example unit tests to illustrate project structure 
and how the build process works.

When performing a maven compile, this project also performs a Cobertura code-coverage check and it will fail the build if the coverage is below 80%

This can be disabled by adjusting the code coverage percentage in the variable called "code_coverage_percentage" located in the pom.xml file to zero or your choosen value.

The Dockerfile will launch the compiled application inside a Docker container within a Linux based environment.

The Vagrant provisioning will launch the application inside a Vagrant Machine using Virtualbox.
