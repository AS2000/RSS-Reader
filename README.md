# XML RSS Feed Reader

Usage:
1. Pull the project.
2. Move to the project folder on your PC by typing: cd project_folder_name
3. Compile it to the .war file by typing: mvn clean install
4. Copy created .war file (you will find it in the project /target/ folder) to the Tomcat /webapps/ folder
5. Tomcat server will automaticaly add project to the server link: localhost:80/rss/ (on the local server), or YourServerIP:80/rss/ (on dedicated server).

Please be noticed: Default Tomcat port is 8080, If you want to use 80 port, please configure Tomact /conf/server.xml file.

#App was creaded by Anton Šepetko in 2018 as a task for the potential Employer.
