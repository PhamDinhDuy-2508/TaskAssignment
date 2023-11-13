FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=25082000 
ENV MYSQL_USER=PHAMDINHDUY
ENV MYSQL_PASSWORD=25082000
ENV MYSQL_DATABASE=TASK 

COPY task_user.sql /docker-entrypoint-initdb.d/
COPY task_role.sql /docker-entrypoint-initdb.d/
COPY task_task.sql /docker-entrypoint-initdb.d/

EXPOSE 3307