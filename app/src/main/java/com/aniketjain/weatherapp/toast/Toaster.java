package com.aniketjain.weatherapp.toast;

import android.content.Context;

import com.aniketjain.roastedtoast.Toasty;
import com.aniketjain.weatherapp.R;

public class Toaster {
    private static final String BACKGROUND_COLOR = "#454B54";
    private static final String TEXT_COLOR = "#EEEEEE";
    private static final int TEXT_SIZE = 14;

    public static void successToast(Context context, String msg) {
        showCustomToast(context, msg, R.drawable.ic_baseline_check_24);
    }

    public static void errorToast(Context context, String msg) {
        showCustomToast(context, msg, R.drawable.ic_baseline_error_outline_24);
    }

    private static void showCustomToast(Context context, String msg, int iconResId) {
        Toasty.custom(
                context,
                msg,
                iconResId,
                BACKGROUND_COLOR,
                TEXT_SIZE,
                TEXT_COLOR
        );
    }
}
