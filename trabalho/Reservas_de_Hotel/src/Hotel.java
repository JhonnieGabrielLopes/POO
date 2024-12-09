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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean control=true;
        String tempCPF;
        do{
            System.out.println(" >> REALIZAR RESERVA - HOTEL JAVA << ");
            System.out.println("------------------------------------------------------");
            System.out.println("VAMOS FAZER A SUA RESERVA. PREENCHA OS CAMPOS ABAIXO:");
            System.out.print("CPF: ");
            tempCPF=in.nextLine();
            control=false;
            if (!(tempCPF.length()==11||tempCPF.length()==14)) {
                System.out.println("\nCPF DIGITADO ERRADO OU INVÁLIDO! INSIRA NOVAMENTE.");
                control=true;
                System.out.print("\nENTER...");
                in.nextLine();
                Limpar_terminal.limpar();
            }
        }while(control);
        
        System.out.print("ENDEREÇO: ");
        String tempEND=in.nextLine();
        System.out.print("TELEFONE PARA CONTATO: ");
        String tempTEL=in.nextLine();
        LocalDate verifDataReserva=null;
        String dataReservain=null;
        do{
            try {
                System.out.print("DATA PARA RESERVA: (dd/MM/aaaa): ");
                dataReservain=in.nextLine(); // data da reserva, esse valor que será adicionado no objeto reserva
                verifDataReserva=LocalDate.parse(dataReservain, formatter); // data formatada, será usada para verificar disponibilidade de quartos.
                control=false;
            } catch (Exception e) {
                System.out.println("\nENTRADA OU DATA INVÁLIDA, TENTE NOVAMENTE.\n");
                control=true;
            }
        }while(control);
        int diasReserva=0;
        do{
            System.out.print("QUANTOS DIAS DE RESERVA: ");
            try {
                diasReserva=in.nextInt();
                in.nextLine();
                control=false;
            } catch (Exception e) {
                in.nextLine();
                System.out.println("ENTRADA INVÁLIDA, DEVE SER UM NÚMERO INTEIRO.");
                System.out.print("ENTER...");
                in.nextLine();
                control=true;
                Limpar_terminal.limpar();
            }
        }while(control);
        
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
                    if (!(dataFimReserva.isBefore(temp2)||verifDataReserva.isAfter(temp3))) { // verifica se está ocupado em uma outra reserva
                        disponivel=false;
                        break;
                    }
                }
            }
            if (disponivel) {
                System.out.println("    ["+(temp.getNumeroQuarto())+"] VALOR DIÁRIO: R$"+temp.getValorDiaria()+"0\n");
            }
        }
        int tempQuartoIN=0;
        Quarto tempQuarto = new Quarto(0, 0);
        boolean control2;
        do{
            do{
                System.out.print("QUANTOS DIAS DE RESERVA: ");
                try {
                    System.out.print("    > ");
                    tempQuartoIN=in.nextInt();
                    in.nextLine();
                    control=false;
                } catch (Exception e) {
                    System.out.println("ENTRADA INVÁLIDA, DEVE SER UM NÚMERO INTEIRO.");
                    System.out.print("ENTER...");
                    in.nextLine();
                    control=true;
                    Limpar_terminal.limpar();
                }
            }while(control);
            control2=true;
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
                    System.out.println("\nOPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
                    System.out.println("-------------------------------------------");
                    System.out.print("ENTER...");
                    in.nextLine();
                    control2=false;
                    Limpar_terminal.limpar();
                    break;
            }
        }while(!control2);
        reserva.add(new Reserva(tempQuarto, (new Hospede(tempCPF, tempEND, tempTEL)), diasReserva, dataReservain));
        System.out.println("\n------------------------------------------");
        System.out.println(" >> RESERVA CADASTRADA COM SUCESSO <<");
        System.out.println("------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void cancelarReserva(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        boolean teste=true, control=true;
        int numQuarto=0;
        do{
            System.out.println(" >> CANCELAR RESERVA - HOTEL JAVA  <<");
            System.out.println("------------------------------------------");
            System.out.print("NÚMERO DO QUARTO: ");
            try {
                numQuarto=in.nextInt();
                in.nextLine();
                control=false;
            } catch (Exception e) {
                System.out.println("ENTRADA INVÁLIDA, DEVE SER UM NÚMERO INTEIRO.");
                System.out.print("ENTER...");
                in.nextLine();
                control=true;
                Limpar_terminal.limpar();
            }
        }while(control);

        System.out.print("DATA DA RESERVA: ");
        String dataReservaCancelar=in.nextLine();
        
        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            if (temp.getQuarto().getNumeroQuarto()==numQuarto&&temp.getDataReserva().equals(dataReservaCancelar)) {
                reserva.remove(temp);
                System.out.println("\n---------------------------------------------------");
                System.out.println(" >> RESERVA REMOVIDA COM SUCESSO <<");
                teste=false;
                break;
            }
        }
        if (teste) {
            System.out.println("NÃO HÁ RESERVAS PARA ESTE QUARTO NA DATA FORNECIDA");
        }
        System.out.println("---------------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void consultarReserva(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        boolean teste=true, control=true;
        String tempCPF;
        System.out.println(" >> CONSULTAR RESERVA - HOTEL JAVA <<");
        System.out.println("------------------------------------------");
        do{
            System.out.print("DIGITE O CPF: ");
            tempCPF=in.nextLine();
            control=false;
            if (!(tempCPF.length()==11||tempCPF.length()==14)) {
                System.out.println("CPF DIGITADO ERRADO OU INVÁLIDO! INSIRA NOVAMENTE.");
                control=true;
            }
        }while(control);

        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            if (tempCPF.equals(temp.getHospede().getCpf())) {
                System.out.println("\n------------------------------------------");
                System.out.println("RESERVA");
                System.out.println("------------------------------------------");
                System.out.println("QUARTO: "+temp.getQuarto().getNumeroQuarto());
                System.out.println("VALOR DIÁRIO: R$"+temp.getQuarto().getValorDiaria());
                System.out.println("RESERVADA ATIVA A PARTIR DE: "+temp.getDataReserva()+" POR "+temp.getNumeroDias()+" DIAS");
                System.out.println("------------------------------------------");
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
        double receitaHotel=0;
        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            receitaHotel+=(temp.getQuarto().getValorDiaria()*temp.getNumeroDias());
        }
        System.out.println("-------------------------------------------");
        System.out.println(" >> RECEITA TOTAL - HOTEL JAVA <<");
        System.out.println("-------------------------------------------");
        System.out.println("RECEITA CALCULADA: R$"+String.format("%.2f", receitaHotel));
        System.out.println("------------------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void verificarTodasReservas(ArrayList<Reserva> reserva, Iterator<Reserva> iter, Scanner in){
        System.out.println("------------------------------------------");
        System.out.println(" >> RESERVAS ATIVAS - HOTEL JAVA <<");
        iter=reserva.iterator();
        while (iter.hasNext()) {
            Reserva temp=iter.next();
            System.out.println("------------------------------------------");
            System.out.println("QUARTO: "+temp.getQuarto().getNumeroQuarto());
            System.out.println("RESERVADA ATIVA A PARTIR DE: "+temp.getDataReserva()+" POR "+temp.getNumeroDias()+" DIAS");
        }
        System.out.println("------------------------------------------");
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
                        mtd.receitaTotal(reserva, iter, in);
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