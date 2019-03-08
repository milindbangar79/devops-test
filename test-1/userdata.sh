#!/bin/sh
set -x
# output log of userdata to /var/log/user-data.log
exec > >(tee /var/log/user-data.log|logger -t user-data -s 2>/dev/console) 2>&1
sudo yum install -y httpd
sudo service httpd start
sudo chkonfig httpd on
echo "<html><h1>Hello from Three Tier Applicaion</h2></html>" > /var/www/html/index.html