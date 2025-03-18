import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        double monto;
        boolean estado = true;

        List<CuentaBancaria> listBanco = new ArrayList<>();

        do{
            System.out.println("""
                --------------------Menu------------------------
                | 1 | Crear cuenta                             |
                | 2 | Ver cuentas creadas                      |
                | 3 | Ver información de una cuenta especifica |
                | 4 | Depositar dinero                         |
                | 5 | Retirar dinero                           |
                | 6 | Salir                                    |
                ------------------------------------------------
                """);

            op= teclado.nextInt();
            teclado.nextLine();

            switch (op){
                case 1-> {

                    System.out.println("--------------------Crear cuenta--------------------");
                    System.out.println("Ingrese nombre del titular: ");
                    String titular = teclado.nextLine();
                    System.out.println("Ingrse saldo de la cuenta: ");
                    double saldo = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Ingrese numero de cuenta: ");
                    String numeroCuenta = teclado.nextLine();

                    listBanco.add(new CuentaBancaria(titular, saldo, numeroCuenta));

                }
                case 2-> {

                    System.out.println("--------------------Cuentas creadas--------------------");
                    if (listBanco.isEmpty()){
                        System.out.println("No hay cuentas registradas");
                    }else {
                        for (CuentaBancaria cu : listBanco){
                            System.out.println(cu);
                        }
                    }

                }
                case 3-> {

                    System.out.println("--------------------Información de una cuenta especifica--------------------");
                    System.out.println("Ingrese su número de cuenta");
                    String nCuenta = teclado.nextLine();
                    boolean encontrada = false;

                    for (CuentaBancaria cuenta : listBanco) {
                        if (cuenta.getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            System.out.println(cuenta);
                            encontrada = true;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Cuenta no encontrada");
                    }

                }
                case 4-> {

                    System.out.println("--------------------Depositar dinero--------------------");
                    System.out.println("Ingrese numero de cuenta: ");
                    String nCuenta = teclado.nextLine();
                    boolean encontrada = false;

                    for (int i = 0; i < listBanco.size(); i++) {
                        if (listBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            do {
                                System.out.println("Ingrese el monto a depositar: ");
                                monto = teclado.nextDouble();
                                if (monto > 0) {
                                    listBanco.get(i).depositarDinero(monto);
                                    System.out.println("Depósito exitoso. Nuevo saldo: " + listBanco.get(i).getSaldo());
                                } else {
                                    System.out.println("El monto debe ser positivo");
                                }
                            } while (monto <= 0);
                            encontrada = true;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Cuenta no encontrada");
                    }

                }
                case 5-> {

                    System.out.println("--------------------Retirar dinero--------------------");
                    System.out.println("Ingrese numero de cuenta: ");
                    String nCuenta = teclado.nextLine();
                    boolean encontrada = false;

                    for (int i = 0; i < listBanco.size(); i++) {
                        if (listBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            do {
                                System.out.println("Ingrese el monto a retirar: ");
                                monto = teclado.nextDouble();
                                if (monto > 0) {
                                    if (monto <= listBanco.get(i).getSaldo()) {
                                        listBanco.get(i).retirarDinero(monto);
                                        System.out.println("Retiro exitoso. Nuevo saldo: " + listBanco.get(i).getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente. Su saldo actual es: " + listBanco.get(i).getSaldo());
                                    }
                                } else {
                                    System.out.println("El monto debe ser positivo");
                                }
                            } while (monto <= 0);
                            encontrada = true;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Cuenta no encontrada");
                    }

                }
                case 6-> {

                    System.out.println("Saliendo...");
                    estado = false;

                }
                default -> System.out.println("Opción no válida");
            }

        }while (estado);

        // Se corrige error, se crean los objetos CuentaBancaria con valores directamente y se agregan a la lista.
        // Se verifica si la lista está vacía en el caso 2.
        // Se redujeron líneas de código, se declararon variables en la misma línea de código.
        // Se agregaron mejoras visuales y textos que se le muestran al usuario.
        // Se agregó la variable encontrada en el caso 3, 4 y 5, si el cliente ingresa una cuenta que no existe, se le muestra el correspondiente mensaje.
        // Se agregó teclado.nextLine(); que se usa después de nextInt() y nextDouble() para evitar problemas con el salto de línea pendiente.
        // Ahora se comprueba si el monto es positivo antes de procesar el depósito o retiro.
        // Si el monto a retirar es mayor que el saldo disponible, se muestra un mensaje de saldo insuficiente.



















        /*
        CuentaBancaria cl1 = new CuentaBancaria("abc123", 20500, "Juan");
        CuentaBancaria cl2 = new CuentaBancaria("xyz123", 20500, "Daniela");
        CuentaBancaria cl3 = new CuentaBancaria("was123", 20500, "Pedro");

        listBanco.add(cl1);
        listBanco.add(cl2);
        listBanco.add(cl3);


        listBanco.size();
        listBanco.remove();

        do{
            System.out.println("""
                1. Depositar dinero
                2. Retirar dinero
                3. Mostrar datos de la cuenta
                4. Mostrar clientes desde la lista
                5. Salir
                """);
            op=teclado.nextInt();

            switch (op){
                case 1 -> {
                    System.out.println("Depositar");
                    do{
                        System.out.println("Cuanto dinero desea depositar");
                        monto = teclado.nextDouble();
                    }while (monto<=0);

                    cl1.depositarDinero(monto);
                }
                case 2-> {
                    System.out.println("Retirar");
                    do{
                        System.out.println("Cuanto dinero desea retirar");
                        monto = teclado.nextDouble();
                    }while(monto<=0);

                    cl1.retirarDinero(monto);
                }
                case 3-> {
                    System.out.println("Mostrar datos de la cuenta");
                    cl1.mostrarInformacion();
                }
                case 4->{
                    System.out.println("Mostrar datos de la cuenta desde la lista");
                    //System.out.println(listBanco.toString());
                    for (CuentaBancaria cu : listBanco){
                        System.out.println(cu);
                    }
                }
                case 5->{
                    System.out.println("Salir...");
                    estado = false;
                }
                default -> {
                    System.out.println("No existe opcion");
                }
            }

        }while (estado);

         */
    }
}