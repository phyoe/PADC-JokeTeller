package xyz.phyoekhant.harthapadaythar.components.textviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import xyz.phyoekhant.harthapadaythar.utils.MMFontUtils;

/**
 * Created by Phyoe Khant on 6/26/2016.
 */
public class MMTextView extends TextView {
    public MMTextView(Context context) {
        super(context);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }
}
