/*
 * Copyright 2020 the original author or authors.
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

package org.gradle.plugin.management.internal;

import org.gradle.api.Incubating;
import org.gradle.api.initialization.IncludedBuild;

// TODO: move to org.gradle.api.initialization in core-api when making public
/**
 * A plugin build that is to be included in the composite.
 *
 * @since 7.0
 */
@Incubating
public interface ConfigurableIncludedPluginBuild extends IncludedBuild {

    /**
     * Sets the name of the included build.
     *
     * @param name the name of the build
     * @since 7.0
     */
    @Incubating
    void setName(String name);
}