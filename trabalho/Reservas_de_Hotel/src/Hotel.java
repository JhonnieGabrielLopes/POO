import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Hotel {
    public void Opcoes(){
        System.out.println(" >> Menu de Opções - HOTEL JAVA << ");
        System.out.println(" > [1].Adicionar reserva");
        System.out.println(" > [2].Cancelar reserva");
        System.out.println(" > [3].Buscar reservas");
        System.out.println(" > [4].Receita total do hotel");
        System.out.println(" > [5].Reservas ativas");
        System.out.println(" > [6].Sair");
    }
    public void fazerReserva(ArrayList<Reserva> reserva, ArrayList<Quarto> quartos, Iterator<Quarto> iterQuartos, Iterator<Reserva> iter, Scanner in){
        //Variáveis temporárias - tempCPF: para pegar cpf, tempEND: para endereço do usuário e tempTEL: para telefone
        //Variáveis temporárias - temp: para número do quarto, temp1: para puxar reserva, temp2: para a data da reserva e temp3: para o números de dias reservados
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //
        System.out.println(" >> Nova Reserva - HOTEL JAVA << ");
        System.out.println("Vamos fazer a sua reserva. Preencha os campos abaixo:");
        System.out.print("CPF: ");
        String tempCPF=in.nextLine();
        System.out.print("ENDEREÇO: ");
        String tempEND=in.nextLine();
        System.out.print("TELEFONE PARA CONTATO: ");
        String tempTEL=in.nextLine();
        System.out.print(" > Data para reserva (dd/MM/aaaa): ");
        String dataReservain=in.nextLine(); // data da reserva, esse valor que será adicionado no objeto reserva
        LocalDate verifDataReserva=LocalDate.parse(dataReservain, formatter); // data formatada, será usada para verificar disponibilidade de quartos.
        System.out.print(" > Quantos dias de reserva: ");
        int diasReserva=in.nextInt();
        LocalDate dataFimReserva=verifDataReserva.plusDays(diasReserva);
        System.out.println("Escolha um quarto entre os disponíveis:");
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
                    System.out.println("["+(temp.getNumeroQuarto())+"] Diária: R$"+temp.getValorDiaria()+"\n");
                }
            }
        int tempQuartoIN=in.nextInt();
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
                    Limpar_terminal.limpar();
                    break;
                case 3:
                    Limpar_terminal.limpar();
                    break;
                case 4:
                    Limpar_terminal.limpar();
                    break;
                case 5:
                    Limpar_terminal.limpar();
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