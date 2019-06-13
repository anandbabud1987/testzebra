1.Unzip the file

2. Please make sure you have java installed on your machine if not, please download (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and install java jdk and jre 1.8 version

3. Open command prompt

4. Type "java". you should see like below. if not, please set the java path in environment variables. or simple type the following command
"set PATH=your-java-home/bin"

Usage: java [-options] class [args...]
           (to execute a class)
   or  java [-options] -jar jarfile [args...]
           (to execute a jar file)
where options include:
    -d32	  use a 32-bit data model if available
    -d64	  use a 64-bit data model if available
    -server	  to select the "server" VM
                  The default VM is server,
                  because you are running on a server-class machine.


    -cp <class search path of directories and zip/jar files>
    -classpath <class search path of directories and zip/jar files>
                  A : separated list of directories, JAR archives,
                  and ZIP archives to search for class files.
    -D<name>=<value>
    
 5. now type "cd target"
 
 6 type "java -jar musturd-statistics-0.0.1.jar" and wait for the server to start.
 
 7. open post man. if you do not have postman, then please download from "https://www.getpostman.com/apps" and install postman for windows and signup to login.
 
 8. To test 2.1.1.type the following endpoint to import the csv. use 844DE****.csv under src/main/resources
URL:http://localhost:2018/mustardstatistics
Select method: POST
Choose form data and choose the csv file and provide the "key" as "file" and click "send"


9.To test 2.1.2, type the following endpoint in postman and click send
URL:http://localhost:2018/mustardstatistics
Select method: GET


10. To test 2.2.1.type the following endpoint to import the csv. use Strom.csv under src/main/resources
URL:http://localhost:2018/hurricanestatistics
Select method: POST
Choose form data and choose the csv file and provide the "key" as "file" and click "send"


11.To test 2.2.2, type the following endpoint in postman and click send
URL:http://localhost:2018/hurricanestatistics
Select method: GET
# test-api
