public class Actividad16 {
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        Contador cont2 = new Contador(400);
        // creamos los hilos
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont2);
        // los iniciamos
        a.start();
        b.start();
    }
}

class Contador {
    private int c = 100;

    Contador(int c) {
        this.c = c;
    }

    public synchronized void incrementa() {
        c = c + 1;
    }

    public synchronized void decrementa() {
        c = c - 1;
    }

    public int getValor() {
        return c;
    }
}

class HiloA extends Thread {
    private Contador contador;

    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        // bucle de 300 repeticiones
        for (int j = 0; j < 300; j++) {
            contador.incrementa();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}

class HiloB extends Thread {
    private Contador contador;

    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        // bucle de 300 repeticiones
        for (int j = 0; j < 300; j++) {
            // llamada al metodo de decrementar
            contador.decrementa();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
