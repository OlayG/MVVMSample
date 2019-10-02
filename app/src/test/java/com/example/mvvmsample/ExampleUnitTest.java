package com.example.mvvmsample;

import com.example.mvvmsample.repository.Repository;
import com.example.mvvmsample.viewmodel.MainActivityViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Mock
    MainActivityViewModel viewModel;
    @Mock
    Repository repository;

    @Before
    public void setup() {
    }

    @Test
    public void check_repository_invocked() {
        // TELL THEM BUT THIS IS THE IDEA
        // VERIFY***
        // I HAVE TO LOOK UP THE DOCUMENTATION TO FINISH THIS OFF
        Mockito.when(repository.getPosts()).thenReturn(null);

        // OKAY THANK YOU FOR YOUR TIME
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @After
    public void teardown() {

    }
}