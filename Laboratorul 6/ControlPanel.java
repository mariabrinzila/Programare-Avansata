import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    final JFileChooser fc = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        saveBtn.setVisible(true);
        loadBtn.setVisible(true);
        resetBtn.setVisible(true);
        exitBtn.setVisible(true);

        //add all buttons
        frame.add(saveBtn);
        frame.add(loadBtn);
        frame.add(resetBtn);
        frame.add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("e:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            ImageIO.read(new File("e:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
        //punem o culoare pe tot ecranul
        frame.canvas.graphics.setColor(Color.LIGHT_GRAY);
        frame.canvas.graphics.fillRect(0, 0, 800, 600);
    }

    private void exit(ActionEvent e) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
