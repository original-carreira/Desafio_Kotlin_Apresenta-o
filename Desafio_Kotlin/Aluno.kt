package Desafio_Kotlin

class Aluno(val nomeAluno:String,val sobrenome:String,val codigoAluno:Int) {

    override fun equals(other: Any?): Boolean {
        return (other is Aluno && other.codigoAluno == this.codigoAluno)
    }

    override fun hashCode(): Int {
        return this.codigoAluno
    }

    override fun toString(): String {
        return "Nome do Aluno $nomeAluno $sobrenome, Codigo fo aluno $codigoAluno "
    }
}