this project aims to solve the bounded-buffer producer-consumer problem using threads in Java

files:
circBuffer.java - implements the circular buffer with FIFO properties
producer.java - generates 1,000,000 random Double values and adds them to the buffer
consumer.java - consumes values from buffer
ProducerConsumer.java - main class to run the producer and consumer threads

makefile instructions: 
run `make all` to compile the project
run `make run` to execute the program
run `make clean` to remove the compiled class files
run  'make package' to create a zip file of the project