To use service:
- Start rest endpoint in 81 port
- curl -X POST http://localhost:82/payment -d '{"amount": 200}' -H "Content-Type: application/json" -o localhost.html ; cat localhost.html