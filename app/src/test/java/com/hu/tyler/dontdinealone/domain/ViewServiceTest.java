package com.hu.tyler.dontdinealone.domain;

import static org.mockito.Mockito.*;

import org.mockito.Mock;

import android.app.Activity;
import android.view.View;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Simple unit tests to learn Mockito.
 *
 * Tests by Jean. Not full equivalance class since we do not have the success cases.
 * Was unable to figure how to call the activity in time.
 */
public class ViewServiceTest {

    private static final String viewName = "viewName";

    @Mock
    Activity mockActivity = mock(Activity.class);

    @Mock
    View mockView = mock(View.class);

    @Test(expected = Exception.class)
    public void testGetViewName_WithNullView_ThrowException() {
        ViewService.getViewName(null);
    }

    @Test(expected = Exception.class)
    public void testGetView_WithValidNameAndNullActivity_ThrowException() {
        ViewService.getView(viewName, null);
    }

    @Test(expected = Exception.class)
    public void testGetView_WithNullViewNameAndValidActivity_ThrowException() {
        ViewService.getView(null, mockActivity);
    }
}