// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;


// Referenced classes of package android.support.v7.internal.widget:
//            ProgressBarCompat

private class mFromUser
    implements Runnable
{

    private boolean mFromUser;
    private int mId;
    private int mProgress;
    final ProgressBarCompat this$0;

    public void run()
    {
        ProgressBarCompat.access$000(ProgressBarCompat.this, mId, mProgress, mFromUser, true);
        ProgressBarCompat.access$102(ProgressBarCompat.this, this);
    }

    public void setup(int i, int j, boolean flag)
    {
        mId = i;
        mProgress = j;
        mFromUser = flag;
    }

    (int i, int j, boolean flag)
    {
        this$0 = ProgressBarCompat.this;
        super();
        mId = i;
        mProgress = j;
        mFromUser = flag;
    }
}
