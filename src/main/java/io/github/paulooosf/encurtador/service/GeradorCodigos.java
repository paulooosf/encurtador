package io.github.paulooosf.encurtador.service;

import java.util.Random;

public class GeradorCodigos {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TAMANHO = 6;

    public static String gerarCodigoAleatorio() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(TAMANHO);

        for (int i = 0; i < TAMANHO; i++) {
            int indice = random.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(indice));
        }

        return sb.toString();
    }
}
