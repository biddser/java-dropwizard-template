FROM dockerfile/java:oracle-java8
ADD ./target/java-dropwizard-template-1.0-SNAPSHOT.jar /opt/app.jar
ADD default.yml /opt/config/default.yml
EXPOSE 3003

CMD java -Ddw.database.url="jdbc:postgresql://db:10000/postgres" -jar /opt/app.jar server /opt/config/local.yml

