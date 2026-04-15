FROM alpine:3.20

# Installation dépendances
RUN apk update && apk upgrade
RUN apk add git
RUN apk add maven
RUN apk add openjdk21

# Variables maven
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH=$JAVA_HOME/bin:$PATH

# Récupérer le repo
WORKDIR /app
COPY . .

# Compile
WORKDIR /app/numja/
RUN mvn clean package -DskipTests

CMD ["java", "-cp", "target/numja-1.0-SNAPSHOT.jar", "fr.uga.numja.Demo"]
