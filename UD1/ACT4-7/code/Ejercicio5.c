//actividad5.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main () {
    pid_t pid;
    
    // bucle con 4 repeticiones
    for(int i = 0; i<4; i++){
        pid = fork();
        if (pid == -1){
            printf("No se ha podido crear el proceso hijo...");
            exit (-1);
        }else if(pid == 0){
            // mensaje que se muestra por pantalla
            printf("Soy el hijo %d, mi PID es %d, mi padre es %d\n", i, getpid(), getppid());
        }else{
            //En el proceso padre
            pid = wait(NULL);
            exit(0);
        }
    }
}