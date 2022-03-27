package mk.riste.buck;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SaveButton {
    private CardView cardViewSave;
    private ConstraintLayout layoutSave;
    private ProgressBar progressBarSave;
    private TextView textViewSave;

    Animation fade_in;

    SaveButton(Context ct, View view){
        cardViewSave = view.findViewById(R.id.cardViewSave);
        layoutSave = view.findViewById(R.id.constraintLayoutSave);
        progressBarSave = view.findViewById(R.id.progressBarSave);
        textViewSave = view.findViewById(R.id.textViewSave);
        fade_in = AnimationUtils.loadAnimation(ct, R.anim.fade_in);
    }

    void buttonActivated() {
        progressBarSave.setAnimation(fade_in);
        progressBarSave.setVisibility(View.VISIBLE);
        textViewSave.setVisibility(View.GONE);
    }

    void buttonFinished() {
        layoutSave.setBackgroundColor(cardViewSave.getResources().getColor(R.color.success));
        progressBarSave.setAnimation(fade_in);
        progressBarSave.setVisibility(View.GONE);
//        textViewSave.setTypeface(null, Typeface.BOLD);
        textViewSave.setAnimation(fade_in);
        textViewSave.setText("SAVED!");
        textViewSave.setVisibility(View.VISIBLE);
    }
}
