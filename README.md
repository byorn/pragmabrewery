#Code Challenge

Running the Project
--------------------


What were the questions you would ask and your own answers/assumptions?
------------------------------------------------------------------------

Question: How does the real time solution look like ? How do all the parts fit ?
Answer: The System Architecture is as follows:

Using RasberryPI, connected to temperature sensors ( https://github.com/ControlEverythingCommunity/MCP9805 ),
will notify the backend servers with the beer name , and temperature, and the status.
i.e. Each Sensor(PI and Sensor Device) is configured to have the minimum and maximum temperature. If the temperature falls out of this range,
the sensor will notify the central server, of the beer container, temperature, and the status.

A Mobile/Tablet Device on the Truck will retrieve this information from the Back End Server.

Javascript is running on the Table UI Interface to notify the truck driver of an error/alert if temperature is high.

Java / SpringBoot Services will have two services
  1 ) To be notified of the current beer container, temperature and alert status from the sensors.
  2 ) To display the full list of beer categories and their statuses.


What are the highlights of your logic/code writing style?
-----------------------------------------------------------
+ Code follows 'Separation of concerns' style. Relevant classes are placed in its ideal packages.
+ The front end pages are decoupled from the backend services, following a REST architecture.


What could have been done in a better way? What would you do in version 2.0?
----------------------------------------------------------------------------
+ A more 'eye catching' user interface with sound enabled for clearer notifications when temperature changes.
+ The central backend server will store historical information of the temperature captured from each device.









