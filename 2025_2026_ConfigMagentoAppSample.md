## Web GUI Automation Testing

How to configure to use the MagentoApp Application Sample

## CASE 1. Use the application installed at the UBB servers (only while in CREIC or FSEGA)

Step 1. Configure and edit the file hosts

The file in Windows

c:\Windows\System32\Drivers\etc\hosts

Add the following lines:

172.30.244.131 qa1.dev.evozon.com

172.30.244.131 qa2.dev.evozon.com

172.30.244.131 qa3.dev.evozon.com

Step 2. Access the application in Chrome (while connected to Mateinfo internet)

[http://172.30.244.131:80](http://172.30.244.131/)


## CASE 2. Install the application on your computer.

## Step1 - Install docker desktop

[a. Download https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)

Install Docker Desktop on Windows

- [b. https://docs.docker.com/docker-for-windows/install-windows-home/](https://docs.docker.com/docker-for-windows/install-windows-home/)

## Install Docker Desktop on Windows

1. Double-click Docker Desktop Installer.exe to run the installer. If haven't already downloaded the installer ( Docker Desktop Installer.exe ), you can get it from Docker Hub. It typically you

folder, or you can run it from the recent downloads bar at the bottom of your web browser.

downloads to your

2. When prompted, ensure the Enable Hyper-V Windows Features option is selected on the Configuration page.

3. Follow the instructions on the installation wizard to authorize the installer and proceed with the install.

4. When the installation is successful, click Close to complete the installation process.

. If your admin account is different to your ser account, you must add the user to the docker-users group. Run Computer Management as an administrator and navigate to Local Users and Groups > Groups > docker-users. Right-click to add the user to

the Log out and log back in for the changes to take effect. group.

## Step 2 - Install (by unzipping and copying) the MagentoApp application

## Step 2.1. - Download and install application

From Assignment 1 in Teams (Web GUI Automation) download the zip file MagentoApp_2025.zip.

Unzip and copy to a directory (for example, E:\Temp\ATST\MagentoApp)

## Step 2.2. – MagentoApp and Docker application configuration

## Important: From the directory where the application was installed (at the same level as docker- compose.yml)

Exemple: E:\Temp\ATST\MagentoApp

## Step 2.2.1 – Container start command

To start containers run in command line….> docker-compose up

## Step 2.2.2 – Command to display containers (in a different command line than Step 2.2.1)

To display containers (in a different command line, because the docker-compose command takes a long time)

Run in command line …> docker ps -a


## Step 2.2.3 – Inspect nginx container and get IP

The next command, to inspect nginx container, from which we need to get an IP

It is run in command line …> docker inspect nginx

it will appear as a json, and "IPAddress": "........", is the IP of the docker container

## Step 2.2.4 – Configure and edit hosts file

The next step is to edit the hosts file (open notepad with administrator rights), which in

Windows is in c:\Windows\System32\Drivers\etc\hosts

In this file, these lines must be added to resolve the domains.

172.17.0.9 qa1.dev.evozon.com

172.17.0.9 qa2.dev.evozon.com

172.17.0.9 qa3.dev.evozon.com

instead of the above IP, add the IP taken from the nginx inspect from Step 2.2.3

## Step 2.2.4 – access the application in chrome

http://testfasttrackit.info/selenium-test/

You should see the page below, it has something similar (another picture)

The next step is to access the application on qa1.dev.evozon.com

Note: If the site does not work, then change the IP in the host file from 172.17.0.9 to the following IP: 127.0.0.1
