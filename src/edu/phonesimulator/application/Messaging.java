/*
 * Copyright (C) 2014, Samuel I. Gunadi.
 */

package edu.phonesimulator.application;

import edu.phonesimulator.common.Application;
import javax.swing.JLabel;

/**
 * Messaging
 *
 * @author Samuel I. Gunadi
 */
public class Messaging
extends Application
{
    JLabel _label;
    public Messaging()
    {
        _id = "Messaging";
        
        _label = new JLabel("Not implemented.");
        add(_label);
    }
}