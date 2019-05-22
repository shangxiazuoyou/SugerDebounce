package library.shangxiazuoyou.sugerdebounce;

public interface DebounceObserver<T> {

    void onError(Throwable throwable);

    void onSuccess(T t);
}