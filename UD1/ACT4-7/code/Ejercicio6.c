#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t child1, child2, child3;

    // PID del padre
    pid_t parent_pid = getpid();

    // Crear el primer hijo
    child1 = fork();

    if (child1 == 0) {
        // Código del primer hijo
        printf("Soy el primer hijo, mi PID es %d, mi padre es %d\n", getpid(), parent_pid);
    } else if (child1 > 0) {
        // Crear el hijo2
        child2 = fork();

        if (child2 == 0) {
            pid_t hijo2 = getpid();
            printf("Soy el segundo hijo, mi PID es %d, mi padre es %d\n", hijo2, parent_pid);
            
            // Crear el hijo3 y que tenga como padre el hijo2
            child3 = fork();

            if (child3 == 0) {
                printf("Soy el tercer hijo, mi PID es %d, mi padre es %d\n", getpid(), hijo2);
            }
        }
    }

    return 0;
}
