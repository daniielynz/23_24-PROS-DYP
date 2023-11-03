#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

// Metodo que devuelve los mensajes que saldran por consola
void signal_handler(int signo) {
    if (signo == SIGUSR1) {
        printf("Padre recibe señal...10\n");
    } else if (signo == SIGKILL) {
        printf("Terminado (killed)\n");
        exit(0);
    }
}

int main() {
    // Configurar el manejador de señales para SIGUSR1
    signal(SIGUSR1, signal_handler);
    
    pid_t child_pid;
    child_pid = fork();

    if (child_pid < 0) {
        // si el pid es negativo, da error
        perror("Error al crear el proceso hijo");
        exit(1);
    } else if (child_pid == 0) {
        // Esperar para que el proceso padre esté listo para recibir señales
        sleep(2);
        // Enviar 3 señales SIGUSR1 al proceso padre
        for (int i = 0; i < 3; i++) {
            kill(getppid(), SIGUSR1);
            // un segundo de espera
            sleep(1); 
        }

        // Utilizamos SIGKILL para matar el proceso padre
        kill(getppid(), SIGKILL);
    }

    return 0;
}
