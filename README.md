# TaskManager
using H2 as in memory with the following settings
spring.h2.console.path=/h2
server.port=8081

## #Datasource
spring.datasource.url=jdbc:h2:file:C:\data\sample
spring.datasource.driver-class-name=org.h2.Driver

kindley use the save config to use this projector change accordingly

## operations:-

## H2createTask:-
its an post operation with

## taskNum:-
for giving a unique id to the task
date:- for the task date
label:- labeling and giving details about task
priority:- setting the selected priority for the task

## updateInfo:-
for updating pre saved tasks

## findTask:- 
based on the priority entered.

## getAllTask:- 
get all the tasks saved.

## getTaskBeforDate:- 
get all the tasked saved within two days time span from entered date.
