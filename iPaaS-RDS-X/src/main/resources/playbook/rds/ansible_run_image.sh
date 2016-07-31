cd $9 && /usr/bin/ansible-playbook -i ansible_ssh/$1.cfg   rdsimage.yml  --user=$2 --extra-vars "user=$2 ansible_ssh_pass=$3 host=$4 image=$5 port=$6 mysql_data_path=$7 mysql_home=$8"

