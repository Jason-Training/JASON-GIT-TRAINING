package com.example.jason.opps_concept;

import com.example.jason.opps_concept.Login.PLogin;
import com.example.jason.opps_concept.Login.iLoginView;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private iLoginView mView;
    @Mock
    private PLogin pLogin;

    @Before
    public void setUp() throws Exception{
        pLogin = new PLogin(mView);
    }


    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception{
        when(mView.getUsername()).thenReturn("");
        pLogin.checkLogin();

        verify(mView).showUsernameError(R.string.username_Error);
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception{
        when(mView.getPassword()).thenReturn("");
        pLogin.checkLogin();

        verify(mView).showPasswordError(R.string.password_Error);
    }

}