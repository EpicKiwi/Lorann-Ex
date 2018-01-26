#!/bin/bash

docker run --name loranndb -i -p "3306:3306" -e "MYSQL_ROOT_PASSWORD=root" -e "MYSQL_DATABASE=lorann" -v "init-db:/docker-entrypoint-initdb.d" mysql