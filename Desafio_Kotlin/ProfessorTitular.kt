package Desafio_Kotlin

class ProfessorTitular(val especialidade:String,
                       nomeProfessor: String,
                       sobrenomeProfessor: String,
                       tempoCasa: Int = 0,
                       codigoProfessor: Int
): Professor(nomeProfessor, sobrenomeProfessor, tempoCasa, codigoProfessor) {
}