# Endpoints de la api

## autenticación (la ruta servira como ejemplo. No es la ruta final)

- ruta base: <http://localhost:8080>

/login -> Metodo POST y acepta un json con estos campos:
{
    "username":"string",
    "password":"string"
}

si la contraseña es correcta obtendras un resultado de codigo 200 con estos campos:
{
    "role": "[ROLE_ADMIN]",
    "message": "Inicio de sesion exitoso Martin Romero_bc875e",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYXJ0aW4gUm9tZXJvX2JjODc1ZSIsImV4cCI6MTc2MjIxMDIyMCwiaWF0IjoxNzYyMTgwMjIwLCJhdXRob3JpdGllcyI6Ilt7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU5cIn1dIn0.XNkmASDw_gUa0ITaywS1HoOaKDrsm4mIwo4o1kwX_xE",
    "username": "Martin Romero_bc875e"
}

de lo contrario un resultado de codigo 401 con estos campos:
{
    "message": "error en la autenticacion. username o password incorrecto",
    "error": "Bad credentials"
}

## usuarios

- ruta base: <http://localhost:8080>

/api/users -> metodo GET:
[
    {
        "name": "Pedro Santos",
        "email": "pedro.santos@gmail.com",
        "phone": "964041728",
        "role": "ROLE_ADMIN",
        "available": true
    },
    {
        "name": "Ana Torres",
        "email": "ana.torres@gmail.com",
        "phone": "964041723",
        "role": "ROLE_MEDIC",
        "available": true
    },
    {
        "name": "Valentina Rios",
        "email": "valentina.rios@gmail.com",
        "phone": "964041727",
        "role": "ROLE_RECEPTIONIST",
        "available": true
    }
]

tambien puedes filtrar por parametros como:
/api/users?id=1 para filtrar por roles o /api/users?availability=true para filtrar por disponibilidad

en conjunto se veria asi: /api/users?id=1&availability=true

/api/users -> metodo POST y acepta un json con estos valores:
{
    "name":"string",
    "lastname":"string",
    "email":"string",
    "phone":"string",
    "role":{
        "id":number,
        "name":"string"
    },
    "password":"string"
}
