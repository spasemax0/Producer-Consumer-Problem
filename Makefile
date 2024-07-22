FILES = consumer.java producer.java circBuffer.java ProducerConsumer.java

all:
	 javac -g $(FILES)

run:
	 java ProducerConsumer

clean:
	 rm *.class

package:
	 zip -r Spase-Sandoval-HW4.zip $(FILES) makefile README.txt