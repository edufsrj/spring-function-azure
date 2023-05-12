# Azure Functions with Spring Cloud Functions

A simple *POC* to use spring cloud functions in a azure function environment


## Advantages
* **N/A**

## Disadvantages
* Bigger startup time and execution time in general
* More code to write to make it work
* The only binder supported at the moment is **HttpTrigger** which makes more difficult the development because you need to write the database, servicebus and all other connections by hand
* The DI doesn't work