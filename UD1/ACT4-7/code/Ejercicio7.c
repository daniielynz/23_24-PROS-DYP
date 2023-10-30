#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    // Valor inicial
    int valor = 6; 

    printf("Valor inicial de la variable:%d\n", valor);

    // Crear un nuevo proceso
    pid_t child_pid = fork(); 

    if (child_pid == -1) {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    } else if (child_pid == 0) {
        // Restar 5 al valor
        valor -= 5; 

        printf("Variable en proceso Hijo: %d\n", valor);

        // Salir del proceso hijo
        exit(EXIT_SUCCESS);
    } else {
        // Incrementar 5 al valor
        valor += 5; 

        printf("Variable en proceso Padre: %d\n", valor);

        // Esperar a que el proceso hijo termine
        wait(NULL);
    }

    return 0;
}