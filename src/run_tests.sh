javac -cp junit-4.13.jar:hamcrest-core-1.3.jar:. PokerTest.java CardTest.java
java -cp junit-4.13.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore PokerTest CardTest
