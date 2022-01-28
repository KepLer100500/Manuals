#!/bin/bash

new_password="bacula"

for i in bacula-dir.conf bacula-sd.conf bacula-fd.conf bconsole.conf
	do
		echo "Passwords in file $i:"
		grep -Po '(?<=Password = ").*(?=")' $i
		echo "Will be replaced by -> $new_password"
		sed -i "s/Password = .*/Password = \"$new_password\"/g" $i
	done
