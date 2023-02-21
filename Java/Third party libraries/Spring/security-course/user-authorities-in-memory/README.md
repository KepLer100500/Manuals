Try to get records unauthenticated user: result -> access deny

`curl -X GET http://localhost/api/v1/developers -v`

Get records authenticated user: result -> access granted

`curl -X GET http://localhost/api/v1/developers -u "user:user"`

`curl -X GET http://localhost/api/v1/developers -u "admin:admin"`

Try to create record user without role ADMIN: result -> access deny

`curl -X POST http://localhost/api/v1/developers -v -u "user:user" -d '{"id":5,"name":"Fedor","language":"SQL"}' -H "Content-Type: application/json"`

Try to create record with role ADMIN: result -> access granted

`curl -X POST http://localhost/api/v1/developers -u "admin:admin" -d '{"id":5,"name":"Fedor","language":"SQL"}' -H "Content-Type: application/json"`

Try to remove record with role ADMIN: result -> access granted

`curl -X DELETE http://localhost/api/v1/developers/5 -u "admin:admin"`
