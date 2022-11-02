#!/bin/bash

JAR_FILE="tcc-experimentos-java-1.0-SNAPSHOT.jar"
JAR_PATH="/home/mateus/IdeaProjects/tcc-experimentos-java/target"
JAR_FILEPATH="$JAR_PATH/$JAR_FILE"
JAR_ARGS="/home/mateus/IdeaProjects/tcc-experimentos-java/assets/foto-07.jpg"

JOULAR_FILE="joularjx-1.0.jar"
JOULAR_PATH="/opt/joularjx"
JOULAR_FILEPATH="$JOULAR_PATH/$JOULAR_FILE"

cd $JOULAR_PATH

for i in $(seq 1 10); 
    do
        sudo rm -f *.csv *.jpg *.log;
        sudo touch executor.log;
        sudo chmod 666 executor.log;
        sudo java -javaagent:$JOULAR_FILEPATH -jar $JAR_FILEPATH $JAR_ARGS > executor.log;

        echo "Seq: $i";
        cat *-methods-energy-filtered.csv;
        cat executor.log | grep "Time elapsed";
        cat executor.log | grep "Memory usage";
        echo "---------------";
    done

sudo rm -f *.csv *.jpg *.log;