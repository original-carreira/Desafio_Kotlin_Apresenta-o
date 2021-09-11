package Desafio_Kotlin

fun main (){
    val professor1 = ProfessorTitular("Matemática", "Valdemiro","Castello",codigoProfessor = 1001)
    val professor2 = ProfessorTitular("História", "manoel","Casagrande",codigoProfessor = 1002)
    val professor3 = ProfessorAdjunto(nomeProfessor = "Raimundo",sobrenomeProfessor = "Castelo",codigoProfessor = 1003)
    val professor4 = ProfessorAdjunto(nomeProfessor = "Raimundo",sobrenomeProfessor = "Siva",codigoProfessor = 1004)

    val aluno = Aluno("Bruno","Silva",10)
    val aluno2 = Aluno("José Amaro", "Crusoé",11)



}