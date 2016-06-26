package xyz.phyoekhant.harthapadaythar.components.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import xyz.phyoekhant.harthapadaythar.utils.MMFontUtils;

/**
 * Created by Phyoe Khant on 6/26/2016.
 */
public class MMButton extends Button {

    public MMButton(Context context) {
        super(context);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }
}