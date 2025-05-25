FROM  my-first-image:1.0.2

LABEL version="0.1.7"

USER root

ENV TZ="Europe/Moscow"

ENV EMULATOR_IMAGE="system-images;android-33;google_apis;x86_64"
ENV ANDROID_HOME_EMULATOR="$ANDROID_HOME/emulator"
ENV ANDROID_SDK_ROOT=$ANDROID_HOME
ENV ADB_SERVER_DIR=/opt/adbserver
ENV MARATHON=/opt/marathon
ARG MARATHON_VER="0.10.3"
ARG MARATHON_ZIP="marathon-$MARATHON_VER.zip"
ARG MARATHON_URL="https://github.com/MarathonLabs/marathon/releases/download/$MARATHON_VER/$MARATHON_ZIP"
ARG ADB_SERVER_JAR=adbserver.jar
ARG ADB_SERVER_URL="https://github.com/KasperskyLab/Kaspresso/raw/master/artifacts/adbserver-desktop.jar"
ARG MARATHON_FILE="Marathonfile"
ARG NODE_URL="https://deb.nodesource.com/setup_22.x"

RUN sdkmanager --update && \
    sdkmanager "emulator" && \
    echo "y" | sdkmanager "$EMULATOR_IMAGE" && \
    mkdir -p $ADB_SERVER_DIR && \
    wget -c -O $ADB_SERVER_DIR/$ADB_SERVER_JAR ${ADB_SERVER_URL} && \
    mkdir -p $MARATHON && \
    wget -c -O $MARATHON/$MARATHON_ZIP $MARATHON_URL && \
    unzip -d $MARATHON $MARATHON/$MARATHON_ZIP && \
    curl -fsSL $NODE_URL | bash - && \
    apt-get install -y nodejs && \
    npm install -g @mockoon/cli && \
    npm cache clean --force

COPY "$MARATHON_FILE" $MARATHON/$MARATHON_FILE
ENV PATH="${PATH}:$ANDROID_HOME_EMULATOR:$MARATHON/marathon-$MARATHON_VER/bin"
RUN groupadd libvirt && \
    groupadd kvm && \
    usermod -aG libvirt,kvm jenkins && \
    chown -R jenkins:jenkins $MARATHON

USER jenkins