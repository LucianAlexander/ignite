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
package org.apache.ignite.testsuites;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.apache.ignite.internal.processors.cache.persistence.DiskPageCompressionIntegrationDirectIOTest;
import org.apache.ignite.internal.processors.cache.persistence.IgniteNativeIoLocalWalModeChangeDuringRebalancingSelfTest;
import org.apache.ignite.internal.processors.cache.persistence.IgniteNativeIoPdsRecoveryAfterFileCorruptionTest;
import org.apache.ignite.internal.processors.cache.persistence.db.wal.IgniteNativeIoWalFlushFsyncSelfTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

/**
 * Same as {@link IgnitePdsTestSuite2} but is started with direct-oi jar in classpath.
 */
@RunWith(AllTests.class)
public class IgnitePdsNativeIoTestSuite2 {
    /**
     * @return Suite.
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("Ignite Persistent Store Test Suite 2 (Native IO)");

        IgnitePdsTestSuite2.addRealPageStoreTests(suite, null);

        // Direct IO + Page compression.
        suite.addTest(new JUnit4TestAdapter(DiskPageCompressionIntegrationDirectIOTest.class));

        //Integrity test with reduced count of pages.
        suite.addTest(new JUnit4TestAdapter(IgniteNativeIoPdsRecoveryAfterFileCorruptionTest.class));

        suite.addTest(new JUnit4TestAdapter(IgniteNativeIoLocalWalModeChangeDuringRebalancingSelfTest.class));

        suite.addTest(new JUnit4TestAdapter(IgniteNativeIoWalFlushFsyncSelfTest.class));

        return suite;
    }
}
