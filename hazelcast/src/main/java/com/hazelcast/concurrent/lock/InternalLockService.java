/*
 * Copyright (c) 2008-2015, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.concurrent.lock;

import com.hazelcast.nio.serialization.Data;
import com.hazelcast.spi.ObjectNamespace;

public interface InternalLockService extends LockService {

    /**
     * Schedule lock eviction. The lock will be evicted only when matching the version
     * at the time of eviction.
     *
     * @param namespace namespace of the lock
     * @param partitionId partitionId the key falls into
     * @param key locked key
     * @param version version of a lock to evict.
     * @param delayMillis delay in ms
     */
    void scheduleEviction(ObjectNamespace namespace, int partitionId, Data key, int version, long delayMillis);

    /**
     * Cancel scheduled lock eviction.
     *
     * @param namespace namespace of the lock
     * @param partitionId partitionId the key falls into
     * @param key locked key
     */
    void cancelEviction(ObjectNamespace namespace, int partitionId, Data key);
}