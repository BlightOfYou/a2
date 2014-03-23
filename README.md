a2
==

Assignment 2 for architectures class

Team Members: Micah Lee, Keith Lindsey Jr, Daniel Souza, Christine Parry

##Prerequisites:
* Netbeans (tested with 7.4, use other versions at your own risk)
* MySQL(5.6.15, use other versions at your own risk )
* J connector(tested with 5.1.28, use other versions at your own risk)
* Clone of the source
  
##Database Setup:
1. Connect to MySQL Database using command:
	mysql --user=root

2. Create database for Login Service using command:
	mysql> create database loginservice;

3. Exist from mysql using command:
	mysql> exit

4. Load Login Service data schema by running this command from the root installation directory:
	mysql -u root -p[root pwd] -D loginservice < ./src/Phase2/sql/loginservice.sql


##Compile/Run Instructions
1. In Netbeans, click on: File -> Open Project, and then navigate to the source. Select the Phase2 project.
2. To add the J Connector jar file to the libraries, left click on the libraries and you can choose to add a Project, Library, or JAR/Folder… select JAR/Folder. A window will pop-up allowing you to select the mysql-connector-java-5-1-28-bin.jar file.
3. Right click on one of the three Applications and click "Run File":
   * InventoryMainFrame.java
   * OrderMainFrame.java
   * ShippingMainFrame.java

##User Credentials
Your assigned username is 'andrew' with password 'architecture101'
