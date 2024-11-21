package com.karlo.ashflix.ui.view.login


import com.karlo.ashflix.model.data.ashflix.login.LoginData
import com.karlo.ashflix.model.data.ashflix.login.LoginResponse
import com.karlo.ashflix.model.repository.remote.ashflix.auth.AshflixAuthRepository
import com.karlo.ashflix.network.ashflix.service.FakeAshflixService
import com.karlo.ashflix.ui.main.uiState.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var ashflixService: FakeAshflixService

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        ashflixService = FakeAshflixService()
        loginViewModel = LoginViewModel(AshflixAuthRepository(ashflixService))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `initial state checking`() = runTest {
        val uiState = loginViewModel.uiState
        assert(uiState.value.userName == "")
        assert(uiState.value.password == "")
        assert(uiState.value.loginApiState is ApiState.Idle)
    }

    @Test
    fun `state values should be updated`() = runTest {
        val uiState = loginViewModel.uiState

        val userName = "MyUserName"
        val password = "MyPassword"

        loginViewModel.updateUsername(userName)
        loginViewModel.updatePassword(password)

        assert(uiState.value.userName == userName)
        assert(uiState.value.password == password)
    }

    @Test
    fun `login should be successful`() = runTest {
        val uiState = loginViewModel.uiState
        val userName = "MyUserName"
        val password = "MyPassword"
        loginViewModel.updateUsername(userName)
        loginViewModel.updatePassword(password)

        val expectedResponse = LoginResponse("success", data = LoginData(token = "sample token"))

        ashflixService.loginResponse = expectedResponse

        loginViewModel.login()

        assert(uiState.value.loginApiState is ApiState.Success)
        assert(expectedResponse == (uiState.value.loginApiState as ApiState.Success<LoginResponse>).response)
    }

    @Test
    fun `login should have error on empty name`() = runTest {
        val uiState = loginViewModel.uiState

        val userName = ""
        val password = "MyPassword"
        loginViewModel.updateUsername(userName)
        loginViewModel.updatePassword(password)

        loginViewModel.login()
        assert(uiState.value.loginApiState is ApiState.Error)
//        assert((uiState.value.loginApiState as ApiState.Error).message == "User name must not be empty")
    }

    @Test
    fun `login should have error on network error`() = runTest {
        val uiState = loginViewModel.uiState
        ashflixService.hasNetwork = false
        val userName = "MyUserName"
        val password = "MyPassword"
        loginViewModel.updateUsername(userName)
        loginViewModel.updatePassword(password)
        loginViewModel.login()
        assert(uiState.value.loginApiState is ApiState.Error)
//        assert((uiState.value.loginApiState as ApiState.Error).message == "Network Error")
    }
}