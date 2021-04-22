# prueba-acciona

## Pasos para ejecutar:

1. Descargar el proyecto
2. Añadir las credenciales de la API de Twitter en el fichero **src/main/resources/twitter4j.properties**
3. En caso de querer sobre escribir las propiedades de consumo de Tweets por default y el numero de hashtag mas utilizados, las mismas se encuentran en el fichero **src/main/resources/application.properties** :
	```
	tweet.minimum.number.of.followers=
	tweet.languages.accepted=
	hashtag.top.n=
	```
4. Ejecutar el comando `mvn clean install`
5. Ejecutar el comando `mvn spring-boot:run`
6. Acceder a http://localhost:8080/swagger-ui.html#/

## Diseño de la solución:

- Para el consumo de tweets se utiliza el streaming provisto por la libreria twitter4j para tener un consumo constante en tiempo real de los tweets luego, en base a los criterios indicados en los requerimientos de la prueba, se filtran los tweets y se persisten en una base de datos en memoria. La logica de consumo de tweets se encuentra en las clases `ApplicationEventListener.java` y `TwitterListener.java`.
- Para los hashtags, una vez que se consume un tweet y el mismo pasa por los filtros se le extraen los hashtags y se guardan en una estructura en memoria, donde se va acumulando el numero de apariciones de los mismos para luego poder listarlos, esta lógica se encuentra en la clase `HashTagServiceImpl.java`
- Para la capa REST se detectan los siguientes recursos:
  - tweets
  	 Endpoints:
  	 ```
  	  GET /api/tweets
  	  
  	  Retorna todos los tweets almacenados.
  	 ```
  	 ```
  	  PATCH /api/tweets/{id}
  	  
  	  Modifica el atributo validated de un tweet para marcarlo o desmarcarlo como validado. 
  	  Se debe enviar en el body de la petición: 
  	  {
  		"validated": true/false
	  }
  	 ```
  - users
     Endpoints:
     ```
  	  GET /api/users/{user}/tweets?validated=true/false
  	  
  	  Retorna todos los tweets validados o no validados para un usuario. 
  	  Utilizar el request parameter validated a true para validados o a false para no validados. 
  	  El parametro {user} puede obtenerse de la respuesta del endpoint /api/tweets en el campo user.
  	 ```
  - hashtags
     Endpoints:
     ```
  	  GET /api/hashtags?topNLimit=
  	  
  	  Retorna la lista de los hashtags mas usados.
  	  Se puede enviar el request parameter topNLimit con un valor deseado para solicitar la cantidad de hashtags, si el valor no se envía se utilizara el default.
  	 ```
     