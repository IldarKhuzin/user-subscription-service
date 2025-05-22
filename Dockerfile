# Используем официальный образ OpenJDK 17
FROM eclipse-temurin:17-jdk-alpine

# Копируем JAR-файл (указан путь как в Gradle)
COPY build/libs/user-subscription-service-0.0.1-SNAPSHOT.jar app.jar


# Устанавливаем локаль (опционально)
ENV LANG=C.UTF-8

# Запускаем Spring Boot приложение
ENTRYPOINT ["java", "-jar", "/app.jar"]
