/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
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
package org.apache.log4j.config;

import static org.apache.logging.log4j.core.impl.Log4jPropertyKey.CONFIG_V1_FILE_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.test.net.mock.MockSyslogServer;
import org.apache.logging.log4j.core.test.net.mock.MockSyslogServerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Class Description goes here.
 */
@Tag("sleepy")
public class SyslogAppenderTest {

    private static MockSyslogServer syslogServer;

    @BeforeAll
    public static void beforeClass() throws IOException {
        initTCPTestEnvironment();
        System.setProperty("syslog.port", Integer.toString(syslogServer.getLocalPort()));
        System.setProperty(CONFIG_V1_FILE_NAME.getKey(), "target/test-classes/log4j1-syslog.xml");
    }

    @AfterAll
    public static void cleanup() {
        System.clearProperty(CONFIG_V1_FILE_NAME.getKey());
        syslogServer.shutdown();
    }

    @Test
    public void sendMessage() throws Exception {
        final Logger logger = LogManager.getLogger(SyslogAppenderTest.class);
        logger.info("This is a test");
        List<String> messages = null;
        for (int i = 0; i < 5; ++i) {
            Thread.sleep(250);
            messages = syslogServer.getMessageList();
            if (messages != null && messages.size() > 0) {
                break;
            }
        }
        assertThat(messages).hasSize(1);
    }

    protected static void initTCPTestEnvironment() throws IOException {
        syslogServer = MockSyslogServerFactory.createTCPSyslogServer();
        syslogServer.start();
    }
}
