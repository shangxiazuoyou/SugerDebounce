package library.shangxiazuoyou.sugerdebounce;

import android.text.Editable;
import android.widget.TextView;

public class TextViewAfterTextChangeEvent {

    private TextView textView;
    private Editable editable;

    static TextViewAfterTextChangeEvent create(TextView view, Editable editable) {
        return new TextViewAfterTextChangeEvent(view, editable);
    }

    private TextViewAfterTextChangeEvent(TextView textView, Editable editable) {
        this.textView = textView;
        this.editable = editable;
    }

    public TextView view() {
        return textView;
    }

    public Editable editable() {
        return editable;
    }
}
