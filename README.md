# Employee API - Backend Test

Para ejecutar la API con docker, siga los siguientes pasos:

1. Generar el archivo .jar.
```sh
$ .\mvnw clean package -DskipTests
```
2. Crear la imagen del poryecto para docker.
```sh
$ docker build -t employee-api:1.0.0 .
```
3. Ejecutamos el docker compose para correr las imágenes en un contenerdor.
```sh
$ docker compose up -d
```

# Nota
Los comandos anteriores se deben ejecutar en la raíz del proyecto.