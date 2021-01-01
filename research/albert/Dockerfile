
FROM tensorflow/tensorflow:latest

WORKDIR /albert
COPY albert /albert
COPY tmp/glue_data /albert/glue_data
#COPY download_glue_data.py /albert/download_glue_data.py
COPY start /albert/start
CMD [ "/albert/start" ]
