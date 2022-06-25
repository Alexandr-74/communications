# communications
Для запуска необходимо запустить базу данных postgres c сользователем postgres и паролем mysecretpassword на 5432 порту
для сборки проекта необходимо выпольнить задачу gradle build, после этого в папке build\libs появиться jar файл для запуска сервера, помимо этого программа 
запущена на сервере 217.197.116.107 в кластере докер контейнеров и по get-запросу http://217.197.116.107/communications может быть получен json-file с пользователями,а post-запросе http://217.197.116.107/communication отправлен json-файл для создания пользователей, пример файла:
Ссылка на postman: https://www.postman.com/dark-space-202478/workspace/communication-public/collection/15982067-cb038b59-d376-4928-82c3-046820ea4cf1?action=share&creator=15982067
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
В данном запросе в список контактов Masha и ALice добавятся друг к другу, при повторном запросе с добавлением еще одного пользователя он добавиться к обеим и получит Alice и Masha в свой список
