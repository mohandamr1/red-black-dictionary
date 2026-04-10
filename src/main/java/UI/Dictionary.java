package UI;

import filehandler.DictFileHandler;

public class Dictionary extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(Dictionary.class.getName());

    private DictFileHandler handler;

    public Dictionary() {
        handler = new DictFileHandler("files/dictionary.txt");
        DictFileHandler.loadDictionary();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1      = new javax.swing.JLabel();
        jTextField1  = new javax.swing.JTextField();
        jButton1     = new javax.swing.JButton();
        jButton2     = new javax.swing.JButton();
        jResultLabel = new javax.swing.JLabel();
        jStatsLabel  = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RB Dictionary");
        setResizable(false);

        // --- Title ---
        jLabel1.setText("Red-Black Dictionary");
        jLabel1.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // --- Input Field ---
        jTextField1.setToolTipText("Enter a word...");
        jTextField1.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 13));

        // --- Buttons ---
        jButton1.setText("Look-Up");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Insert Word");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        // --- Result Label ---
        jResultLabel.setText(" ");
        jResultLabel.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        jResultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // --- Stats Label ---
        jStatsLabel.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 11));
        jStatsLabel.setForeground(java.awt.Color.GRAY);
        jStatsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateStats();

        // --- Layout ---
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel1)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1,  javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jResultLabel)
                .addComponent(jStatsLabel)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addComponent(jLabel1)
                .addGap(15)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(10)
                .addComponent(jResultLabel)
                .addGap(5)
                .addComponent(jStatsLabel)
                .addGap(20)
        );

        pack();
        setLocationRelativeTo(null);
    }

    // --- Look-Up ---
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String word = jTextField1.getText().trim();
        if (word.isEmpty()) {
            showResult("Type a word first.", java.awt.Color.GRAY);
            return;
        }
        boolean found = DictFileHandler.lookupWord(word);  // see note below
        if (found) {
            showResult("\"" + word + "\" found ✓", new java.awt.Color(0, 153, 76));
        } else {
            showResult("\"" + word + "\" not found ✗", java.awt.Color.RED);
        }
    }

    // --- Insert ---
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String word = jTextField1.getText().trim();
        if (word.isEmpty()) {
            showResult("Type a word first.", java.awt.Color.GRAY);
            return;
        }
        String result = DictFileHandler.insertWord(word);  // see note below
        if (result.startsWith("ERROR")) {
            showResult(result, java.awt.Color.RED);
        } else {
            showResult("\"" + word + "\" inserted ✓", new java.awt.Color(0, 153, 76));
            updateStats();
        }
        jTextField1.setText("");
    }

    private void showResult(String msg, java.awt.Color color) {
        jResultLabel.setText(msg);
        jResultLabel.setForeground(color);
    }

    private void updateStats() {
        jStatsLabel.setText(String.format(
            "Size: %d  |  Height: %d  |  Black-Height: %d",
            DictFileHandler.getSize(),
            DictFileHandler.getHeight(),
            DictFileHandler.getBlackHeight()
        ));
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Dictionary().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jResultLabel;
    private javax.swing.JLabel jStatsLabel;
}