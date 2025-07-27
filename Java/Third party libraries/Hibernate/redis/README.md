## Run Redis:
```
docker-compose up -d
```
### UI:
```
http://192.168.162.144:8001/
```
```
login: default
pass:  admin
```
## Connect to database configuration in:
```
com.kepler.config.Config
```
## Usage:
#### Create tag
```
curl -X POST localhost:8079/api/v1/signal
```
#### Read tag
```
curl -X GET localhost:8079/api/v1/signal/5
```