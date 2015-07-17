// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

// Referenced classes of package android.support.v7.internal.widget:
//            TintTypedArray

public class TintSpinner extends Spinner
{

    private static final int TINT_ATTRS[] = {
        0x10100d4, 0x1010176
    };

    public TintSpinner(Context context)
    {
        this(context, null);
    }

    public TintSpinner(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010081);
    }

    public TintSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = TintTypedArray.obtainStyledAttributes(context, attributeset, TINT_ATTRS, i, 0);
        setBackgroundDrawable(context.getDrawable(0));
        if (android.os.Build.VERSION.SDK_INT >= 16 && context.hasValue(1))
        {
            setPopupBackgroundDrawable(context.getDrawable(1));
        }
        context.recycle();
    }

}
