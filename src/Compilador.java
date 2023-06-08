
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author codex_404
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Codex_Music";// Titulo de la ventana
        setLocationRelativeTo(null);
        setTitle(title);
        btnEjecutar.setVisible(false);
        // algun nombre de extension???
        directorio = new Directory(this, jtpCode, title, ".cmx");

        //Asegurarse de que al salir podamos guardar los cambios en el archivo
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });

        //Mostrar los numeros de linea en la ventana jtpCode
        Functions.setLineNumberOnJTextComponent(jtpCode);

        //Colores en el editor de texto cada 300 ms
        timerKeyReleased = new Timer(300, (ActionEvent e) -> {
            timerKeyReleased.stop();
            colores();
        });

        //Idicador de texto modificado en el editor jtpCode
        //Functions.insertAsteriskInName(this, jtpCode, () -> {
        //    timerKeyReleased.restart();
        //});

        //Arrays de elementos
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();

        //Autocompletado de codigo
        Functions.setAutocompleterJTextComponent(new String[]{/*UTILIZAR AL FINAL*/}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        lblALex = new javax.swing.JLabel();
        lblASin = new javax.swing.JLabel();
        btnEjecutar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonsFilePanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Open Sans", 2, 36)); // NOI18N
        jLabel1.setText("CODEX-MUSIC");

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsFilePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        rootPanel.add(buttonsFilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 6, -1, -1));

        jtpCode.setBackground(new java.awt.Color(40, 42, 54));
        jtpCode.setFont(new java.awt.Font("JetBrainsMono Nerd Font", 0, 24)); // NOI18N
        jtpCode.setForeground(new java.awt.Color(255, 255, 255));
        jtpCode.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtpCode);

        rootPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 138, 693, 480));

        panelButtonCompilerExecute.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        rootPanel.add(panelButtonCompilerExecute, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 6, -1, -1));

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        rootPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 419, 507, 199));

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        rootPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 88, 507, 276));

        lblALex.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        lblALex.setText("Analizador Lexico");
        rootPanel.add(lblALex, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 63, -1, -1));

        lblASin.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        lblASin.setText("Analizador Sintactico");
        rootPanel.add(lblASin, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 394, -1, -1));

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        rootPanel.add(btnEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 6, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnNuevo.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon("/home/kobayashi/Desktop/TEC/1-Automatas/COMPILADOR/Compiler/src/imagenes/newfile_85903 (1).png")); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAbrir.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/32527 (1).png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save_icon_125167 (1).png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/32743 (1).png"))); // NOI18N
        btnGuardarC.setText("Guardar como");
        btnGuardarC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnCompilar.setBackground(new java.awt.Color(204, 255, 204));
        btnCompilar.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga (1).png"))); // NOI18N
        btnCompilar.setText("Compilar");
        btnCompilar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarC, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(516, Short.MAX_VALUE))
        );

        rootPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 640));

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colores();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            limpiarCampos();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            limpiarCampos();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compilar();
            }
        } else {
            compilar();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);
            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void compilar() {
        limpiarCampos();
        analisisLexico();
        rellenarTablaTokens();
        analisisSintactico();
        mostrarConsola();
        codeHasBeenCompiled = true;
    }

    private void analisisLexico() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void analisisSintactico() {
        Grammar gramatica = new Grammar(tokens, errors);
        /*ERRORES*/
        gramatica.delete(new String[]{"ERROR"}, 1);

        /*GRUPOS*/
        gramatica.group("COMPAS", "TOKEN_DIGITO TOKEN_DIVISOR_TEMPO TOKEN_DIGITO");
        gramatica.group("COMPAS_ERROR", "TOKEN_DIGITO TOKEN_DIGITO | TOKEN_DIGITO");
        gramatica.group("FIGURA", "(TOKEN_REDONDA | TOKEN_BLANCA | TOKEN_NEGRA | TOKEN_CORCHEA | TOKEN_SEMICORCHEA | TOKEN_FUSA | TOKEN_SEMIFUSA) | (TOKEN_REDONDA | TOKEN_BLANCA | TOKEN_NEGRA | TOKEN_CORCHEA | TOKEN_SEMICORCHEA | TOKEN_FUSA | TOKEN_SEMIFUSA)(TOKEN_PUNTILLO)", true);
        gramatica.group("SILENCIOS", "(TOKEN_SILENCIO_REDONDA | TOKEN_SILENCIO_BLANCA | TOKEN_SILENCIO_NEGRA | TOKEN_SILENCIO_CORCHEA | TOKEN_SILENCIO_SEMICORCHEA | TOKEN_SILENCIO_FUSA | TOKEN_SILENCIO_SEMIFUSA)(TOKEN_PUNTILLO) | (TOKEN_SILENCIO_REDONDA | TOKEN_SILENCIO_BLANCA | TOKEN_SILENCIO_NEGRA | TOKEN_SILENCIO_CORCHEA | TOKEN_SILENCIO_SEMICORCHEA | TOKEN_SILENCIO_FUSA | TOKEN_SILENCIO_SEMIFUSA)(TOKEN_PUNTILLO)", true);

        /* DECLARACIÓN CLAVE--------------------------------------------------*/
        gramatica.group("DECLARACION_CLAVE", "TOKEN_CLAVE TOKEN_ASIGNACION TOKEN_NOTA", true);
        // ERRORES DECLARACION CLAVE
        gramatica.group("DECLARACION_CLAVE", "TOKEN_CLAVE TOKEN_ASIGNACION", true,
                2, "Error sintáctico {}: Declarción incompleta, falta especificar la clave (G2 o F{3,4} o C{1,2,3,4}) [#,%]");

        gramatica.group("DECLARACION_CLAVE", "TOKEN_CLAVE TOKEN_NOTA", true,
                3, "Error sintáctico {}: Declarción incompleta, se espera simbolo de asignación (=) [#,%]");

        gramatica.group("DECLARACION_CLAVE", "TOKEN_ASIGNACION TOKEN_NOTA", true,
                4, "Error sintáctico {}: Declarción incompleta, se espera la palabra reservada \"\\clave\" antes de \"=\" [#,%]");

        gramatica.group("DECLARACION_CLAVE", "TOKEN_CLAVE", true,
                5, "Error sintáctico {}: Declaración de clave incompleta [#,%]");

        /* DECLARACIÓN COMPAS-------------------------------------------------*/
        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS TOKEN_ASIGNACION COMPAS", true);
        /*ERRORES DELCARACION COMPAS*/
        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS TOKEN_ASIGNACION TOKEN_DIGITO TOKEN_DIVISOR_TEMPO", true,
                6, "Error sintáctico {}: Falta declarar unidad de tiempo [#,%]");

        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS TOKEN_ASIGNACION TOKEN_DIVISOR_TEMPO TOKEN_DIGITO", true,
                7, "Error sintáctico {}: Falta declarar unidad de compas [#,%]");

        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS TOKEN_DIGITO TOKEN_DIVISOR_TEMPO TOKEN_DIGITO", true,
                8, "Error sintáctico {}: Falta declarar asignacion (=) [#,%]");

        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS TOKEN_ASIGNACION COMPAS_ERROR", true,
                9, "Error sintáctico {}: Falta divisor (/) [#,%]");

        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS TOKEN_ASIGNACION", true,
                10, "Error sintáctico {}: No hay un compas asignado [#,%]");

        gramatica.group("DECLARACION_COMPAS", "TOKEN_ASIGNACION COMPAS", true,
                11, "Error sintáctico {}: Declarción incompleta, se espera la palabra reservada \"\\compas\" antes de \"=\" [#,%]");

        gramatica.group("DECLARACION_COMPAS", "TOKEN_COMPAS", true,
                12, "Error sintáctico {}: Declaración de compas incompleta [#,%]");

        /* DECLARACIÓN TEMPO--------------------------------------------------*/
        gramatica.group("DECLARACION_TEMPO", "TOKEN_TEMPO TOKEN_ASIGNACION COMPAS_ERROR", true);
        // ERRORES DECLARACION TEMPO
        gramatica.group("DECLARACION_TEMPO", "TOKEN_TEMPO TOKEN_ASIGNACION", true,
                13, "Error sintáctico {}: Declarción incompleta, falta especificar el tempo [#,%]");

        gramatica.group("DECLARACION_TEMPO", "TOKEN_TEMPO COMPAS_ERROR", true,
                14, "Error sintáctico {}: Declarción incompleta, se espera simbolo de asignación (=) [#,%]");

        gramatica.group("DECLARACION_TEMPO", "TOKEN_ASIGNACION COMPAS_ERROR", true,
                15, "Error sintáctico {}: Declarción incompleta, se espera la palabra reservada \"\\tempo\" antes de \"=\" [#,%]");

        gramatica.group("DECLARACION_TEMPO", "TOKEN_TEMPO", true,
                16, "Error sintáctico {}: Declaración de tempo incompleta [#,%]");

        /*DECLARACION FIGURA CON NOTA-----------------------------------------*/
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("DECLARACION_FIGURANOTA", "(FIGURA TOKEN_APERTURA TOKEN_NOTA TOKEN_CIERRE)+");
        });
        /*ERRORES DECLARACION NOTAS*/
        gramatica.group("DECLARACION_FIGURANOTA", "FIGURA TOKEN_APERTURA TOKEN_NOTA", true,
                17, "Error sintáctico {}: Se espera una declaracion de cierre \"}\" para la nota [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "FIGURA TOKEN_NOTA TOKEN_CIERRE", true,
                18, "Error sintáctico {}: Se espera una declaracion de apertura \"{\" para la nota [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "FIGURA TOKEN_APERTURA TOKEN_CIERRE", true,
                19, "Error sintáctico {}: Se espera una nota (Ej. A4) [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "FIGURA TOKEN_NOTA", true,
                20, "Error sintáctico {}: Se espera que el valor de nota se encuentre entre llaves (\"{}\") [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "TOKEN_APERTURA TOKEN_NOTA TOKEN_CIERRE", true,
                21, "Error sintáctico {}: No se ha especificado un a figura [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "FIGURA TOKEN_APERTURA", true,
                22, "Error sintáctico {}: Declaracion incompleta, hace falta un valor de nota (Ej. A4) y un cierre \"}\" [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "TOKEN_APERTURA TOKEN_NOTA", true,
                23, "Error sintáctico {}: Se un valor de figura, y un valor de cierre \"}\" [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "TOKEN_NOTA TOKEN_CIERRE", true,
                24, "Error sintáctico {}: Se espera un valor de figura, y un valor de apertura \"{\" [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "FIGURA TOKEN_CIERRE", true,
                25, "Error sintáctico {}: Declaracion incompleta, hace falta un valor de apertura \"{\" y una nota (Ej. A4) [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "TOKEN_APERTURA TOKEN_CIERRE", true,
                26, "Error sintáctico {}: Declaracion incompleta, hace falta un valor de figura y una nota (Ej. A4) [#,%]");

        /*DECLARACION BLOQUE DE COMPASES*/
        gramatica.group("BLOQUE_COMPASES", "TOKEN_INICIO_PARTITURA DECLARACION_FIGURANOTA TOKEN_FINAL_PARTITURA", true);
        //ERROR DECLARACION BLOQUE DE COMPASES
        gramatica.finalLineColumn();
        gramatica.group("BLOQUE_COMPASES", "TOKEN_INICIO_PARTITURA DECLARACION_FIGURANOTA", true,
                27, "Error sintáctico {}: Declaracion incompleta, final de la partitura no encontrada (\\final))[#,%]");
        
        gramatica.initialLineColumn();
        gramatica.group("BLOQUE_COMPASES", "DECLARACION_FIGURANOTA TOKEN_FINAL_PARTITURA", true,
                28, "Error sintáctico {]: Declaracion incompleta, inicio de la partitura no encontrada (\\inicio()[#,%]");

        gramatica.group("BLOQUE_COMPASES", "TOKEN_INICIO_PARTITURA TOKEN_FINAL_PARTITURA", true,
                29, "Advertencia: No hay notas en el bloque de partitura [#,%]");

        gramatica.group("DECLARACION_FIGURANOTA", "DECLARACION_FIGURANOTA", true,
                30, "Error sintáctico #: Declaracion incompleta, hace falta una declaracion de inicio y una declaracion de final en antes y despues del bloque de partitura [#,%]");
        /* Mostrar gramáticas */
 /*TOKENS FUERA DE CONTEXTO*/
        gramatica.show();
    }

    private void colores() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void rellenarTablaTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{id(token.getLexicalComp()), token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    public String id(String n) {
        if (n.equals("TOKEN_DIGITO")) {
            return "1";
        }
        if (n.equals("TOKEN_NOTA")) {
            return "2";
        }
        if (n.equals("TOKEN_CLAVE")) {
            return "3";
        }
        if (n.equals("TOKEN_COMPAS")) {
            return "4";
        }
        if (n.equals("TOKEN_TEMPO")) {
            return "5";
        }
        if (n.equals("TOKEN_INICIO_PARTITURA")) {
            return "6";
        }
        if (n.equals("TOKEN_FINAL_PARTITURA")) {
            return "7";
        }
        if (n.equals("TOKEN_REDONDA")) {
            return "8";
        }
        if (n.equals("TOKEN_BLANCA")) {
            return "9";
        }
        if (n.equals("TOKEN_NEGRA")) {
            return "10";
        }
        if (n.equals("TOKEN_CORCHEA")) {
            return "11";
        }
        if (n.equals("TOKEN_SEMICORCHEA")) {
            return "12";
        }
        if (n.equals("TOKEN_FUSA")) {
            return "13";
        }
        if (n.equals("TOKEN_SEMIFUSA")) {
            return "14";
        }
        if (n.equals("TOKEN_SILENCIO_REDONDA")) {
            return "15";
        }
        if (n.equals("TOKEN_SILENCIO_BLANCA")) {
            return "16";
        }
        if (n.equals("TOKEN_SILENCIO_NEGRA")) {
            return "17";
        }
        if (n.equals("TOKEN_SILENCIO_CORCHEA")) {
            return "18";
        }
        if (n.equals("TOKEN_SILENCIO_SEMICORCHEA")) {
            return "19";
        }
        if (n.equals("TOKEN_SILENCIO_FUSA")) {
            return "20";
        }
        if (n.equals("TOKEN_SILENCIO_SEMIFUSA")) {
            return "21";
        }
        if (n.equals("TOKEN_PUNTILLO")) {
            return "22";
        }
        if (n.equals("TOKEN_SOSTENIDO")) {
            return "23";
        }
        if (n.equals("TOKEN_BEMOL")) {
            return "24";
        }
        if (n.equals("TOKEN_DIVISOR_TEMPO")) {
            return "25";
        }
        if (n.equals("TOKEN_DIVISOR_COMPAS")) {
            return "26";
        }
        if (n.equals("TOKEN_APERTURA")) {
            return "27";
        }
        if (n.equals("TOKEN_CIERRE")) {
            return "28";
        }
        if (n.equals("TOKEN_ASIGNACION")) {
            return "29";
        }
        if (n.equals("TOKEN_SEPARACION_COMPAS")) {
            return "30";
        }
        if (n.equals("TOKEN_DEFINE_CLAVE")) {
            return "31";
        }
        return "";
    }

    private void mostrarConsola() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void limpiarCampos() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JLabel lblALex;
    private javax.swing.JLabel lblASin;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
