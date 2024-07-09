Firma

**Crear inmobiliario**
curl --location 'localhost:8080/v1/inmobiliaria' \
--header 'Content-Type: application/json' \
--data '{
    "reference":"ca-pe-2p",
    "descripcion":"Casa campestre 2 pisos",
    "location":"Cucuta NDS",
    "dimension":150,
    "type":"Casa",
    "status":"Disponible",
    "owner":"Juan Palacios",
    "dateBuilding":"01/01/2001",
    "project":"Zona Campo",
    "price":50000000
}'

**Consultar todos los inmobiliarios**
curl --location 'localhost:8080/v1/inmobiliaria/retrieve'

**Consultar inmobiliario por referencia**
curl --location 'localhost:8080/v1/inmobiliaria/reference/ca-pe-2p'

**Modificar inmobiliario**
curl --location --request PUT 'localhost:8080/v1/inmobiliaria' \
--header 'Content-Type: application/json' \
--data '{
    "reference":"ca-pe-2p",
    "descripcion":"Casa campestre 3 pisos",
    "location":"Cucuta NDS",
    "dimension":150,
    "type":"Casa",
    "status":"Disponible",
    "owner":"Juan Palacios",
    "dateBuilding":"01/01/2001",
    "project":"Zona Campo",
    "price":50000000
}'

**Eliminar inmobiliario**
curl --location --request DELETE 'localhost:8080/v1/inmobiliaria/reference/ca-pe-2p'
