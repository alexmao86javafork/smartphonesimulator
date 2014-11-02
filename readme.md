# Smartphone Simulator

An Android-like smartphone simulator utilizing Java Swing components.

## Overview

The simulated smartphone has an nHD (640 × 360 pixels) touch screen with one-finger touch capability that is simulated by the host pointing device. The simulator does not offer any kind of persistence. Data will be lost on closing an application or exiting the program. The simulator does not accept input from host keyboard and instead uses built-in keyboard. The main user interface layout is consisted of four parts: status bar, application, keyboard, and soft keys.

The status bar displays the carrier and signal quality information, the time, and the percentage of the phone battery left. The time is set based on the host local time and is automatically updated. The rests are static, since the carrier and the battery are not simulated.

The soft keys have three buttons: back, home, and, menu. Pressing back while having an application open will close the application. Pressing home, on the other hands, will keep the application running in the background and will open the home screen.

## Compiling

To build from source, open this folder in NetBeans.

## Built-in Applications

### Task Manager

From this application, user can monitor opened application and close them or close all of them. This application has a scroll bar and, therefore, is capable of displaying big number of application titles.

![](https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/taskmgr.png)

### Home

The home screen has launcher icons aligned to the grid. The position of these icons are fixed and cannot be rearranged.

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/home.png)

### Messaging

The messaging app has not been implemented at the moment.

### Phone

The phone application has a custom dial pad consisting of numeric, backspace, `*`, and `#`. The phone calls are not simulated and thus no answers will be received.

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/phone.png)

### Contacts

Each contact has the following fields: name, phone numbers, and addresses. User can search for a contact and call or text them.

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/contacts.png)

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/contacts_2.png)

### Memo

The memo application let you write multiple memos. Each memo has a title and a body.

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/memo.png)

### Calculator

The calculator supports four basic arithmetic operations and a custom keyboard (numeric, backspace, clear, `.`, `+`, `−`, `×`, and `÷`).

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/calculator.png)

### Clock

The clock application features three tabs: digital clock, stopwatch, and timer.

https://raw.githubusercontent.com/samuelgunadi/smartphonesimulator/master/documentation/clock.png)

### Keyboard

The keyboard is automatically opened when you click a text field or a text area. The keyboard has a QWERTY layout; it features alphabets keys, numeric keys, various symbols keys, a shift key, a backspace key, a space key, a return key, and a key to switch between alphabets layout and numbers and symbols layout. The shift key can function as both shift key and caps lock. When the keyboard is opened and you click on the back soft key, it will close the keyboard instead of closing the application.
