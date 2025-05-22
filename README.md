# User Subscription Service

Микросервис на Spring Boot 3 для управления пользователями и их подписками на цифровые сервисы.

## 📌 Стек технологий

- Java 17
- Spring Boot 3
- PostgreSQL
- Docker, Docker Compose
- SLF4J (логирование)

---

## 🚀 Функциональность

### Пользователи
- `POST /users` — создать пользователя
- `GET /users/{id}` — получить информацию о пользователе
- `PUT /users/{id}` — обновить данные пользователя
- `DELETE /users/{id}` — удалить пользователя

### Подписки
- `POST /users/{id}/subscriptions` — добавить подписку пользователю
- `GET /users/{id}/subscriptions` — получить подписки пользователя
- `DELETE /users/{id}/subscriptions/{sub_id}` — удалить подписку

### Аналитика
- `GET /subscriptions/top` — получить ТОП-3 популярных подписок

---

## 🛠 Запуск проекта

### Через Docker Compose

```bash
docker-compose up --build
