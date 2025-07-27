## Install:

### Start docker containers:

```
docker-compose up -d
```

### Database configs:

- DataSourceConfig
- application.properties

## Usage:

### Adding user:

```
curl -X POST http://localhost:8092/users \
     -H "Content-Type: application/json" \
     -d '{"username":"john_doe","email":"john@example.com"}'
```

### Getting user:

```
curl -X GET http://localhost:8092/users/1
```
