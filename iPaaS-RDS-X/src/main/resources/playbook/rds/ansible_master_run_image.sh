cd $0 && /usr/bin/ansible-playbook -i ansible_ssh/$1.cfg   rdsimage_master.yml  --user=$2 --extra-vars "user=$2 ansible_ssh_pass=$3 host=$4 image=$5 port=$6 mysql_data_path=$7 mysql_home=$8 mysql_volumn_path=$9 container_name=$10 db_server_id=$11 container_storage=$12 mysql_type=$13"

