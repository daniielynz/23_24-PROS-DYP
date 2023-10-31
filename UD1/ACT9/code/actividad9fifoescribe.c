#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    int p, bytesleidos;
    char saludo[] = "Un saludo !!!!!\n";
    
    p=mknod("FIFO2", S_IFIFO|0666, 0); // Creamos el FIFO con permisos de lectura y escritura
    
    if (p == -1) {
        printf("Ha ocurrido un error al crear el FIFO...\n");
        exit(1);
    }
    
    while (1) {
        fp = open("FIFO2", O_WRONLY); // Abrimos el FIFO en modo escritura
        printf("Mandando información al FIFO...\n");
        write(fp, saludo, sizeof(saludo));
        close(fp);
    }
    
    return 0;
}