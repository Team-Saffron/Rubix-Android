// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.archit_jain08.rubix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Referenced classes of package com.example.archit_jain08.rubix:
//            newState

public class artifical_Intelligence
{
    private class node
    {

        String parent;
        int probe;
        String state;
        int steps;
        final artifical_Intelligence this$0;

        node(String s, String s1, int i, int j)
        {
            this$0 = artifical_Intelligence.this;
            super();
            state = s;
            parent = s1;
            steps = i;
            probe = j;
        }
    }


    Map hash;
    LinkedList moves;
    Queue q;

    artifical_Intelligence()
    {
        moves = new LinkedList();
        q = new LinkedList();
        hash = new HashMap();
    }

    void generateMoves()
    {
        q.add(new node("123456789", null, 0, -1));
        hash.put("123456789", new node("123456789", null, 0, -1));
        do
        {
            if (q.isEmpty())
            {
                break;
            }
            node node1 = (node)q.poll();
            if (node1.steps != 9)
            {
                int i = 0;
                while (i < 4) 
                {
                    Object obj = new newState(0, node1.state);
                    ((newState) (obj)).rotate(i, 0);
                    obj = ((newState) (obj)).simpleRetrieval();
                    if (!hash.containsKey(obj))
                    {
                        hash.put(obj, new node(((String) (obj)), node1.state, node1.steps + 1, i));
                        q.add(new node(((String) (obj)), node1.state, node1.steps + 1, i));
                    }
                    i++;
                }
            }
        } while (true);
    }

    int nextMove(String s)
    {
        if (s.equals("123456789"))
        {
            return -2;
        }
        if (!hash.containsKey(s))
        {
            return -1;
        } else
        {
            return ((node)hash.get(s)).probe;
        }
    }
}
