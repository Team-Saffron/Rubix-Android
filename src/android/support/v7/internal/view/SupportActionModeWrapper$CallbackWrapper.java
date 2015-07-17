// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.view:
//            SupportActionModeWrapper

public static class mWrappedCallback
    implements android.support.v7.view.kWrapper
{

    final SimpleArrayMap mActionModes = new SimpleArrayMap();
    final Context mContext;
    final android.view.ry.createMenuWrapper mWrappedCallback;

    private android.view.ActionMode getActionModeWrapper(ActionMode actionmode)
    {
        SupportActionModeWrapper supportactionmodewrapper = (SupportActionModeWrapper)mActionModes.get(actionmode);
        if (supportactionmodewrapper != null)
        {
            return supportactionmodewrapper;
        } else
        {
            SupportActionModeWrapper supportactionmodewrapper1 = new SupportActionModeWrapper(mContext, actionmode);
            mActionModes.put(actionmode, supportactionmodewrapper1);
            return supportactionmodewrapper1;
        }
    }

    public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        return mWrappedCallback.mWrappedCallback(getActionModeWrapper(actionmode), MenuWrapperFactory.createMenuItemWrapper(menuitem));
    }

    public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        return mWrappedCallback.mWrappedCallback(getActionModeWrapper(actionmode), MenuWrapperFactory.createMenuWrapper(menu));
    }

    public void onDestroyActionMode(ActionMode actionmode)
    {
        mWrappedCallback.mWrappedCallback(getActionModeWrapper(actionmode));
    }

    public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return mWrappedCallback.mWrappedCallback(getActionModeWrapper(actionmode), MenuWrapperFactory.createMenuWrapper(menu));
    }

    public (Context context, android.view.per.CallbackWrapper callbackwrapper)
    {
        mContext = context;
        mWrappedCallback = callbackwrapper;
    }
}
