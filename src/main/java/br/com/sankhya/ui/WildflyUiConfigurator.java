package br.com.sankhya.ui;

import javax.swing.*;
import java.awt.*;

public class WildflyUiConfigurator {

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField pathField;
    private JButton browseButton;
    private JButton cancelButton;
    private JButton saveButton;

    public WildflyUiConfigurator() {
    }

    public static void open(){
        if(GraphicsEnvironment.isHeadless()){ // Verifica se o ambiente é headless
            System.out.println("A interface gráfica não pode ser exibida em um ambiente headless.");
            return;
        }

        // padrão sigleton controlado por metodo estático
        WildflyUiConfigurator configurator = new WildflyUiConfigurator(); // Cria uma instancia da classe
        configurator.initialize();
    }

    private void initialize(){

        frame = new JFrame("Configuração do Wildfly");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(490, 360); // Aumentando o tamanho da janela
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        addTexts(); // Adiciona os textos
        addPathField(); // Campo de texto + botão "Procurar..."
        addButtons();  // Botões "Cancelar" e "Salvar"

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private void addTexts() {
        JLabel label1 = new JLabel("Não encontramos um Wildfly configurado!");
        JLabel label2 = new JLabel("<html><div style='width:320px;'>"
                + "Este caminho é configurado via Sanklipse, mas aqui também nós conseguimos salvar "
                + "essa configuração para ser utilizada nos próximos builds de todos os projetos."
                + "</div></html>");
        JLabel label3 = new JLabel("<html><div style='width:320px;'>"
                + "Por favor, informe o caminho do seu Wildfly que iremos salvar a configuração:"
                + "</div></html>");


        label1.setAlignmentX(Component.LEFT_ALIGNMENT);
        label2.setAlignmentX(Component.LEFT_ALIGNMENT);
        label3.setAlignmentX(Component.LEFT_ALIGNMENT);

        label2.setMaximumSize(new Dimension(460, Integer.MAX_VALUE));
        label3.setMaximumSize(new Dimension(460, Integer.MAX_VALUE));

        mainPanel.add(label1);
        mainPanel.add(Box.createVerticalStrut(2)); // Espaço entre label1 e label2
        mainPanel.add(label2);
        mainPanel.add(Box.createVerticalStrut(0)); // Espaço entre label2 e label3
        mainPanel.add(label3);
        mainPanel.add(Box.createVerticalStrut(5)); // Espaço após o texto até o campo
    }

    private void addPathField() {
        pathField = new JTextField();
        JPanel pathPanel = new JPanel(new BorderLayout());
        pathPanel.setMaximumSize(new Dimension(460, 30));
        pathPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField pathField = new JTextField();

        pathField.setPreferredSize(new Dimension(300, 30));

        pathField.setMaximumSize(new Dimension(300, 30));

        JPanel textFieldWrapper = new JPanel(new BorderLayout());
        textFieldWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        textFieldWrapper.add(pathField, BorderLayout.CENTER); //Campo vai ocupar o centro do painel interno

        JButton browseButton = createRoundedButton("Procurar...");
        browseButton.setPreferredSize(new Dimension(100, 30));

        pathPanel.add(textFieldWrapper, BorderLayout.CENTER);
        pathPanel.add(browseButton, BorderLayout.EAST);

        mainPanel.add(pathPanel);
        mainPanel.add(Box.createVerticalStrut(25));
    }


    private void addButtons() {

        cancelButton = createRoundedButton("Cancelar");
        saveButton = createRoundedButton("Salvar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 13, 9));
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        buttonPanel.setAlignmentX(Component.TOP_ALIGNMENT);

        JButton cancelButton = createRoundedButton("Cancelar");
        JButton saveButton = createRoundedButton("Salvar");

        cancelButton.setPreferredSize(new Dimension(100, 30));
        saveButton.setPreferredSize(new Dimension(100, 30));

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        mainPanel.add(buttonPanel);

        addHoverEffect(cancelButton, new Color(239, 181, 181)); // Vermelho
        addHoverEffect(saveButton, new Color(189, 230, 189));   // Verde
    }



    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(240, 240, 240));
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        return button;
    }

    // efeito simples visual de hover nos botões
    private void addHoverEffect(JButton button, Color hoverColor) {
        Color originalColor = button.getBackground();

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }



}
