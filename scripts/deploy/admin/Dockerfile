FROM livingobjects/jre8
ENV JAVA_OPTS=""
VOLUME /tmp
ADD hypermarket-browser-1.0-SNAPSHOT.jar /app.jar
RUN sh -c 'touch /app.jar'
CMD exec java -Xms512m -Xmx512m $JAVA_OPTS -jar /app.jar