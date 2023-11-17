#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>

int main() 
{
    int status;
    pid_t hijo_pid;

    hijo_pid = fork();
    if (hijo_pid > 0) {
        printf("Soy el proceso padre\n");
        // le añadimos la sentencia wait
        wait(&status);
        sleep(60);
    } 
    else if (hijo_pid == 0) {
        printf("Soy el proceso hijo\n");
        exit(0);
    } 
    else {
        perror("Error al crear el proceso hijo");
        exit(1);
    }

    return 0;
}
