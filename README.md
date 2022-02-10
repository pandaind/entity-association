


Start Mysql
-----------
docker run --name=mysql -p3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_HOST=% -d mysql/mysql-server:latest
