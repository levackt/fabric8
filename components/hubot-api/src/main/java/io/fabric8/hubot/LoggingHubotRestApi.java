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
package io.fabric8.hubot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.FormParam;

/**
 * A default logging implementation for when there is no Hubnot running
 */
public class LoggingHubotRestApi implements HubotRestApi {
    private static final transient Logger LOG = LoggerFactory.getLogger(LoggingHubotRestApi.class);

    @Override
    public String notify(String room, @FormParam("message") String message) {
        String category = "hubot." + room;

        Logger logger = LoggerFactory.getLogger(category);
        logger.info(message);
        return null;
    }
}
