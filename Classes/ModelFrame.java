package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

//If the warnings on the right side interest you, i have an explanation on the bottom of the classfile (spoiler: they are redundant)
public class ModelFrame extends JFrame {
    //GUI FORM ELEMENTS
    private JPanel mainPanel;
    private JButton goButton;
    private JComboBox<String> ascBox;
    private JComboBox<String> classBox;
    private JLabel headLabel;
    private JLabel classLabel;
    private JLabel ascLabel;
    private JTable screenTable;
    private JLabel titleLabel;
    private JLabel linkLabel;
    private JLabel popLabel;
    private JLabel classImgLabel;
    private JLabel ascImgLabel;

    //GLOBAL VARIABLES
    ImageIcon classImg;
    ImageIcon ascImg;
    ImageIcon resizedImg;
    final String[] classNames = {"Duelist","Marauder","Ranger","Scion","Shadow","Templar","Witch"};
    final String[] DuelistAscs = {"Slayer","Gladiator","Champion"};
    final String[] MarauderAscs = {"Juggernaught","Berserker","Chieftain"};
    final String[] RangerAscs = {"Deadeye","Raider","Pathfinder"};
    final String ScionAsc = "Ascendant";
    final String[] ShadowAscs = {"Assassin","Saboteur","Trickster"};
    final String[] TemplarAscs = {"Inquisitor","Hierophant","Guardian"};
    final String[] WitchAscs = {"Occultist","Necromancer","Elementalist"};


//CONSTRUCTOR (basically the whole program)
    public ModelFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo;
        logo = createImageIcon("images/poelogo.jpg");
        this.setIconImage(logo.getImage());
        this.setContentPane(mainPanel);
        this.pack();

//Initializing JTable and enabling/disabling GUI Elements
        DefaultTableModel model = new DefaultTableModel(10,3);
        screenTable.setModel(model);
        screenTable.setEnabled(false);
        titleLabel.setEnabled(true);
        ascLabel.setEnabled(true);
        classLabel.setEnabled(true);
        linkLabel.setEnabled(true);
        popLabel.setEnabled(true);
        headLabel.setEnabled(true);
        classBox.setEnabled(true);
        ascBox.setEnabled(false);

//CLASS AND ASCENDANCY CHOICE
//Loading JComboBox for all Classes while loading only the class-specific Ascendancies in the other JComboBox
//Adding 2 EventListeners (one for each Box) and loading the according ImageIcons for each Field
        for (String className : classNames) classBox.addItem(className);
        classBox.setSelectedIndex(-1);

