import javax.swing.*;
import java.awt.*;

public class groupExample extends JFrame{

    public groupExample(String title) throws HeadlessException {
        super(title);
//        setSize(400,200);
        createUIComponents();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createUIComponents() {
        JCheckBox b1 = new JCheckBox("check1");
        JCheckBox b2 = new JCheckBox("check2");
        JCheckBox b3 = new JCheckBox("check3");
        JCheckBox b4 = new JCheckBox("check4");
        JTextField text = new JTextField("Insert here");
        JLabel label = new JLabel("Label");
        JComboBox combo = new JComboBox(new String[]{"Salut", "Buna ziua"});

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(text)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(b1)
                                        .addComponent(b3))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(b2)
                                        .addComponent(b4))))
                .addComponent(combo)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label)
                        .addComponent(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(b1)
                        .addComponent(b2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(b3)
                        .addComponent(b4)));

        layout.linkSize(SwingUtilities.VERTICAL, text, combo);

        setContentPane(panel);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new groupExample("Librarie").setVisible(true));
    }
}

