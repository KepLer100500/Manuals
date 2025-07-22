### Initializing
Generate ai token
```
https://cortecs.ai/userArea/userProfile
```

Generate telegram bot token
```
@BotFather
```
### Testing
Send http request with Curl
```
curl -X POST http://localhost:8083 \
-H "Content-Type: application/json; charset=utf-8" \
--data-binary @payload.json
```
payload.json
```
{
    "message": "Привет, как дела?"
}
```
