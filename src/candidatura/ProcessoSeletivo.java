package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo{

    public static void main(String[] args) {

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for(String candidato:candidatos){

            entrarContato(candidato);
        }
    }

    static void entrarContato(String candidato) {
		
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu =   false;

		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
		
		
	}

    static boolean atender(){
    return new Random().nextInt(3)==1;

    }

    static void imprimirSelecionados(){

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento: ");

        for(int indice = 0; indice < candidatos.length; indice++){

            System.out.println("O candidato de nº: " + (indice+1) + " é o " + candidatos[indice]);

        }
    }

    static void selecaoCandidatos(){

        // Array com a lista de candidatos
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        
        while ( candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            
            System.out.println("O candidato "+ candidato + " solicitou este valor de salário: " + salarioPretendido);
            
            if(salarioPretendido > salarioBase){
                System.out.println("O candidadto " + candidato + " foi selecionado selecionado para a vaga.");
                candidatosSelecionados  ++;
            }

            else{
                System.out.println("O candidato " + candidato + " não foi selecionado.");
            }
            
            candidatoAtual++;

        }
    }
    
    // Método que simula o valor pretendido
    static double valorPretendido(){
     return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000.00;

        if(salarioBase > salarioPretendido){

            System.out.println("Ligar para o candidato.");
        }

        else if (salarioBase == salarioPretendido){

            System.out.println("Ligar para o candidato com contra proposta.");
        }

        else{

            System.out.println("Aguardando demais candidatos.");
        }

    }
}