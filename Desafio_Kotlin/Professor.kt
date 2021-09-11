package Desafio_Kotlin

open class Professor (val nomeProfessor:String, val sobrenomeProfessor:String, val tempoCasa:Int? = 0, val codigoProfessor:Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Professor && other.codigoProfessor == this.codigoProfessor)
    }

    override fun hashCode(): Int {
        return this.codigoProfessor
    }
}
