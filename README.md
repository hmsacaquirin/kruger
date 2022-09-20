# Crear una base, usuario y contraseña para conexion a postgresql 

Con estos datos parametrizar en el archivo application.properties en las secciones

spring.datasource.url=jdbc:postgresql://localhost:5432/kruger   
spring.datasource.username=el usuario creado     
spring.datasource.password=la clave creada   

## Ejecutar la aplicacion 

Al ejecutarse la aplicacion se podra acceder por la siguiente url http://localhost:8080/    
Si queremos ver la documentacion de las apis desplegadas vamos a swagger http://localhost:8080/swagger-ui/index.html#/  

## Autentificacion para cada json

Para consumir cada api debemos de generar el token de austorizacion esto con OAuth 2.0 ejecutamos la siguiente url en postman http://localhost:8080/oauth/token     
Autorization    
Type Basic Auth 
Username hugo   
Password 123abc..   
grant_type client_credentials   
Luego para cada api agregamos el token generado en los headers      
Bearer da56d925-e100-4488-a7e7-226c11cc074a     
Para el administrador solo utiliza urls con /admin      
## Base de datos

Se crear 3 tablas:     
person  
usuario     
empleado    
Para la tabla persona contiene la informacion basica como cedula, nombres ademas despues de dar alta en esta tabla se genera el usuario y contraseña en la tabla usuario, en la tabla empleado se completa los datos de vacunacion cuando una persona ingresa al sistema        

## Colecction de objetos enviados

kruger.postman_collection.json      
modelodatos.png     


