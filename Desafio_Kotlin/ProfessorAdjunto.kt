package Desafio_Kotlin

class ProfessorAdjunto(val horasMonitoria:Int = 0,
                       nomeProfessor: String,
                       sobrenomeProfessor: String,
                       tempoCasa: Int = 0,
                       codigoProfessor: Int
): Professor(nomeProfessor, sobrenomeProfessor, tempoCasa, codigoProfessor) {
}