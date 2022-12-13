## Quest-project

#### Ссылка на web приложение: https://quest-vy5z.onrender.com/login.jsp

> Логика работы приложения:
> * После запуска приложения, пользователю будет предложено указать имя
> * Пользователю задается вопрос и 2 варианта ответа на выбор. В зависимости от выбранного ответа, предоставляется следующий вопрос.
> * В конечном результате пользователю выдается информация о победе или поражении, с возможностью рестарта.
* Приложение работет на web сервере tomcat с ипользованием JavaServlet
* Логи сохраняются в консоль и записываются в файл: "appLog.log". 
* Файл логирования генерируется автоматически, выделено памяти: 500KB. После переполнения, будет создан новый файл той же емкости.
* Максимальное кол-во файлов 10. Параметры задаются в файле: log4j2.xml
![applicationLog](https://i.imgur.com/ejUWtZH.png)
------------------------------------
* Для создания и сборки проекта использовались следующие технологии: 
Maven, JavaServlets, log4j2, Bootstrap, jsp/jstl, Tomcat, JUnit, jquery, Docker, Render