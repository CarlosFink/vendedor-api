FROM gradle:7.6.0-jdk17-alpine AS GRADLE_BUILD
ENV APP_HOME=/workspace
RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME
COPY --chown=gradle:gradle . $APP_HOME
RUN gradle build --no-daemon

FROM openjdk:17-alpine
COPY --from=GRADLE_BUILD /workspace/build/libs/*.jar vendedor.jar
EXPOSE 8888
CMD ["java","-jar","vendedor.jar"]