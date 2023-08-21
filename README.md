
# Grape 




## 🔗 Clone Repos
      - https://github.com/girishkadambari/grape.git
      - https://github.com/girishkadambari/orange.git
      



    
## Configure  Hosts
Add Prod Align Config file in httpd

```bash
RewriteEngine On
RewriteCond %{HTTP_HOST} "dev-grape.prodalign.com"
RewriteCond %{REQUEST_URI} "^/ui/"
RewriteRule .* http://localhost:9000%{REQUEST_URI} [P]   

RewriteCond %{HTTP_HOST} "dev-grape.prodalign.com"
RewriteCond %{REQUEST_URI} "^/static/"
RewriteRule .* http://localhost:9000%{REQUEST_URI} [P]   

RewriteCond %{HTTP_HOST} "dev-grape.prodalign.com"
RewriteCond %{REQUEST_URI} "^/locales/"
RewriteRule .* http://localhost:9000%{REQUEST_URI} [P]     


RewriteCond %{HTTP_HOST} "dev-grape.prodalign.com"
RewriteRule .* http://localhost:9091%{REQUEST_URI} [P]

```
## Add Hosts in hosts file 
Add **127.0.0.1 dev-grape.prodalign.com** to /etc/hosts file



```bash
##
# Host Database
#
# localhost is used to configure the loopback interface
# when the system is booting.  Do not change this entry.
##

127.0.0.1 dev-grape.prodalign.com
127.0.0.1 localhost
255.255.255.255    broadcasthost
::1             localhost
# Added by Docker Desktop
# To allow the same kube context to work on the host and the container:
127.0.0.1 kubernetes.docker.internal
# End of section
```

## Mysql

Create Database
```bash
  CREATE DATABASE grape
```


## Jarvis

Clone the project

```bash
  https://github.com/girishkadambari/grape.git
```
```bash
   start the server
  ```



## Red-Snapper

Clone the project

```bash
   https://github.com/girishkadambari/orange.git
```

Go to the project directory

```bash
  cd orange
```

Install dependencies

```bash
  npm install
```

Start the server

```bash
  npm run start
```

