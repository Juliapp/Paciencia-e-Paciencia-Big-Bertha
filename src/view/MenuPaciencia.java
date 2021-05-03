package view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import facade.Facade;
import model.Carta;


/**
 * 
 * Menu com as opções pro jogo de Paciência
 * 
 * @author Adlla Katarine e Daniel Alves
 * 
 */
public class MenuPaciencia {
    Scanner scan = new Scanner(System.in);
    Facade facade;
    int quantidadeCartasEstoque;//quantidade de cartas do estoque que o usuário quer ver/mover
    String separador = "\n-------------------------------------------------------------------------------------------------------------------------";
    
    public MenuPaciencia(int quantidadeBaralho) {
        facade = new Facade(quantidadeBaralho);
        exibirOpcoesPaciencia();
    }
    

    private void exibirOpcoesPaciencia(){
        boolean continuarJogar = true;//variável para saber se o usuário quer continuar a jogar ou retornar
        int opcao;//opção escolhida pelo usuário

        do{
            System.out.println(separador);
            exibirDadosJogo();
            System.out.println(separador);

            System.out.println("\nEscolha a próxima jogada.");
            System.out.println("[1] - Virar carta do estoque para descarte.\n"
                + "[2] - Virar carta da pilha de fileira.\n"
                + "[3] - Pedir dados da carta.\n"
                + "[4] - Mover cartas.\n"
                + "[5] - Iniciar jogo novamente.\n"
                + "[0] - Retornar ao menu anterior.");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Quantas cartas deseja virar?(1 ou 3)");
                    this.quantidadeCartasEstoque = scan.nextInt();
                    if(facade.qtdVirarCartasEstoque(quantidadeCartasEstoque)){
                        facade.mostrarCartas(facade.getEstoque().getCartasEstoque(), quantidadeCartasEstoque); 
                        facade.moverEstoqueParaDescarte(facade.getEstoque().getCartasEstoque(), facade.getDescarte().getCartasDescarte(), this.quantidadeCartasEstoque);
                    }
                    break;

                case 2:
                    System.out.println(separador);
                    imprimirFileiras(1);//imprimindo fileiras do jogo
                    System.out.println(separador);

                    System.out.print("Digite de qual fileira gostaria de virar a carta: \n");
                    opcao = scan.nextInt();
                    facade.mostrarCartas(facade.getFileiras().get(opcao-1).getCartasFileira(), 1); 
                    break;

                case 3:
                    System.out.print("Digite de qual pilha gostaria de ver dados da carta: \n");
                    opcao = scan.nextInt();
                    if(opcao <4){
                        System.out.println(separador);
                        System.out.println("Carta: " + facade.getFundacao().get(opcao-1).getCartasFundacao()); 
                        System.out.println(separador);
                    }else{
                        System.out.println(separador);
                        System.out.println("Carta: " + facade.getFileiras().get(opcao).getCartasFileira()); 
                        System.out.println(separador);
                    }//dados carta
                    break;

                case 4:
                    menuMoverCarta();
                    continuarJogar = !parabenizarJogoGanho();
                    break;

                case 5:
                    //reiniciar jogo
                    break;

                case 0:
                    continuarJogar = false;
                    break;

                default:
                    printOpcaoInvalida();
            }
        } while(continuarJogar);
    }


    /**
     * 
     * Função com opções para movimentação das cartas
     * 
     */
    private boolean menuMoverCarta(){
        boolean continuarJogar = true;//variável para saber se o usuário quer continuar a jogar ou retornar
        int opcao;
        int[] escolherPilha = new int[2]; //salvar fileiras para movimentação das cartas
        
        do{
            System.out.println(separador);
            exibirDadosJogo();
            System.out.println(separador);

            System.out.println("\nEscolha o próximo movimento da carta.");
            System.out.println("[1] - Mover a carta da pilha de descarte para uma das pilhas de fileiras.\n"
                    + "[2] - Mover a carta da pilha de descarte para uma das pilhas de fundação.\n"
                    + "[3] - Mover a carta da pilha de fileiras para uma das pilhas de fundação.\n"
                    + "[4] - Mover a carta da pilha de fundação para uma das pilhas de fileiras.\n"
                    + "[5] - Mover a carta da pilha de fileiras para outra pilha de fileiras.\n"
                    + "[6] - Mover a pilha de descarte para a pilha de estoque, caso esteja vazia.\n"
                    + "[0] - Retornar ao menu anterior.\n");
            
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(separador);
                    System.out.println("Carta do descarte: " + facade.getDescarte().getCartasDescarte().get(facade.getDescarte().getCartasDescarte().size() - 1));//imprimindo a carta que será movida do descarte
                    
                    imprimirFileiras(1);//imprimindo fileiras do jogo
                    System.out.println(separador);

                    System.out.println("\n\nDigite para qual fileira gostaria de mover a carta: ");
                    escolherPilha[0] = scan.nextInt();

                    //método pilha de descarte para fileiras
                    facade.moverCartaDescarteParaFileira(facade.getDescarte().getCartasDescarte(), facade.getFileiras().get(escolherPilha[0]-1).getCartasFileira());
                    continuarJogar = false;
                    break;

                case 2:
                    System.out.println(separador);
                    System.out.println("Carta do descarte: " + facade.getDescarte().getCartasDescarte().get(facade.getDescarte().getCartasDescarte().size() - 1));//imprimindo a carta que será movida do descarte

                    imprimirFundacoes(1);//imprimindo fundações do jogo
                    System.out.println(separador);

                    System.out.println("\n\nDigite para qual fundação gostaria de mover a carta: ");
                    escolherPilha[0] = scan.nextInt();

                    //método pilha de descarte para fundações
                    facade.moverCartaDescarteParaFundacao(facade.getDescarte().getCartasDescarte(), facade.getFundacao().get(escolherPilha[0]-1).getCartasFundacao());
                    continuarJogar = false;
                    break;

                case 3:
                    System.out.println(separador);
                    imprimirFileiras(1);//imprimindo fileiras do jogo
                    System.out.println(separador);
                    System.out.print("\nDigite de qual fileira gostaria de mover a carta: ");
                    escolherPilha[0] = scan.nextInt();

                    System.out.println(separador);
                    imprimirFundacoes(1);//imprimindo fundações do jogo
                    System.out.println(separador);
                    System.out.print("\nDigite para qual fundação gostaria de mover a carta: ");
                    escolherPilha[1] = scan.nextInt();

                    //método pilha de fileiras para fundações
                    facade.moverCartaFileiraParaFundacao(facade.getFileiras().get(escolherPilha[0]-1).getCartasFileira(), facade.getFundacao().get(escolherPilha[1]-1).getCartasFundacao());
                    continuarJogar = false;
                    break;

                case 4:
                    System.out.println(separador);
                    imprimirFundacoes(1);//imprimindo fundações do jogo
                    System.out.println(separador);
                    System.out.print("\nDigite de qual fundação gostaria de mover a carta: ");
                    escolherPilha[0] = scan.nextInt();
                    
                    System.out.println(separador);
                    imprimirFileiras(1);//imprimindo fileiras do jogo
                    System.out.println(separador);
                    System.out.print("\nDigite para qual fileira gostaria de mover a carta: ");
                    escolherPilha[1] = scan.nextInt();

                    //método pilha de fundação para fileiras
                    facade.moverCartaFundacaoParaFileira(facade.getFundacao().get(escolherPilha[0]-1).getCartasFundacao(), facade.getFileiras().get(escolherPilha[1]-1).getCartasFileira());
                    continuarJogar = false;
                    break;

                case 5:
                    System.out.println(separador);
                    imprimirFileiras(1);//imprimindo fileiras do jogo
                    System.out.println(separador);
                    System.out.print("\nDigite de qual fileira gostaria de mover a carta: ");
                    escolherPilha[0] = scan.nextInt();

                    imprimirCartasDisponiveis(facade.getFileiras().get(escolherPilha[0]-1).getCartasFileira());
                    System.out.println("\nDigite qual carta (ou a partir de qual) gostaria de mover: ");
                    int opcaoCartaEscolhida = scan.nextInt();
                    

                    System.out.print("\nDigite para qual fileira gostaria de mover a(s) carta(s): ");
                    escolherPilha[1] = scan.nextInt();

                    //método pilha de fileira para fileiras
                    facade.moverFileiraParaFileira(facade.getFileiras().get(escolherPilha[0]-1), facade.getFileiras().get(escolherPilha[1]-1), opcaoCartaEscolhida-1);
                    continuarJogar = false;
                    break;

                case 6:
                    facade.moverDescarteParaEstoque(facade.getDescarte(), facade.getEstoque());
                    //método pilha de descarte para estoque
                    continuarJogar = false;
                    break;
                
                case 0:
                    continuarJogar = false;
                    break;

                default:
                    printOpcaoInvalida();

             }
        } while(continuarJogar);
        return continuarJogar;
    }
    
    /**
     * 
     * Função para exibir os dados(montes) do jogo
     * 
     */
    private void exibirDadosJogo(){
        int opcao = 1;
        System.out.print("\n" +  " - ESTOQUE: ");
        imprimirCartas(facade.getEstoque().getCartasEstoque());//mostra o estoque do jogo
        System.out.print("\n" + " - DESCARTE: ");
        imprimirCartas(facade.getDescarte().getCartasDescarte());//cartas descartadas
        opcao = imprimirFundacoes(opcao++);
        imprimirFileiras(opcao);
    }

    /**
     * 
     * Função para imprimir as fundações do jogo
     * 
     * @param opcao posição da fileira
     * 
     */
    private int imprimirFundacoes(int opcao){
        for(int i=0; i<4; i++){
            System.out.print("\n" + opcao +  " - FUNDAÇÃO " +  (i+1) + ": ");
            imprimirCartas(facade.getFundacao().get(i).getCartasFundacao()); //cartas fundação i
            opcao++;
        } return opcao;
    }


    /**
     * 
     * Função para imprimir as fileiras do jogo
     * 
     * @param opcao posição da fileira
     * 
     */
    private int imprimirFileiras(int opcao){
        for (int i=0; i<7; i++) {
            System.out.print("\n" + opcao +  " - FILEIRA " +  (i+1) + ": ");
            imprimirCartas(facade.getFileiras().get(i).getCartasFileira());//cartas fileira i
            opcao++;
        } return opcao;
    }


    /**
     * 
     * Função para imprimir cartas da lista
     * 
     * @param cartas lista de cartas que serão exibidas
     * 
     */
    private void imprimirCartas(List<Carta> cartas){
        Iterator<Carta> it = cartas.iterator();
        
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    /**
     * 
     * Exibir cartas contidas na lista que estão viradas
     * 
     * @param cartas lista que deseja exibir
     * 
     */
    private void imprimirCartasDisponiveis(List<Carta> cartas){
        Iterator<Carta> it = cartas.iterator();
        int opcao = 1;

        while(it.hasNext()){
            Carta carta = it.next();
            if(carta.isVisivel()){
                System.out.println("\n" + opcao + " - " + carta);
            } opcao++;
        } 
    }

    /**
     * 
     * Parabeniza o jogador, caso ganhe.
     * 
     * @return true caso tenha ganhado o jogo
     * 
     */
    public boolean parabenizarJogoGanho(){
        if(facade.verificarJogoGanho()){
            imprimirFundacoes(1);
            System.out.println("\n" + "Parabéns!!! Você ganhou o jogo!");
            return true;
        } 
        return false;
    }

    /**
     * 
     * Função para informar que digitou uma opção invalida //transformar em exception
     * 
     */
    private void printOpcaoInvalida(){
        System.out.println("Você digitou uma opção inválida!!! Escolha uma das opções disponíveis.");
    }
}
