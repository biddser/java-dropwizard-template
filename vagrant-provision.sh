#!/usr/bin/env bash
#!/bin/sh
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 36A1D7869245C8950F966E92D8576A8BA88D21E9
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys B70731143DD9F856
sudo sh -c "echo deb https://get.docker.com/ubuntu docker main\
> /etc/apt/sources.list.d/docker.list"
sudo sh -c "echo deb http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main\
> /etc/apt/sources.list.d/natecarlson.list"
sudo add-apt-repository -y ppa:webupd8team/java
echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
curl -s https://deb.nodesource.com/gpgkey/nodesource.gpg.key | sudo apt-key add -

sudo sh -c "echo deb https://deb.nodesource.com/node trusty main\
> /etc/apt/sources.list.d/nodesource.list"

sudo apt-get update
sudo apt-get install -y build-essential lxc-docker python-pip oracle-java8-installer maven3 nodejs

sudo pip install fig

sudo sh -c "echo \
127.0.0.1	docker \
>> /etc/hosts"


# Set up environment variables, adding the new tools to PATH.
sudo sh -c "cat >> /etc/default/docker" <<'EOF'

DOCKER_OPTS="-H tcp://127.0.0.1:4243 -H unix:///var/run/docker.sock"
EOF

sudo sh -c "cat > /etc/profile.d/devenv.sh" <<'EOF'
export DOCKER_HOST=tcp://localhost:4243

cd /vagrant
EOF

sudo sh -c "sudo service docker restart"
