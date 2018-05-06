 Platform, tools
==================
* Platform
-- OS name: "windows xp", version: "5.1", arch: "x86", family: "windows".
* IDE
-- IntellijIDEA 2017.1 Community edition.
* Build tool
-- Apache Maven 3.5.3 (3383c37e1f9e9b3bc3df5050c29c8aff9f295297; 2018-02-24T22:49:05+03:00).
* Java 
-- Java version: 1.8.0_121, vendor: Oracle Corporation.


Project description
======================

Original task description
---------------------------------------------------------
Backend developer test
Appliance Control
The task is to design and implement a backend service to control an appliance such as a wash machine or an oven. The API should be REST based and the state of the appliance should be persisted to any form of persistent storage. There is no need for any frontend but we expect there to be a README.md file with build directions and examples of how to invoke the REST API (e.g. curl).
The project should be implemented using Java or Node.js. Feel free to use any 3rd party library that you are comfortable with. Unit tests are expected and the assignment will be assessed based on good programming practices and design.
Please use GitHub or Bitbucket to publish your source code.

General description
---------------------------------------------------------
Project was created initially with Spring Initializer. 
The KIS approach is used.
The washing machine is assumed as a concrete appliance.


Restrictions, simplifications
---------------------------------------------------------
Simplest approach for persistence implementation is used.
No log tools used in the project.
No new Java8 features used.
In-memory “H2” DB is used for simplicity.
Not full coverage by tests is performed – only several tests for demonstartion.
Maybe some unused dependencies are kept in the POM, some commented code is not cleared, etc. 

How to build and run the project
---------------------------------------------------------
- To build project use “mvn_bld.bat” file.
- To start project use “mvn_run.bat” file or use “java -jar restapi-0.0.1-SNAPSHOT.war” command from command line.
- The application URL is http://localhost:8080/RestApiApplianceApp/. 
- The DB url is http://localhost:8080/h2-console. Datasource string to connect is “jdbc:h2:mem:RestApiApplianceDB”, username = “sa”, password is empty.
- The state of the appliance can be obtained via GET request – use http://localhost:8080/RestApiApplianceApp/state in the browser.
- To control the appliance application use CURL tool. Several examples of the control commands are located in the “cURL” directory. Use appropriate *.bat file to post commands.

Comments
---------------------------------------------------------
Main comments are related to the state persistence approach. Currently the simplest way is used – only one record with only one field. But the following enhancements are possible like these:
- Use separate DB table for available set of appliance states, and keep in the main table reference to appropriate state ID.
- Keep previous states of the appliance with timestamps. Keep previous ones in the main table or separate history table.
- Use some restrictions like forbidden (allowed) state transitions, and keep them in the separate DB table. While command requires change the state, check transition matrix before.
As well as state processing, the commands objects have the simplest structure too. Commands have no additional parameters like time, speed, temperature, etc.
