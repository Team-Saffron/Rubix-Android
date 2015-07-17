// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.archit_jain08.rubix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.example.archit_jain08.rubix:
//            artifical_Intelligence, menuGame

public class launcher extends Activity
    implements Runnable
{

    public static artifical_Intelligence ai;
    private Intent i;
    private Thread t;

    public launcher()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030018);
        ai = new artifical_Intelligence();
        t = new Thread(this);
        t.start();
    }

    protected void onStop()
    {
        super.onStop();
        finish();
    }

    public void run()
    {
        ai.generateMoves();
        startActivity(new Intent(this, com/example/archit_jain08/rubix/menuGame));
    }
}
