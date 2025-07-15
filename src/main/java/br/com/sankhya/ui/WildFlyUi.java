package br.com.sankhya.ui;

import javax.swing.*;
import java.awt.*;

public class WildFlyUi {

    private final JFrame frame;
    private final JPanel mainPanel;

    public WildFlyUi() {
        frame = new JFrame("Configuração do Wildfly");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 360); // Ligeiramente aumentado
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 30));

        addTexts();
        addPathField();
        addButtons();

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private void addTexts() {
        JLabel label1 = new JLabel("Não encontramos um Wildfly configurado!");
        JLabel label2 = new JLabel("<html><div style='width:460px;'>"
                + "Este caminho é configurado via Sanklipse, mas aqui também nós conseguimos salvar "
                + "essa configuração para ser utilizada nos próximos builds de todos os projetos."
                + "</div></html>");
        JLabel label3 = new JLabel("<html><div style='width:460px;'>"
                + "Por favor, informe o caminho do seu Wildfly que iremos salvar a configuração:"
                + "</div></html>");

        label1.setAlignmentX(Component.LEFT_ALIGNMENT);
        label2.setAlignmentX(Component.LEFT_ALIGNMENT);
        label3.setAlignmentX(Component.LEFT_ALIGNMENT);

        label2.setMaximumSize(new Dimension(460, Integer.MAX_VALUE));
        label3.setMaximumSize(new Dimension(460, Integer.MAX_VALUE));

        mainPanel.add(label1);
        mainPanel.add(Box.createVerticalStrut(2));
        mainPanel.add(label2);
        mainPanel.add(Box.createVerticalStrut(2));
        mainPanel.add(label3);
        mainPanel.add(Box.createVerticalStrut(5)); 
    }

    private void addPathField() {
        JPanel pathPanel = new JPanel(new BorderLayout());
        pathPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // Novo painel para controlar a largura visível do JTextField
        JPanel textFieldWrapper = new JPanel(new BorderLayout());
        textFieldWrapper.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10)); // margem interna
        JTextField pathField = new JTextField();
        textFieldWrapper.add(pathField, BorderLayout.CENTER);

        JButton browseButton = createRoundedButton("Procurar...");
        browseButton.setPreferredSize(new Dimension(100, 30));

        pathPanel.add(textFieldWrapper, BorderLayout.CENTER);
        pathPanel.add(browseButton, BorderLayout.EAST);

        mainPanel.add(pathPanel);
        mainPanel.add(Box.createVerticalStrut(25));
    }


    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton cancelButton = createRoundedButton("Cancelar");
        JButton saveButton = createRoundedButton("Salvar");

        cancelButton.setPreferredSize(new Dimension(100, 30));
        saveButton.setPreferredSize(new Dimension(100, 30));

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        mainPanel.add(buttonPanel);
    }

    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(240, 240, 240));
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        return button;
    }

}
