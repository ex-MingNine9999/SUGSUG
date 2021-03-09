FROM python

COPY . /python
WORKDIR /python/openDartAPI

RUN pip install --upgrade pip
RUN pip install -r ../requirements.txt

CMD ["python", "__main__.py"]
