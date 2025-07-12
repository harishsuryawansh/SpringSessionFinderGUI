/*package com.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.springbean.SessionFinder;

public class DependencyInjection {

	public static void main(String[] args) {

		// Note: File name is NewFile.xml (not ApplicationContext.xml)
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
			"C:\\Users\\haris\\eclipse-workspace\\Spring_Core\\IOCProj02\\src\\com\\confi\\NewFile.xml"
		);

		SessionFinder finder = ctx.getBean("sessionFinder", SessionFinder.class);

		String result = finder.findSession("Harshu");
		System.out.println(result);

		ctx.close();
	}
}*/

package com.main;

import javax.swing.*;
import java.awt.event.*;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.springbean.SessionFinder;

public class DependencyInjection {

    public static void main(String[] args) {

        // ✅ Step 1: Spring Container load karo
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
                "C:\\Users\\haris\\eclipse-workspace\\Spring_Core\\IOCProj02\\src\\com\\confi\\NewFile.xml"
        );

        // ✅ Step 2: Spring se SessionFinder bean le lo
        SessionFinder finder = ctx.getBean("sessionFinder", SessionFinder.class);

        // ✅ Step 3: GUI components
        JFrame frame = new JFrame("🗓️ Session Finder");
        frame.setSize(450, 250);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter your name:");
        label.setBounds(50, 30, 150, 30);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(180, 30, 180, 30);
        frame.add(textField);

        JButton button = new JButton("Find Session");
        button.setBounds(130, 80, 150, 35);
        frame.add(button);

        JLabel outputLabel = new JLabel("");
        outputLabel.setBounds(50, 130, 350, 30);
        frame.add(outputLabel);

        // ✅ Step 4: Button click event
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText().trim();
                if (!name.isEmpty()) {
                    String result = finder.findSession(name);
                    outputLabel.setText(result);
                } else {
                    outputLabel.setText("⚠️ Please enter your name.");
                }
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ctx will remain open while GUI is running
        // ctx.close(); // ❌ Don't close immediately
    }
}

   