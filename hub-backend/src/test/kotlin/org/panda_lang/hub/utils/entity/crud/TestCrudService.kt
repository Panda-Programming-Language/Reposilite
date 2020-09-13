/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.panda_lang.hub.utils.entity.crud

import org.bson.types.ObjectId
import org.panda_lang.hub.utils.entity.AbstractCrudOperationService
import org.panda_lang.hub.utils.entity.CrudOperationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.Throws

@Service
class TestCrudService @Autowired internal constructor(testRepository: TestRepository?) : AbstractCrudOperationService<TestRepository?, TestEntity?, ObjectId?>(testRepository), CrudOperationsService<TestEntity?, ObjectId?>