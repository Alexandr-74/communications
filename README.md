# communications
Для запуска необходимо запустить базу данных postgres c сользователем postgres и паролем mysecretpassword на 5432 порту
для сборки проекта необходимо выпольнить задачу gradle build, после этого в папке build\libs появиться jar файл для запуска сервера, помимо этого программа 
запущена на сервере 217.197.116.107 в кластере докер контейнеров и по get-запросу http://217.197.116.107/communications может быть получен json-file с пользователями,
а post-запросу http://217.197.116.107/communication отправлен json-файл для создания пользователей, пример файла:
{
    "users" : [
        {
            "userName" : "Alice"
        },
        {
            "userName":"Masha"
        }
    ]
}
