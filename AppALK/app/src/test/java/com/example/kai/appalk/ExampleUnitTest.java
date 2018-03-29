package com.example.kai.appalk;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest
{
    @Test
    public void istMail_istkorrekt() throws Exception
    {
        Registrieren_Tab2 registrieren_tab2 = new Registrieren_Tab2();
        boolean result = registrieren_tab2.istMail("peter.lustig@gmail.com");
        assertEquals(true, result);
    }

    @Test
    public void istMail_istfalsch() throws Exception
    {
        Registrieren_Tab2 registrieren_tab2 = new Registrieren_Tab2();
        boolean result = registrieren_tab2.istMail("peter.lustig@gmailcom");
        assertEquals(false, result);
    }
}