/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
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

package org.panda_lang.hub.user

import com.github.michaelbull.result.get
import com.github.michaelbull.result.getError
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.panda_lang.hub.github.LocalGitHubClient
import kotlin.test.assertEquals
import kotlin.test.assertNull

class UserFacadeTest {

    private var userFacade = UserFacade(LocalGitHubClient(), InMemoryUserRepository())

    @Test
    fun `given unknown id should return no value` () = runBlocking {
        val unknownId = -1L

        assertNull(userFacade.getUser(unknownId))
    }

    @Test
    fun `given github token should fetch profile and return user` () = runBlocking {
        val token = "localToken"

        val user = userFacade.fetchUser(token).get()!!

        assertEquals(7, user.id)
        assertEquals("localLogin", user.profile.login)
    }

    @Test
    fun `given invalid github token should return error response` () = runBlocking {
        val invalidToken = "invalidToken"

        val fetchResult = userFacade.fetchUser(invalidToken)
        val error = fetchResult.getError()!!

        assertEquals(404, error.status.value)
    }

    @Test
    fun `given login should find and return user` () = runBlocking {
        val token = "localToken"
        val login = "localLogin"

        userFacade.fetchUser(token)
        val user = userFacade.getUser(login)

        assertEquals(7, user!!.id)
    }

    @Test
    fun `given invalid login should return error response` () = runBlocking {
        val invalidToken = "invalidLogin"

        val user = userFacade.getUser(invalidToken)

        assertNull(user)
    }

}