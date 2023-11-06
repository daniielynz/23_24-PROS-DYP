#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

int count = 0;

// Función para manejar la señal SIGUSR1 en el padre
void sigusr1_handler(int signo) {
    if (signo == SIGUSR1) {
        printf("Padre recibe señal...%d\n", signo);
    }
}

int main() {
    // Registra el manejador de señal para SIGUSR1 en el padre
    signal(SIGUSR1, sigusr1_handler);

    pid_t child_pid;

    // Crea un proceso hijo
    if ((child_pid = fork()) < 0) {
        perror("Error al crear el proceso hijo");
        exit(1);
    }

    if (child_pid == 0) {
        // Este es el proceso hijo
        sleep(1);  // Espera un segundo para asegurarse de que el padre esté listo

        // Envía tres señales SIGUSR1 al proceso padre
        for (int i = 0; i < 3; i++) {
            kill(getppid(), SIGUSR1);
            sleep(1);
        }

        // Envía una señal SIGKILL para terminar el proceso padre
        kill(getppid(), SIGKILL);
    } else {
        // Este es el proceso padre
        while (1) {
            // Espera a recibir señales
            pause();
        }
    }

    return 0;
}


