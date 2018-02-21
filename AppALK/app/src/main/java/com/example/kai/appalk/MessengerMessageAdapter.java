package com.example.kai.appalk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kai on 19.02.2018.
 */

public class MessengerMessageAdapter extends BaseAdapter
{
    private static LayoutInflater inflater = null;
    ArrayList<MessengerMessage> messengerMessageList;

    public MessengerMessageAdapter (Activity activity, ArrayList<MessengerMessage> list)
    {
        messengerMessageList = list;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return messengerMessageList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        MessengerMessage message = (MessengerMessage) messengerMessageList.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.messenger_bubble, null);
        TextView msg = (TextView) vi.findViewById(R.id.message_text);
        msg.setText(message.body);
        LinearLayout layout = (LinearLayout) vi
                .findViewById(R.id.bubble_layout);
        LinearLayout parent_layout = (LinearLayout) vi
                .findViewById(R.id.bubble_layout_parent);

        // if message is mine then align to right
        if (message.isMine)
        {
            layout.setBackgroundResource(R.drawable.bubble2);
            parent_layout.setGravity(Gravity.END);
        }
        // If not mine then align to left
        else {
            layout.setBackgroundResource(R.drawable.bubble1);
            parent_layout.setGravity(Gravity.START);
        }
        msg.setTextColor(Color.BLACK);
        return vi;
    }

    public void add(MessengerMessage object)
    {
        messengerMessageList.add(object);
    }
}
