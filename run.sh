rm -rf out
mkdir -p out/production/forkjoinfib
cd forkjoinfib/src
javac -d ../../out/production/forkjoinfib  eu/javaspecialists/performance/managedblocker/Fibonacci.java eu/javaspecialists/performance/managedblocker/FibonacciPerfTest.java
cd ../../
mkdir -p out/production/mathhack
cd mathhack/src
javac -Xlint:none -d ../../out/production/mathhack  java/math/BigInteger.java
cd ../../
time java -showversion -Xbootclasspath/p:/Users/heinz/Dropbox/heinz/projects/talks/18_VoxxedAthens/TurboChargeManagedBlockerVoxxedAthens2018/out/production/mathhack -Djava.util.concurrent.ForkJoinPool.common.parallelism=3 -cp out/production/forkjoinfib -verbose:gc -Xmx8g -Xms8g -XX:NewSize=4g -XX:SurvivorRatio=1 eu.javaspecialists.performance.managedblocker.FibonacciPerfTest
