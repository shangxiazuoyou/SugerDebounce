package library.shangxiazuoyou.sugerdebounce.internal;

import android.os.Looper;

import library.shangxiazuoyou.sugerdebounce.DebounceObserver;

public class Preconditions {

    private Preconditions() {
        throw new AssertionError("No instances.");
    }

    /**
     * Verifies if the object is not null and returns it or throws a NullPointerException
     * with the given message.
     *
     * @param <T>     the value type
     * @param object  the object to verify
     * @param message the message to use with the NullPointerException
     * @throws NullPointerException if object is null
     */
    public static <T> void requireNonNull(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * Check current thread is the UI thread, if not the observer will receive an error.
     *
     * @return if UI thread returns true, otherwise false, and call the observer
     */
    public static boolean checkMainThread(DebounceObserver<?> observer) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            observer.onError(new IllegalStateException(
                    "Expected to be called on the main thread but was " + Thread.currentThread().getName()));
            return false;
        }
        return true;
    }
}
