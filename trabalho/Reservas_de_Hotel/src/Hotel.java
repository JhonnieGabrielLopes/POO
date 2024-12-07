import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Hotel {
    public void Opcoes(){
        System.out.println(" >> MENU DE OPÇÕES - HOTEL JAVA << ");
        System.out.println("------------------------------------------");
        System.out.println(" > [1].ADICIONAR RESERVA");
        System.out.println(" > [2].CANCELAR RESERVA");
        System.out.println(" > [3].BUSCAR RESERVA");
        System.out.println(" > [4].RECEITA TOTAL DO HOTEL");
        System.out.println(" > [5].RESERVAS ATIVAS");
        System.out.println(" > [6].SAIR");
        System.out.println("------------------------------------------");
    }
    public void fazerReserva(ArrayList<Reserva> reserva, ArrayList<Quarto> quartos, Iterator<Quarto> iterQuartos, Iterator<Reserva> iter, Scanner in){
        //Variáveis temporárias - tempCPF: para pegar cpf, tempEND: para endereço do usuário e tempTEL: para telefone
        //Variáveis temporárias - temp: para número do quarto, temp1: para puxar reserva, temp2: para a data da reserva e temp3: para o números de dias reservados
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //
        System.out.println(" >> REALIZAR RESERVA - HOTEL JAVA << ");
        System.out.println("------------------------------------------------------");
        System.out.println("VAMOS FAZER A SUA RESERVA. PREENCHA OS CAMPOS ABAIXO:");
        System.out.print("CPF: ");
        String tempCPF=in.nextLine();
        System.out.print("ENDEREÇO: ");
        String tempEND=in.nextLine();
        System.out.print("TELEFONE PARA CONTATO: ");
        String tempTEL=in.nextLine();
        System.out.print("DATA PARA RESERVA: (dd/MM/aaaa): ");
        String dataReservain=in.nextLine(); // data da reserva, esse valor que será adicionado no objeto reserva
        LocalDate verifDataReserva=LocalDate.parse(dataReservain, formatter); // data formatada, será usada para verificar disponibilidade de quartos.
        System.out.print("QUANTOS DIAS DE RESERVA: ");
        int diasReserva=in.nextInt();
        LocalDate dataFimReserva=verifDataReserva.plusDays(diasReserva);
        System.out.println("------------------------------------------");
        System.out.println("ESCOLHA UM QUARTO ENTRE OS DISPONÍVEIS:\n");
            Reserva temp1;
            Quarto temp;
            iterQuartos=quartos.iterator();
            while (iterQuartos.hasNext()) {
                boolean disponivel=true;
                temp=iterQuartos.next();
                iter=reserva.iterator();
                while (iter.hasNext()) {
                    temp1=iter.next();
                    LocalDate temp2=LocalDate.parse(temp1.getDataReserva(),formatter); // pega a data da reserva
                    LocalDate temp3=temp2.plusDays(temp1.getNumeroDias()); // pega a data do fim da reserva
                    if (temp1.getQuarto().getNumeroQuarto()==temp.getNumeroQuarto()) {
                        if (!(dataFimReserva.isBefore(temp2)||verifDataReserva.isAfter(temp3))) {
                            disponivel=false;
                            break;
                        }
                    }
                }
                if (disponivel) {
                    System.out.println("    ["+(temp.getNumeroQuarto())+"] VALOR DIÁRIO: R$"+temp.getValorDiaria()+"0\n");
                }
            }
        System.out.print("    > ");
        int tempQuartoIN=in.nextInt();
        in.nextLine();
        Quarto tempQuarto = new Quarto(0, 0);
        switch (tempQuartoIN) {
            case 101:
                tempQuarto=quartos.get(0);
                break;
            case 102:
                tempQuarto=quartos.get(1);
                break;
            case 201:
                tempQuarto=quartos.get(2);
                break;
            case 202:
                tempQuarto=quartos.get(3);
                break;
            default:
                break;
        }
        reserva.add(new Reserva(tempQuarto, (new Hospede(tempCPF, tempEND, tempTEL)), diasReserva, dataReservain));
        System.out.println("\n------------------------------------------");
        System.out.println(" >> RESERVA CADASTRADA COM SUCESSO <<");
        System.out.println("------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void cancelarReserva(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        boolean teste=true;
        System.out.println(" >> CANCELAR RESERVA - HOTEL JAVA  <<");
        System.out.println("------------------------------------------");
        System.out.print("NÚMERO DO QUARTO: ");
        int numQuarto=in.nextInt();
        in.nextLine();
        System.out.print("DATA DA RESERVA: ");
        String dataReservaCancelar=in.nextLine();
        
        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            if (temp.getQuarto().getNumeroQuarto()==numQuarto&&temp.getDataReserva().equals(dataReservaCancelar)) {
                reserva.remove(temp);
                System.out.println("\n------------------------------------------");
                System.out.println(" >> RESERVA REMOVIDA COM SUCESSO <<");
                teste=false;
                break;
            }
        }
        if (teste) {
            System.out.println("NÃO HÁ RESERVAS PARA ESTE QUARTO NA DATA FORNECIDA");
        }
        System.out.println("------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void consultarReserva(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        boolean teste=true;
        System.out.println(" >> CONSULTAR RESERVA - HOTEL JAVA <<");
        System.out.println("------------------------------------------");
        System.out.print("DIGITE O CPF: ");
        String tempCPF=in.nextLine();
        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            if (tempCPF.equals(temp.getHospede().getCpf())) {
                System.out.println("\n------------------------------------------");
                System.out.println("INFORMAÇÕES DA RESERVA");
                System.out.println("------------------------------------------");
                System.out.println("QUARTO: "+temp.getQuarto().getNumeroQuarto());
                System.out.println("VALOR DIÁRIO: R$"+temp.getQuarto().getValorDiaria());
                System.out.println("RESERVADA ATIVA A PARTIR DE: "+temp.getDataReserva()+" POR "+temp.getNumeroDias()+" DIAS");
                System.out.println("------------------------------------------");
                System.out.println("INFORMAÇÕES ADICIONAIS");
                System.out.println("------------------------------------------");
                System.out.println("CPF: "+temp.getHospede().getCpf());
                System.out.println("ENDEREÇO: "+temp.getHospede().getEndereco());
                System.out.println("TELEFONE DE CONTATO: "+temp.getHospede().getTelefone());
                teste=false;
            }
        }
        if (teste) {
            System.out.println("NÃO HÁ RESERVAS ATIVAS PARA "+tempCPF);
        }
        System.out.println("------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void receitaTotal(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        iter=reserva.iterator();
        
    }
    public void verificarTodasReservas(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        System.out.println("------------------------------------------------");
        System.out.println(" >> RESERVAS ATIVAS - HOTEL JAVA <<");
        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            System.out.println("-----------------------------------------------");
            System.out.println("QUARTO: "+temp.getQuarto().getNumeroQuarto());
            System.out.println("RESERVADA ATIVA A PARTIR DE: "+temp.getDataReserva()+" POR "+temp.getNumeroDias()+" DIAS");
        }
        System.out.println("------------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public static void main(String[] args) throws Exception {
        Limpar_terminal.limpar();
        //Inicialização
        Scanner in = new Scanner(System.in);
        Hotel mtd = new Hotel();
        ArrayList<Reserva> reserva = new ArrayList<>();
        Iterator<Reserva> iter = reserva.iterator();
        ArrayList<Quarto> quartos = new ArrayList<>();
        Iterator<Quarto> iterQuartos = quartos.iterator();
        //Variáveis menu
        int opc=0;
        boolean control=true;
        //Quartos disponíveis
        quartos.add(new Quarto(101, 100.00));
        quartos.add(new Quarto(102, 100.00));
        quartos.add(new Quarto(201, 120.00));
        quartos.add(new Quarto(202, 120.00));
        //Opções
        do {
            do {
                try {
                    mtd.Opcoes();
                    System.out.print(" > ");
                    opc=in.nextInt();
                    in.nextLine();
                    control=false;
                } catch (Exception e) {
                    in.nextLine();
                    System.out.println("\nDigite uma entrada válida!");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    control=true;
                }
            } while (control);
            switch (opc) {
                case 1:
                    Limpar_terminal.limpar();
                    mtd.fazerReserva(reserva, quartos, iterQuartos, iter, in);
                    break;
                case 2:
                    if (!reserva.isEmpty()) {
                        Limpar_terminal.limpar();
                        mtd.cancelarReserva(reserva, iter, in);
                    }else{
                        System.out.println("\n >> NENHUMA RESERVA ATIVA\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 3:
                    if (!reserva.isEmpty()) {
                        Limpar_terminal.limpar();
                        mtd.consultarReserva(reserva, iter, in);
                    }else{
                        System.out.println("\n >> NENHUMA RESERVA ATIVA\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 4:
                    if (!reserva.isEmpty()) {
                        Limpar_terminal.limpar();
                    }else{
                        System.out.println("\n >> NENHUMA RESERVA ATIVA\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 5:
                    if (!reserva.isEmpty()) {
                        Limpar_terminal.limpar();
                        mtd.verificarTodasReservas(reserva, iter, in);                    
                    }else{
                        System.out.println("\nNENHUMA RESERVA ATIVA\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    System.out.println("-------------------------------------------");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    break;
            }
        } while (opc!=6);
        in.close();
    }
}
/*Desenvolva um programa para gerenciar reservas de um hotel. Implemente
as seguintes classes:
➔ Classe Quarto: Com numeroQuarto, valorDiaria
➔ Classe Hospede: Com atributos cpf, endereco e telefone.
➔ Classe Reserva: Com atributos quarto (objeto), hóspede (objeto) e
numeroDias e dataReserva.
➔ Classe Hotel: Utilize ArrayList para armazenar as reservas.
Implemente métodos para:
◆ Adicionar novas reservas(Verifique se o quarto já está
reservado naquela data).
◆ Cancelar uma reserva pelo número do quarto e dataReserva.
◆ Procurar todas as reservas de determinado CPF.
◆ Calcular a receita total do hotel.
◆ Listar todas as reservas ativas. */