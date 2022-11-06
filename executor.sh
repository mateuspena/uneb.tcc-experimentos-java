#!/bin/bash

JAR_FILE="tcc-experimentos-java-1.0-SNAPSHOT.jar"
JAR_PATH="/home/mateus/IdeaProjects/tcc-experimentos-java/target"
JAR_FILEPATH="$JAR_PATH/$JAR_FILE"
JAR_ARGS=$1

JOULAR_FILE="joularjx-1.0.jar"
JOULAR_PATH="/opt/joularjx"
JOULAR_FILEPATH="$JOULAR_PATH/$JOULAR_FILE"

cd $JOULAR_PATH || exit;

echo "energy;memory;time";
for i in $(seq 1 10);
    do
        sudo rm -f *.csv *.jpg *.log;
        sudo touch executor.log;
        sudo chmod 666 executor.log;
        sudo java -javaagent:$JOULAR_FILEPATH -jar $JAR_FILEPATH $JAR_ARGS > executor.log;

        ENERGY=$(cat *-methods-energy-filtered.csv);
        MEMORY=$(grep "Memory usage" executor.log);
        TIME=$(grep "Time elapsed" executor.log);

        echo "${ENERGY#*,};${MEMORY#*: };${TIME#*: }"
    done

sudo rm -f *.csv *.jpg *.log;