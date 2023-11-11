## Software necesario

- JDK 21
- Docker

## Construir

```bash
./mvnw clean package -DskipTests=true
```

## Generar imagen Docker

- Windows

```bash
.\build.bat
```

- Linux

```bash
./build.sh
```

## Desplegar

```bash
cd build
docker compose up -d
```
