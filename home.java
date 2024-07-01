import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

class Book {
    String issuerName;
    String gender;
    String bookName;
    String bookID;
    String bookGenre;
    String dateOfIssue;
    String dateOfReturn;
    String status;

    public Book(String bookID, String bookName, String bookGenre, String issuerName, String gender, String dateOfIssue, String dateOfReturn, String status) {
        this.issuerName = issuerName;
        this.gender = gender;
        this.bookName = bookName;
        this.bookID = bookID;
        this.bookGenre = bookGenre;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
        this.status = status;
    }
}

class home implements ActionListener {
    JFrame f;
    JPanel p, p1, p2, p3, p4;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, errorMsg;
    JLabel iss, ret, rep;
    JTextField ti1, ti2, ti3, ti4;
    JTextField trb1, trb3, trb4;
    JTextField trl1, trl3, trl4;
    JComboBox<String> cbi;
    JRadioButton ri1, ri2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    ButtonGroup rgi;
    DefaultTableModel tableModel;

    java.util.List<Book> books = new java.util.ArrayList<>();

    home() {
        f = new JFrame("Library Management System");

        // Home Page
        p = new JPanel();
        p.setLayout(null);

        l1 = new JLabel("Library Home Page");

        b1 = new JButton("Issue Book");
        b1.addActionListener(this);

        b2 = new JButton("Return Book");
        b2.addActionListener(this);

        b3 = new JButton("Show Issued Books");
        b3.addActionListener(this);

        b4 = new JButton("Report Lost Book");
        b4.addActionListener(this);

        b5 = new JButton("Quit");
        b5.addActionListener(this);

        // Issue Page
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(500, 500));

	iss = new JLabel("Book Issue");       

	l2 = new JLabel("Issuer Name");
        ti1 = new JTextField();

        l3 = new JLabel("Gender");
        rgi = new ButtonGroup();
        ri1 = new JRadioButton("Male", false);
        ri2 = new JRadioButton("Female", false);
        rgi.add(ri1);
        rgi.add(ri2);

        l4 = new JLabel("Book Name");
        ti2 = new JTextField();

        l5 = new JLabel("Book ID No");
        ti3 = new JTextField();

        l6 = new JLabel("Book Genre");
        cbi = new JComboBox<>();
        cbi.addItem("Fantasy");
        cbi.addItem("Mystery");
        cbi.addItem("Fiction");
        cbi.addItem("Science Fiction");
        cbi.addItem("Romance Novel");
        cbi.addItem("Biography");
        cbi.addItem("Horror");

        l7 = new JLabel("Date of Issue");
        ti4 = new JTextField();

        b6 = new JButton("Save");
        b6.addActionListener(this);

        b7 = new JButton("Cancel");
        b7.addActionListener(this);

        errorMsg = new JLabel("");
        errorMsg.setForeground(Color.RED);

        // Return Page
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setPreferredSize(new Dimension(500, 500));

	ret = new JLabel("Book Return");

        trb1 = new JTextField();
        trb3 = new JTextField();
        trb4 = new JTextField();

        l8 = new JLabel("Date of Return");

        b8 = new JButton("Save");
        b8.addActionListener(this);

        b9 = new JButton("Cancel");
        b9.addActionListener(this);

        // Report Page
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setPreferredSize(new Dimension(500, 500));

	rep = new JLabel("Report Lost Book");

        trl1 = new JTextField();
        trl3 = new JTextField();
        trl4 = new JTextField();

        b10 = new JButton("Save");
        b10.addActionListener(this);

        b11 = new JButton("Cancel");
        b11.addActionListener(this);

        // Show Issued Books Page
        p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        p4.setPreferredSize(new Dimension(500, 500));

