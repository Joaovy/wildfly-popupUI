package br.com.sankhya.ui;

import javax.swing.*;
import java.awt.*;

public class WildFlyUi {

    private final JFrame frame;
    private final JPanel mainPanel;

    public WildFlyUi() {
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
        JPanel pathPanel = new JPanel(new BorderLayout());
        pathPanel.setMaximumSize(new Dimension(460, 30));
        pathPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Campo de texto para o caminho do Wildfly
        JTextField pathField = new JTextField();

        // Define o tamanho preferido para exibição (largura x altura)
        pathField.setPreferredSize(new Dimension(300, 30));

        // Define o tamanho máximo para impedir que ele ultrapasse os limites do painel
        pathField.setMaximumSize(new Dimension(300, 30));

        // Painel interno apenas para aplicar margem ao redor do JTextField
        JPanel textFieldWrapper = new JPanel(new BorderLayout());
        textFieldWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        textFieldWrapper.add(pathField, BorderLayout.CENTER); //Campo vai ocupar o centro do painel interno

        // Botão de "Procurar"
        JButton browseButton = createRoundedButton("Procurar...");
        browseButton.setPreferredSize(new Dimension(100, 30));

        // Junta os dois componentes: campo no centro, botão à direita
        pathPanel.add(textFieldWrapper, BorderLayout.CENTER);
        pathPanel.add(browseButton, BorderLayout.EAST);

        // Adiciona ao painel principal
        mainPanel.add(pathPanel);
        mainPanel.add(Box.createVerticalStrut(25));
    }



    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 13, 9)); // espaçamento horizontal dos botões
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        buttonPanel.setAlignmentX(Component.TOP_ALIGNMENT); // Alinha os botões ao topo do painel

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
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true)); // arredondamento
        return button;
    }

}
