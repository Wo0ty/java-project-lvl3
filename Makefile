clean:
	./gradlew clean

run-dist:
	./build/install/app/bin/app

build:
	./gradlew clean build

install:
	./gradlew clean install
	make lint

lint:
	./gradlew checkstyleMain checkstyleTest