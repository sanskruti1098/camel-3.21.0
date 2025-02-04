/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.reifier.language;

import org.apache.camel.CamelContext;
import org.apache.camel.model.language.ExpressionDefinition;
import org.apache.camel.model.language.WasmExpression;

public class WasmExpressionReifier extends TypedExpressionReifier<WasmExpression> {

    public WasmExpressionReifier(CamelContext camelContext, ExpressionDefinition definition) {
        super(camelContext, definition);
    }

    @Override
    public boolean isResolveOptionalExternalScriptEnabled() {
        // simple language will handle to resolve external scripts as they can be dynamic using simple language itself
        return false;
    }

    @Override
    protected Object[] createProperties() {
        Object[] properties = new Object[2];
        properties[0] = definition.getResultType();
        properties[1] = definition.getModule();
        return properties;
    }
}
