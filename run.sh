mkdir -p out/production/forkjoinfib
cd forkjoinfib/src
javac -d ../../out/production/forkjoinfib  eu/javaspecialists/performance/managedblocker/Fibonacci.java eu/javaspecialists/performance/managedblocker/FibonacciPerfTest.java
cd ../../
java -Xbootclasspath/a:/Users/heinz/Dropbox/heinz/projects/talks/17_WJAX_Munich/TurboChargeManagedBlockerWJAX-2017/out/production/mathhack -Djava.util.concurrent.ForkJoinPool.common.parallelism=3 -cp out/production/forkjoinfib -verbose:gc -Xmx8g -Xms8g -XX:NewSize=4g -XX:SurvivorRatio=1 eu.javaspecialists.performance.managedblocker.FibonacciPerfTest
