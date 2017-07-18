.PHONY: build
build:
	./gradlew build
test:
	./gradlew test
clean:
	./gradlew clean
install:
	adb install -r app/build/outputs/apk/app-debug.apk
