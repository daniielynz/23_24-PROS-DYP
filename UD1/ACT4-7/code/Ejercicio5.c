#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    // Obtener el PID del proceso padre
    pid_t parent_pid = getpid();

    printf("Soy el proceso padre %d.\n", parent_pid);

    // Crear el primer hijo
    pid_t child1_pid = fork();

    if (child1_pid == 0) {

        pid_t child1_pid_actual = getpid();
        printf("Soy el hijo %d y mi padre es %d.\n", child1_pid_actual, parent_pid);

        // Crear el segundo hijo
        pid_t child2_pid = fork();

        if (child2_pid == 0) {

            pid_t child2_pid_actual = getpid();
            printf("Soy el hijo %d y mi padre es %d.\n", child2_pid_actual, child1_pid_actual);

            exit(EXIT_SUCCESS);
        }

        exit(EXIT_SUCCESS);
    }

    return 0;
}