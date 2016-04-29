
#base image
FROM alpine:latest
#repositories issues workaround: we use our own local file to build the image
#COPY repositories /etc/apk/repositories
#other workaround: we add ipv6 to the configuration for the system to work
#installing python & pip
RUN apk add --update py-pip
#installing python modules with pip
COPY requirements.txt /usr/src/app/
RUN pip install --no-cache-dir -r /usr/src/app/requirements.txt
#copying files needed to run the python app
COPY app.py /usr/src/app/
COPY templates/index.html /usr/src/app/templates/
#port to expose outside the virtual machine
EXPOSE 5000
#command to launch on run call
CMD ["python", "/usr/src/app/app.py"]