#base image:
FROM ubuntu
RUN apt-get -y install  mono-devel
COPY server.exe /usr/src/payment/
EXPOSE 9090
CMD ["mono","/usr/src/payment/server.exe"]