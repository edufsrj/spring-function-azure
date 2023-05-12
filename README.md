# Azure Functions with Spring Cloud Functions

A simple *POC* to use spring cloud functions in a azure function environment


## Advantages
* **N/A**

## Disadvantages
* Bigger startup time and execution time in general
* More code to write to make it work
* The only binder supported at the moment is **HttpTrigger** which makes harder the development because you need to write all connections by hand and manage it by hand
* Needs more dependencies to make it work which causing a bigger jar after compilation
* The DI doesn't work
