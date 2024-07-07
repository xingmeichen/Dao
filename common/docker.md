# Docker
Note: 
1. 下文中的 image_name 也就是 docker images 中的 REPOSITORY 列
2. Docker 的三个基本概念，仓库Registry, 镜像Image, 容器Container, 
   仓库是保存镜像的地方
   容器是镜像运行时的实体，容器与镜像的关系类似于对象与类的关系
   

## Registry 仓库
仓库是保存镜像的地方，可以看作是代码控制中心（类比github）

## Image 镜像
### 查找镜像
docker search {image_name}
eg.
docker search ubuntu

### 查看有哪些镜像
docker images

### 从仓库拉取镜像
docker pull {image_name}
eg. 
docker pull ubuntu

### 从仓库拉取指定版本的镜像
docker pull {image_name}:{image_version}
eg.
docker pull ubuntu:15.10

### 从仓库拉取最新版本的镜像
docker pull {image_name}:latest
eg.
docker pull ubuntu:latest

## Container 容器

### docker ps
查看正在运行的容器

### docker ps -a
查看所有的容器

### 用镜像启动一个容器, 容器还不存在则会创建一个容器
docker run {image_name}
eg. 
docker run -i -t ubuntu /bin/bash
-i: 允许对容器内对标准输入进行交互
-t: 在新容器内指定一个伪终端或终端

### 启动容器
docker start {container_id}
eg. 
docker start 9da42507270b
已经停止的容器，可以通过start命令启动

### 停止一个容器
docker stop {container_id}

### 重启容器
docker restart {container_id}
正在运行的容器，可以用restart命令来重启

### 进入容器
当使用-d参数启动容器的时候，容器启动后会进入后台，如果想要进入容器可以通过如下命令进入
1. docker attach {container_id}
Note：通过这个命令进入容器之后，如果从容器退出，会导致容器的停止

2. docker exec -it {container_id} /bin/bash
Note: 通过这个命令进入容器之后，如果从这个容器退出，容器不会停止，所以推荐该方式

### 删除容器
docker rm -f {container_id}

### 清理所有处于终止状态的容器
docker container prune






