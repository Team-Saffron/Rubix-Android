// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.archit_jain08.rubix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.example.archit_jain08.rubix:
//            newState, Help, launcher, artifical_Intelligence

public class menuGame extends ActionBarActivity
    implements android.view.View.OnClickListener
{

    private TextView best;
    private int count;
    private Button grid[];
    private String state;
    private TextView steps;
    private TextView tme;

    public menuGame()
    {
    }

    private void change()
    {
        for (int i = 0; i < state.length(); i++)
        {
            grid[i].setText(String.valueOf(state.charAt(i)));
        }

    }

    private void generateGrid()
    {
        state = (new newState(3, "123456789")).getState();
    }

    private void initVariables()
    {
        state = "123456789";
        grid = new Button[10];
        grid[0] = (Button)findViewById(0x7f070044);
        grid[1] = (Button)findViewById(0x7f070045);
        grid[2] = (Button)findViewById(0x7f070046);
        grid[3] = (Button)findViewById(0x7f070047);
        grid[4] = (Button)findViewById(0x7f070048);
        grid[5] = (Button)findViewById(0x7f070049);
        grid[6] = (Button)findViewById(0x7f07004a);
        grid[7] = (Button)findViewById(0x7f07004b);
        grid[8] = (Button)findViewById(0x7f07004c);
        steps = (TextView)findViewById(0x7f07004d);
        best = (TextView)findViewById(0x7f07004f);
        tme = (TextView)findViewById(0x7f070050);
        count = 0;
        for (int i = 0; i < 9; i++)
        {
            grid[i].setOnClickListener(this);
        }

    }

    public void onClick(View view)
    {
        newState newstate = new newState(0, state);
        if (newstate.getState() != null && newstate.getState() != "123456789") goto _L2; else goto _L1
_L1:
        return;
_L2:
        count = count + 1;
        view.getId();
        JVM INSTR tableswitch 2131165252 2131165260: default 96
    //                   2131165252 117
    //                   2131165253 96
    //                   2131165254 138
    //                   2131165255 96
    //                   2131165256 96
    //                   2131165257 96
    //                   2131165258 159
    //                   2131165259 96
    //                   2131165260 180;
           goto _L3 _L4 _L3 _L5 _L3 _L3 _L3 _L6 _L3 _L7
_L7:
        break MISSING_BLOCK_LABEL_180;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L9:
        if (newState.checkIfResultReached(state))
        {
            Toast.makeText(this, "Congratulation", 1).show();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        newstate.rotate(0, 0);
        state = newstate.getState();
        change();
          goto _L9
_L5:
        newstate.rotate(1, 0);
        state = newstate.getState();
        change();
          goto _L9
_L6:
        newstate.rotate(2, 0);
        state = newstate.getState();
        change();
          goto _L9
        newstate.rotate(3, 0);
        state = newstate.getState();
        change();
          goto _L9
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030019);
        initVariables();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0c0003, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i;
        i = menuitem.getItemId();
        if (i == 0x7f070058)
        {
            startActivity(new Intent(this, com/example/archit_jain08/rubix/Help));
            return true;
        }
        if (i != 0x7f070059) goto _L2; else goto _L1
_L1:
        generateGrid();
        change();
_L4:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (i == 0x7f07005a)
        {
            int j = launcher.ai.nextMove(state);
            if (j == -2)
            {
                Toast.makeText(this, "Game finished", 0).show();
            } else
            if (j == -1)
            {
                Toast.makeText(this, "Game Stuck", 0).show();
            } else
            if (j == 0)
            {
                Toast.makeText(this, (new StringBuilder()).append("Click at ").append(grid[0].getText()).toString(), 0).show();
            } else
            if (j == 1)
            {
                Toast.makeText(this, (new StringBuilder()).append("Click at ").append(grid[2].getText()).toString(), 0).show();
            } else
            if (j == 2)
            {
                Toast.makeText(this, (new StringBuilder()).append("Click at ").append(grid[6].getText()).toString(), 0).show();
            } else
            {
                Toast.makeText(this, (new StringBuilder()).append("Click at ").append(grid[8].getText()).toString(), 0).show();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        state = (String)bundle.get("State");
        if (state == null)
        {
            state = "123456789";
        }
        change();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("State", state);
    }
}
