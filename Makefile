FILES = consumer.java producer.java circBuffer.java ProducerConsumer.java

all:
	 javac -g $(FILES)

run:
	 java ProducerConsumer

clean:
	 rm *.class

package:
	 zip -r $(FILES) makefile README.txt
