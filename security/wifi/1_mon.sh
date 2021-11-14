#!/bin/bash

dev=$1 # wlan1 - device
ip link set $dev down
iw $dev set monitor control
ip link set $dev up
