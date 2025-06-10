API:

- Get all accounts:
```
curl -X GET http://localhost:85/api/accounts/get
```
- Create account:
```
curl -X POST "http://localhost:85/api/accounts/create" --data-urlencode "owner=user1" --data-urlencode "balance=500"
```
- Transfer money:
```
curl -X POST "http://localhost:85/api/accounts/transfer" --data-urlencode "fromId=1" --data-urlencode "toId=2" --data-urlencode "balance=500"
```

Web interface:
```
http://localhost:85/
```