package library.shangxiazuoyou.sugerdebounce.internal;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

public class Composition {

    private Composition() {
        throw new AssertionError("no instance");
    }

    @SuppressWarnings("unchecked")
    public static <T> ObservableTransformer<T, T> applyDebounceCompose2X(long time, TimeUnit unit) {
        return (ObservableTransformer<T, T>) DebounceTransformer2X.create(time, unit);
    }

    private static class DebounceTransformer2X implements ObservableTransformer {

        private long time;
        private TimeUnit unit;

        static ObservableTransformer create(long time, TimeUnit unit) {
            return new DebounceTransformer2X(time, unit);
        }

        private DebounceTransformer2X(long time, TimeUnit unit) {
            this.time = time;
            this.unit = unit;
        }

        @Override
        public ObservableSource apply(io.reactivex.Observable upstream) {
            return upstream.debounce(time, unit)
                    .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread());
        }
    }
}
