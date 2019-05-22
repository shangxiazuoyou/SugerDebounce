package library.shangxiazuoyou.sugerdebounce;

public interface DebounceSubscription {

    DebounceSubscription NONE = new DebounceSubscription() {

        @Override
        public boolean isUnsubscribed() {
            return true;
        }

        @Override
        public void unsubscribe() {

        }
    };

    boolean isUnsubscribed();

    void unsubscribe();
}
