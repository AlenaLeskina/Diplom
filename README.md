# Diplom

### Инструкция подключения БД и включения SUT
1. С помощью команды `git clone` осуществить клонирование репозитория по ссылке `https://github.com/AlenaLeskina/Diplom.git`.
2. Открыть с клонированный проект в Intellij IDEA.
3. Для запуска контейнеров ввести в терминале Intellij IDEA команду `docker-compose up -d`.
4. Запустить SUT командой:
- `java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar` - на БД mysql.
- `java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar` - на БД postgresql.

Запуск успешен при наличии в логах сообщений `Tomcat started on port(s): 8080 (http) with context path ''` и `Started ShopApplication in ... seconds (JVM running for ...)`

5. Войти в браузер `Google Chrome` и ввести ссылку `http://localhost:8080`.
6. При необходимости отключения SUT, находясь в терминале Intellij IDEA, нажать клавиши `CTRL+C`.
7. При необходимости отключения контейнеров ввести в терминале Intellij IDEA команду `docker-compose down`.

### Инструкция для запуска автотестов и получения отчета с помощью Allure
1. Выполнить шаги 1-4 Инструкции подключения БД и включения SUT
2. В терминале ввести команду `./gradlew test`
3. Ввести команду `./gradlew allureReport` (выполняется при первом запуске)
4. Для открытия отчета в браузере автоматически выполнить команду `./gradlew allureServe`