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

package org.apache.ignite.internal.processors.cache;

import org.apache.ignite.IgniteCheckedException;

import static org.apache.ignite.transactions.TransactionConcurrency.PESSIMISTIC;
import static org.apache.ignite.transactions.TransactionIsolation.REPEATABLE_READ;

/**
 * Tests for local transactions.
 */
public abstract class IgniteMvccTxSingleThreadedAbstractTest extends IgniteTxAbstractTest {
    /**
     * @throws IgniteCheckedException If test failed.
     */
    public void testPessimisticRepeatableReadCommit() throws Exception {
        fail("https://issues.apache.org/jira/browse/IGNITE-10261");

        checkCommit(PESSIMISTIC, REPEATABLE_READ);

        finalChecks();
    }

    /**
     * @throws IgniteCheckedException If test failed.
     */
    public void testPessimisticRepeatableReadRollback() throws Exception {
        fail("https://issues.apache.org/jira/browse/IGNITE-10261");

        checkRollback(PESSIMISTIC, REPEATABLE_READ);

        finalChecks();
    }
}