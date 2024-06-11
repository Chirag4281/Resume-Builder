import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class Resume extends JFrame {
    private String name, dob, fatherName, nationality, email, phoneNo, school, college, university, schoolFrom, schoolTo, collegeFrom, collegeTo, universityFrom, universityTo, company, designation, salary, years, imagePath, english, german, french, hindi;
    private JLabel nameLabel, dobLabel, fatherNameLabel, nationalityLabel, emailLabel, phoneLabel, schoolLabel, collegeLabel, universityLabel, experienceLabel, languagesLabel;
    private JButton pdfButton, saveButton;
    private int school1,college1,university1;
    String sclass,scollege,suniversity;
    public Resume(String name, String dob, String fatherName, String nationality, String phoneNo, String email, String school, String college, String university, String schoolFrom, String schoolTo, String collegeFrom, String collegeTo, String universityFrom, String universityTo, String company, String designation, String salary, String years, String imagePath, String english, String german, String french, String hindi) {
        this.name = name;
        this.dob = dob;
        this.fatherName = fatherName;
        this.nationality = nationality;
        this.phoneNo = phoneNo;
        this.email = email;
        this.school = school;
        this.college = college;
        this.university = university;
        this.schoolFrom = schoolFrom;
        this.schoolTo = schoolTo;
        this.universityFrom = universityFrom;
        this.universityTo = universityTo;
        this.collegeFrom = collegeFrom;
        this.collegeTo = collegeTo;
        this.company = company;
        this.designation = designation;
        this.salary = salary;
        this.years = years;
        this.imagePath = imagePath;
        this.english = english;
        this.german = german;
        this.french = french;
        this.hindi = hindi;
        setTitle("Resume Template");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.school1 = Integer.parseInt(schoolFrom);
this.college1=Integer.parseInt(schoolTo);
this.university1=Integer.parseInt(collegeFrom);
        // Add profile image
        JLabel profileImageLabel = new JLabel();
        ImageIcon profileImageIcon = new ImageIcon(imagePath);
        profileImageIcon = new ImageIcon(profileImageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        profileImageLabel.setIcon(profileImageIcon);
        profileImageLabel.setBounds(550, 30, 150, 150);
        add(profileImageLabel);
        if(school1 >=0 && school1 <=30)
        {
            sclass = "Failed";
        }
        if(school1 >=50 && school1 <=70)
        {
            sclass = "3rd Class";
        }
        if(school1 >70 && school1 <=90)
        {
            sclass = "2nd Class";
        }if(school1 >90 && school1 <=100)
        {
            sclass = "1st Class";
        }
        if(college1 >=0 && college1 <=30)
        {
            scollege = "Failed";
        }if(college1 >=50 && college1 <=70)
        {
            scollege = "3rd Class";
        }
        if(college1 >70 && college1 <=90)
        {
            scollege = "2nd Class";
        }if(college1 >90 && college1 <=100)
        {
            scollege = "1st Class";
        }if(university1 >=4 && school1 <=6)
        {
            suniversity = "3rd Class";
        }if(university1 >6 && university1 <=8)
        {
            suniversity= "2nd Class";
        }if(university1 >=9 && university1 <=10)
        {
            suniversity= "1st Class";
        }
        nameLabel = createLabel(name, "Arial", Font.BOLD, 30, 50, 30, 500, 50);
        dobLabel = createLabel("Date of Birth: " + dob, "Arial", Font.PLAIN, 14, 50, 80, 200, 20);
        fatherNameLabel = createLabel("Father's Name: " + fatherName, "Arial", Font.PLAIN, 14, 50, 100, 300, 20);
        nationalityLabel = createLabel("Nationality: " + nationality, "Arial", Font.PLAIN, 14, 50, 120, 200, 20);
        emailLabel = createLabel("Email: " + email, "Arial", Font.PLAIN, 14, 50, 140, 300, 20);
        phoneLabel = createLabel("Phone: " + phoneNo, "Arial", Font.PLAIN, 14, 50, 160, 300, 20);
        schoolLabel = createLabel("School (SSC): " + school + " (" + schoolFrom + "% - " + collegeTo + ") "+sclass+" ", "Arial", Font.PLAIN, 14, 50, 200, 500, 20);
        collegeLabel = createLabel("College (HSC): " + college + " (" +  schoolTo+ "% - " + universityFrom+ ") "+scollege+" ", "Arial", Font.PLAIN, 14, 50, 220, 500, 20);
        universityLabel = createLabel("University: " + university + " (" + collegeFrom + " CGPA- " + universityTo + ") "+suniversity+" ", "Arial", Font.PLAIN, 14, 50, 240, 500, 20);

        experienceLabel = createLabel("Work Experience", "Arial", Font.BOLD, 18, 50, 280, 200, 20);
        JLabel experienceDescLabel = createLabel("- " + designation + " at " + company, "Arial", Font.PLAIN, 14, 70, 310, 500, 20);
        JLabel experienceDesc2Label = createLabel("- " + years + " years of experience", "Arial", Font.PLAIN, 14, 70, 330, 500, 20);

        languagesLabel = createLabel("Languages Known", "Arial", Font.BOLD, 18, 50, 370, 200, 20);
        JLabel languagesDescLabel = createLabel("- English: " + english + ", French: " + french + ", German: " + german + ", Hindi: " + hindi, "Arial", Font.PLAIN, 14, 70, 400, 600, 20);

        pdfButton = createButton("Generate PDF", "Arial", Font.PLAIN, 14, 300, 500, 150, 30);
        saveButton = createButton("Save", "Arial", Font.PLAIN, 14, 500, 500, 100, 30);

        add(nameLabel);
        add(dobLabel);
        add(fatherNameLabel);
        add(nationalityLabel);
        add(emailLabel);
        add(phoneLabel);
        add(schoolLabel);
        add(collegeLabel);
        add(universityLabel);
        add(experienceLabel);
        add(experienceDescLabel);
        add(experienceDesc2Label);
        add(languagesLabel);
        add(languagesDescLabel);
        add(pdfButton);
        add(saveButton);

        pdfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    generate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    private JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.BLACK);
        label.setBounds(x, y, width, height);
        return label;
    }

    private JButton createButton(String text, String fontName, int fontStyle, int fontSize, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font(fontName, fontStyle, fontSize));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 0, 117));
        button.setBounds(x, y, width, height);
        return button;
    }

    public void generate() throws IOException {
        // Take a screenshot of the JFrame
        BufferedImage screenshot = new BufferedImage(getWidth(), 500, BufferedImage.TYPE_INT_RGB);
        paint(screenshot.getGraphics());

        // Convert the screenshot to a PDF
        convertToPDF(screenshot, "resume.pdf");
    }

    public void convertToPDF(BufferedImage image, String outputPath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(new PDRectangle(image.getWidth(), 500));
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.drawImage(org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory.createFromImage(document, image), 0, 0, image.getWidth(), 500);
            }

            document.save(new File(outputPath));
        }
    }

    public static void main(String[] args) {
        // Example usage
        new Resume("John Doe", "01/01/1990", "Michael Doe", "American", "+1234567890", "john.doe@example.com",
                "High School Name", "College Name", "University Name", "2005", "2010", "2010", "2014",
                "2014", "2018", "ABC Inc.", "Software Engineer", "$100,000", "5", "profile_picture.jpg",
                "Fluent", "Basic", "Intermediate", "Fluent");
    }
}
