// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.archit_jain08.rubix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class newState
{

    public static final int ANTICLOCKWISE = 1;
    public static final int CLOCKWISE = 0;
    public static final int PROBE_A = 0;
    public static final int PROBE_B = 1;
    public static final int PROBE_C = 2;
    public static final int PROBE_D = 3;
    private int level;
    String state;

    newState(int i, String s)
    {
        level = i;
        state = s;
    }

    static boolean checkIfResultReached(String s)
    {
        return s.equals("123456789");
    }

    public static int nextMove(String s)
    {
        LinkedList linkedlist;
        HashMap hashmap;
        byte byte0;
        byte0 = -1;
        linkedlist = new LinkedList();
        hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        linkedlist.add(s);
        hashmap.put(s, Integer.valueOf(0));
        hashmap1.put(s, Integer.valueOf(-1));
_L7:
        int i = byte0;
        if (linkedlist.isEmpty()) goto _L2; else goto _L1
_L1:
        s = (String)linkedlist.poll();
        if (!checkIfResultReached(s)) goto _L4; else goto _L3
_L3:
        i = ((Integer)hashmap.get(s)).intValue();
_L2:
        return i;
_L4:
        i = byte0;
        if (((Integer)hashmap.get(s)).intValue() == 8) goto _L2; else goto _L5
_L5:
        int j = 0;
        while (j < 4) 
        {
            Object obj = new newState(0, s);
            ((newState) (obj)).rotate(j, 0);
            obj = ((newState) (obj)).simpleRetrieval();
            if (!hashmap.containsKey(obj))
            {
                hashmap.put(obj, Integer.valueOf(((Integer)hashmap.get(s)).intValue() + 1));
                linkedlist.add(obj);
            }
            j++;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    String getState()
    {
        probabilisticRotation();
        return state;
    }

    void probabilisticRotation()
    {
        Random random = new Random();
        for (int i = 0; i < level; i++)
        {
            int j = random.nextInt(4);
            random.nextInt(2);
            rotate(j, 0);
        }

    }

    void rotate(int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            if (j == 0)
            {
                swap(0, 1);
                swap(0, 4);
                swap(0, 3);
                return;
            } else
            {
                swap(0, 3);
                swap(0, 1);
                swap(1, 4);
                return;
            }

        case 1: // '\001'
            if (j == 0)
            {
                swap(1, 2);
                swap(1, 4);
                swap(4, 5);
                return;
            } else
            {
                swap(1, 2);
                swap(2, 4);
                swap(2, 5);
                return;
            }

        case 2: // '\002'
            if (j == 0)
            {
                swap(3, 4);
                swap(3, 7);
                swap(3, 6);
                return;
            } else
            {
                swap(3, 4);
                swap(4, 6);
                swap(4, 7);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (j == 0)
        {
            swap(4, 5);
            swap(4, 8);
            swap(4, 7);
            return;
        } else
        {
            swap(4, 5);
            swap(5, 7);
            swap(5, 8);
            return;
        }
    }

    String simpleRetrieval()
    {
        return state;
    }

    void swap(int i, int j)
    {
        char ac[] = state.toCharArray();
        char c = ac[i];
        ac[i] = ac[j];
        ac[j] = c;
        state = new String(ac);
    }
}