        b12 = new JButton("Back");
        b12.addActionListener(this);
    }

    public void acc() {
        f.setVisible(true);
        f.setSize(1000, 600);
        f.add(p);
        p.add(l1);
        l1.setBounds(370, 100, 500, 70);
        l1.setFont(new Font("Benett", Font.BOLD, 30));
        p.add(b1);
        b1.setBounds(330, 230, 150, 40);
        p.add(b2);
        b2.setBounds(530, 230, 150, 40);
        p.add(b3);
        b3.setBounds(330, 330, 150, 40);
        p.add(b4);
        b4.setBounds(530, 330, 150, 40);
        p.add(b5);
        b5.setBounds(430, 430, 150, 40);
    }

    public void issue() {
        f.add(p1);
        p.setVisible(false);
        p1.setVisible(true);

	p1.add(iss);
	iss.setBounds(420, 40, 200 ,20);
	iss.setFont(new Font("Benett", Font.BOLD, 25));

        p1.add(l2);
        l2.setBounds(350, 100, 150, 20);
        p1.add(ti1);
        ti1.setBounds(450, 100, 150, 20);

        p1.add(l3);
        l3.setBounds(350, 150, 150, 20);
        p1.add(ri1);
        ri1.setBounds(450, 150, 100, 20);
        p1.add(ri2);
        ri2.setBounds(550, 150, 100, 20);

        p1.add(l4);
        l4.setBounds(350, 200, 150, 20);
        p1.add(ti2);
        ti2.setBounds(450, 200, 150, 20);

        p1.add(l5);
        l5.setBounds(350, 250, 150, 20);
        p1.add(ti3);
        ti3.setBounds(450, 250, 150, 20);

        p1.add(l6);
        l6.setBounds(350, 300, 150, 20);
        p1.add(cbi);
        cbi.setBounds(450, 300, 150, 20);

        p1.add(l7);
        l7.setBounds(350, 350, 150, 20);
        p1.add(ti4);
        ti4.setBounds(450, 350, 150, 20);

        p1.add(b6);
        b6.setBounds(370, 400, 100, 20);
        p1.add(b7);
        b7.setBounds(520, 400, 100, 20);

        p1.add(errorMsg);
        errorMsg.setBounds(450, 380, 250, 20);
    }

    public void returnBook() {
        f.add(p2);
        p.setVisible(false);
        p2.setVisible(true);

	p2.add(ret);
	ret.setBounds(400, 130, 200, 20);
	ret.setFont(new Font("Benett", Font.BOLD, 25));

        p2.add(l2);
        l2.setBounds(350, 200, 150, 20);
        p2.add(trb1);
        trb1.setBounds(450, 200, 150, 20);

        p2.add(l5);
        l5.setBounds(350, 250, 150, 20);
        p2.add(trb3);
        trb3.setBounds(450, 250, 150, 20);

        p2.add(l8);
        l8.setBounds(350, 300, 150, 20);
        p2.add(trb4);
        trb4.setBounds(450, 300, 150, 20);

        p2.add(b8);
        b8.setBounds(370, 380, 100, 30);
        p2.add(b9);
        b9.setBounds(500, 380, 100, 30);
    }

    public void report() {
        f.add(p3);
        p.setVisible(false);
        p3.setVisible(true);

	p3.add(rep);
	rep.setBounds(370, 130, 500, 25);
	rep.setFont(new Font("Benett", Font.BOLD, 30));

        p3.add(l2);
        l2.setBounds(350, 200, 150, 20);
        p3.add(trl1);
        trl1.setBounds(450, 200, 150, 20);

        p3.add(l5);
        l5.setBounds(350, 250, 150, 20);
        p3.add(trl3);
        trl3.setBounds(450, 250, 150, 20);

        p3.add(l7);
        l7.setBounds(350, 300, 150, 20);
        p3.add(trl4);
        trl4.setBounds(450, 300, 150, 20);

        p3.add(b10);
        b10.setBounds(370, 380, 100, 30);
        p3.add(b11);
        b11.setBounds(500, 380, 100, 30);
    }

    public void showBooks() {
	p4.removeAll();
        p.setVisible(false);

        String[] columnNames = {"Book ID", "Book Name", "Book Genre", "Issuer Name", "Gender",  "Date of Issue", "Date of Return", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);

        for (Book book : books) {
            String[] row = {book.bookID, book.bookName, book.bookGenre, book.issuerName, book.gender, book.dateOfIssue, book.dateOfReturn, book.status};
            tableModel.addRow(row);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        p4.add(scrollPane, BorderLayout.CENTER);
        p4.add(b12, BorderLayout.SOUTH);
	f.add(p4);
	p4.setVisible(true);
	p4.revalidate();
	p4.repaint();
    }

    public boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date parsedDate = sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();

    if (source == b1) {
        issue();
        ti1.setText("");
        ti2.setText("");
        ti3.setText("");
        ti4.setText("");
        rgi.clearSelection();
        cbi.setSelectedIndex(-1);
    } else if (source == b2) {
        returnBook();
        trb1.setText("");
        trb3.setText("");
        trb4.setText("");
    } else if (source == b3) {
        showBooks();
    } else if (source == b4) {
        report();
        trl1.setText("");
        trl3.setText("");
        trl4.setText("");
    } else if (source == b5) {
        f.dispose();
    } else if (source == b6) {
        String issuerName = ti1.getText();
        String gender = ri1.isSelected() ? "Male" : "Female";
        String bookName = ti2.getText();
        String bookID = ti3.getText();
        String bookGenre = (String) cbi.getSelectedItem();
        String dateOfIssue = ti4.getText();

        boolean bookExists = false;
        for (Book book : books) {
            if (book.bookID.equals(bookID) && book.status.equals("Issued")) {
                JOptionPane.showMessageDialog(f, "This book is already issued.");
                bookExists = true;
                break;
            }
        }

        if (!bookExists) {
            books.add(new Book(bookID, bookName, bookGenre, issuerName, gender, dateOfIssue, "", "Issued"));
        }

        p1.setVisible(false);
        p.setVisible(true);
    } else if (source == b8) { // Save Return Book
        String bookID = trb3.getText();
        String dateOfReturn = trb4.getText();
        boolean bookFound = false;

        for (Book book : books) {
            if (book.bookID.equals(bookID)) {
                if (book.status.equals("Issued")) {
                    book.dateOfReturn = dateOfReturn;
                    book.status = "Available";
                    JOptionPane.showMessageDialog(f, "Book returned successfully.");
                } else {
                    JOptionPane.showMessageDialog(f, "This book is not currently issued.");
                }
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            JOptionPane.showMessageDialog(f, "Invalid book ID.");
        }

        p2.setVisible(false);
        p.setVisible(true);
    } else if (source == b10) { // Save Report Lost Book
        String bookID = trl3.getText();
        boolean bookFound = false;

        for (Book book : books) {
            if (book.bookID.equals(bookID)) {
                book.status = "Lost";
                JOptionPane.showMessageDialog(f, "Book reported as lost.");
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            JOptionPane.showMessageDialog(f, "Invalid book ID.");
        }

        p3.setVisible(false);
        p.setVisible(true);
    } else if (source == b7 || source == b9 || source == b11 || source == b12) {
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p.setVisible(true);
    }
}


    public static void main(String[] args) {
        home s = new home();
        s.acc();
    }
}
