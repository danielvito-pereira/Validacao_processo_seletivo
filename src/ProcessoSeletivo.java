import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos ={"Felipe", "Marcia "," Daniela ","Joao","Vitor"};
        for(String candidato:  candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentaivasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentaivasRealizadas++;
            }else{
                System.out.println("Contato Realizado com sucesso");
            }
        } while(continuarTentando && tentaivasRealizadas<3);

        if(atendeu){
            System.out.println("Conseguimos Contato com "+ candidato +" na " + tentaivasRealizadas);
        } else {
            System.out.println("Não conseguimos Contato com "+ candidato +" na " + tentaivasRealizadas);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    
    static void imprimirSelecionados(){
        String [] candidatos ={"Felipe", "Marcia "," Daniela ","Joao","Vitor"};
        System.out.println("Imprimindo a lista de candidatos informando o indice ");

        for (int indice= 0; indice < candidatos.length; indice++){
            System.out.println(" O candidato de n " + (indice+1) + " é o " + candidatos[indice]);
        }

        System.out.println(" Forma abreviada de interação for each ");

        for(String canditato: candidatos){
            System.out.println(" O canditato selecionado foi "+ candidatos);
        }
    }
    static void selecaoCandidatos(){
        String [] candidatos ={"Felipe", "Marcia "," Julia "," Paulo "," Monica"," Fabricio "," Mirela "," Daniela ","Joao","Vitor"};
        int candidatosSelecionados = 0;
        int candidatosAtual= 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println(" O Candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println(" O Candidato " + candidato + " foi selecionado para a vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
  /*   static void analisarCandidato(double salarioPretendido) {
        double salarioBase= 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println(" Ligar para o candidato. "+ "Salario Pretendido: "+ salarioPretendido);

        } else if(salarioBase == salarioPretendido) {
            System.out.println(" Ligar para candidato com contra proposta. " + "Salario Pretendido: "+salarioPretendido);
        } else {
            System.out.println(" Aguardando o resultado dos demais candidatos. "+"Salario Pretendido: " +salarioPretendido);
        }
    }*/
}
