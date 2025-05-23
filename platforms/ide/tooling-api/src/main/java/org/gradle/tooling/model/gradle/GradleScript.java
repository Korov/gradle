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

package org.gradle.tooling.model.gradle;

import org.jspecify.annotations.Nullable;

import java.io.File;

/**
 * Represents a Gradle script. A Gradle script may be a build script, settings script or initialization script.
 *
 * @since 1.8
 */
public interface GradleScript {
    /**
     * Returns the source file for this script, or {@code null} if this script has no associated source file.
     * If this method returns a non-null value, the given source file will exist.
     *
     * @return The source file. Returns null if the script has no associated source file.
     * @since 1.8
     */
    @Nullable
    File getSourceFile();
}
