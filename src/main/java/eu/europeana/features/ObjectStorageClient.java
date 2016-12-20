/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.europeana.features;


import eu.europeana.domain.StorageObject;
import org.jclouds.io.Payload;

import java.util.List;
import java.util.Optional;


public interface ObjectStorageClient {

    /**
     * @return an {@link List<StorageObject>}.
     */

    List<StorageObject> list();


    /**
     * Creates or updates a {@link StorageObject}.
     *
     * @param key   corresponds to {@link StorageObject#getName()}.
     * @param value corresponds to {@link StorageObject#getPayload()}.
     * @return {@link StorageObject#getETag()} of the object.
     */
    String put(String key, Payload value);


    /**
     * Creates or updates a {@link StorageObject}.
     *
     * @param storageObject corresponds to {@link StorageObject#getName()}.
     * @return {@link StorageObject#getETag()} of the object.
     */
    String put(StorageObject storageObject);


    /**
     * Gets the {@link StorageObject} metadata without its {@link Payload#openStream() body}.
     *
     * @param objectName corresponds to {@link StorageObject#getName()}.
     * @return the {@link StorageObject} or {@code null}, if not found.
     */

    Optional<StorageObject> getWithoutBody(String objectName);

    /**
     * Gets the {@link StorageObject} including its {@link Payload#openStream() body}.
     *
     * @param objectName corresponds to {@link StorageObject#getName()}.
     * @return the {@link StorageObject} or {@code null}, if not found.
     */

    Optional<StorageObject> get(String objectName);


    /**
     * Deletes an object, if present.
     *
     * @param objectName corresponds to {@link StorageObject#getName()}.
     */

    void delete(String objectName);


}