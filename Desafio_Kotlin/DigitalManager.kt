package Desafio_Kotlin

import java.util.*

class DigitalManager {

    class DigitalHouseManager {
        val listaProfessores:MutableSet<Professor> = mutableSetOf()
        val listaCursos: MutableSet<Curso> = mutableSetOf()
        val listaAlunos:MutableList<Aluno> = mutableListOf()
        val listaMatricula:MutableList<Matricula> = mutableListOf()
        val listaProfessoresAlocados = mutableSetOf<Map<Professor,Curso>>()


/*##################################################################################################################*/
/*                                  Função para adicionar objetos à lista de cursos                                 */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun registraCurso(nomeDoCurso: String, codigoDoCurso: Int, quantidaDeAlunosMax: Int){
            val cursoRegistrado = listaCursos.find { it.codigoCurso == codigoDoCurso}
            try {
                val cursoadd = when {
                    listaCursos.contains(cursoRegistrado) -> print("Este curso já está cadastrado")
                    listaCursos.contains(cursoRegistrado) -> listaCursos.add(Curso(codigoCurso = codigoDoCurso, nomeCurso = nomeDoCurso, quantidadeAlunoMax = quantidaDeAlunosMax))
                    else -> throw IllegalArgumentException ("Você digitou algo errado.Por favor verifique os dados de entrada")
                }
            } catch (e: IllegalArgumentException){
                println("Erro: ${e.message}")
            }
        }
/*##################################################################################################################*/
/*                                    Função para remover objetos da lista de cursos                                */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun removeCurso(codigoDoCurso: Int){
            val cursoRegistrado = listaCursos.find { it.codigoCurso == codigoDoCurso}

            try {
                if (listaCursos.contains(cursoRegistrado)){
                    listaCursos.remove(cursoRegistrado)
                }else{
                    throw IllegalArgumentException("Código de curso não encontrado")
                }
            }catch (e: Exception){
                println("Erro: ${e.message}")
            }
        }

/*##################################################################################################################*/
/*                                    Função para registrar professor adjunto                                       */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun registraProfessorAdjunto(nomeDoProfessor:String,sobrenomeDoProfessor: String,codigoDoProfessor:Int,horasMonitoria:Int){
            val professorRegistrado = listaProfessores.find { it.codigoProfessor == codigoDoProfessor }
            try {
                val professorAdjunto = when {
                    listaProfessores.contains(professorRegistrado) -> print("Este professor já está cadastrado")
                    !listaProfessores.contains(professorRegistrado) -> listaProfessores.add(ProfessorAdjunto(nomeProfessor = nomeDoProfessor,sobrenomeProfessor = sobrenomeDoProfessor,codigoProfessor = codigoDoProfessor,horasMonitoria = horasMonitoria))
                    else -> throw IllegalArgumentException ("Você digitou algo errado.Por favor verifique os dados de entrada")
                }
            } catch (e: IllegalArgumentException){
                println("Erro: ${e.message}")
            }

        }

/*##################################################################################################################*/
/*                                    Função para registrar professor titular                                       */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun registraProfessorTitular(nomeDoProfessor:String,sobrenomeDoProfessor: String,codigoDoProfessor:Int,especialidade:String){
            val professorRegistrado2 = listaProfessores.find { it.codigoProfessor == codigoDoProfessor }
            try {
                val professorTitular = when {
                    listaProfessores.contains(professorRegistrado2) -> print("Este professor já está cadastrado")
                    !listaProfessores.contains(professorRegistrado2) -> listaProfessores.add(ProfessorTitular(nomeProfessor = nomeDoProfessor,sobrenomeProfessor = sobrenomeDoProfessor,codigoProfessor = codigoDoProfessor,especialidade = especialidade))
                    else -> throw IllegalArgumentException ("Você digitou algo errado.Por favor verifique os dados de entrada")
                }
            } catch (e: IllegalArgumentException){
                println("Erro: ${e.message}")
            }

        }

/*##################################################################################################################*/
/*                                    Função para registrar um aluno                                                */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun registraAluno(nomeDoAluno:String,sobrenomeDoAluno:String,codigoDoAluno:Int){
            val alunoNovo = listaAlunos.find { it.codigoAluno == codigoDoAluno }
            try {
                val aluno = when {
                    listaAlunos.contains(alunoNovo) -> print("")
                    !listaAlunos.contains(alunoNovo) -> listaAlunos.add(Aluno(nomeAluno = nomeDoAluno,sobrenome = sobrenomeDoAluno,codigoAluno = codigoDoAluno))
                    else -> throw IllegalArgumentException("Você tentou registrar um aluno já cadastrado.Verifique seus dados de entrada!")
                }
            }catch (e: IllegalArgumentException){
                println("Erro: ${e.message}")
            }
        }

/*##################################################################################################################*/
/*                                    Função para excluir um professor                                              */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun removeProfessor(codigoDoProfessor: Int) {
            val professorRegistrado3 = listaProfessores.find { it.codigoProfessor == codigoDoProfessor }

            try {
                if (listaProfessores.contains(professorRegistrado3)) {
                    listaProfessores.remove(professorRegistrado3)
                } else {
                    throw IllegalArgumentException("Código do professor não encontrado")
                }
            } catch (e: Exception) {
                println("Erro: ${e.message}")
            }
        }

/*##################################################################################################################*/
/*                                    Função para matricular um aluno                                               */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun matriculaAluno(codigoDoAluno: Int,codigoDoCurso: Int) {
            val curso = listaCursos.find{ it.codigoCurso == codigoDoCurso}
            val aluno = listaAlunos.find { it.codigoAluno == codigoDoAluno }
            var contadorAlunoMatriculado = 0
            if (contadorAlunoMatriculado < curso!!.quantidadeAlunoMax){
                listaMatricula.add(Matricula(aluno = aluno, curso = curso, dataMatricula = Date()))
                contadorAlunoMatriculado += 1
            }else{
                println("Não foi possível efetivar a matrícula. Vagas esgotadas.")
            }
        }
/*##################################################################################################################*/
/*                                    Função para imprimir a lista de matriculados                                  */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun imprimeMAtricula(){
            listaMatricula.forEachIndexed { index, matricula -> println(" Matricula $index contém $matricula") }
        }


/*##################################################################################################################*/
/*                                    Função para alocar professor em um curso registrado                           */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun alocarProfessor(codigoDoCurso: Int,codigoDoProfessor: Int){
            require(codigoDoProfessor != 0,{"Erro: código do professor não pode ser zero"})
            val professorAlocar = listaProfessores.find { it.codigoProfessor == codigoDoProfessor }
            val cursoAlocar = listaCursos.find { it.codigoCurso == codigoDoCurso }
            val mapaAlocados = mutableMapOf<Professor,Curso>()
            if(professorAlocar != null && cursoAlocar != null){
                mapaAlocados.put(professorAlocar,cursoAlocar)
            }
        }
/*##################################################################################################################*/
/*                                    Função imprime lista de professores alocados                                  */
/*                                                                                                                  */
/*##################################################################################################################*/

        fun imprimeAlocados(){
            listaProfessoresAlocados.forEachIndexed{index, map -> println("Curso index $index contém $map")  }
        }

//  usando find para validar se o objeto com a propriedade especificada(código do curso) já foi adicionado à lista.
//  usando find para retorna o objeto com a propriedade especificada(código do curso).

    }
}