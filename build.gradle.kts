group = "net.tassia"
version = "1.0.0-P1"

plugins {
	kotlin("multiplatform") version "1.5.0"
}

repositories {
	mavenCentral()
}

kotlin {
	jvm()

	sourceSets {
		val commonMain by getting
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test"))
			}
		}
	}
}
