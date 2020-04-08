/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.gradle.gradlebuild.testing.integrationtests.cleanup.WhenNotEmpty
plugins {
    gradlebuild.distribution.`plugins-api-java`
}

dependencies {
    implementation(project(":baseServices"))
    implementation(project(":logging"))
    implementation(project(":coreApi"))
    implementation(project(":modelCore"))
    implementation(project(":core"))
    implementation(project(":fileCollections"))
    implementation(project(":resources"))
    implementation(project(":baseServicesGroovy"))
    implementation(project(":dependencyManagement"))
    implementation(project(":plugins"))
    implementation(project(":pluginUse"))
    implementation(project(":publish"))

    implementation(library("slf4j_api"))
    implementation(library("groovy"))
    implementation(library("guava"))
    implementation(library("commons_lang"))
    implementation(library("inject"))
    implementation(library("ant"))
    implementation(library("ivy"))
    implementation(library("maven3"))
    implementation(library("pmaven_common"))
    implementation(library("pmaven_groovy"))
    implementation(library("maven3_wagon_file"))
    implementation(library("maven3_wagon_http"))
    implementation(library("plexus_container"))
    implementation(library("aether_connector"))

    testImplementation(project(":native"))
    testImplementation(project(":processServices"))
    testImplementation(project(":snapshots"))
    testImplementation(project(":resourcesHttp"))
    testImplementation(testLibrary("xmlunit"))
    testImplementation(testFixtures(project(":core")))
    testImplementation(testFixtures(project(":modelCore")))
    testImplementation(testFixtures(project(":dependencyManagement")))

    testRuntimeOnly(project(":runtimeApiInfo"))

    integTestImplementation(project(":ear"))
    integTestImplementation(testLibrary("jetty"))
    integTestRuntimeOnly(project(":resourcesS3"))
    integTestRuntimeOnly(project(":resourcesSftp"))
    integTestRuntimeOnly(project(":apiMetadata"))
    integTestRuntimeOnly(project(":kotlinDslProviderPlugins"))

    testFixturesApi(project(":baseServices")) {
        because("Test fixtures export the Action class")
    }
    testFixturesImplementation(project(":coreApi"))
    testFixturesImplementation(project(":internalTesting"))
    testFixturesImplementation(project(":internalIntegTesting"))
    testFixturesImplementation(project(":dependencyManagement"))
}

testFilesCleanup {
    policy.set(WhenNotEmpty.REPORT)
}
