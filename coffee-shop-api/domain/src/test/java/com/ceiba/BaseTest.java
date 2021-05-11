package com.ceiba;

import static org.junit.Assert.fail;

import java.util.function.Supplier;

import org.junit.Assert;

public class BaseTest {

    private static final String THE_EXCEPTION_WAS_EXPECTED = "Se esperaba la excepcion ";
    private static final String BUT_IT_WAS_RELEASED = " Pero fue lanzada ";

    public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
        try {
            supplier.get();
            fail();
        } catch (Exception e) {
            Assert.assertTrue(THE_EXCEPTION_WAS_EXPECTED + exception.getCanonicalName() + BUT_IT_WAS_RELEASED
                    + e.getClass().getCanonicalName(), exception.isInstance(e));
            Assert.assertTrue(e.getMessage().contains(message));
        }
    }

    public static void assertThrows(Thunk thunk, Class<? extends Exception> exception, String message) {
        try {
            thunk.execute();
            fail();
        } catch (Exception e) {
            Assert.assertTrue(THE_EXCEPTION_WAS_EXPECTED + exception.getCanonicalName() + BUT_IT_WAS_RELEASED
                    + e.getClass().getCanonicalName(), exception.isInstance(e));
            Assert.assertTrue(e.getMessage().contains(message));
        }
    }

    @FunctionalInterface
    public interface Thunk {
        void execute();
    }

}
