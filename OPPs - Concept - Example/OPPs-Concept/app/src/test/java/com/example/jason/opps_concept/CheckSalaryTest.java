package com.example.jason.opps_concept;

import com.example.jason.opps_concept.Login.LoginService;
import com.example.jason.opps_concept.Login.PLogin;
import com.example.jason.opps_concept.Login.iLoginView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(MockitoJUnitRunner.class)
public class CheckSalaryTest {

    private static final int MATH_RESULT = 3;

    @Mock
    private iLoginView mView;
    @Mock
    private PLogin pLogin;
    @Mock
    private LoginService loginService;

    @Before
    public void setUp() throws Exception{
        pLogin = new PLogin(mView, loginService);
    }

    @Test
    public void checkMath(){
        //Input conditions
        when(mView.getMath()).thenReturn(MATH_RESULT);

        int result = pLogin.Math();
        Assert.assertEquals(result, MATH_RESULT);
    }

    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception{
        //Input conditions
        when(mView.getUsername()).thenReturn("");
        pLogin.loginClick();

        //Expected results
        verify(mView).showUsernameError(R.string.username_Error);
    }


}