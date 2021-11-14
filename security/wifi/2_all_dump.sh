#!/bin/bash

dev=$1 # wlan1 - device
sudo airodump-ng --manufacturer --uptime --wps $dev
