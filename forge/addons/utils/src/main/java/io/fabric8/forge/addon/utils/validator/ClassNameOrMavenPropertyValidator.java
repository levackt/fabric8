/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.forge.addon.utils.validator;

import org.jboss.forge.addon.parser.java.utils.ResultType;
import org.jboss.forge.addon.parser.java.utils.ValidationResult;

public class ClassNameOrMavenPropertyValidator extends ClassNameValidator {

    public ClassNameOrMavenPropertyValidator(boolean allowPackageName) {
        super(allowPackageName);
    }

    @Override
    protected ValidationResult validate(String s) {
        if (s != null) {
            String trimmed = s.trim();
            if (trimmed.startsWith("${") && trimmed.endsWith("}")) {
                return new ValidationResult(ResultType.INFO);
            }
        }
        return super.validate(s);
    }
}
