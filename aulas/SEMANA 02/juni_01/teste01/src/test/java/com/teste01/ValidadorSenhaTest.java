package com.teste01;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    @Test
    @DisplayName("Senha nula é inválida")
    void deveRejeitarSenhaNula() {
        assertFalse(validador.ehValida(null));
    }

    // TODO: alunos acrescentam os casos para tamanho, maiúscula, número e espaço.
}
