/*
 * Copyright 2013 the original author or authors.
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

package org.gradle.nativecode.base.plugins

import org.gradle.util.HelperUtil
import spock.lang.Specification

class BinariesPluginTest extends Specification {
    final def project = HelperUtil.createRootProject()

    def "creates domain objects for library"() {
        given:
        project.plugins.apply(BinariesPlugin)

        when:
        project.libraries {
            test
        }

        then:
        final sharedLibName = project.compilers.defaultToolChain.getSharedLibraryName("test")
        final staticLibName = project.compilers.defaultToolChain.getStaticLibraryName("test")

        and:
        def sharedLibraryBinary = project.binaries.testSharedLibrary
        sharedLibraryBinary.outputFile == project.file("build/binaries/testSharedLibrary/$sharedLibName")
        sharedLibraryBinary.component == project.libraries.test

        and:
        def staticLibraryBinary = project.binaries.testStaticLibrary
        staticLibraryBinary.outputFile == project.file("build/binaries/testStaticLibrary/$staticLibName")
        staticLibraryBinary.component == project.libraries.test
    }
}
