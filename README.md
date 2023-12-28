<h1 align="center"> TiendaGamer </h1>

> [!IMPORTANT]\
> El proyecto aún se encuentra en fase de desarrollo por lo que algunas funciones podrían no estar terminadas o presentar alguna falla.
> 
> El README también se encuentra en producción y mejora constante.


 >[!NOTE]\
> Por favor, visita el "Indice" que se encuentra a continuación para que te puedas orientar en la estructura y composición del README.md del proyecto y puedas conocer más de el y ver como poder acceder a el y hacerlo funcional.


# Indice:

- [Descripción](##Descripción)
- [Contenido](##Contenido)
- [Funciones](##Funciones)
- [Uso](##Uso)
- [Tecnologías usadas](##Tecnologias)
- [Requisitos](##Requisitos)
- [Descarga](##Descarga)
- [Postman](##Postman)

<h4 align="center">
:construction: Proyecto en construcción. Versión 1.0 lanzada :construction:
</h4>

## Descripción: 
**TiendaGamer** es una plataforma web destinada a la venta de artículos tecnológicos como consolas, videojuegos, tablets, periféricos, notebooks y tarjetas para canje digital. 

## Contenido:
La plataforma tiene varías áreas de interés como los videojuegos, plataformas, medios de pago, clientes y compras. El contenido del sistema esta asociado con cada una de ellas para que se puedan hacer consultar necesarias y llevar una correcta administración de cada una de ellas. 

## Funciones: 
* Visualización, busqueda, ingreso, modificación y eliminación de videojuegos.
* Visualización, busqueda, ingreso, modificación y eliminación de plataformas.
* Visualización, busqueda, ingreso, modificación y eliminación de medios de pago.
* Visualización, busqueda, ingreso, modificación y eliminación de clientes.
* Visualización, busqueda, ingreso, modificación y eliminación de compras.

## Uso:
De momento, **TiendaGamer** cuenta con varias áreas de interés tanto para los negocios como para los clientes. De esta forma, se pueden registrar clientes, ver y modificar sus datos o bien eliminarlos. Estos pueden comprar videojuegos, los cuáles deben estar previamente registrados en el sistema junto con su respectivo género y plataforma. También es importante que seleccione un tipo de pago, el cuál también es necesario que este ingresado en el sistema junto a la cantidad de cuotas en caso de tenerlas (por defecto, las cuotas pueden ser entre 1 y 18 pagos). 

### Detalles importantes:
#### Clientes: 
Los clientes deben tener nombre, apellido, mail y DNI de forma obligatoria para poder registrarse en el sistema. En el caso de nombre y apellido, la cantidad de letras queda limitada entre 2 y 24 caracteres. Se controla que el DNI sea entre 10.000.000 y 60.000.000 para que sea válido. Adicionalmente, se incluye un ID único y diferencial para cada cliente el cuál será un identificador al momento de busqueda junto con su DNI y nombre y apellido. Cabe destacar que también se ingresa la fecha de registro del cliente, junto con un Array o lista de compras realizadas por el cliente, las cuáles se podrán consultar en el momento de buscar y obtener todos los clientes o cada uno de manera individual en caso de consulta, lo cuál permite una visualización más completa del cliente y que puede dar lugar a análisis de estadísticas y preferencias y sugerencias para compras.

#### Medios de pago: 
Cada medio de pago tiene su propio ID identificador, junto con un nombre, el cuál puede ser repetido, es decir, pueden haber múltiples tarjetas de crédito del mismo o de diferente banco y con diferente cantidad de cuotas. Es importante mencionar que solo se pueden aplicar entre 1 y 18 cuotas para cada medio de pago. Otro rango fuera de esos valores no podrá ser ingresado y saltará error.

#### Plataformas:
La plataforma tiene un ID como identificar junto a un nombre de plataforma. El nombre de la plataforma no se puede repetir ya que no existen 2 consolas con el mismo nombre en la realidad, pero si pueden existir diferentes versiones de la misma. El nombre es de carácter obligatorio al momento de registro.

#### Juegos:
Los juegos tienen un ID como identificador, pero también cuentan con título, plataforma y fecha de lanzamiento como campos obligatorios a completar. La plataforma debe estar ingresada previamente en el sistema y se revisará que realmente exista en el. Adicionalmente, se puede ingresar un número entero como stock y un precio, no son campos de carácter obligatorio ya que los juegos podrían ser ingresados con fin de visualización o promoción de ellos en lugar de venta.

#### Compras: 
Las compras tienen un ID como identificar, junto con fecha de compra, juego (no es obligatorio ya que podría comprarse otro producto del negocio), y cliente y medio de pago de carácter obligatorio ya que todas las compras tienen un cliente y un medio de pago. Estos últimos 3 campos requieren de un registro previo tanto de un juego, como de un cliente y un medio de pago para que se válide su registro y pueda realizarse sin problemas.


## :hammer: Tecnologías usadas:
* Java versión 17.
* SpringBoot versión 3.2.0.
* Maven.
* IntelliJ.

## Requisitos: 
No hay requisitos para su uso, simplemente entender el funcionamiento del sistema, el cuál se encuentra detallado en este archivo, y la descarga del código en caso de ser necesario. 

Posteriormente, el proyecto será deployado para que se pueda ver su funcionamiento de forma interactiva.

## Descarga: 
Su descarga es sencilla, primero tenemos que ubicarnos en el inicio de este repositorio, es decir, estar en: https://github.com/Daniela2-1998/TiendaGamer. Luego visualizamos el botón verde que dice "Code", lo clickeamos y podemos elegir si descargarlo con GitHub (en caso de tener acceso) o bajarlo como un ZIP. Lo ideal es hacerlo como ZIP para no modificar ningún contenido de la plataforma y, de todas formas, seguir con acceso a todo el contenido ofrecido.

Todo el contenido necesario está incluido en el **POM.XML** creado a partir de SpringInitilizr (https://start.spring.io/) y con el uso de Maven para obtener otras dependencias necesarias para su uso, de todas formas, debajo podrás ver una lista entera de todas las depencias utilizadas:

```

<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>3.1.0</version>
		</dependency>
	</dependencies>


```
La configuración esta hecha en el **APPLICATION.PROPERTIES**, ubicado en la carpeta **resources** en el **main**:

```


server.port=8081

spring.datasource.url=jdbc:h2:mem:database
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true

#Configura la ruta de acceso a la consola h2 (/h2-console es la ruta por defecto.)
spring.h2.console.path=/h2-console

spring.jpa.defer-datasource-initialization=true


```


## Postman:
Postman nos permite realizar peticiones de una manera simple para testear APIs de tipo REST propias o de terceros, pero también tiene unas funcionalidades extras como las que podrás ver en la lista de abajo:
- Testear colecciones o catálogos de APIs tanto para Frontend como para Backend.
- Organizar en carpetas, funcionalidades y módulos los servicios web.
- Permite gestionar el ciclo de vida (conceptualización y definición, desarrollo, monitoreo y mantenimiento) de nuestra API.
- Generar documentación de nuestras APIs.
- Trabajar con entornos (calidad, desarrollo, producción) y de este modo es posible compartir a través de un entorno cloud la información con el resto del equipo involucrado en el desarrollo.

 >[!NOTE]\
> Si bien existen varios tipos de métodos disponibles para probar en POSTMAN, se han considerado 4 en particular en el controller:
>
>**GET:** obtener información.
>
>**POST:** agregar información.
>
>**PUT:** reemplazar la información.
>
>**PATCH:** actualizar alguna información.
>
>**DELETE:** borrar información.
>


```
GET ALL:

(/nombre del área de interés en plural)

CLIENTES: http://localhost:8081/clientes
PLATAFORMAS: http://localhost:8081/plataformas
MEDIOS DE PAGO: http://localhost:8081/mediosDePago
JUEGOS: http://localhost:8081/juegos
COMPRAS: http://localhost:8081/compras

```

```
GET BY ID:

(/número de ID)

CLIENTES: http://localhost:8081/clientes/1
PLATAFORMAS: http://localhost:8081/plataformas/1
MEDIOS DE PAGO: http://localhost:8081/mediosDePago/1
JUEGOS: http://localhost:8081/juegos/1
COMPRAS: http://localhost:8081/compras/1

```

```
POST:

(/nombre del área de interés en plural)

CLIENTES: http://localhost:8081/clientes
Ejemplo:
{
        "nombre": "Maria", 
        "apellido": "Suarez", 
        "mail": "mariasuarez1@gmail.com", 
        "dni": "40000002", 
        "fechaRegistro": "2023-12-10"
}


PLATAFORMAS: http://localhost:8081/plataformas
Ejemplo:
{
    "nombre": "Playstation 4"
}


MEDIOS DE PAGO: http://localhost:8081/mediosDePago
Ejemplo:
 {
    "medio": "Tarjeta de crédito Santander", 
    "cuotasDisponibles": 3
}


JUEGOS: http://localhost:8081/juegos
Ejemplo:
{
    "titulo": "Uncharted 2",
    "plataforma": {
        "idPlataforma": 1,
        "nombre": "Playstation 4"
    },
    "lanzamiento": "2010-12-10", 
    "stock": 200, 
    "precio": 20000.0
 }
 


COMPRAS: http://localhost:8081/compras
Ejemplo:
{
    "fechaCompra": "2023-12-24",
    "juegos": [
        {
            "idJuego": 1,
            "titulo": "Uncharted 2",
            "plataforma": {
                "idPlataforma": 1,
                "nombre": "Playstation 4"
            },
            "lanzamiento": "2010-12-10",
            "stock": 200,
            "precio": 20000.0
        },
        {
            "idJuego": 2,
            "titulo": "Uncharted 2",
            "plataforma": {
                "idPlataforma": 1,
                "nombre": "Playstation 4"
            },
            "lanzamiento": "2010-12-10",
            "stock": 200,
            "precio": 20000.0
        }
    ],
    "cliente": {
        "idCliente": 1,
        "nombre": "Maria",
        "apellido": "Suarez",
        "mail": "mariasuarez1@gmail.com",
        "dni": "40000002",
        "fechaRegistro": "2023-12-10"
    },
    "medioDePago": {
        "idMedioDePago": 1,
        "medio": "Tarjeta de crédito Santander",
        "cuotasDisponibles": 3
    }
}
```

```
PUT:

Se coloca el id correspondiente al área de interés y se modifica el campo que se desea modificar.
(/nombre del área de interés en plural)

CLIENTES: http://localhost:8081/clientes
PLATAFORMAS: http://localhost:8081/plataformas
MEDIOS DE PAGO: http://localhost:8081/mediosDePago
JUEGOS: http://localhost:8081/juegos
COMPRAS: http://localhost:8081/compras

```

```
DELETE:

(/número de ID)

CLIENTES: http://localhost:8081/clientes/1
PLATAFORMAS: http://localhost:8081/plataformas/1
MEDIOS DE PAGO: http://localhost:8081/mediosDePago/1
JUEGOS: http://localhost:8081/juegos/1
COMPRAS: http://localhost:8081/compras/1

```

```
