package com.github.app.model.aluno;

// DTO utilizado para listar alunos com campos resumidos.
public record DadosListagemAluno(
    Integer id,
    String nome,
    String email,
    String ra,
    String curso
) {
    public DadosListagemAluno(Aluno aluno) {
        this(
            aluno.getId(),
            // aluno.getEmail(), // ERRO 4: deveria ser aluno.getNome()
            aluno.getNome(),  // ERRO 4: deveria ser aluno.getEmail()
            aluno.getEmail(),
            aluno.getRa(),
            aluno.getCurso()
        );
    }
}
