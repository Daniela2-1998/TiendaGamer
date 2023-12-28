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
- [Postman](##Postman)

<h4 align="center">
:construction: Proyecto en construcción. Versión 1.0 lanzada :construction:
</h4>

## Descripción: 
TiendaGamer es una plataforma web destinada a la venta de artículos tecnológicos como consolas, videojuegos, tablets, periféricos, notebooks y tarjetas para canje digital. 

## Contenido:

## Funciones: 
* Visualización, busqueda, ingreso, modificación y eliminación de videojuegos.
* Visualización, busqueda, ingreso, modificación y eliminación de plataformas.
* Visualización, busqueda, ingreso, modificación y eliminación de medios de pago.
* Visualización, busqueda, ingreso, modificación y eliminación de clientes.
* Visualización, busqueda, ingreso, modificación y eliminación de compras.

## Uso:

## :hammer: Tecnologías usadas:
* Java versión 17.
* SpringBoot versión 3.2.0.
* Maven.
* IntelliJ.

## Requisitos: 


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
>GET: obtener información.
>
>POST: agregar información.
>
>PUT: reemplazar la información.
>
>PATCH: actualizar alguna información.
>
>DELETE: borrar información.
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
