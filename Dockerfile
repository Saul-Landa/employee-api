FROM ubuntu:latest
LABEL authors="salag"

ENTRYPOINT ["top", "-b"]