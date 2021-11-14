#!/bin/bash

dev=$1   # wlan1 - device
c=$2     # 7 - channel
bssid=$3 # 00:11:22:33:44:55 - BSSID (MAC)
file=$4  # SSID_NAME

sudo airodump-ng -c $c --bssid $bssid -w $file $dev
