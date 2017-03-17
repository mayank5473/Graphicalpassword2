    /*
        this is a function to check and performs the following operations:
        1. to get the email from user during login.
        2. to establish the connection with the sqlite through drivers manager.
        3. to establish connection to a specific email id and fetch the query from it. 
        4. to set the active color in the dail.
        5. to deliver the message box about confiming the error or the approval login.
    */
    
    private void btn_email_verifyActionPerformed(java.awt.event.ActionEvent evt)
    {                                                 
        // TODO add your handling code here:
        String email= txt_email.getText();    //email string is created to get email from user in a dailog box
        String sql;                           // sql string is created
        try
        {
            Class.forName("org.sqlite.JDBC");  // to calling the class of jdbc ,using the sqlite database manager
            conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
            /*conn variable is set to get drivers to set the connection with
                sqlite database of specific email id
            */ 
        }catch(ClassNotFoundException | SQLException | HeadlessException e)// to catch an exception of connection of drivers to sqlite
        {    
            JOptionPane.showMessageDialog(null, e); 
        }
        
        sql = "select * from users where email='" + email + "'";  // to get the database of desired email account
        try
        {
            pst = conn.prepareStatement(sql);     // to establishing the connection with a desired user of specific email id    
            rs = pst.executeQuery();              // to get all the details of establised connection
            /*
                if the query is found after establishing the connection
                the conditioned is entered or the else condition of 
                login error is get initiated
            */
            if(rs.next())
            {
                String db_email = rs.getString("Email"); // to get email address from the database
                /*
                    if the entered email is same as registered one 
                    then condition will be intiated or the else condition
                    `email error` will be performed
                */
                if(db_email.equals(email))  
                {
                    JOptionPane.showMessageDialog(null, "EMAIL OK"); // message box will be poped up showing message "email ok"
                   // suffle();
                    btn_anti_clock_rotate.setVisible(true);   // the `btn_anti_clock_rotate` function will be called on clicking of button  
                    btn_clock_rotate.setVisible(true);        // the `btn_clock_rotate` function will be called on clicking of button
                    btn_outer_orbit.setVisible(true);         // the `btn_outer_orbit` function will be called on clicking of button
                    btn_inner_orbit.setVisible(true);         // the `btn_inner_orbit` function will be called on clicking of button
                    txt_password.setVisible(true);            // the `txt_password` function will be called on clicking of button
                    lbl_password.setVisible(true);            // the `lbl_password` function will be called on clicking of button
                    btn_confirm.setVisible(true);             // the `btn_confirm` function will be called on clicking of button
                    btn_clear.setVisible(true);               // the `btn_clear` function will be called on clicking of button
                    email_verified=true;                      // when the email_verified is defined as true the dail will appear
                    this.repaint();                           // to set the dail over the area
                    this.setSize(650, 650);                   // the rea of the dail        
                    db_password = rs.getString("Password");   // to store the password in  db_password
                    String col = rs.getString("Color");       // to store the selected color from the database in col
                    
                    /* To set the color of variable db_color ,as it will be determined to choose the password unit 
                       with the accordance of it.
                    */
                    if(col.equals("Blue"))
                    {
                       db_color=Color.BLUE;                // wheather the color is equals to blue
                    }
                    else if(col.equals("Yellow"))
                    {
                       db_color=Color.YELLOW;              // or the color is equals to yellow, the color will be stored as db_color
                    }
                    else if(col.equals("Orange"))
                    {
                       db_color=Color.ORANGE;              // or the color is equals to orange, the color will be stored as db_color
                    }
                    else if(col.equals("Grey"))
                    {
                       db_color=Color.LIGHT_GRAY;           // or the color is equals to light_gray, the color will be stored as db_color
                    }else if(col.equals("Red"))
                    {
                       db_color=Color.RED;                 // or the color is equals to red, the color will be stored as db_color
                    }
                    else if(col.equals("Pink"))
                    {
                       db_color=Color.PINK;                // or the color is equals to pink, the color will be stored as db_color
                    }
                    else if(col.equals("Cyan"))
                    {
                       db_color=Color.CYAN;                // or the color is equals to cyan, the color will be stored as db_color                    
                    }
                    else if(col.equals("Green"))
                    {
                       db_color=Color.GREEN;              // or the color is equals to green, the color will be stored as db_color 
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "EMAIL ERROR");  // if email is not same then email error
                }
                conn.close();      //connection is closed to stop any of function lekaage
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login ERROR");   // if the email box get error message will be popped up
            }
        }
        
        catch(SQLException | HeadlessException e) // to catch any of the exception appear during the connection of GUI and database
        {
          JOptionPane.showMessageDialog(null, e);          //exception message
        }
    }         
