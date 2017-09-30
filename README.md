##1.)
###Execute
run:
Buffer Size: 5
Producers: 1
Consumers: 1
Main thread 1 will sleep for 10 seconds upon awakening will terminate application
Consumer 9 wants to consume.
Producer 10 produced "89"
Producer 10 inserted "89" count = 1
Consumer 9 removed "89". BUFFER EMPTY  count =  0
Consumer 9 consumed "89"
Consumer 9 wants to consume.
Producer 10 produced "50"
Producer 10 inserted "50" count = 1
Application has finished executing for 10 seconds.

##2.)
###Execute
run:
Buffer Size: 1
Producers: 5
Consumers: 5
Main thread 1 will sleep for 10 seconds upon awakening will terminate application
Consumer 9 wants to consume.
Consumer 11 wants to consume.
Consumer 12 wants to consume.
Consumer 10 wants to consume.
Consumer 13 wants to consume.
Producer 17 produced "14"
Producer 17 inserted "14 BUFFER FULL count = 1.
Consumer 13 removed "14". BUFFER EMPTY  count =  0
Consumer 13 consumed "14"
Consumer 13 wants to consume.
Producer 15 produced "2"
Producer 15 inserted "2 BUFFER FULL count = 1.
Consumer 10 removed "2". BUFFER EMPTY  count =  0
Consumer 10 consumed "2"
Consumer 10 wants to consume.
Producer 16 produced "61"
Producer 16 inserted "61 BUFFER FULL count = 1.
Consumer 13 removed "61". BUFFER EMPTY  count =  0
Consumer 13 consumed "61"
Consumer 13 wants to consume.
Producer 17 produced "81"
Producer 17 inserted "81 BUFFER FULL count = 1.
Consumer 12 removed "81". BUFFER EMPTY  count =  0
Consumer 12 consumed "81"
Consumer 12 wants to consume.
Producer 14 produced "48"
Producer 14 inserted "48 BUFFER FULL count = 1.
Consumer 12 removed "48". BUFFER EMPTY  count =  0
Consumer 12 consumed "48"
Consumer 12 wants to consume.
Producer 18 produced "90"
Producer 18 inserted "90 BUFFER FULL count = 1.
Consumer 9 removed "90". BUFFER EMPTY  count =  0
Consumer 9 consumed "90"
Consumer 9 wants to consume.
Application has finished executing for 10 seconds.

##3.)
###Execute
run:
Buffer Size: 10
Producers: 5
Consumers: 5
Main thread 1 will sleep for 10 seconds upon awakening will terminate application
Consumer 10 wants to consume.
Consumer 11 wants to consume.
Consumer 12 wants to consume.
Consumer 9 wants to consume.
Consumer 13 wants to consume.
Producer 14 produced "87"
Producer 14 inserted "87" count = 1
Producer 16 produced "61"
Consumer 11 removed "87". BUFFER EMPTY  count =  0
Consumer 11 consumed "87"
Consumer 11 wants to consume.
Producer 16 inserted "61" count = 1
Consumer 13 removed "61". BUFFER EMPTY  count =  0
Consumer 13 consumed "61"
Consumer 13 wants to consume.
Producer 15 produced "95"
Producer 15 inserted "95" count = 1
Consumer 12 removed "95". BUFFER EMPTY  count =  0
Consumer 12 consumed "95"
Consumer 12 wants to consume.
Producer 14 produced "18"
Producer 14 inserted "18" count = 1
Consumer 10 removed "18". BUFFER EMPTY  count =  0
Consumer 10 consumed "18"
Consumer 10 wants to consume.
Producer 14 produced "74"
Producer 14 inserted "74" count = 1
Consumer 12 removed "74". BUFFER EMPTY  count =  0
Consumer 12 consumed "74"
Consumer 12 wants to consume.
Producer 14 produced "48"
Producer 14 inserted "48" count = 1
Consumer 11 removed "48". BUFFER EMPTY  count =  0
Consumer 11 consumed "48"
Consumer 11 wants to consume.
Application has finished executing for 10 seconds.
Producer 17 produced "97"
Producer 17 inserted "97" count = 1
Consumer 12 removed "97". BUFFER EMPTY  count =  0
Consumer 12 consumed "97"
Consumer 12 wants to consume.
Producer 17 produced "57"