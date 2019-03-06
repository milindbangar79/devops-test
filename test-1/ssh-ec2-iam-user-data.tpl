#!/bin/bash -ex
exec > >(tee /var/log/user-data.log|logger -t user-data -s 2>/dev/console) 2>&1
echo "BEGIN USER-DATA"
# Install git
yum install -y git aws-cli

# Clone the git repo
cd /root

ssh-keyscan -H code.fresco.me >> ~/.ssh/known_hosts
git clone https://github.com/widdix/aws-ec2-ssh.git

cd /root/aws-ec2-ssh
sh install.sh -l "iam-synced-users" -i "${ user_group }" -s "${ root_user_group }"
${ additional_user_data }
