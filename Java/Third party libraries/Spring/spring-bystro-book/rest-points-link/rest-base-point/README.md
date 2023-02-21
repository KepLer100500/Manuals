
Started in 81 port.
Need parameters:
- in header: requestId
- in body request: {"amount": 500}

To test: 
curl -X POST http://localhost:81/payment -d '{"amount": 500}' -H "Content-Type: application/json" -H "requestId: 123" -o localhost.html ; cat localhost.html