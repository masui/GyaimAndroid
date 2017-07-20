.PHONY: build
build:
	./gradlew build
	cp app/build/outputs/apk/app-debug.apk Gyaim.apk
test:
	./gradlew test
clean:
	./gradlew clean
install:
	adb install -r app/build/outputs/apk/app-debug.apk
