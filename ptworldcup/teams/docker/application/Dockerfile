# first image
FROM java:8 AS base

# get all the code
ADD ./ /app/
RUN chmod -R 777 /app

# get gradle
ENV GRADLE_VERSION 2.13
ENV GRADLE_SHA 0f665ec6a5a67865faf7ba0d825afb19c26705ea0597cec80dd191b0f2cbb664

RUN cd /usr/lib \
 && curl -fl https://downloads.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle-bin.zip \
 && echo "${GRADLE_SHA} gradle-bin.zip" | sha256sum -c - \
 && unzip "gradle-bin.zip" \
 && ln -s "/usr/lib/gradle-${GRADLE_VERSION}/bin/gradle" /usr/bin/gradle \
 && rm "gradle-bin.zip"

ENV GRADLE_HOME=/app/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

RUN cd /app \
  && ./gradlew clean build jar

FROM java:8
COPY --from=base /app/build/libs .

# Run our service
COPY /docker/application/run.sh ./run.sh
CMD [ "./run.sh" ]