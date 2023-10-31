#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    int p, bytesleidos;
    char saludo[] = "Un saludo !!!!!\n";
    char buffer[10];
    
    while (1) {
        fp = open("FIFO2", O_RDONLY); // Abrimos el FIFO en modo lectura
        bytesleidos = read(fp, buffer, sizeof(buffer));
        printf("Obteniendo información...\n");
        
        while (bytesleidos != 0) {
            printf("%s", buffer);
            bytesleidos = read(fp, buffer, sizeof(buffer));
        }
        
        close(fp);
    }
    
    return 0;
}