```
mvn clean package
```

```
docker build -t app-vaadin-test .
```

```
docker-compose up -d
```

```
docker logs vaadin-test_app-vaadin-test_1 --follow
```
---
Web interface
```
http://192.168.0.104:8089
```

```
http://192.168.0.104:8089/actuator
```

```
http://192.168.0.104:8089/actuator/prometheus
```
API
```
curl -X POST http://192.168.0.104:8089/api/v1
```
```
curl -X GET http://192.168.0.104:8089/api/v1
```
Prometheus
```
http://192.168.0.104:9090
```
Custom metric
```
kepler_custom_metric_total
```

Grafana
```
http://192.168.0.104:3000
```
