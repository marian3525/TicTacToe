package debug.marian.com.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public class OnClickListenerClass implements View.OnClickListener {

    Activity activity;
    Context context;

    public OnClickListenerClass(Activity activity, Context context) {
        this.context = context;
        this.activity = activity;
    }

    public void onClick(View view) {

    }
}
