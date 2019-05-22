package library.shangxiazuoyou.sugerdebounce;

import io.reactivex.disposables.Disposable;

class RxSubscription implements DebounceSubscription {

    private Disposable disposable;

    static DebounceSubscription wrap(Disposable disposable) {
        return new RxSubscription(disposable);
    }

    private RxSubscription(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override
    public boolean isUnsubscribed() {

        if (disposable != null) {
            return disposable.isDisposed();
        }
        return true;
    }

    @Override
    public void unsubscribe() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
