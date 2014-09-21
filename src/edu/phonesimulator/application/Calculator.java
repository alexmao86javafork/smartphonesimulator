
/*
* Copyright (C) 2014, Ryan Hermansyah, Samuel I. Gunadi.
*/

package edu.phonesimulator.application;

import edu.phonesimulator.common.Application;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* Calculator
*
* @author Ryan Hermansyah, Samuel I. Gunadi
*/
public class Calculator
extends Application
{
    
    // Samuel: translated and refactored all variable, class, and function names
    //         in accordance with coding standards.
    String _result;
    private JTextField _displayField;
    private boolean _isFirstNumber = true;
    private boolean _hasPoint = false;
    private String _operator = "=";
    private CalculatorCpu _cpu = new CalculatorCpu();
    
    public Calculator()
    {
        _id = "Calculator";
        
        _displayField = new JTextField("0", 20);
        _displayField.setPreferredSize(new Dimension(369, 86));
        _displayField.setHorizontalAlignment(JTextField.LEFT);
        _displayField.setEditable(false);
        
        // Non-editable
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));
        ActionListener numListener = new NumListener();
        ActionListener clearListener = new ClearListener();
        JButton zeroButton = new JButton("0");
        JButton oneButton = new JButton("1");
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton fourButton = new JButton("4");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton sevenButton = new JButton("7");
        JButton eightButton = new JButton("8");
        JButton nineButton = new JButton("9");
        JButton clearButton = new JButton("C");
        JButton pointButton = new JButton(".");
        buttonPanel.add(oneButton);
        oneButton.addActionListener(numListener);
        buttonPanel.add(twoButton);
        twoButton.addActionListener(numListener);
        buttonPanel.add(threeButton);
        threeButton.addActionListener(numListener);
        buttonPanel.add(fourButton);
        fourButton.addActionListener(numListener);
        buttonPanel.add(fiveButton);
        fiveButton.addActionListener(numListener);
        buttonPanel.add(sixButton);
        sixButton.addActionListener(numListener);
        buttonPanel.add(sevenButton);
        sevenButton.addActionListener(numListener);
        buttonPanel.add(eightButton);
        eightButton.addActionListener(numListener);
        buttonPanel.add(nineButton);
        nineButton.addActionListener(numListener);
        buttonPanel.add(clearButton);
        clearButton.addActionListener(clearListener);
        buttonPanel.add(zeroButton);
        zeroButton.addActionListener(numListener);
        buttonPanel.add(pointButton);
        pointButton.addActionListener(numListener);
        
        ActionListener opListener = new OpListener();
        ActionListener spaceListener = new SpaceListener();
        
        JPanel opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(6, 1));
        JButton plusButton = new JButton("+");
        
        // Samuel: better symbols
        JButton minusButton = new JButton("\u2212");
        JButton multiplyButton = new JButton("\u00D7");
        JButton divideButton = new JButton("\u00F7");
        JButton equalButton = new JButton("=");
        JButton backspaceButton = new JButton("Backspace");
        opPanel.add(plusButton);
        plusButton.addActionListener(opListener);
        opPanel.add(minusButton);
        minusButton.addActionListener(opListener);
        opPanel.add(multiplyButton);
        multiplyButton.addActionListener(opListener);
        opPanel.add(divideButton);
        divideButton.addActionListener(opListener);
        opPanel.add(equalButton);
        equalButton.addActionListener(opListener);
        opPanel.add(backspaceButton);
        backspaceButton.addActionListener(spaceListener);
        
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(_displayField, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.CENTER);
        container.add(opPanel, BorderLayout.EAST);
        
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(360, 86));
        container.add(spacer, BorderLayout.SOUTH);
        
        setLayout(new GridLayout(1, 1));
        add(container);
        
    }
    
    private void clear()
    {
        _isFirstNumber = true;
        _displayField.setText("0");
        _operator = "=";
        _cpu.setResult("0");
    }
    
    class OpListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            _isFirstNumber = true;
            String displayText = _displayField.getText();
            
            // Samuel: Error handler.
            try
            {
                if (_operator.equals("="))
                {
                    _cpu.setResult(displayText);
                } else if (_operator.equals("+"))
                {
                    _cpu.add(displayText);
                } else if (_operator.equals("\u2212"))
                {
                    _cpu.subtract(displayText);
                } else if (_operator.equals("\u00D7"))
                {
                    _cpu.multiply(displayText);
                } else if (_operator.equals("\u00F7"))
                {
                    _cpu.divide(displayText);
                }
            } catch (Exception ex)
            {
                return;
            }
            _displayField.setText("" + _cpu.getResult());
            _operator = e.getActionCommand();
            
        }
    }
    
    class NumListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            String num = e.getActionCommand();
            if (_isFirstNumber)
            {
                _displayField.setText(num);
                num = _result;
                _isFirstNumber = false;
                // Samuel: implement point error handler
                if (_hasPoint) _hasPoint = false;
            }
            else
            {
                // Samuel: implement point error handler
                if (".".equals(num))
                {
                    if(_hasPoint) return;
                    _hasPoint = true;
                }
                _displayField.setText(_displayField.getText() + num);
            }
        }
    }
    
    class SpaceListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            _displayField.setText(_displayField.getText().substring(0, _displayField.getText().length() - 1));
            
            if (_displayField.getText().length() < 1)
            {
                _displayField.setText("0");
            }
        }
    }
    
    class ClearListener implements ActionListener
    
    {
        
        public void actionPerformed(ActionEvent e)
        {
            clear();
        }
    }
    
    public class CalculatorCpu
    {
        
        private double _result;
        
        public CalculatorCpu()
        {
            _result = 0.0;
        }
        
        public String getResult()
        {
            return "" + _result;
        }
        
        public void setResult(String n)
        {
            _result = Double.parseDouble(n);
        }
        
        public void add(String n)
        {
            _result += Double.parseDouble(n);
        }
        
        public void subtract(String n)
        {
            _result -= Double.parseDouble(n);
        }
        
        public void multiply(String n)
        {
            _result *= Double.parseDouble(n);
        }
        
        public void divide(String n)
        {
            _result /= Double.parseDouble(n);
        }
    }
};