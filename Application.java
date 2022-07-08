/**
 * 
 * Author: Jai Surya Palle
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Application extends JFrame {
    WorkAreaPanel workAreaPanel;

    public static void main(String[] a) {
        Application app = new Application();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(800, 500);
        app.setVisible(true);
        BlackBoard.getInstance().addObserver(new HandlerLine());
        BlackBoard.getInstance().addObserver(new HandlerCluster());
    }

    public Application() {
        super("Project 360");
        workAreaPanel = new WorkAreaPanel();
        setLayout(new BorderLayout());
        this.add(workAreaPanel, BorderLayout.CENTER);

        JMenu fileMenu = new JMenu("File");
        JMenuItem newFileItem = new JMenuItem("New");
        JMenuItem loadFileItem = new JMenuItem("Load");
        JMenuItem saveFileItem = new JMenuItem("Save");
        fileMenu.add(newFileItem);
        fileMenu.add(loadFileItem);
        fileMenu.add(saveFileItem);

        JMenu connectionMenu = new JMenu("Connections");
        JMenuItem lineNeighbourItem = new JMenuItem("Line - nearest neighbour");
        JMenuItem clusterItem = new JMenuItem("Clusters");
        JMenuItem lineClusterItem = new JMenuItem("Line + Clusters");
        connectionMenu.add(lineNeighbourItem);
        connectionMenu.add(clusterItem);
        connectionMenu.add(lineClusterItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(connectionMenu);
        menuBar.add(helpMenu);

        newFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workAreaPanel.clearAll();
            }
        });

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file to save");

        saveFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = fileChooser.showSaveDialog(Application.this);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ArrayList<Point> points = BlackBoard.getInstance().getPoints();
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(
                                new FileWriter(selectedFile.getAbsolutePath()));
                        for (Point point: points) {
                            bufferedWriter.write(point.toString());
                            bufferedWriter.write("\n");
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        JFileChooser loadFileChooser = new JFileChooser();
        loadFileChooser.setDialogTitle("Select a file to load");

        loadFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = loadFileChooser.showOpenDialog(Application.this);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = loadFileChooser.getSelectedFile();
                    workAreaPanel.clearAll();

                    try {
                        BufferedReader bufferedReader = new BufferedReader(
                                new FileReader(selectedFile.getAbsolutePath()));
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            String[] split = line.trim().split(";");
                            Point point = new Point(Integer.parseInt(split[0]),
                                    Integer.parseInt(split[1]), Color.getColor(split[2]));
                            BlackBoard.getInstance().addPoint(point);

                        }
                        workAreaPanel.repaint();
                        bufferedReader.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        setJMenuBar(menuBar);
    }
}
