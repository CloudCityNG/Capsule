package com.pitchedapps.capsule.library.event;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.pitchedapps.capsule.library.utils.ResUtils;

/**
 * Created by Allan Wang on 2016-11-14.
 */

public class SnackbarEvent {

    private String text, actionText;
    private int textId = -1, actionTextId = -1, colorInt = -1, colorRes = -1;
    private int duration = Snackbar.LENGTH_LONG;
    private View.OnClickListener mListener;

    public SnackbarEvent(String s) {
        text = s;
    }

    public SnackbarEvent(@StringRes int si) {
        textId = si;
    }

    public SnackbarEvent setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public SnackbarEvent setAction(String text, View.OnClickListener listener) {
        actionText = text;
        mListener = listener;
        return this;
    }

    public SnackbarEvent setAction(@StringRes int textId, View.OnClickListener listener) {
        actionTextId = textId;
        mListener = listener;
        return this;
    }

    public SnackbarEvent setColorRes(@ColorRes int color) {
        colorRes = color;
        return this;
    }

    public SnackbarEvent setColor(@ColorInt int color) {
        colorInt = color;
        return this;
    }

    //It is guaranteed that one of the two contains a value
    private String getText(Context context, String s, @StringRes int si) {
        if (si != -1) return ResUtils.s(context, si);
        return s;
    }

    private int getColor(Context context, @ColorRes int colorRes, @ColorInt int colorInt) {
        if (colorRes != -1) return ContextCompat.getColor(context, colorRes);
        return colorInt;
    }

    public void load(@NonNull View view) {
        Snackbar snackbar = Snackbar.make(view, getText(view.getContext(), text, textId), duration);
        if (mListener != null)
            snackbar.setAction(getText(view.getContext(), actionText, actionTextId), mListener);
        int bgColor = getColor(view.getContext(), colorRes, colorInt);
        if (bgColor != -1) snackbar.getView().setBackgroundColor(bgColor);
        snackbar.show();
    }
}
