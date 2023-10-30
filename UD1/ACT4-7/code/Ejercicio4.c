#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
// PID del proceso padre
pid_t padre = getpid();
// Crear 3 procesos hijos
for (int i = 0; i < 3; i++) {
pid_t hijo_pid = fork();
if (hijo_pid == 0) {
// Este código se ejecutará en cada proceso hijo
pid_t pid = getpid();
printf("Soy el hijo %d, Mi padre es %d y mi PID es %d\n", i+1,padre,pid);
// Salir del proceso hijo
return 0;
}
}
// El proceso padre espera a que todos los hijos terminen
for (int i = 0; i < 3; i++) {
wait(NULL);
}
// Informacion sobre el proceso padre
printf("Soy el proceso padre. Mi PID es: %d\n", padre);

return 0;
}