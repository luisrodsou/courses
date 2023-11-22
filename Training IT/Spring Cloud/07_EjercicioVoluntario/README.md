## Software necesario

- JDK 21
- Docker

## Construir

```bash
mvn -f config-server/pom.xml clean package -DskipTests=true
mvn -f eureka-server/pom.xmlclean package -DskipTests=true
mvn -f hotel-ms/pom.xml clean package -DskipTests=true
mvn -f flight-ms/pom.xml clean package -DskipTests=true
mvn -f booking-ms/pom.xml clean package -DskipTests=true
mvn -f gateway-server/pom.xml clean package -DskipTests=true
```

## Generar imágenes Docker

```bash
docker compose build
```

## Desplegar contenedores Docker

```bash
docker compose up -d --scale flight-ms=2
```

## Enlaces de interés

- Cliente front: web/newbooking.html
- Cliente MySQL: http://localhost:8001
- Cliente Kafka: http://localhost:8002
