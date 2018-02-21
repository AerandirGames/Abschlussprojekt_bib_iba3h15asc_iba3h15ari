package com.example.kai.appalk;

import java.util.Random;

/**
 * Created by Kai on 19.02.2018.
 */

public class MessengerMessage
{
    public String body, sender, empfaenger;
    public boolean isMine;

    public MessengerMessage (String sender, String empfaenger, String messageString, boolean isMINE)
    {
        body = messageString;
        isMine = isMINE;
        this.sender = sender;
        this.empfaenger = empfaenger;
    }



}