        classBox.addItemListener(e -> {
            ascBox.setEnabled(true);
            if (e.getItem() == classNames[0]){
                classImg = createImageIcon("images/"+classNames[0]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                for(String DuelistAsc : DuelistAscs) ascBox.addItem(DuelistAsc);
                    }
            else if(e.getItem() == classNames[1]){
                classImg = createImageIcon("images/"+classNames[1]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                for(String MarauderAsc : MarauderAscs) ascBox.addItem(MarauderAsc);
            }
            else if(e.getItem() == classNames[2]){
                classImg = createImageIcon("images/"+classNames[2]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                for(String RangerAsc : RangerAscs) ascBox.addItem(RangerAsc);
            }
            else if(e.getItem() == classNames[3]){
                classImg = createImageIcon("images/"+classNames[3]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                ascBox.addItem(ScionAsc);
            }
            else if(e.getItem() == classNames[4]){
                classImg = createImageIcon("images/"+classNames[4]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                for(String ShadowAsc : ShadowAscs) ascBox.addItem(ShadowAsc);
            }
            else if(e.getItem() == classNames[5]){
                classImg = createImageIcon("images/"+classNames[5]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                for(String TemplarAsc : TemplarAscs) ascBox.addItem(TemplarAsc);
            }
            else{
                classImg = createImageIcon("images/"+classNames[6]+".png");
                classImgLabel.setIcon(classImg);
                ascBox.removeAllItems();
                for(String WitchAsc : WitchAscs) ascBox.addItem(WitchAsc);
            }
        });

//Added a resize class to make the images displayed look similar to the above section due to size differences
//During these if-else statements i cycle through the same variables/objects reassigning their values over-and-over
        ascBox.addItemListener(e -> {
            //DUELIST ASCENDANCY ICONS
            if(e.getItem() == DuelistAscs[0]){
                ascImg = createImageIcon("images/" + DuelistAscs[0] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == DuelistAscs[1]){
                ascImg = createImageIcon("images/" + DuelistAscs[1] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == DuelistAscs[2]) {
                ascImg = createImageIcon("images/" + DuelistAscs[2] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            //MARAUDER ASCENDANCY ICONS
            else if(e.getItem() == MarauderAscs[0]){
                ascImg = createImageIcon("images/" + MarauderAscs[0] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == MarauderAscs[1]){
                ascImg = createImageIcon("images/" + MarauderAscs[1] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == MarauderAscs[2]) {
                ascImg = createImageIcon("images/" + MarauderAscs[2] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            //RANGER ASCENDANCY ICONS
            else if(e.getItem() == RangerAscs[0]){
                ascImg = createImageIcon("images/" + RangerAscs[0] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == RangerAscs[1]){
                ascImg = createImageIcon("images/" + RangerAscs[1] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == RangerAscs[2]) {
                ascImg = createImageIcon("images/" + RangerAscs[2] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            //SCION ASCENDANCY ICONS
            else if(e.getItem() == ScionAsc) {
                ascImg = createImageIcon("images/" + ScionAsc + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            //SHADOW ASCENDANCY ICONS
            else if(e.getItem() == ShadowAscs[0]){
                ascImg = createImageIcon("images/" + ShadowAscs[0] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == ShadowAscs[1]){
                ascImg = createImageIcon("images/" + ShadowAscs[1] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == ShadowAscs[2]) {
                ascImg = createImageIcon("images/" + ShadowAscs[2] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            //TEMPLAR ASCENDANCY ICONS
            else if(e.getItem() == TemplarAscs[0]){
                ascImg = createImageIcon("images/" + TemplarAscs[0] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == TemplarAscs[1]){
                ascImg = createImageIcon("images/" + TemplarAscs[1] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == TemplarAscs[2]) {
                ascImg = createImageIcon("images/" + TemplarAscs[2] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            //WITCH ASCENDANCY ICONS
            else if(e.getItem() == WitchAscs[0]){
                ascImg = createImageIcon("images/" + WitchAscs[0] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == WitchAscs[1]){
                ascImg = createImageIcon("images/" + WitchAscs[1] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }
            else if(e.getItem() == WitchAscs[2]) {
                ascImg = createImageIcon("images/" + WitchAscs[2] + ".png");
                resizedImg = resizeImageIcon(ascImg);
                ascImgLabel.setIcon(resizedImg);
            }

        });
//Longest if-else statement in my life... lol (hopefully i will manage to make it smaller in the future if i can)

//BUTTON ACTION
//Gathering info from user assigned fields and implementing the backend classes to get and handle the data i need
        goButton.addActionListener(e -> {
            ForumFetcher Fetch = new ForumFetcher();
            ForumLinkCreator Link = new ForumLinkCreator();
            String link = null;
            try {
                link = Link.forumLink(ascBox.getSelectedItem().toString());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            URL url = null;
            try {
                url = new URL(link);
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
//The following class and function documentation exists on their own classfiles (ForumFetcher.java ForumLinkCreator)
            List<String> Titles = Fetch.TitleReader(url);
            List<String> Views = Fetch.ViewsReader(url);
            List<String> BuildLinks = Fetch.BuildLink(url);
            List<Integer> IntViews = Fetch.ViewBoardConverter(Views);
            Fetch.BuildShorter(Titles, Views, BuildLinks, IntViews);

            for(int i=0; i<10; i++) {
                screenTable.setValueAt(Views.get(i), i, 0);
                screenTable.setValueAt(BuildLinks.get(i),i,1);
                screenTable.setValueAt(Titles.get(i),i,2);
            }
            screenTable.setEnabled(true);


        });
    }

//Class that ensures the images loaded do not trigger the NULL pointer exception and if triggered a message appears to help me
//with the troubleshooting
    protected static ImageIcon createImageIcon(String path){
        URL imgURL = ModelFrame.class.getResource(path);
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }
        else{
            System.err.println("Missing file: " + path);
            return null;
        }
    }
//Resizing class to handle the images loaded as i like
    protected static ImageIcon resizeImageIcon(ImageIcon icon){
        Image image = icon.getImage(); // transform it
        Image resizedImg = image.getScaledInstance(220, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(resizedImg);
        return icon;
    }


//ALL OF THE WARNINGS ON MY RIGHT ARE REDUNDANT  SO IGNORE THEM (the createImageIcon class handles the error that might arrise)
}
