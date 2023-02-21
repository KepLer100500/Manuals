To use service:
- Start rest endpoint in 81 port
- curl -X POST http://localhost:83/payment -d '{"amount": 500}' -H "Content-Type: application/json" -o localhost.html ; cat localhost.html
