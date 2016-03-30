/*
 * Copyright 2016 the original author or authors.
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

package org.gradle.performance

import org.gradle.performance.categories.Experiment
import org.gradle.performance.categories.ToolingApiPerformanceTest
import org.gradle.tooling.model.eclipse.EclipseProject
import org.junit.experimental.categories.Category
import spock.lang.Unroll

import static org.gradle.performance.measure.Duration.millis

@Category([ToolingApiPerformanceTest, Experiment])
class ToolingApiIdeModelCrossVersionPerformanceTest extends AbstractToolingApiCrossVersionPerformanceTest {

    @Unroll
    def "building Eclipse model for a #template project"() {
        given:

        experiment(template, "get $template EclipseProject model") {
            warmUpCount = 3
            invocationCount = 10
            maxExecutionTimeRegression = millis(maxRegressionTime)
            action {
                def model = getModel(tapiClass(EclipseProject))
                // we must actually do something to highlight some performance issues
                forEachProject(model) {
                    buildCommands.each {
                        it.name
                        it.arguments
                    }
                    gradleProject.tasks.collect {
                        it.name
                        it.project
                        it.path
                        it.description
                        it.displayName
                        it.group
                        it.public
                    }
                    gradleProject.buildDirectory
                    gradleProject.path
                    gradleProject.buildScript.sourceFile
                    gradleProject.buildDirectory
                    gradleProject.name
                    gradleProject.projectDirectory
                    gradleProject.description
                    classpath.collect {
                        [it.exported, it.file, it.gradleModuleVersion.group, it.gradleModuleVersion.name, it.gradleModuleVersion.version, it.javadoc, it.source]
                    }
                    javaSourceSettings?.jdk?.javaHome
                    withJava(javaSourceSettings?.jdk?.javaVersion)
                    withJava(javaSourceSettings?.sourceLanguageLevel)
                    withJava(javaSourceSettings?.targetBytecodeVersion)
                    projectNatures.each {
                        it.id
                    }
                    projectDependencies.each {
                        it.exported
                        it.path
                    }
                    description
                    name
                    linkedResources.each {
                        it.name
                        it.location
                        it.locationUri
                        it.type
                    }
                    projectDirectory
                    sourceDirectories.each {
                        it.path
                        it.directory
                    }
                }
            }
        }

        when:
        def results = performMeasurements()

        then:
        noExceptionThrown()

        where:
        template                 | maxRegressionTime
        "smallOldJava"           | 20
        "mediumOldJava"          | 100
        "bigOldJava"             | 100
        "lotDependencies"        | 400
        "lotProjectDependencies" | 400
    }

    private static void forEachProject(def elm, @DelegatesTo(value=EclipseProject) Closure<?> action) {
        action.delegate = elm
        action.call()
        elm.children?.each {
            forEachProject(it, action)
        }
    }

    private static void withJava(def it) {
        if (it != null) {
            it.java5
            it.java5Compatible
            it.java6
            it.java6Compatible
            it.java7
            it.java7Compatible
            it.java8Compatible
            it.java9Compatible
        }
    }
}
