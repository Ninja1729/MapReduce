# Steps to execute Hadoop program using Driver

1. Write the jar file and put it into hadoop client
scp WordCountNin/target/wordcount-1.0-SNAPSHOT.jar nkandavel@hdpclient1.bigdatadev3.lb.truecarcorp.com:/home/nkandavel

2. Create the input file in the hadoop cluster directly or create in client and move it to cluster as below.
hdfs dfs -copyFromLocal input.txt /user/nkandavel/wordcount/input.txt

3. Execute the hadoop jar program by giving the input file and output folder
hadoop jar wordcount-1.0-SNAPSHOT.jar wordcount/WordCount /user/nkandavel/wordcount/input.txt /user/nkandavel/wordcount/output

Note : gz compressed format cannot be split

# Steps to execute Hadoop program using Driver

To run a oozie job,
1. put the coordinator.properties file into client
scp coordinator.properties nkandavel@hdpclient1.bigdatadev3.lb.truecarcorp.com:/home/nkandavel

2. put the coordinator.xml and workflow.xml into the cluster in /user/nkandavel/testoz/ folder
scp coordinator.xml nkandavel@hdpclient1.bigdatadev3.lb.truecarcorp.com:/home/nkandavel
scp workflow.xml nkandavel@hdpclient1.bigdatadev3.lb.truecarcorp.com:/home/nkandavel
hadoop fs -copyFromLocal coordinator.xml  /user/nkandavel/testoz/
hadoop fs -copyFromLocal workflow.xml  /user/nkandavel/testoz/

3. put the jar file into the cluster /user/nkandavel/testoz/lib folder 
scp jar nkandavel@hdpclient1.bigdatadev3.lb.truecarcorp.com:/home/nkandavel
hadoop fs -copyFromLocal jar  /user/nkandavel/testoz/lib

Run the script
oozie job -oozie  http://oozie:11000/oozie/ -config coordinator.properties -run


