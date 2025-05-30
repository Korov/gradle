plugins {
    id("gradlebuild.distribution.api-java")
    id("gradlebuild.publish-public-libraries")
}

description = "Base tools to work with files"

gradleModule {
    usedInWorkers = true
}

dependencies {
    api(projects.stdlibJavaExtensions)

    api(libs.jspecify)
    api(libs.jsr305)

    implementation(libs.guava)
    implementation(libs.slf4jApi)

    testImplementation(projects.native)
    testImplementation(projects.baseServices) {
        because("TextUtil is needed")
    }
    testImplementation(testFixtures(projects.native))
}
