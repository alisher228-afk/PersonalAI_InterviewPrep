# Personal AI Interview Prep

Backend-сервис для подготовки к техническим интервью с AI-оценкой ответов на основе Google Gemini.

## Стек

- **Java 17**
- **Spring Boot 3.5**
- **PostgreSQL** (Docker)
- **Liquibase** — управление миграциями БД
- **MapStruct** — маппинг Entity ↔ DTO
- **Google Gemini API** — AI-оценка ответов
- **WebFlux (WebClient)** — HTTP-клиент для Gemini API

## Структура данных

```
Topic (тема)
  └── Question (вопрос)
        └── Answer (ответ + AI-оценка)
```

- **Topic** — тема для подготовки (например, "Spring Boot", "SQL Joins")
- **Question** — вопрос внутри темы с уровнем сложности (EASY / MEDIUM / HARD)
- **Answer** — ответ пользователя, после сохранения автоматически оценивается Gemini (score 1–10 + feedback)

## Запуск

### 1. Запустить PostgreSQL через Docker

```bash
docker run --name personal_ai \
  -p 5437:5432 \
  -e POSTGRES_PASSWORD=12345 \
  -e POSTGRES_DB=personal_ai \
  -d postgres
```

### 2. Установить переменную окружения для Gemini API

**Windows (PowerShell):**
```powershell
[System.Environment]::SetEnvironmentVariable("GEMINI_API_KEY", "your_api_key", "User")
```

**Linux / macOS:**
```bash
export GEMINI_API_KEY=your_api_key
```

Получить API ключ: [aistudio.google.com](https://aistudio.google.com)

### 3. Настроить application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5437/personal_ai
spring.datasource.username=postgres
spring.datasource.password=12345

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.yaml

gemini.api-key=${GEMINI_API_KEY}
```

### 4. Запустить приложение

```bash
mvn spring-boot:run
```

Liquibase автоматически создаст все таблицы при первом запуске.

## API Endpoints

### Topics

| Метод | URL | Описание |
|-------|-----|----------|
| POST | `/api/topics/create` | Создать тему |
| GET | `/api/topics?page=0&size=10` | Список тем (с пагинацией) |
| GET | `/api/topics/{id}` | Получить тему по id |
| PUT | `/api/topics/{id}` | Обновить тему |
| DELETE | `/api/topics/{id}` | Удалить тему |

### Questions

| Метод | URL | Описание |
|-------|-----|----------|
| POST | `/api/topics/{topicId}/questions` | Создать вопрос в теме |
| GET | `/api/topics/{topicId}/questions` | Список вопросов по теме |
| GET | `/api/questions/{id}` | Получить вопрос по id |
| PUT | `/api/questions/{id}` | Обновить вопрос |
| DELETE | `/api/questions/{id}` | Удалить вопрос |

### Answers

| Метод | URL | Описание |
|-------|-----|----------|
| POST | `/api/questions/{questionId}/answers` | Создать ответ (+ AI-оценка) |
| GET | `/api/questions/{questionId}/answers` | Список ответов на вопрос |
| GET | `/api/answers/{id}` | Получить ответ по id |
| DELETE | `/api/answers/{id}` | Удалить ответ |

## Примеры запросов

### Создать тему
```json
POST /api/topics/create
{
  "name": "Spring Boot",
  "description": "Основы Spring Boot фреймворка"
}
```

### Создать вопрос
```json
POST /api/topics/1/questions
{
  "text": "Что такое IoC контейнер?",
  "difficulty": "MEDIUM"
}
```

### Создать ответ (AI оценит автоматически)
```json
POST /api/questions/1/answers
{
  "answerText": "IoC (Inversion of Control) — это принцип..."
}
```

Ответ будет содержать `aiScore` (1–10) и `aiFeedback` от Gemini.

## Обработка ошибок

| Статус | Ситуация |
|--------|----------|
| 400 | Невалидные данные (пустые поля) |
| 404 | Ресурс не найден |
| 409 | Конфликт (дублирующееся имя темы) |
| 500 | Внутренняя ошибка сервера |

## Планы по развитию

- [ ] Аутентификация и авторизация (Spring Security + JWT)
- [ ] Привязка тем и ответов к пользователю
- [ ] Аналитика прогресса (средний score по теме, динамика)
- [ ] Swagger / OpenAPI документация
- [ ] Unit и интеграционные тесты (Testcontainers)
- [ ] Docker Compose для запуска всего стека одной командой
