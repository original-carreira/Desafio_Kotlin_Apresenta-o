package Desafio_Kotlin

class Curso(val codigoCurso: Int,
            val nomeCurso: String,
            val quantidadeAlunoMax:Int,
            val alunosMatriculados: ArrayList<Aluno> = ArrayList<Aluno>(),
            val professorTitular: ProfessorTitular? = null,
            val professorAdjunto: ProfessorAdjunto? = null) {

    override fun equals(other: Any?): Boolean {
        return (other is Curso && other.codigoCurso == this.codigoCurso)
    }

    override fun hashCode(): Int {
        return this.codigoCurso
    }

    override fun toString(): String {
        return "Nome do  Curso $nomeCurso, Código do Curso $codigoCurso, Quantidade Máxima de Alunos $quantidadeAlunoMax "
    }
    fun addAlunoNoCurso(aluno: Aluno): Boolean {
        if (alunosMatriculados.size < quantidadeAlunoMax) {
            alunosMatriculados.add(aluno)
            return true
        } else{
            return  false
        }
    }

    fun removeAluno(aluno: Aluno):String{
        alunosMatriculados.remove(aluno)
        return "O Aluno $aluno foi removido do cadastro"
    }
}