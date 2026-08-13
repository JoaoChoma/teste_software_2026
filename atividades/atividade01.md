# Elaborar o plano de teste e casos de teste para o produto


- Fazer em duplas 
- até dia 20/08

---

# Escopo do produto

- Salas possuem capacidades e recursos diferentes.
- Reservas têm data, horário, turma e responsável.
- Conflitos, manutenção e horário devem ser respeitados.
- Operações dependem do perfil do usuário.
- Alterações afetam notificações e histórico.

# RF

- RF-01 reservar sala disponível para turma compatível
- RF-02 impedir sobreposição na mesma sala
- RF-03 impedir turma maior que a capacidade
- RF-04 bloquear sala em manutenção
- RF-05 permitir reservas entre 07h30 e 22h30
- RF-06 só coordenação altera reserva de outro professor
- RF-07 cancelamento libera horário e registra histórico
- RF-08 alteração ou cancelamento gera notificação

# RNF

- RNF-01: busca responde em até 2 segundos.
- RNF-02: operações possuem trilha de auditoria.
- RNF-03: acesso limitado às unidades autorizadas.

# Riscos críticos
- Dupla ocupação, capacidade insegura, alteração sem autorização e falha de notificação.


# Plano de teste docx

https://github.com/JoaoChoma/teste_software_2026/blob/main/aulas/SEMANA%2002/docs/Plano%20de%20Teste.docx

# Caso de teste docx

https://github.com/JoaoChoma/teste_software_2026/blob/main/aulas/SEMANA%2002/docs/Caso%20de%20Teste.docx