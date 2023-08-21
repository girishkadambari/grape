Prod Align Config 

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
